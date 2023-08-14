package BeatrizCesconettoSchool.scholarship.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SchoolClassTable")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    private StatusClass statusClass;

    @OneToMany
    private List <Student> students = new ArrayList<>();

    @OneToMany
    private List <Instructor> instructors = new ArrayList<>();

    @OneToOne
    private Coordinator coordinator;

    @OneToOne
    private ScrumMaster scrumMaster;

}
