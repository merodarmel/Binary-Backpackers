package trailguide;

import trailguide.model.InMemoryTrailRepository;
import trailguide.model.Trail;
import trailguide.model.TrailRepository;

public class Main {
    public static void main(String[] args) {
        TrailRepository repository = new InMemoryTrailRepository();

        System.out.println("=== CREATE ===");
        Trail mistTrail = repository.save(
                new Trail("Mist Trail", "Yosemite National Park", 2.5f, false));
        Trail landsEndTrail = repository.save(
                new Trail("Lands End Trail", "San Francisco", 3.4f, true));
        System.out.println("Created: " + mistTrail);
        System.out.println("Created: " + landsEndTrail);

        System.out.println("\n=== LIST ===");
        for (Trail trail : repository.findAll()) {
            System.out.println(trail);
        }

        System.out.println("\n=== FIND ===");
        Trail found = repository.findById(mistTrail.getId());
        System.out.println(found == null ? "Trail not found." : "Found: " + found);

        System.out.println("\n=== UPDATE ===");
        Trail updatedMistTrail = new Trail(
                mistTrail.getId(), "Mist Trail", "Yosemite National Park", 3.0f, false);
        System.out.println("Updated: " + repository.save(updatedMistTrail));

        System.out.println("\n=== DELETE ===");
        repository.deleteById(landsEndTrail.getId());
        System.out.println("Deleted trail #" + landsEndTrail.getId());

        System.out.println("\n=== LIST AFTER UPDATE AND DELETE ===");
        for (Trail trail : repository.findAll()) {
            System.out.println(trail);
        }
    }
}
