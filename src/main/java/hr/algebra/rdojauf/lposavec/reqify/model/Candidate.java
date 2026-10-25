package hr.algebra.rdojauf.lposavec.reqify.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, updatable = false)
    private String anonymousReference;

    @Column(length = 4000)
    private String professionalSummary;

    private Integer totalExperienceMonths;

    @ElementCollection
    @CollectionTable(
            name = "candidate_skills",
            joinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<CandidateSkill> skills = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "candidate_education",
            joinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<EducationEntry> education = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "candidate_experience",
            joinColumns = @JoinColumn(name = "candidate_id")
    )
    private List<WorkExperienceEntry> workExperience = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
            name = "candidate_certifications",
            joinColumns = @JoinColumn(name = "candidate_id")
    )
    private Set<Certification> certifications = new HashSet<>();

    @Column(nullable = false)
    private Instant createdAt;

    @Column(nullable = false)
    private Instant updatedAt;

    @Version
    private long version;
}
