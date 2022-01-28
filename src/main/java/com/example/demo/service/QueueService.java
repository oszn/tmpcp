package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QueueService {
    public List<String> getStore() {
        return store;
    }

    public void setStore(List<String> store) {
        this.store = store;
    }

    List<String> store;
    Integer maxlen;
    public QueueService(){
        maxlen=100;
        store=new ArrayList<>();
    }
    public QueueService(int len){
        maxlen=len;
        store=new ArrayList<>();
    }

    public void add(String s){
        if(store.size()>maxlen){
            store.remove(0);
        }
        store.add(0,"\n"+s+"\n");
    }
//    public List<String> getRev(){
//
//    }
    public void remote(int index){
        store.remove(index);
    }
}
