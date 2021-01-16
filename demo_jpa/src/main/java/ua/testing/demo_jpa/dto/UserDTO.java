package ua.testing.demo_jpa.dto;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Must have email's address format")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min=8, message="Password must be at least 8 symbols")
    private String password;

}
