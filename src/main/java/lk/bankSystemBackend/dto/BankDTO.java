package lk.bankSystemBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDTO implements Serializable {
    @Null(message = "Id cannot be set")
    private Integer id;
    @NotNull(message = "Bank name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]+", message = "Invalid bank name")
    private String bankName;
}
