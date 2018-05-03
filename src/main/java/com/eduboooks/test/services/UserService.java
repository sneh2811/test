package com.eduboooks.test.services;

import com.eduboooks.test.domain.ISBN;
import com.eduboooks.test.repositories.ISBNRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final ISBNRepository ISBNRepository;

    private final AuthenticationManager authenticationManager;

    public UserService(ISBNRepository ISBNRepository, AuthenticationManager authenticationManager) {
        this.ISBNRepository = ISBNRepository;
        this.authenticationManager = authenticationManager;
    }

    public ISBN findOne(Long id) {
        log.debug("Request to get ISBN : {}", id);
        return ISBNRepository.findOne(id);
    }
}
