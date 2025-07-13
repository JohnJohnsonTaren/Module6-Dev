package behavior.db.model;

public class LongestProject {
    private String nameClient;

    public LongestProject(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    @Override
    public String toString() {
        return "Longest Project {Name Client = " + nameClient + "}";
    }
}
