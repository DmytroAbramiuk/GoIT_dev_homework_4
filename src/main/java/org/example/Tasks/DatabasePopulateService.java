package org.example.Tasks;

import org.example.config.H2Db;
import org.example.query.QueryReader;

import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        H2Db instance = H2Db.getInstance();
        List<String> queryListForPopulate = QueryReader.getQuery("src/main/resources/sql/populate_db.sql");

        for(String query : queryListForPopulate){
            instance.executeUpdate(query);
        }
    }
}
