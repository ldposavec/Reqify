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
public class AllowedStageTransition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VacancyStage sourceStage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VacancyStage targetStage;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<RecruitmentRole> permittedRoles = new HashSet<>();

    private boolean commentRequired;
    private boolean reviewRequired;
}
