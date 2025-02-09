package by.svyat.spring.security.basic.service;

import by.svyat.spring.security.basic.common.UserRequest;
import by.svyat.spring.security.basic.repository.UserDaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDaoRepository userDaoRepository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(UserRequest user) {
        UserDetails newUser = User.builder()
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .roles(user.getRole())
                .build();

        userDaoRepository.createUser(newUser);
        userDaoRepository.addRole(newUser);
    }

}
