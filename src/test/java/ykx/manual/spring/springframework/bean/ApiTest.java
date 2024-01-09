package ykx.manual.spring.springframework.bean;


import org.junit.Test;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

    @Test
    public void test_BeanFactory(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService" , beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
