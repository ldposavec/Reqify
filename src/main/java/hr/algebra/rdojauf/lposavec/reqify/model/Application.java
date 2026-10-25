package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "candidate_id",
                "vacancy_id"
        })
})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, updatable = false)
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Vacancy vacancy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private VacancyStage currentStage;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status;

    @Column(nullable = false)
    private Instant createdAt;

    private Instant withdrawnAt;
    private Instant closedAt;

    @ElementCollection
    @CollectionTable(
            name = "application_answers",
            joinColumns = @JoinColumn(name = "application_id")
    )
    @MapKeyColumn(name = "question_key")
    @Column(length = 4000)
    private Map<String, String> answers = new HashMap<>();

    @Version
    private long version;
}
