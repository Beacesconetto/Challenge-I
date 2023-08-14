package BeatrizCesconettoSchool.scholarship.dto;

import BeatrizCesconettoSchool.scholarship.entity.*;
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
public class SchoolClassDto {

    private Long id;

    private String name;

    private StatusClass statusClass;

    private Coordinator coordinator;

    private ScrumMaster scrumMaster;

    private List<Instructor> instructors = new ArrayList<>();

    private List <Student> students = new ArrayList<>();




}
