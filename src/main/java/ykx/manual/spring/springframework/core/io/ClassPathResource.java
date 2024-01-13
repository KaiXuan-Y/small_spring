package ykx.manual.spring.springframework.core.io;

import cn.hutool.core.lang.Assert;
import ykx.manual.spring.springframework.util.ClassUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {
    private final String path;

    private final ClassLoader classLoader;

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notBlank(path, "path cannot be empty");
        this.path = path;
        this.classLoader = null == classLoader ? ClassUtil.getDefaultClassLoader() : classLoader;
    }

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = classLoader.getResourceAsStream(this.path);
        if (null == is) {
            throw new FileNotFoundException(
                    this.path + "can not be opened without it exists"
            );
        }
        return is;
    }

    public String getPath() {
        return path;
    }
}
