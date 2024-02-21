package ykx.manual.spring.springframework.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

public class ClassUtil {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            cl = Thread.currentThread().getContextClassLoader();
        }catch (Throwable exception){
            //cannot get default class loader
        }

        if (null == cl) {
            cl = ClassUtil.class.getClassLoader();
        }

        return cl;


    }

    public static boolean isCglibProxyClass(Class<?> clazz){
        return null != clazz && isCglibProxyClassName(clazz.getName());
    }

    public static boolean isCglibProxyClassName(String className){
        return StringUtils.isNotBlank(className) && className.contains("$$");
    }
}
