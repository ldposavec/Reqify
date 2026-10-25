package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.VacancyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String reference;

    @Column(nullable = false)
    private String title;

    private String department;
    private String location;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VacancyStatus status;

    @Column(nullable = false)
    private Integer hiringManagerId;

    private LocalDate closingDate;

    @OneToMany(
            mappedBy = "vacancy",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @OrderBy("displayOrder asc")
    private List<VacancyStage> stages = new ArrayList<>();

    @Version
    private long version;
}
