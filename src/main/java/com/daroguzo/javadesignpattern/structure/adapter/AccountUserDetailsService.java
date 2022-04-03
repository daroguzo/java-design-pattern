package com.daroguzo.javadesignpattern.structure.adapter;

import com.daroguzo.javadesignpattern.structure.adapter.security.UserDetails;
import com.daroguzo.javadesignpattern.structure.adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    private AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        return new AccountUserDetails(accountService.findAccountByUsername(username));
    }
}
