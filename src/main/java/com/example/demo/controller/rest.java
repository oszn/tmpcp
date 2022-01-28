package com.example.demo.controller;

import com.example.demo.service.QueueService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class rest {
    private static final Log logger = LogFactory.getLog(rest.class);
    @Autowired
    QueueService queueService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<String> get(@RequestParam(value = "top") Integer top){
        List<String> list=queueService.getStore();
        List<String> tmp=new ArrayList<>();
        try {
            tmp=list.subList(0,top);
        }
        catch (Exception e){
            tmp=list;
        }

//        System.out.println(tmp);
        return tmp;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void add(@RequestParam(value = "content") String content){

//        System.out.println(content);
        queueService.add(content);
    }
    @RequestMapping(value = "/rm",method = RequestMethod.GET)
    public void remote(@RequestParam(value = "index") int index){
//        System.out.println(index);
//        System.out.println(conten);
        logger.info("index is"+index);
        queueService.remote(index);
    }
}
