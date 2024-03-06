package ykx.manual.spring.springframework.beans.factory.config;

import com.alibaba.nacos.shaded.org.checkerframework.checker.nullness.qual.Nullable;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

/**
 * @author yangkaixuan
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {

    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansCreateException;


    PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansCreateException;
}
