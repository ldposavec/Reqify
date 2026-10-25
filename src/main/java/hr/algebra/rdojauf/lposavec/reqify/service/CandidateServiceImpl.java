package hr.algebra.rdojauf.lposavec.reqify.service;

import hr.algebra.rdojauf.lposavec.reqify.model.Candidate;
import hr.algebra.rdojauf.lposavec.reqify.model.CandidateSkill;
import hr.algebra.rdojauf.lposavec.reqify.model.EducationEntry;
import hr.algebra.rdojauf.lposavec.reqify.model.WorkExperienceEntry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class CandidateServiceImpl implements CandidateService {
    @Override
    public List<Candidate> getAll() {
        // This is a temp method for testing:
        CandidateSkill java = CandidateSkill.builder().name("Java").experienceMonths(9).build();
        CandidateSkill cs = CandidateSkill.builder().name("C#").experienceMonths(9).build();

        Set<CandidateSkill> skills = new HashSet<>();
        skills.add(java);
        skills.add(cs);

        EducationEntry educationEntry = EducationEntry.builder()
                .fieldOfStudy("CS")
                .graduationYear(3)
                .institution("Uni")
                .qualification("Qual").build();

        List<EducationEntry> educationEntries = new ArrayList<>();
        educationEntries.add(educationEntry);

        WorkExperienceEntry workExperienceEntry = WorkExperienceEntry.builder()
                .description("desc")
                .employer("John")
                .endedOn(LocalDate.now().minusMonths(5))
                .identifyingDetailsSanitized(true)
                .jobTitle("Job")
                .startedOn(LocalDate.now().minusMonths(10))
                .build();
        List<WorkExperienceEntry> workExperienceEntries = new ArrayList<>();
        workExperienceEntries.add(workExperienceEntry);

        Candidate candidate = Candidate.builder()
                .id(1)
                .anonymousReference("anon")
                .professionalSummary("summary")
                .totalExperienceMonths(18)
                .skills(skills)
                .education(educationEntries)
                .workExperience(workExperienceEntries)
                .certifications(Collections.emptySet())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .version(1L)
                .build();

        List<Candidate> candidates = new ArrayList<>();
        candidates.add(candidate);

        return candidates;
    }
}
