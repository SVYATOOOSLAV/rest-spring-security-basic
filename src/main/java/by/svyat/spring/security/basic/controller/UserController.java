package by.svyat.spring.security.basic.controller;

import by.svyat.spring.security.basic.common.UserRequest;
import by.svyat.spring.security.basic.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public void createUser(
           @Valid @RequestBody UserRequest request
    ){
        userService.createUser(request);
    }
}
