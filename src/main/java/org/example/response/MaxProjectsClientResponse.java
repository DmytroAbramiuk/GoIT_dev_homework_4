package org.example.response;

public class MaxProjectsClientResponse {
    private final String name;
    private final int projectCount;

    public MaxProjectsClientResponse(String name, int projectCount) {
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
        return "MaxProjectsClientResponse{" +
                "name='" + name + '\'' +
                ", project_count=" + projectCount +
                '}';
    }
}
