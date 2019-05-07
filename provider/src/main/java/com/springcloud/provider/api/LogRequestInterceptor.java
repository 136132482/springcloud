package com.springcloud.provider.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author brett.chen
 * @date 29/08/2018
 **/
@Slf4j
public class LogRequestInterceptor implements HttpRequestInterceptor {

    private final String brand;

    public LogRequestInterceptor(String brand) {
        this.brand = brand;
    }


    @Override
    public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
        if (log.isDebugEnabled()) {

            // Request-Line   = Method SP Request-URI SP HTTP-Version CRLF
            log.debug("{}-Request URL>: {}", brand, request.getRequestLine().toString());

            Header[] headers = request.getAllHeaders();
            for (int i = 0; i < headers.length; i++) {
                log.debug("{}-Request Header> {}: {}", brand, headers[i].getName(), headers[i].getValue());
            }

            if (request instanceof HttpEntityEnclosingRequest) {
                HttpEntity entity = ((HttpEntityEnclosingRequest) request).getEntity();

                String str = EntityUtils.toString(entity, "utf-8");
                // log
                log.debug(brand + "-Request Body>: " + str);
            }

        }

    }

}