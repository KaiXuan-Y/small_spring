package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.Aware;

public interface BeanNameAware extends Aware {
    void setBeanName(String beanName);
}
