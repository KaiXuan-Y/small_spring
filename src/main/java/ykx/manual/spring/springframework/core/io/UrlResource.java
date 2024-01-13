package ykx.manual.spring.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yangkaixuan
 */
public class UrlResource implements Resource{
    private final URL url;


    public UrlResource(URL url) {
        Assert.notNull(url, "url cannot be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = this.url.openConnection();
        try (InputStream inputStream = urlConnection.getInputStream()) {
            return inputStream;
        }catch (IOException e) {
            if (urlConnection instanceof HttpURLConnection){
                ((HttpURLConnection) urlConnection).disconnect();
            }
            throw e;
        }
    }
}
