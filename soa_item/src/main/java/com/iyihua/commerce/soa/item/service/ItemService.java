package com.iyihua.commerce.soa.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iyihua.commerce.soa.item.mapper.ItemMapper;
import com.iyihua.commerce.soa.item.model.Item;


@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;
    
    public List<Item> getDemo() {
    	List<Item> r = itemMapper.findAll();
    	return r;
    }
    
}
