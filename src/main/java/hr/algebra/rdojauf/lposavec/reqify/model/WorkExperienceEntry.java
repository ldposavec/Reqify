package hr.algebra.rdojauf.lposavec.reqify.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class WorkExperienceEntry {

    private String jobTitle;
    private String employer;

    private LocalDate startedOn;
    private LocalDate endedOn;

    @Column(length = 4000)
    private String description;

    private boolean identifyingDetailsSanitized;
}
