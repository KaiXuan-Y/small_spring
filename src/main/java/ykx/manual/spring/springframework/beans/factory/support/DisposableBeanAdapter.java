package ykx.manual.spring.springframework.beans.factory.support;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import ykx.manual.spring.springframework.beans.factory.DisposableBean;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean){
            ((DisposableBean) bean).destroy();
        }
        if (StringUtils.isNotBlank(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(destroyMethodName))){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method){
                throw new BeansCreateException("could not find destroy method " + destroyMethodName);
            }
            method.invoke(bean);
        }
    }
}
