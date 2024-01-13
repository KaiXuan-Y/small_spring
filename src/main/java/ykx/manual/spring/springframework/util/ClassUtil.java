package ykx.manual.spring.springframework.util;

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
}
