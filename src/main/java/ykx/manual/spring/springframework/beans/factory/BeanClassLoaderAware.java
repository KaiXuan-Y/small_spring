package ykx.manual.spring.springframework.beans.factory;

/**
 * @author yangkaixuan
 */
public interface BeanClassLoaderAware extends Aware{
    void setBeanClassLoader(ClassLoader classLoader);
}
