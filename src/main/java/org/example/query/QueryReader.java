package org.example.query;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class QueryReader {
    public static List<String> getQuery(String path){
        File queries = new File(path);
        StringBuilder listOfQueries = new StringBuilder();
        Scanner sc;
        try {
            sc = new Scanner(queries);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while(sc.hasNext()){
            listOfQueries.append(sc.nextLine());
            listOfQueries.append("\n");
        }

        List<String> listOfQuery = List.of(listOfQueries.toString().replace("\t", "").split("\n\n"));

        if(listOfQuery==null){
            System.out.println("There aren't any query at file");
            return null;
        }

        return listOfQuery;
    }
}
