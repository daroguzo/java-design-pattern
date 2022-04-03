package com.daroguzo.javadesignpattern.structure.adapter;

import com.daroguzo.javadesignpattern.structure.adapter.security.LoginHandler;
import com.daroguzo.javadesignpattern.structure.adapter.security.UserDetailsService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("daroguzo", "daroguzo");
        System.out.println(login);
    }
}
