package com.springcloud.provider.moudle.controller;

import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public String buyTicket(){
        System.out.println("我是8002");
        return "《疯狂的石头》";
    }

}
