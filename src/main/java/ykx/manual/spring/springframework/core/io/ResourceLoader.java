package ykx.manual.spring.springframework.core.io;

/**
 * @author yangkaixuan
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
