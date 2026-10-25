package hr.algebra.rdojauf.lposavec.reqify.model;

import hr.algebra.rdojauf.lposavec.reqify.enums.EvidenceLevel;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class ReviewEvaluation {

    @Enumerated(EnumType.STRING)
    private EvidenceLevel evidenceLevel;

    @Column(length = 2000)
    private String evidenceNote;
}
