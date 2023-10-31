package org.example.clients;

import java.sql.Date;

public class YoungestEldestWorkersResponse {
    String type;
    String name;
    Date date;
    public YoungestEldestWorkersResponse(String type, String name, Date date) {
        this.type = type;
        this.name = name;
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "YoungestEldestWorkersResponse{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
