package hr.algebra.rdojauf.lposavec.reqify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkill {

    @Column(nullable = false)
    private String name;

    private Integer experienceMonths;
}
