package com.example.getmap.controller;

import org.springframework.web.bind.annotation.*;


import javax.crypto.KeyGenerator;

import java.security.Signature;
import java.util.Base64;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class DemoController {
    private boolean verify;
    @GetMapping("/sign")
    public boolean sign(@RequestBody String value) throws Exception{

        Signature sign = Signature.getInstance("SHA256withRSA");

        KeyGen keyGen = new KeyGen();
        sign.initSign(keyGen.getKey());
        byte[] bytes = value.getBytes();

        sign.update(bytes);

        byte[] signature = sign.sign();

        PublicKeyGen pubKeyGen = new PublicKeyGen();
        sign.initVerify(pubKeyGen.getPublicKey());

        sign.update(bytes);

        this.verify = sign.verify(signature);

        return this.verify;
    }
}
