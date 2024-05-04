package com.kodilla.patterns2.facade;

import org.springframework.stereotype.Service;

@Service
public class Authenticator {

    public boolean isAuthenticated(Long userId) {
        return true;
    }
}
