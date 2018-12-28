package com.keguang.daily.i18n;

import java.util.Locale;

/**
 * @version v1.0.0
 * @Author:keguang
 * @Date:2018/8/17 15:16
 */
public class I18nDemo {
    public static void main(String[] args) {
        Locale defaultLocale = Locale.getDefault();
        System.out.println("countr=" + defaultLocale.getCountry());
        System.out.println("language=" + defaultLocale.getLanguage());

    }
}
