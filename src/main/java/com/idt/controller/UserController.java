package com.id;

import com.idt.service.UserMockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by eric on 26/11/16.
 */
@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserMockService userMockService;

    @Autowired
    public UserController(UserMockService userMockService){
        this.userMockService = userMockService;
    }

    /**
     * get user by id references
     *
     * @param userId
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public getUser(@PathVariable String userId) {
        return customerService.findById(userId);
    }

    /**
     * updateUser customer
     *
     * @param customer
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Customer updateUser(@RequestBody Customer customer) {
        logger.info("creating or updating company: {}", customer);
        return customerService.saveOrUpdate(customer);
    }

}
