package by.svyat.spring.security.basic.service;

import by.svyat.spring.security.basic.common.UserDeleteRequest;
import by.svyat.spring.security.basic.common.UserDeleteResponse;
import by.svyat.spring.security.basic.common.UserRequest;
import by.svyat.spring.security.basic.common.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserDetailsManager userDetailsManager;
    private final UserMapper userMapper;

    public UserResponse createUser(UserRequest user) {
        var newUser = userMapper.mapToUserDetails(user);

        if(!userDetailsManager.userExists(user.getUsername())) {
            userDetailsManager.createUser(newUser);
        } else {
            log.warn("User with username: [{}] already exists, skip store", user.getUsername());
        }

        return new UserResponse(user.getUsername(), user.getRole(), true);
    }

    public UserResponse updateUser(UserRequest user) {
        var newUser = userMapper.mapToUserDetails(user);

        if(userDetailsManager.userExists(user.getUsername())) {
            userDetailsManager.updateUser(newUser);
        } else {
            log.warn("User with username: [{}] doesnt exists, skip updating", user.getUsername());
        }

        return new UserResponse(user.getUsername(), user.getRole(), true);
    }

    public UserDeleteResponse deleteUser(UserDeleteRequest user) {

        if(userDetailsManager.userExists(user.getUsername())) {
            userDetailsManager.deleteUser(user.getUsername());
        } else {
            log.warn("User with username: [{}] doesnt exists, skip deleting", user.getUsername());
        }

        return new UserDeleteResponse(user.getUsername());
    }

}
