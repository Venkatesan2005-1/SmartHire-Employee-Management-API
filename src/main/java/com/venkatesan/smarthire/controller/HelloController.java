package com.venkatesan.smarthire.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "SmartHire API is live!";
    }

    @GetMapping("/status")
    public String status() {
        return "Server running — Venkatesan's SmartHire v1.0";
    }
}