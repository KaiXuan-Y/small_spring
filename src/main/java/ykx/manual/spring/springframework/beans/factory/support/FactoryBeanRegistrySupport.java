package ykx.manual.spring.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import ykx.manual.spring.springframework.beans.factory.FactoryBean;
import ykx.manual.spring.springframework.beans.factory.NullBean;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author yangkaixuan
 */
public class FactoryBeanRegistrySupport extends DefaultSingletonRegistry {
    private final ConcurrentMap<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        return this.factoryBeanObjectCache.get(beanName);
    }

    protected Object getObjectFromFactoryBean(FactoryBean factory, String beanName) {
        if (factory.isSingleton()) {
            Object object = factoryBeanObjectCache.get(beanName);
            if (BeanUtil.isEmpty(object)) {
                object = doGetObjectFromFactoryBean(beanName, factory);
                this.factoryBeanObjectCache.put(beanName, object);
            }
            return object;
        } else {
            return doGetObjectFromFactoryBean(beanName, factory);
        }

    }

    private Object doGetObjectFromFactoryBean(final String beanName, final FactoryBean factoryBean) {
        Object object;
        try {
            object = factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansCreateException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
        if (BeanUtil.isEmpty(object)) {
            object = new NullBean();
        }
        return object;
    }
}
