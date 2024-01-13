package ykx.manual.spring.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangkaixuan
 */
public interface Resource {
    InputStream getInputStream() throws IOException;

}
