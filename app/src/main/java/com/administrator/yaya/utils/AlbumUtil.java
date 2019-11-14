package com.administrator.yaya.utils;

import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;

/**
 * 调用相机
 */
public class AlbumUtil {
    /**
     * 获取文件路径
     */
    @TargetApi(19)
    public static String getFilePath(Context context, Uri uri , Intent intent){
        boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0] ;
                if ("primary".equalsIgnoreCase(type) == true) {
                    return "${Environment.getExternalStorageDirectory()}/${split[1]}" ;
                }
            } else if (isDownloadsDocument(uri)) {
                //DownloadsProvider
                final String id  = DocumentsContract.getDocumentId(uri) ;
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null) ;
            } else if (isMediaDocument(uri)) {
                //MediaProvider
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split  = docId.split(":");
                final String  type = split[0];
                Uri contentUri = null;
                if ("image" == type) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video" == type) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio" == type) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?" ;
                final String[] selectionArgs = new String[] { split[1] };
                return getDataColumn(context, contentUri, selection, selectionArgs) ;
            }// MediaProvider
            // DownloadsProvider
        } else if ("content".equalsIgnoreCase(uri.getScheme()) == true) {
            // MediaStore (and general)
            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();
            return getDataColumn(context, uri, null, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme()) == true) {
            // File
            return uri.getPath() ;
        }else if (DocumentsContract.isDocumentUri(context, uri) == false){
            getImagePath(context,uri,intent);
        }
        return null ;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     * @param context The context.
     * *
     * @param uri The Uri to query.
     * *
     * @param selection (Optional) Filter used in the query.
     * *
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * *
     * @return The value of the _data column, which is typically a file path.
     */
    private static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs){
        Cursor cursor = null ;
        final String column = "_data";
        final String[] projection = { column };
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
            if (cursor == null){
                return uri.getPath();
            }
        } finally {
            if (cursor != null)
                cursor.close();
            return null ;
        }
        //return null ;
    }

    /**
     * @param uri The Uri to check.
     * *
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    private static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * *
     * @return Whether the Uri authority is DownloadsProvider.
     */
    private static boolean isDownloadsDocument(Uri uri){
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * *
     * @return Whether the Uri authority is MediaProvider.
     */
    private static boolean isMediaDocument(Uri uri){
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
    //content://com.android.providers.media.documents/document/image%3A48974
    /**
     * @param uri The Uri to check.
     * *
     * @return Whether the Uri authority is Google Photos.
     */
    private static boolean isGooglePhotosUri(Uri uri){
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /**
     * 获取图片路径
     */
    public static String getImagePath(Context context, Uri uri, Intent data){
        Uri selectedImage = data.getData();
        //Log.e(TAG, selectedImage.toString());
        if (selectedImage != null) {
            String uriStr = selectedImage.toString();
            String path = uriStr.substring(10, uriStr.length());
            if (path.startsWith("com.sec.android.gallery3d")) {
                Log.e("Method selectImage", "It's auto backup pic path:" + selectedImage.toString());
                return null ;
            }
        }
        final String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = context.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
        String mImgPath ;
        if (cursor != null){
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            mImgPath = picturePath;
            cursor.close();
        }else
        {
            mImgPath = selectedImage.getPath();
        }

        return mImgPath;
    }

}
