package ykx.manual.spring.springframework.beans.factory;

import ykx.manual.spring.springframework.beans.factory.config.BeanDefinition;
import ykx.manual.spring.springframework.beans.factory.config.BeanFactoryPostProcessor;
import ykx.manual.spring.springframework.beans.factory.exception.BeansCreateException;
import ykx.manual.spring.springframework.core.io.DefaultResourceLoader;
import ykx.manual.spring.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Properties;

public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public static final String DEFAULT_PLACEHOLDER_PREFIX = "${";

    public static final String DEFAULT_PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansCreateException {

        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
            for (String beanName : beanDefinitionNames) {
                BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
                PropertyValues propertyValues = beanDefinition.getPropertyValues();
                for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                    Object value = propertyValue.getValue();
                    if (!(value instanceof String)){
                        continue;
                    }
                    String strVal = (String) value;
                    StringBuffer stringBuffer = new StringBuffer(strVal);
                    int startIdx = stringBuffer.indexOf(DEFAULT_PLACEHOLDER_PREFIX);
                    int endIdx = stringBuffer.indexOf(DEFAULT_PLACEHOLDER_SUFFIX);
                    if (startIdx != -1 && endIdx != -1 && startIdx < endIdx){
                        String propKey = strVal.substring(startIdx + 2, endIdx);
                        String propValue = properties.getProperty(propKey);
                        stringBuffer.replace(startIdx , startIdx + 1 , propValue);
                        propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName() , stringBuffer.toString()));
                    }
                }
            }


        } catch (Exception e) {
            throw new BeansCreateException(e.getMessage());
        }


    }

    public void setLocation(String location) {
        this.location = location;
    }
}
