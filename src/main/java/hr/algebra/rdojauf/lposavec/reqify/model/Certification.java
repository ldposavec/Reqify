package hr.algebra.rdojauf.lposavec.reqify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certification {

    private String name;
    private LocalDate issuedAt;
    private LocalDate expiresAt;

    private String storageKey;
    private String fileName;
    private String contentType;
    private long sizeBytes;
    private String contentHash;
}
