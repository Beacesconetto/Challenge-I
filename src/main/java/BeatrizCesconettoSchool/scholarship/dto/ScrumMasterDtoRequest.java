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
public class ScrumMasterDtoRequest {

    private Long Id;


    private String name;


    private String lastname;


    private String email;

}
