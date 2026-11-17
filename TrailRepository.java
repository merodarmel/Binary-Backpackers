package trailguide.model;

import java.util.List;

public interface TrailRepository {
    List<Trail> findAll();
    Trail findById(int id);
    Trail save(Trail trail);
    void deleteById(int id);
}