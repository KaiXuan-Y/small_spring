package ykx.manual.spring.springframework.bean;

import ykx.manual.spring.springframework.beans.factory.DisposableBean;
import ykx.manual.spring.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {
    private String uId;

    private UserDao userDao;

    private String company;

    private String location;


    public void queryUserInfo(){
        System.out.println("查询用户信息:" + userDao.queryUserName(uId) + ", 公司：" + company + ", 地点：" +location);
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }
}
