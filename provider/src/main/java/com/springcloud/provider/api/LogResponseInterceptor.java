package com.springcloud.provider.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author brett.chen
 * @date 29/08/2018
 **/
@Slf4j
public class LogResponseInterceptor implements HttpResponseInterceptor {

    private final String brand;

    public LogResponseInterceptor(String brand) {
        this.brand = brand;
    }

    @Override
    public void process(HttpResponse response, HttpContext context) throws HttpException, IOException {

        HttpEntity entity = response.getEntity();
        GzipDecompressingEntity ungzip = null;

        if (entity != null) {
            Header ceheader = entity.getContentEncoding();
            if (ceheader != null) {
                HeaderElement[] codecs = ceheader.getElements();
                for (int i = 0; i < codecs.length; i++) {
                    if (codecs[i].getName().equalsIgnoreCase("gzip")) {
                        entity = new GzipDecompressingEntity(response.getEntity());
                        // response.setEntity(ungzip);
                        break;
                    }
                }
            }

            if (log.isDebugEnabled()) {
                String str = EntityUtils.toString(entity, "utf-8");
                // log
                log.debug(brand + "-Response: " + str);
                response.setEntity(new StringEntity(str, "utf-8"));
            }
        }

    }


}
