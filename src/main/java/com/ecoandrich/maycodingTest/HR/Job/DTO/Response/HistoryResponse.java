package com.ecoandrich.maycodingTest.HR.Job.DTO.Response;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Job.Entity.JobHistory;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class HistoryResponse {
    private LocalDate startDate;
    private LocalDate endDate;
    private JobResponse job;
    private DepartmentWithManagerAndLocationResponse department;

    public static HistoryResponse toResponse(JobHistory history) {
        JobResponse job = JobResponse.toResponse(history.getJob());
        DepartmentWithManagerAndLocationResponse department = DepartmentWithManagerAndLocationResponse.toResponse(history.getDepartment());

        return HistoryResponse.builder()
                .startDate(history.getStart_date())
                .endDate(history.getEnd_date())
                .job(job)
                .department(department)
                .build();
    }
}
