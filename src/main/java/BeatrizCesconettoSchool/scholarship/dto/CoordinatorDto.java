package BeatrizCesconettoSchool.scholarship.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CoordinatorDto {


    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    private String email;
}
