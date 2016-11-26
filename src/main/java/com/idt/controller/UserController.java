package com.idt.controller;

import com.idt.model.ImmutableUser;
import com.idt.service.UserMockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * User controller API
 * <p>
 * Created by eric on 26/11/16.
 */
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserMockService userMockService;

    @Autowired
    public UserController(UserMockService userMockService) {
        this.userMockService = userMockService;
    }

    /**
     * Get user by id
     *
     * @param id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ImmutableUser getUser(@PathVariable String id) {
        return userMockService.findById(UUID.fromString(id)).orElse(null);
    }

    /**
     * Update user information
     *
     * @param id
     * @param user
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ImmutableUser updateUser(@PathVariable String id, @RequestBody ImmutableUser user) {
        return userMockService.update(UUID.fromString(id), user);
    }

}
