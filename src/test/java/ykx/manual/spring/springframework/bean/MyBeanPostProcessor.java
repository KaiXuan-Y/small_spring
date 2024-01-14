package ykx.manual.spring.springframework.bean;

import ykx.manual.spring.springframework.beans.factory.config.BeanPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansCreateException {
        if ("userService".equals(beanName)){
            UserService userService = (UserService) bean;
            userService.setLocation("改为北京");
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansCreateException {
        return bean;
    }
}
