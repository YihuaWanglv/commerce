package com.iyihua.commerce.soa.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.commerce.soa.common.mapper.ItemMapper;
import com.iyihua.commerce.soa.common.model.Item;

@Service
public class MyService {

    @Autowired
    private ItemMapper itemMapper;
    
    public List<Item> getDemo() {
    	List<Item> r = itemMapper.findAll();
    	return r;
    }
    
}
