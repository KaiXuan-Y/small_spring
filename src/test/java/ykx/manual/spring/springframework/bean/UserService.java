package ykx.manual.spring.springframework.bean;

import ykx.manual.spring.springframework.beans.factory.*;
import ykx.manual.spring.springframework.context.ApplicationContext;

public class UserService {

//    private BeanFactory beanFactory;
//    private ApplicationContext applicationContext;
//    private String uId;
//
//    private String company;
//
//    private String location;
//
//
//    public void queryUserInfo(){
//        System.out.println("查询用户信息:" + userDao.queryUserName(uId) + ", 公司：" + company + ", 地点：" +location);
//    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }



    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("执行：UserService.afterPropertiesSet");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("执行：UserService.destroy");
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) {
//        this.beanFactory = beanFactory;
//    }
//
//    @Override
//    public void setBeanName(String beanName) {
//        System.out.println("Bean Name is " + beanName);
//    }
//
//    @Override
//    public void setBeanClassLoader(ClassLoader classLoader) {
//        System.out.println("ClassLoader is " + classLoader);
//    }

    private String uId;

    private String company;

    private String location;

    private IUserDao userDao;


    public String queryUserInfo(){
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

}
