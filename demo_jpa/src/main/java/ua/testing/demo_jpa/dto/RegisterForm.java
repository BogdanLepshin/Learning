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
    @NotBlank(message = "{registration.validation.firstName}")
    private String firstName;
    @NotBlank (message = "{registration.validation.lastName}")
    private String lastName;
    @NotBlank(message = "{registration.validation.NotBlank.email}")
    @Email(message = "{registration.validation.email}")
    private String email;
    @NotBlank(message = "{registration.validation.password}")
    @Size(min=8, message="{registration.validation.size.password}")
    private String password;
    @NotBlank(message = "{registration.validation.confirmPassword}")
    @Size(min=8, message="{registration.validation.size.confirmPassword}")
    private String confirmPassword;
}
