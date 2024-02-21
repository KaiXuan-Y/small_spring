package ykx.manual.spring.springframework.beans.factory.config;

/**
 * @author yangkaixuan
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void destroySingletons();

    void registerSingleton(String beanName, Object singletonObject);
}
