package BeatrizCesconettoSchool.scholarship.dto;

import BeatrizCesconettoSchool.scholarship.entity.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SquadDtoRequest {


    private Long Id;
    private String name;

    @Size(max = 5)
    private List <Long> students = new ArrayList<>();

}
