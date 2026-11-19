package hr.algebra.rdojauf.lposavec.reqify.service;

import hr.algebra.rdojauf.lposavec.reqify.dto.CandidateDto;
import hr.algebra.rdojauf.lposavec.reqify.mapper.CandidateMapper;
import hr.algebra.rdojauf.lposavec.reqify.model.Candidate;
import hr.algebra.rdojauf.lposavec.reqify.repository.CandidateRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final CandidateMapper candidateMapper;

    public CandidateServiceImpl(CandidateRepository candidateRepository, CandidateMapper candidateMapper) {
        this.candidateRepository = candidateRepository;
        this.candidateMapper = candidateMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CandidateDto> getAll() {
        return candidateRepository.findAll().stream()
                .map(candidateMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CandidateDto getById(Integer id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Candidate not found: " + id));
        return candidateMapper.toDto(candidate);
    }

    @Override
    public CandidateDto save(CandidateDto candidateDto) {
        if (candidateDto == null) {
            throw new IllegalArgumentException("Candidate data is required");
        }
        Candidate candidate = candidateMapper.toEntity(candidateDto);
        Instant now = Instant.now();
        if (candidate.getCreatedAt() == null) {
            candidate.setCreatedAt(now);
        }
        candidate.setUpdatedAt(now);
        return candidateMapper.toDto(candidateRepository.save(candidate));
    }

    @Override
    public CandidateDto update(CandidateDto candidateDto) {
        if (candidateDto == null) {
            throw new IllegalArgumentException("Candidate data is required");
        }
        Candidate candidate = candidateMapper.toEntity(candidateDto);
        if (candidate.getId() == null) {
            throw new IllegalArgumentException("Candidate id is required for update");
        }

        Candidate existing = candidateRepository.findById(candidate.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Candidate not found: " + candidate.getId()));
        candidate.setCreatedAt(existing.getCreatedAt());
        candidate.setUpdatedAt(Instant.now());
        return candidateMapper.toDto(candidateRepository.save(candidate));
    }

    @Override
    public void deleteById(Integer id) {
        if (!candidateRepository.existsById(id)) {
            throw new EntityNotFoundException("Candidate not found: " + id);
        }
        candidateRepository.deleteById(id);
    }
}
