package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.RecruitmentRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "vacancy_id",
                "stage_key"
        })
})
public class VacancyStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Vacancy vacancy;

    @Column(name = "stage_key", nullable = false)
    private String key;

    @Column(nullable = false)
    private int displayOrder;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecruitmentRole ownerRole;

    @Column(nullable = false)
    private boolean terminal;

    @ElementCollection
    private Set<String> requiredFields = new HashSet<>();

    @OneToMany(
            mappedBy = "sourceStage",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<AllowedStageTransition> allowedTransitions = new HashSet<>();
}
