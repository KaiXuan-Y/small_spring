package ykx.manual.spring.springframework.beans.factory.config;

/**
 * @author yangkaixuan
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);
}
