package BeatrizCesconettoSchool.scholarship.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ScumMasterTable")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ScrumMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @Email
    @NotBlank
    private String email;

    @OneToOne(mappedBy = "scrumMaster")
    @JsonBackReference
    private SchoolClass schoolClass;
}
