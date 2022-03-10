package com.colin.annotation.service;

import com.colin.annotation.bean.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CollectionService {
    @Autowired
    List<Animal> animalList;
    @Autowired
    Map<String,Animal> animalMap;

    public void method(){
        if(animalList == null){
            System.out.println("no annimal");
        }else{
            for (Animal animal : animalList) {
                animal.speak();
            }

            for (Map.Entry<String, Animal> stringAnimalEntry : animalMap.entrySet()) {
                System.out.println(stringAnimalEntry.getKey() + "\t" + stringAnimalEntry.getValue());
            }
        }
    }
}
