package hr.algebra.rdojauf.lposavec.reqify.service;

import hr.algebra.rdojauf.lposavec.reqify.dto.ApiResourceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiResourceService {
    public List<ApiResourceDto> list(JpaRepository<?, Integer> repository, String resource) {
        return repository.findAll().stream().map(entity -> toDto(entity, resource)).toList();
    }

    public ApiResourceDto get(JpaRepository<?, Integer> repository, Integer id, String resource) {
        return repository.findById(id).map(entity -> toDto(entity, resource))
                .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException(resource + " not found: " + id));
    }

    private ApiResourceDto toDto(Object entity, String resource) {
        try {
            var method = entity.getClass().getMethod("getId");
            return new ApiResourceDto((Integer) method.invoke(entity), resource);
        } catch (ReflectiveOperationException ex) {
            return new ApiResourceDto(null, resource);
        }
    }
}
