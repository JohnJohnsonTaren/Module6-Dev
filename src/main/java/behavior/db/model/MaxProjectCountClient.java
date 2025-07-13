package behavior.db.model;

public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    public String getName() {
        return name;
    }

    public int getProjectCount() {
        return projectCount;
    }

    @Override
    public String toString() {
        return "Max Project Count Client {Name client = " + name + ", project count = " + projectCount + '}';
    }
}
