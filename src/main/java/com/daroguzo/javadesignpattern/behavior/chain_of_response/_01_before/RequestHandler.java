package com.daroguzo.javadesignpattern.behavior.chain_of_response._01_before;

public class RequestHandler {

    public void handler(Request request) {
        System.out.println(request.getBody());
    }
}
