package sg.edu.nus.iss.d13work.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @NotEmpty(message = "First name is mandatory")
    @Size(min=3, max=20, message = "First Name must be betweek 3-20 characters")
    private String firstName;

    @NotEmpty(message = "Last name is mandatory")
    @Size(min=3, max=20, message = "Last Name must be betweek 3-20 characters")
    private String lastName;

    @Email(message = "Invalid Email Format")
    @Size(max =30, message = "Email length exceeded 30 characters")
    @NotBlank //if this is removed, email is an optional field to be filled in
    private String email;

    @Pattern(regexp ="(\\8|9) [0-9]{7}", message = "Invalid phone number entered")
    private String phoneNo;

    @Min(value=1500, message="Minimum salary starts from $1500")
    @Max(value=500000, message=" Maximum salary cannot exceed $500000")
    private Integer salary;

    @Past(message="Birth date must be a past date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    @Digits(fraction=0, integer=6, message="Invalid postal code") //for not allowing user put any decimal points
    @Min(value=111111, message="starts from 111111")
    @Max(value=899999, message="ends at 899999")
    private Integer postalCode;


    
}
