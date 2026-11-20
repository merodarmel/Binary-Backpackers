package trailguide.model;

import java.util.ArrayList;
import java.util.List;

public class InMemoryItemRepository implements ItemRepository {

  private final List<Item> trails = new ArrayList<>();
  private int nextId = 1;

  @Override
  public List<Item> findAll() {
    return new ArrayList<>(trails);
  }

  @Override
  public Item findById(int id) {
    for (Trail t : trails) {
      if (t.getId() == id) {
        return t;
      }
    }
    return null;
  }

  @Override
  public Item save(Item trail) {
    if(trail == null) {
      throw new IllegalArgumentException("Cannot save a missing trail.");
    }
    if (trail.getId() == 0) {
      trail.setId(nextId++);
      trails.add(trail);
      return trail;
    }
    for (int i = 0; i < trails.size(); i++) {
      if (trails.get(i).getId() == trail.getId()) {
        trails.set(i, trail);
        return trail;
      }
    }
    throw new IllegalArgumentException("No trail with id " + trail.getId() + " to update.");
  }

    @Override
    public void deleteById(int id) {
      trails.removeIf(trail -> trail.getId() == id);
    }
}
