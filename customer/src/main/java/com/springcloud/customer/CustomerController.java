package com.springcloud.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CustomerController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(){
        String result = restTemplate.getForObject("http://ticket-provider/", String.class);

        return result;
    }

}
