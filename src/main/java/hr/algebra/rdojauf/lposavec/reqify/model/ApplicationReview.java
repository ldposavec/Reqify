package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.ReviewStatus;
import hr.algebra.rdojauf.lposavec.reqify.enums.ReviewType;
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
public class ApplicationReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Application application;

    @Column(nullable = false)
    private Integer reviewerUserId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ReviewStatus status;

    @ElementCollection
    @CollectionTable(
            name = "review_evaluations",
            joinColumns = @JoinColumn(name = "review_id")
    )
    @MapKeyColumn(name = "criterion_key")
    private Map<String, ReviewEvaluation> evaluations = new HashMap<>();

    @Column(length = 8000)
    private String notes;

    private Instant createdAt;
    private Instant dueAt;
    private Instant completedAt;

    @Version
    private long version;
}
