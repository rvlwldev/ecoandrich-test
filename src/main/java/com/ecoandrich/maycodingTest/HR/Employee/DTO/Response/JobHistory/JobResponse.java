package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory;

import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.Job;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobResponse {
    private String jobTitle;
    private Double maxSalary;
    private Double minSalary;

    public static JobResponse toResponse(Job job) {
        return JobResponse.builder()
                .jobTitle(job.getJob_title())
                .maxSalary(job.getMax_salary())
                .minSalary(job.getMin_salary())
                .build();
    }
}
