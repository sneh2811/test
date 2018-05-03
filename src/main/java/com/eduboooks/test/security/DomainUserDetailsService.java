package com.eduboooks.test.security;


import com.eduboooks.test.domain.ISBN;
import com.eduboooks.test.repositories.ISBNRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Locale;
import java.util.Optional;


/**
 * Authenticate a user from the database.
 */
@Component("userDetailsService")
public class DomainUserDetailsService implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(DomainUserDetailsService.class);

    private final ISBNRepository ISBNRepository;

    public DomainUserDetailsService(ISBNRepository ISBNRepository) {
        this.ISBNRepository = ISBNRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(final String email) {
        return null;
    }
}
