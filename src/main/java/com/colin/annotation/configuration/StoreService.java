package com.colin.annotation.configuration;

import com.colin.annotation.configuration.impl.IntegerStore;
import com.colin.annotation.configuration.impl.StringStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    IntegerStore integerStore;

    @Autowired
    StringStore stringStore;

    public void method(){
        System.out.println(integerStore);
        System.out.println(stringStore);
    }
}
