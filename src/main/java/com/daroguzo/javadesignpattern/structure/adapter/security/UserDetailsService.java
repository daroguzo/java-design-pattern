package com.daroguzo.javadesignpattern.structure.adapter.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
