package ykx.manual.spring.springframework.beans.factory;

/**
 * @author yangkaixuan
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
