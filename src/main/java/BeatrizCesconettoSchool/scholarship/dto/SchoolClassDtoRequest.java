package BeatrizCesconettoSchool.scholarship.dto;

import BeatrizCesconettoSchool.scholarship.entity.*;
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
public class SchoolClassDtoRequest {

    private String name;
    private Long coordinator;
    private Long scrumMaster;

    @Size(min = 3)
    private List<Long> instructors = new ArrayList<>();

    @Size(max = 30)
    @Size(min = 15)
    private List <Long> students = new ArrayList<>();

}
