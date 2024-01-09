package ykx.manual.spring.springframework.beans.factory.support;

import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author yangkaixuan
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (null == ctor){
                beanClass.getDeclaredConstructor().newInstance();
            }else {
                beanClass.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);

            }
        } catch (InvocationTargetException  | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new BeansCreateException("Failed to instantiate [" + beanClass.getName() + "] :" + e.getMessage()  );
        }


        return null;
    }
}
