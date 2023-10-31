package org.example.Tasks;

import org.example.config.H2Db;
import org.example.query.QueryReader;
import org.example.clients.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public static List<LongestProjectResponse> getLongestProject() {
        List<String> queryListForLongestProject = QueryReader.getQuery("src/main/resources/sql/find_longest_project.sql");
        List<LongestProjectResponse> lpr = new ArrayList<>();
        for(String query : queryListForLongestProject){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    lpr.add(
                            new LongestProjectResponse(
                                    resultSet.getInt("id"),
                                    resultSet.getInt("duration_months")
                            )
                    );
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return lpr;
    }

    public static List<MaxProjectsClientResponse> getMaxProjectsClient(){
        List<String> queryListForMaxProjectsClient = QueryReader.getQuery("src/main/resources/sql/find_max_projects_client.sql");
        List<MaxProjectsClientResponse> mpcr = new ArrayList<>();
        for(String query : queryListForMaxProjectsClient){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    mpcr.add(
                            new MaxProjectsClientResponse(
                                    resultSet.getString("name"),
                                    resultSet.getInt("PROJECT_COUNT")
                            )
                    );
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return mpcr;
    }

    public static List<MaxSalaryWorkerResponse> getMaxSalaryWorker(){
        List<String> queryListForMaxSalaryWorker = QueryReader.getQuery("src/main/resources/sql/find_max_salary_worker.sql");
        List<MaxSalaryWorkerResponse> mswr = new ArrayList<>();
        for(String query : queryListForMaxSalaryWorker){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    mswr.add(
                            new MaxSalaryWorkerResponse(
                                    resultSet.getString("name"),
                                    resultSet.getInt("salary")
                            )
                    );
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return mswr;
    }

    public static List<YoungestEldestWorkersResponse> getYoungestEldestWorkers(){
        List<String> queryListForYoungestEldestWorkers = QueryReader.getQuery("src/main/resources/sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorkersResponse> yewr = new ArrayList<>();
        for(String query : queryListForYoungestEldestWorkers){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    yewr.add(
                            new YoungestEldestWorkersResponse(resultSet.getString("type"),
                            resultSet.getString("name"),
                            resultSet.getDate("birthday"))
                    );
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return yewr;
    }

    public static List<ProjectPricesResponse> getProjectPrices(){
        List<String> queryListForProjectPrices = QueryReader.getQuery("src/main/resources/sql/print_project_prices.sql");
        List<ProjectPricesResponse> ppr = new ArrayList<>();
        for(String query : queryListForProjectPrices){
            try(Statement statement = H2Db.getConnection().createStatement()){
                ResultSet resultSet = statement.executeQuery(query);
                while(resultSet.next()) {
                    ppr.add(
                            new ProjectPricesResponse(
                                    resultSet.getInt("project_id"),
                                    resultSet.getInt("price")
                            )
                    );
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
        return ppr;
    }
}
