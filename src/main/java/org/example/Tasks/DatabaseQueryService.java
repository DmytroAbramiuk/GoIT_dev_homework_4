package org.example.Tasks;

import org.example.config.H2Db;
import org.example.query.QueryReader;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseQueryService {
    public static void getLongestProject() {
        List<String> queryListForLongestProject = QueryReader.getQuery("src/main/resources/sql/find_longest_project.sql");
        for(String query : queryListForLongestProject){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                    System.out.println(resultSet.getInt("ID") + "\t" + resultSet.getInt("duration_months"));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getMaxProjectsClient(){
        List<String> queryListForMaxProjectsClient = QueryReader.getQuery("src/main/resources/sql/find_max_projects_client.sql");
        for(String query : queryListForMaxProjectsClient){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                    System.out.println(resultSet.getString("name") + "\t" + resultSet.getInt("PROJECT_COUNT"));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getMaxSalaryWorker(){
        List<String> queryListForMaxSalaryWorker = QueryReader.getQuery("src/main/resources/sql/find_max_salary_worker.sql");
        for(String query : queryListForMaxSalaryWorker){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                    System.out.println(resultSet.getString("name") + "\t" + resultSet.getInt("salary"));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getYoungestEldestWorkers(){
        List<String> queryListForYoungestEldestWorkers = QueryReader.getQuery("src/main/resources/sql/find_youngest_eldest_workers.sql");
        for(String query : queryListForYoungestEldestWorkers){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                    System.out.println(resultSet.getString("type") + "\t" + resultSet.getString("name") + "\t" + resultSet.getDate("birthday"));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getProjectPrices(){
        List<String> queryListForProjectPrices = QueryReader.getQuery("src/main/resources/sql/print_project_prices.sql");
        for(String query : queryListForProjectPrices){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next())
                    System.out.println(resultSet.getInt("project_id") + "\t" + resultSet.getInt("price"));
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
