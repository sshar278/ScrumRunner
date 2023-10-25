package com.ser515.ScrumRunner.data;

import com.ser515.ScrumRunner.model.Spring;
import org.springframework.stereotype.Repository;

@Repository
public class SpringRepositoryImpl implements SpringReposiroty {
    @Override
    public Spring getSpring() {
        Spring spring = new Spring("Project Under Development!");
        return spring;
    }
}
