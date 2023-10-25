package com.ser515.ScrumRunner.services;

import com.ser515.ScrumRunner.data.SpringReposiroty;
import com.ser515.ScrumRunner.model.Spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceImpl implements SpringService {

    private SpringReposiroty springReposiroty;

    @Autowired
    public SpringServiceImpl(SpringReposiroty springReposiroty){
        this.springReposiroty=springReposiroty;
    }


    @Override
    public Spring getSpring() {
        return springReposiroty.getSpring();
    }
}
