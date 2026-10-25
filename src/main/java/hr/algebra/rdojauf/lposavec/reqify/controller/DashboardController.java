package hr.algebra.rdojauf.lposavec.reqify.controller;

import hr.algebra.rdojauf.lposavec.reqify.model.Application;
import hr.algebra.rdojauf.lposavec.reqify.model.Candidate;
import hr.algebra.rdojauf.lposavec.reqify.service.CandidateService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.*;

@RestController
@RequestMapping("/dashboard")
@AllArgsConstructor
public class DashboardController {

    private CandidateService candidateService;

    @GetMapping
    public List<Application> getApplications(Model model) {
        return Collections.emptyList();
    }

    @GetMapping("/cans")
    public List<Candidate> getCandidates() {
        return candidateService.getAll();
    }
}
