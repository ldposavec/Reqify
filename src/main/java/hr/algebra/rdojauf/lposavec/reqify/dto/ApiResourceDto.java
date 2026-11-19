package hr.algebra.rdojauf.lposavec.reqify.dto;

import java.util.Map;

/** Stable API representation used by resource endpoints; persistence entities never cross the API boundary. */
public record ApiResourceDto(Integer id, String resource, Map<String, Object> attributes) {
    public ApiResourceDto(Integer id, String resource) {
        this(id, resource, Map.of());
    }
}
