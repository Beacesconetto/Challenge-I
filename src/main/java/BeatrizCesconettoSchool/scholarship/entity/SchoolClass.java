package BeatrizCesconettoSchool.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private StatusClass statusClass;

    @OneToMany(mappedBy = "schoolClass",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List <Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "schoolClass",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List <Instructor> instructors = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "coordinador_id")
    private Coordinator coordinator;

    @OneToOne
    @JoinColumn(name = "scrumMaster_id")
    private ScrumMaster scrumMaster;

    public SchoolClass(String name) {
        this.name = name;
        this.statusClass = StatusClass.WAITING;
    }
}
