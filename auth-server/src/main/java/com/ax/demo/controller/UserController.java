package com.ax.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Sebarswee
 */
@RestController
public class UserController {

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
}
