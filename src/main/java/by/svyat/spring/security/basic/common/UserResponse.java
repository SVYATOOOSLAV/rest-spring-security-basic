package by.svyat.spring.security.basic.common;

public record UserResponse(
        String username,
        String role,
        Boolean isActive
) {
}
