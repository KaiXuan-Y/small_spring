package ykx.manual.spring.springframework.beans.factory.config;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.fasterxml.jackson.databind.util.BeanUtil;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;

/**
 * @author yangkaixuan
 */
public class BeanDefinition {
    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = null == propertyValues ? new PropertyValues() : propertyValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
