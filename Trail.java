/**
 * Trail.java
 * @author Paul Sheridan and Matthew Rodarmel
 * This sets and gets the trails, and formats how they are printed.
 */
package trailguide.model
public class Trail {
    private String name;
    private String region;
    private float lengthMiles;
    private boolean dogFriendly;
    private int id;
    public Trail(String name, String region, float lengthMiles, boolean dogFriendly) {
        this(0, name, region, lengthMiles, dogFriendly);
    }
    public Trail(int id, String name, String region, float lengthMiles, boolean dogFriendly) {
        setId(id);
        setName(name);
        setRegion(region);
        setLengthMiles(lengthMiles);
        setDogFriendly(dogFriendly);
    }
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("Id cannot be negative: " + id);
        }
        this.id=id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name){
        if(name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name=name.trim();
    }
    public String getRegion() {
        return this.region;
    }
    public void setRegion(String region){
        if(region == null || region.trim().isEmpty()) {
            throw new IllegalArgumentException("Region cannot be empty.");
        }
        this.region=region.trim();
    }
    public float getLengthMiles() {
        return this.lengthMiles;
    }
    public void setLengthMiles(float lengthMiles){
        if(lengthMiles < 0) {
            throw new IllegalArgumentException("Length cannot be negative: " + lengthMiles);
        }
        this.lengthMiles=lengthMiles;
    }
    public boolean isDogFriendly() {
        return this.dogFriendly;
    }
    public void setDogFriendly(boolean dogFriendly){
        this.dogFriendly=dogFriendly;
    }
    @Override
    public String toString() {
        return String.format("#%-2d %-22s %-38s %6.2f %s", id, name, region, lengthMiles, dogFriendly ? "Dog Friendly" : "Not Dog Friendly");
    }
}
