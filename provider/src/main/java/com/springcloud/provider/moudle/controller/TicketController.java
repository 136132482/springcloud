package com.springcloud.provider.moudle.controller;

import com.springcloud.provider.moudle.entity.Demo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags="账号授权管理")
@RequestMapping(value = "/api/TicketController",method = RequestMethod.POST)
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/user")
    public String index(){
        return ticketService.buyTicket();
    }



    @RequestMapping(value = "/get/user")
    @ApiOperation(value = "根据账号获取登录信息",notes = "根据账号获取登录信息")
    @ApiImplicitParams(@ApiImplicitParam(name = "id",value = "登录账号账号表ID",required = true,dataType = "string"))
    public String getResult(@PathVariable String id){
       LogManager.getLogger(this.getClass()).debug("账号id : {}", id);
        System.out.println(id);
        return id;
    }

    @RequestMapping("/add")
    @ApiOperation(value = "新增账号信息", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addResult(@Validated @RequestBody Demo demo){


    }

}
