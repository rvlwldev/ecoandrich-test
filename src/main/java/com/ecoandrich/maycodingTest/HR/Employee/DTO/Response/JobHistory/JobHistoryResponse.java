package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory;

import com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.EmployeeResponse;
import com.ecoandrich.maycodingTest.HR.Employee.Entity.Employee;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.JobHistory;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class JobHistoryResponse {
    private EmployeeResponse employee;
    private List<HistoryResponse> histories;

    public static JobHistoryResponse toResponse(Employee employee, List<JobHistory> jobHistory) {
        EmployeeResponse employeeResponse = EmployeeResponse.toResponse(employee);

        List<HistoryResponse> historyList = jobHistory.stream()
                .map(HistoryResponse::toResponse)
                .collect(Collectors.toList());

        return JobHistoryResponse.builder()
                .employee(employeeResponse)
                .histories(historyList)
                .build();
    }

}
