package by.svyat.spring.security.basic.common;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {

    @NotBlank(message = "Поле username не должно быть пустым")
    private String username;

    @NotBlank(message = "Поле password не должно быть пустым")
    private String password;

    @NotBlank(message = "Поле role не должно быть пустым")
    private String role;
}
