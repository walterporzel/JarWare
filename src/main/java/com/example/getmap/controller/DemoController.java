package com.example.getmap.controller;

import org.springframework.web.bind.annotation.*;


import javax.crypto.KeyGenerator;

import java.security.Signature;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DemoController {
    @GetMapping("/sign")
    public byte[] sign(@RequestBody String value) throws Exception{
        Signature sign = Signature.getInstance("SHA256withRSA");

        KeyGen keyGen = new KeyGen();
        sign.initSign(keyGen.getKey());
        byte[] bytes = value.getBytes();

        sign.update(bytes);

        byte[] signature = sign.sign();

        return signature;
    }
}
