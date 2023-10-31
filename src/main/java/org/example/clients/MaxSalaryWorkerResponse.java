package org.example.clients;

public class MaxSalaryWorkerResponse {
    private final String name;
    private final int salary;

    public MaxSalaryWorkerResponse(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "MaxSalaryWorkerResponse{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
