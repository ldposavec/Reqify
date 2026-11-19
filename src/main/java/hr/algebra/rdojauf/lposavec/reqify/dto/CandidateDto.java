package hr.algebra.rdojauf.lposavec.reqify.dto;

import hr.algebra.rdojauf.lposavec.reqify.model.CandidateSkill;
import hr.algebra.rdojauf.lposavec.reqify.model.Certification;
import hr.algebra.rdojauf.lposavec.reqify.model.EducationEntry;
import hr.algebra.rdojauf.lposavec.reqify.model.WorkExperienceEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDto {

    private Integer id;
    private String anonymousReference;
    private String professionalSummary;
    private Integer totalExperienceMonths;
    private Set<CandidateSkill> skills;
    private List<EducationEntry> education;
    private List<WorkExperienceEntry> workExperience;
    private Set<Certification> certifications;
    private Instant createdAt;
    private Instant updatedAt;
    private long version;
}
