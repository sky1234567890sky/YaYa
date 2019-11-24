package com.administrator.yaya.utils;

import org.jsoup.helper.StringUtil;

//1.用户信息，不展示用户的ID，展示用户手机号，仅展示前2后2；
public class DealPhoneNumberUtils {
    //151 1111 1111 -> 151 **** 1111
    public static String dealPhoneNumber(String phoneNumber) {
        if (StringUtil.isNumeric(phoneNumber)) {
            int len = phoneNumber.length();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (i > 1 && i < 9) {
                    builder.append("*");
                } else {
                    builder.append(phoneNumber.charAt(i));
                }
                if (i == 1 || i == 8) {
                    if (i != len - 1)
                        builder.append(" ");
                }
            }
            return builder.toString();
        }
        return null;
    }
}