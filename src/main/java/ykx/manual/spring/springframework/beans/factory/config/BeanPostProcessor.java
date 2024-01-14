package ykx.manual.spring.springframework.beans.factory.config;

import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

/**
 * @author yangkaixuan
 */
public interface BeanPostProcessor {


    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansCreateException;

    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansCreateException;

}
