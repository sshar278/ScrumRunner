package com.ser515.ScrumRunner.services;

import com.ser515.ScrumRunner.data.SpringRepository;
import com.ser515.ScrumRunner.model.Spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpringServiceImpl implements SpringService {

    private SpringRepository springRepository;

    @Autowired
    public SpringServiceImpl(SpringRepository springRepository){
        this.springRepository = springRepository;
    }


    @Override
    public Spring getSpring() {
        return springRepository.getSpring();
    }
}
