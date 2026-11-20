package trailguide;

import trailguide.model.InMemoryItemRepository;
import trailguide.model.Item;
import trailguide.model.ItemRepository;

/**
 * Main.java
 * @author Matthew Rodarmel and Paul Sheridan
 * Runs a console demonstration of creating, listing, finding, updating,
 * and deleting trails using the in-memory repository.
 */

public class Main {
    public static void main(String[] args) {
        ItemRepository repository = new InMemoryItemRepository();

        System.out.println("=== CREATE ===");
        Item mistTrail = repository.save(
                new Item("Mist Trail", "Yosemite National Park", 2.5f, false));
        Item landsEndTrail = repository.save(
                new Item("Lands End Trail", "San Francisco", 3.4f, true));
        System.out.println("Created: " + mistTrail);
        System.out.println("Created: " + landsEndTrail);

        System.out.println("\n=== LIST ===");
        for (Item trail : repository.findAll()) {
            System.out.println(trail);
        }

        System.out.println("\n=== FIND ===");
        Item found = repository.findById(mistTrail.getId());
        System.out.println(found == null ? "Trail not found." : "Found: " + found);

        System.out.println("\n=== UPDATE ===");
        Item updatedMistTrail = new Item(
                mistTrail.getId(), "Mist Trail", "Yosemite National Park", 3.0f, false);
        System.out.println("Updated: " + repository.save(updatedMistTrail));

        System.out.println("\n=== DELETE ===");
        repository.deleteById(landsEndTrail.getId());
        System.out.println("Deleted trail #" + landsEndTrail.getId());

        System.out.println("\n=== LIST AFTER UPDATE AND DELETE ===");
        for (Item trail : repository.findAll()) {
            System.out.println(trail);
        }
    }
}
