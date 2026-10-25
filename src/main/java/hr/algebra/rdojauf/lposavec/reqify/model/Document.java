package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.DocumentStatus;
import hr.algebra.rdojauf.lposavec.reqify.enums.DocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Application application;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentType type;

    @Column(nullable = false)
    private String originalFileName;

    @Column(nullable = false)
    private String detectedMimeType;

    @Column(nullable = false)
    private long sizeBytes;

    @Column(nullable = false)
    private String contentHash;

    private String quarantineStorageKey;
    private String permanentStorageKey;
    private String sanitizedStorageKey;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DocumentStatus status;

    private Instant createdAt;
    private Instant scannedAt;
    private Instant storedAt;

    private String scanProvider;
    private String failureCode;
}
