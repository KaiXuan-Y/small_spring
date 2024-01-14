package ykx.manual.spring.springframework.bean;

public class UserService {
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
}
