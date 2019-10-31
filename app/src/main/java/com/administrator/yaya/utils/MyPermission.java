package com.administrator.yaya.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.administrator.yaya.base.BaseApp;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.util.List;

public class MyPermission {

    /**
     * getPermission 动态获取权限方法
     *
     * @param context 上下文
     * @param isAsk   是否开启权限询问      (Android6.0以下用户可以不开启,所有权限自动可以获得；6.0以上用户若不开启，获取不到某权限时，若你没做相应处理，可能会崩溃)
     * @param isHandOpen   是否询问用户被引导手动开启权限界面   (用户永久禁用某权限时是否引导让用户手动授权权限)
     */
    public static void getPermission(Context context, boolean isAsk, final boolean isHandOpen){
        if(!isAsk)return;

        if (XXPermissions.isHasPermission(context,
                //所需危险权限可以在此处添加：
                Permission.READ_PHONE_STATE,
                Permission.WRITE_EXTERNAL_STORAGE)) {
            ToastUtil.showShort("已经获得所需所有权限");
        }else {
            XXPermissions.with((Activity)context).permission(
                    //同时在此处添加：
                    Permission.READ_PHONE_STATE,
                    Permission.WRITE_EXTERNAL_STORAGE
            ).request(new OnPermission() {
                @Override
                public void noPermission(List<String> denied, boolean quick) {
                    if (quick) {
                        ToastUtil.showShort("被永久拒绝授权，请手动授予权限");
                        //如果是被永久拒绝就跳转到应用权限系统设置页面
                        if(isHandOpen) {
                            final AlertDialog.Builder normalDialog =
                                    new AlertDialog.Builder(BaseApp.getApplication());
                            normalDialog.setTitle("开启权限引导");
                            normalDialog.setMessage("被您永久禁用的权限为应用必要权限，是否需要引导您去手动开启权限呢？");
                            normalDialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {
                                    XXPermissions.gotoPermissionSettings(BaseApp.getApplication());
                                }
                            });
                            normalDialog.setNegativeButton("下一次", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface arg0, int arg1) {

                                }
                            });
                            normalDialog.show();
                        }
                    }else {
                        ToastUtil.showShort("获取权限失败");
                    }
                }
                @Override
                public void hasPermission(List<String> granted, boolean isAll) {
                    if (isAll) {
                        ToastUtil.showShort("获取权限成功");
                    }else {
                        ToastUtil.showShort("获取权限成功，部分权限未正常授予");
                    }
                }
            });
        }
    }
}
