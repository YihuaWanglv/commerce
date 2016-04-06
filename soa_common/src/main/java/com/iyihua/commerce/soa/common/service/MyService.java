package com.iyihua.commerce.soa.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.commerce.soa.common.mapper.DemoMapper;
import com.iyihua.commerce.soa.common.model.Demo;

@Service
public class MyService {

    @Autowired
    private DemoMapper demoMapper;
    
    public List<Demo> getDemo() {
    	List<Demo> r = demoMapper.findAll();
    	return r;
    }
    
}
