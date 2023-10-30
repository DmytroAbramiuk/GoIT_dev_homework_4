package org.example.Tasks;

import org.example.config.H2Db;
import org.example.query.QueryReader;

import java.util.List;

public class DatabaseInitService {
    public static void main(String[] args) {
        H2Db instance = H2Db.getInstance();
        List<String> queryListForCreateTables = QueryReader.getQuery("src/main/resources/sql/createTables.sql");

        for(String query : queryListForCreateTables){
            instance.executeUpdate(query);
        }
    }
}
