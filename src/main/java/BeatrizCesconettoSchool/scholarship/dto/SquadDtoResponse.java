package BeatrizCesconettoSchool.scholarship.dto;

import BeatrizCesconettoSchool.scholarship.entity.Student;
import jakarta.validation.constraints.NotBlank;
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
public class SquadDtoResponse {


    private Long Id;

    @NotBlank
    private String name;

    private List<Student> students = new ArrayList<>();

}
