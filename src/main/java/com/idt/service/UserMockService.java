package com.idt.service;

import com.idt.IDTException;
import com.idt.model.ImmutableUser;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

/**
 * Mock service just to fake retrive and update operations
 * <p>
 * Created by eric.nascimento on 26/11/16.
 */
@Service
public class UserMockService {

    public Optional<ImmutableUser> findById(UUID id) {
        return Optional.ofNullable(ImmutableUser.builder().id(id).name("Eric").surName("Nascimento").phoneNumber("+5511951309538").email("ericsantosnascimento@gmail.com").build());
    }

    public ImmutableUser update(UUID id, ImmutableUser user) {
        return findById(id).map(t -> user.withModifiedDate(Instant.now())).orElseThrow(() -> new IDTException("User not Found!"));
    }
}
