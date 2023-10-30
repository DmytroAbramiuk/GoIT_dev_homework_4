package org.example;

import org.example.Tasks.DatabaseQueryService;

import java.sql.SQLException;



public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseQueryService.getLongestProject();
        System.out.println("====================");
        DatabaseQueryService.getMaxProjectsClient();
        System.out.println("====================");
        DatabaseQueryService.getMaxSalaryWorker();
        System.out.println("====================");
        DatabaseQueryService.getYoungestEldestWorkers();
        System.out.println("====================");
        DatabaseQueryService.getProjectPrices();
    }
}