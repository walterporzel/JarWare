package com.example.getmap.controller;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class KeyGen{
    //Instantiate variables so they can be used in another class
    private PrivateKey privKey;

    //reading private key from PEM file
    //Commands for creating private key file:
    //openssl genrsa -out mykey.pem 2048
    //openssl pkcs8 -topk8 -inform PEM -outform PEM -in mykey.pem -out private_key.pem -nocrypt

    public PrivateKey getKey() throws Exception{
        //gets file from resources folder
        File f = ResourceUtils.getFile("classpath:private_key.pem");
        //obtains input bytes from a file in a file system
        FileInputStream fis = new FileInputStream(f);
        //allows application to read primative data from from the input stream
        DataInputStream dis = new DataInputStream(fis);
        byte[] keyBytes = new byte[(int) f.length()];
        dis.readFully(keyBytes);
        dis.close();

        String temp = new String(keyBytes);
        String privKeyPEM = temp.replace("-----BEGIN PRIVATE KEY-----\n","");
        privKeyPEM = privKeyPEM.replace("-----END PRIVATE KEY-----","");

        byte [] decoded = Base64.decodeBase64(privKeyPEM);

        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        this.privKey = kf.generatePrivate(spec);
        return this.privKey;
    }
    //Generating key from key gem

    //public KeyGen throws Exception{
    //Create Keypair generator object
    //KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");

    //Initializing the key pair generator object
    //keyPairGen.initialize(2048);

    //Generate the pair of keys
    //KeyPair pair = keyPairGen.generateKeyPair();

    //Getting the private key from the key pair
    //this.privKey = pair.getPrivate();

    //}
//    public PrivateKey getPrivKey(){
//        return this.privKey;
//    }
}
