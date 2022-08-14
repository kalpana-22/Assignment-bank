package lk.bankSystemBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO implements Serializable {
    @Null(message = "Id cannot be set")
    private Integer id;
    @NotNull(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid first name")
    private String firstName;
    @NotNull(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid last name")
    private String lastName;
    @NotNull(message = "Date of birth cannot be empty")
    private Date dob;
    @NotNull(message = "Phone number cannot be empty")
    private Integer phoneNumber;
    @NotNull(message = "NIC cannot be empty")
    private String nic;
    @NotNull(message = "Address cannot be empty")
    private String address;
    @NotNull(message = "Gender cannot be empty")
    private String gender;
}
