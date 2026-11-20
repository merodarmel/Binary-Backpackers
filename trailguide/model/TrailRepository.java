package trailguide.model;

import java.util.List;

/**
 * TrailRepository.java
 * @author Matthew Rodarmel and Paul Sheridan
 * Defines the operations for finding, saving, and deleting trail records.
 * Implementations provide the storage for those records.
 */
public interface TrailRepository {
    List<Trail> findAll();
    Trail findById(int id);
    Trail save(Trail trail);
    void deleteById(int id);
}
