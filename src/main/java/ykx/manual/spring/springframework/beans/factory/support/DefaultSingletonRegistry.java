package ykx.manual.spring.springframework.beans.factory.support;

import cn.hutool.core.lang.hash.Hash;
import ykx.manual.spring.springframework.beans.factory.DisposableBean;
import ykx.manual.spring.springframework.beans.factory.config.SingletonBeanRegistry;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yangkaixuan
 */
public class DefaultSingletonRegistry implements SingletonBeanRegistry {
    private final ConcurrentMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean disposableBean) {
        disposableBeans.put(beanName, disposableBean);
    }


    public void destroySingletons() {
        Set<String> keySet = this.singletonObjects.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0 ; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = this.disposableBeans.remove(disposableBeanName);
            try {
                if (null != disposableBean){
                    disposableBean.destroy();
                }
            } catch (Exception e) {
                throw new BeansCreateException("Destroy method on bean with name" + disposableBeanName + "threw a exception:" ,e);
            }
        }

    }

}
