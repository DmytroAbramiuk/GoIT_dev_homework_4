package org.example.clients;

public class ProjectPricesResponse {
    int projectId;
    int price;

    public ProjectPricesResponse(int projectId, int price) {
        this.projectId = projectId;
        this.price = price;
    }

    public int getProjectId() {
        return projectId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ProjectPricesResponse{" +
                "projectId=" + projectId +
                ", price=" + price +
                '}';
    }
}
