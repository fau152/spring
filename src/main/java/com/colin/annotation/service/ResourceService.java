package com.colin.annotation.service;

import com.colin.annotation.bean.Animal;
import com.colin.annotation.bean.impl.Dog;
import com.colin.annotation.bean.impl.Pig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class ResourceService {
    @Qualifier("dog")
    @Autowired
    Animal animal;

    public void method(){
        animal.speak();
        animal.run();
    }
}
