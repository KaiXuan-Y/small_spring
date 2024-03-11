package ykx.manual.spring.springframework.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import ykx.manual.spring.springframework.stereotype.Component;

import java.util.Set;

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

    public static Set<Class<?>> scanPackageByAnnotation(String basePackage, Class<Component> componentClass) {


    }
}
