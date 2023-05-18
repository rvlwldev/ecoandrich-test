package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory;

import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.Job;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@ApiModel(value = "직무 정보")
@Data
@Builder
public class JobResponse {

    @ApiModelProperty(value = "직무명")
    private String jobTitle;

    @ApiModelProperty(value = "최소 급여")
    private Double maxSalary;

    @ApiModelProperty(value = "최대 급여")
    private Double minSalary;

    public static JobResponse toResponse(Job job) {
        return JobResponse.builder()
                .jobTitle(job.getJob_title())
                .maxSalary(job.getMax_salary())
                .minSalary(job.getMin_salary())
                .build();
    }
}
