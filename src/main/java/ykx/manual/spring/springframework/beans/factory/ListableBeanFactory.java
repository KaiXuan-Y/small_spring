package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.util.Map;

/**
 * @author yangkaixuan
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * 按照类型返回Bean的实例
     * @param beanType
     * @return
     * @param <T>
     * @throws BeansCreateException
     */
    <T> Map<String, T> getBeansOfType(Class<T> beanType) throws BeansCreateException;

    /**
     * 返回单例池中所有的Bean的名称
     */
    String[] getBeanDefinitionNames();


}
