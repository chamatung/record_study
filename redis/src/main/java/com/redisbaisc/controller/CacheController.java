package com.redisbaisc.controller;


import com.redisbaisc.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("test")
    public void setTest() {
        System.out.println("start");
        System.out.println(cacheService.test("testKey"));
        System.out.println("end");

    }
    @PostMapping("test1")
    public void getTest() {
        System.out.println(cacheService.test("testKey1"));
    }

}
