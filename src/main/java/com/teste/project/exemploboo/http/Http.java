package com.teste.project.exemploboo.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Fernando Godoy
 */
public class Http {

    /**
     * Executa um HTTP GET em uma URL
     * @param url
     * @return HTML 
     * @throws IOException 
     */
    public StringBuilder get(String url) throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpResponse response = httpClient.execute(new HttpGet(url));
        HttpEntity entity = response.getEntity();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        entity.writeTo(os);
        EntityUtils.consume(entity);

        return new StringBuilder(os.toString("UTF-8"));

    }
}
