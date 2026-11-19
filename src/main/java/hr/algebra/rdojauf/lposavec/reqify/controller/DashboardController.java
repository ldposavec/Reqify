package hr.algebra.rdojauf.lposavec.reqify.controller;

import hr.algebra.rdojauf.lposavec.reqify.dto.ApiResourceDto;
import hr.algebra.rdojauf.lposavec.reqify.repository.ApplicationRepository;
import hr.algebra.rdojauf.lposavec.reqify.service.ApiResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {
    private final ApplicationRepository applicationRepository;
    private final ApiResourceService resourceService;
    public DashboardController(ApplicationRepository applicationRepository, ApiResourceService resourceService) {
        this.applicationRepository = applicationRepository;
        this.resourceService = resourceService;
    }
    @GetMapping
    public List<ApiResourceDto> getDashboard(@RequestParam(required = false) String include) {
        return resourceService.list(applicationRepository, "Dashboard");
    }
}
