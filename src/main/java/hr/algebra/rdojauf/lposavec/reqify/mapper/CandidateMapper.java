package hr.algebra.rdojauf.lposavec.reqify.mapper;

import hr.algebra.rdojauf.lposavec.reqify.dto.CandidateDto;
import hr.algebra.rdojauf.lposavec.reqify.model.Candidate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class CandidateMapper {

    public CandidateDto toDto(Candidate entity) {
        if (entity == null) {
            return null;
        }

        return new CandidateDto(
                entity.getId(),
                entity.getAnonymousReference(),
                entity.getProfessionalSummary(),
                entity.getTotalExperienceMonths(),
                entity.getSkills() == null ? new HashSet<>() : new HashSet<>(entity.getSkills()),
                entity.getEducation() == null ? new ArrayList<>() : new ArrayList<>(entity.getEducation()),
                entity.getWorkExperience() == null
                        ? new ArrayList<>()
                        : new ArrayList<>(entity.getWorkExperience()),
                entity.getCertifications() == null
                        ? new HashSet<>()
                        : new HashSet<>(entity.getCertifications()),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getVersion()
        );
    }

    public Candidate toEntity(CandidateDto dto) {
        if (dto == null) {
            return null;
        }

        return Candidate.builder()
                .id(dto.getId())
                .anonymousReference(dto.getAnonymousReference())
                .professionalSummary(dto.getProfessionalSummary())
                .totalExperienceMonths(dto.getTotalExperienceMonths())
                .skills(dto.getSkills() == null ? new HashSet<>() : new HashSet<>(dto.getSkills()))
                .education(dto.getEducation() == null ? new ArrayList<>() : new ArrayList<>(dto.getEducation()))
                .workExperience(dto.getWorkExperience() == null
                        ? new ArrayList<>()
                        : new ArrayList<>(dto.getWorkExperience()))
                .certifications(dto.getCertifications() == null
                        ? new HashSet<>()
                        : new HashSet<>(dto.getCertifications()))
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .version(dto.getVersion())
                .build();
    }
}
