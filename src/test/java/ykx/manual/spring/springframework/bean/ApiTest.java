package ykx.manual.spring.springframework.bean;


import net.sf.cglib.proxy.MethodInterceptor;
import org.junit.Test;
import ykx.manual.spring.springframework.beans.factory.PropertyValue;
import ykx.manual.spring.springframework.beans.factory.PropertyValues;
import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.config.BeanReference;
import ykx.manual.spring.springframework.beans.factory.support.DefaultListableBeanFactory;
import ykx.manual.spring.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import ykx.manual.spring.springframework.context.support.ClassPathXmlApplicationContext;

public class ApiTest {

    @Test
    public void test_BeanFactory() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService", "hello");
        userService.queryUserInfo();

    }

    @Test

    public void test_BeanFactory_2() {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
        userService.queryUserInfo();
    }


    @Test
    public void test_classpath() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        xmlBeanDefinitionReader.loadBeanDefinition("classpath:spring.xml");

        UserService userService = beanFactory.getBean("userService", UserService.class);
        userService.queryUserInfo();
    }


    @Test
    public void test_context() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println(userService.queryUserInfo());
    }

    @Test
    public void test_eventListener() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 123123l, "自定义时间发送。。。"));
    }
    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserDao userService = applicationContext.getBean("userService", IUserDao.class);
        String s = userService.queryUserName("12");
        System.out.println(s);
    }


}
