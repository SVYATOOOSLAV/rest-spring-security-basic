package by.svyat.spring.security.basic.common;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDeleteRequest {

    @NotBlank(message = "Поле username не должно быть пустым")
    private String username;
}
