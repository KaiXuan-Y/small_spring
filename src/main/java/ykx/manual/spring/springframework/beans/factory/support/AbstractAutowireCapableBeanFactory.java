package ykx.manual.spring.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import ykx.manual.spring.springframework.beans.factory.PropertyValue;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.config.BeanPostProcessor;
import ykx.manual.spring.springframework.beans.factory.config.BeanReference;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.lang.reflect.Constructor;

/**
 * @author yangkaixuan
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object instance;
        instance = createBeanInstance(beanDefinition, beanName, args);
        //给Bean进行属性填充
        applyPropertyValues(beanName, instance, beanDefinition);

        instance = initializeBean(beanName, instance, beanDefinition);
        addSingleton(beanName, instance);
        return instance;

    }

    private Object initializeBean(String beanName, Object instance, BeanDefinition beanDefinition) {
        Object wrappedBean = applyBeanPostProcessorBeforeInitialization(instance, beanName);

        invokeInitMethods(beanName, wrappedBean, beanDefinition);

        wrappedBean = applyBeanPostProcessorAfterInitialization(instance, beanName);


        return wrappedBean;
    }

    private void invokeInitMethods(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    private Object applyBeanPostProcessorBeforeInitialization(Object instance, String beanName) {
        Object res = instance;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            if (null == current) {
                return res;
            }
            res = current;
        }
        return res;
    }

    private Object applyBeanPostProcessorAfterInitialization(Object instance, String beanName) {
        Object res = instance;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            if (null == current) {
                return res;
            }
            res = current;
        }
        return res;
    }

    private void applyPropertyValues(String beanName, Object instance, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            if (null == propertyValues) {
                //没有需要填充的属性
                return;
            }
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                BeanUtil.setFieldValue(instance, name, value);


            }
        } catch (BeansCreateException e) {
            throw new BeansCreateException("Error setting property values for :" + beanName);
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        for (Constructor constructor : beanDefinition.getBeanClass().getDeclaredConstructors()) {
            //todo 判断类型
            if (null != args && constructor.getParameterTypes().length == args.length) {
                constructorToUse = constructor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);


    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }
}
