package org.example.response;

public class LongestProjectResponse {
    private final int id;
    private final int durationMonth;

    public LongestProjectResponse(int id, int durationMonth) {
        this.id = id;
        this.durationMonth = durationMonth;
    }

    public int getId() {
        return id;
    }
    public int getDurationMonth() {
        return durationMonth;
    }

    @Override
    public String toString() {
        return "LongestProjectResponse{" +
                "id=" + id +
                ", duration_month=" + durationMonth +
                '}';
    }

}
