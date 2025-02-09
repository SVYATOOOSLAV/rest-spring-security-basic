package by.svyat.spring.security.basic.controller;

import by.svyat.spring.security.basic.common.UserDeleteRequest;
import by.svyat.spring.security.basic.common.UserDeleteResponse;
import by.svyat.spring.security.basic.common.UserRequest;
import by.svyat.spring.security.basic.common.UserResponse;
import by.svyat.spring.security.basic.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public UserResponse createUser(
           @Valid @RequestBody UserRequest request
    ){
        return userService.createUser(request);
    }

    @PatchMapping()
    public UserResponse updateUser(
            @Valid @RequestBody UserRequest request
    ){
        return userService.updateUser(request);
    }

    @DeleteMapping
    public UserDeleteResponse deleteUser(
            @Valid @RequestBody UserDeleteRequest request
    ){
        return userService.deleteUser(request);
    }
}
