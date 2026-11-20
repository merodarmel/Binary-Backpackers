package trailguide.model;

import java.util.List;

/**
 * TrailRepository.java
 * @author Matthew Rodarmel and Paul Sheridan
 * Defines the operations for finding, saving, and deleting trail records.
 * Implementations provide the storage for those records.
 */
public interface ItemRepository {
    List<Item> findAll();
    Item findById(int id);
    Item save(Item trail);
    void deleteById(int id);
}
