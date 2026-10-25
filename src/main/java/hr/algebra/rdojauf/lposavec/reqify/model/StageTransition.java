package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.RecruitmentRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StageTransition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Application application;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VacancyStage previousStage;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VacancyStage newStage;

    @Column(nullable = false)
    private Integer actorUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecruitmentRole actorRole;

    @Column(length = 4000)
    private String comment;

    @Column(nullable = false, updatable = false)
    private Integer createdAt;

    @Column(nullable = false, updatable = false)
    private String authorizationPolicyVersion;
}
