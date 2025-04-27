package model;

import java.util.List;

public class Suspect {
    private String name;
    private boolean hasAlibi;
    private boolean wasSeenNearCrime;
    private boolean hasMotive;
    private List<String> linkedEvidences; // ou Evidence, se tiver essa classe

    public Suspect(String name,
                   boolean hasAlibi,
                   boolean wasSeenNearCrime,
                   boolean hasMotive,
                   List<String> linkedEvidences) {
        this.name = name;
        this.hasAlibi = hasAlibi;
        this.wasSeenNearCrime = wasSeenNearCrime;
        this.hasMotive = hasMotive;
        this.linkedEvidences = linkedEvidences;
    }

    public String getName() {
        return name;
    }

    // **GETTERS QUE FALTAVAM**
    public boolean hasAlibi() {
        return hasAlibi;
    }

    public boolean wasSeenNearCrime() {
        return wasSeenNearCrime;
    }

    public boolean hasMotive() {
        return hasMotive;
    }

    public List<String> getLinkedEvidences() {
        return linkedEvidences;
    }

    // opcional: toString(), setters, etc.
}
