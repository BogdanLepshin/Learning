package ua.testing.demo_jpa.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegisterForm {
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank (message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Must have email's address format")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min=8, message="Password must be at least 8 symbols")
    private String password;
    @NotBlank(message = "Confirmation is required")
    @Size(min=8, message="Password must be at least 8 symbols")
    private String confirmPassword;
}
