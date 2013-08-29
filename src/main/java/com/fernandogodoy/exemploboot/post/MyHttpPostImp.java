package com.fernandogodoy.exemploboot.post;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Fernando Godoy
 */
public class MyHttpPostImp {

    
    /**
     * Executa HTTP Post enviado parametros
     * @param url
     * @param params
     * @return HTML da página
     * @throws IOException 
     */
    public String post(String url, Map<String, String> params) throws IOException {
       
        DefaultHttpClient httpClient = new DefaultHttpClient();
        List<NameValuePair> valuePair = new ArrayList<NameValuePair>();
        
        for (String key : params.keySet()) {
            valuePair.add(new BasicNameValuePair(key, params.get(key)));
        }

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(valuePair, Consts.UTF_8));

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        entity.writeTo(os);
        EntityUtils.consume(entity);

        return os.toString("UTF-8");
    }
}
