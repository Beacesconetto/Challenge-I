package BeatrizCesconettoSchool.scholarship.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CoordinatorTable")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    private String lastname;

    @Email
    private String email;

    @OneToOne(mappedBy = "coordinator")
    @JoinColumn(name = "schoolclass_id")
    private SchoolClass schoolClass;
}
