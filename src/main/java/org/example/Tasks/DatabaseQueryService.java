package org.example.Tasks;

import org.example.config.H2Db;
import org.example.query.QueryReader;
import org.example.response.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseQueryService {
    public static void getLongestProject() {
        List<String> queryListForLongestProject = QueryReader.getQuery("src/main/resources/sql/find_longest_project.sql");
        LongestProjectResponse lpr;
        for(String query : queryListForLongestProject){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    lpr = new LongestProjectResponse(resultSet.getInt("id"), resultSet.getInt("duration_months"));
                    System.out.println(lpr);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getMaxProjectsClient(){
        List<String> queryListForMaxProjectsClient = QueryReader.getQuery("src/main/resources/sql/find_max_projects_client.sql");
        MaxProjectsClientResponse mpcr;
        for(String query : queryListForMaxProjectsClient){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    mpcr = new MaxProjectsClientResponse(resultSet.getString("name"), resultSet.getInt("PROJECT_COUNT"));
                    System.out.println(mpcr);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getMaxSalaryWorker(){
        List<String> queryListForMaxSalaryWorker = QueryReader.getQuery("src/main/resources/sql/find_max_salary_worker.sql");
        MaxSalaryWorkerResponse mswr;
        for(String query : queryListForMaxSalaryWorker){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    mswr = new MaxSalaryWorkerResponse(resultSet.getString("name"), resultSet.getInt("salary"));
                    System.out.println(mswr);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getYoungestEldestWorkers(){
        List<String> queryListForYoungestEldestWorkers = QueryReader.getQuery("src/main/resources/sql/find_youngest_eldest_workers.sql");
        YoungestEldestWorkersResponse yewr;
        for(String query : queryListForYoungestEldestWorkers){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    yewr = new YoungestEldestWorkersResponse(resultSet.getString("type"), resultSet.getString("name"), resultSet.getDate("birthday"));
                    System.out.println(yewr);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void getProjectPrices(){
        List<String> queryListForProjectPrices = QueryReader.getQuery("src/main/resources/sql/print_project_prices.sql");
        ProjectPricesResponse ppr;
        for(String query : queryListForProjectPrices){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    ppr = new ProjectPricesResponse(resultSet.getInt("project_id"), resultSet.getInt("price"));
                    System.out.println(ppr);
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
