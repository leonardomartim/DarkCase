package model;

public class Case {
    private String caseName;
    private String description;
    private String location;
    private String date;
    private boolean isOpen;

    // Construtor
    public Case(String caseName, String description, String location, String date, boolean isOpen) {
        this.caseName = caseName;
        this.description = description;
        this.location = location;
        this.date = date;
        this.isOpen = isOpen;
    }

    // Getters
    public String getCaseName() {
        return caseName;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public boolean isOpen() {
        return isOpen;
    }

    // Setters
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    // Método para representar o caso como String (opcional)
    @Override
    public String toString() {
        return "Case: " + caseName + "\nDescription: " + description + "\nLocation: " + location + "\nDate: " + date + "\nStatus: " + (isOpen ? "Open" : "Closed");
    }
}
