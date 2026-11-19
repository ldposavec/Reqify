package hr.algebra.rdojauf.lposavec.reqify.service;

import hr.algebra.rdojauf.lposavec.reqify.dto.CandidateDto;

import java.util.List;

public interface CandidateService {
    List<CandidateDto> getAll();

    CandidateDto getById(Integer id);

    CandidateDto save(CandidateDto candidateDto);

    CandidateDto update(CandidateDto candidateDto);

    void deleteById(Integer id);
}
