package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.ExtractionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvExtraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Document sourceDocument;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Candidate candidate;

    @Enumerated(EnumType.STRING)
    private ExtractionStatus status;

    private String extractorVersion;

    @Column(length = 16000)
    private String structuredPayload;

    private Instant createdAt;
    private Instant completedAt;

    private Integer confirmedByUserId;
    private Instant confirmedAt;
}
