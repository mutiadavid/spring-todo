package com.example.demo.services;

import java.util.Arrays;
import java.util.List;

public class TestService{
    public String getTest(){
        return "Test Function";
    }  

    public List<String> getTests(){
       return Arrays.asList("Test 1","Test 2");
    }
}