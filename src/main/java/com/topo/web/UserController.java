package com.topo.web;

import com.topo.entities.AppUser;
import com.topo.services.AccountService;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private AccountService accountService;

    public UserController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping("/register")
    private AppUser register(@RequestBody UserForm userForm) {
        return accountService.saveUser(userForm.getUsername(), userForm.getPassword(), userForm.getConfirmatedPassword());
    }
}

@Data
class UserForm {
    private String username;
    private String password;
    private String confirmatedPassword;
}
