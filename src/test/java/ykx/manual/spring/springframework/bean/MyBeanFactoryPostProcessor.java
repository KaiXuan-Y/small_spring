package ykx.manual.spring.springframework.bean;

import ykx.manual.spring.springframework.beans.factory.ConfigurableListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.PropertyValue;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansCreateException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "变更为字节"));
    }
}
