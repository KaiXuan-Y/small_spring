package ykx.manual.spring.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001" , "小");
        hashMap.put("10002", "开");
        hashMap.put("10003", "a");
    }
    public String queryUserName(String uId){
        return hashMap.get(uId);
    }

}
