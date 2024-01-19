package ykx.manual.spring.springframework.beans.factory;

/**
 * @author yangkaixuan
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();

}
