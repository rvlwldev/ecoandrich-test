package com.ecoandrich.maycodingTest.HR.Employee.DTO.Response.JobHistory;

import com.ecoandrich.maycodingTest.HR.Department.DTO.Response.Department.DepartmentWithManagerAndLocationResponse;
import com.ecoandrich.maycodingTest.HR.Employee.SubEntity.JobHistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@ApiModel(value = "이력 정보 조회 결과")
@Data
@Builder
public class HistoryResponse {

    @ApiModelProperty(value = "직무 시작일")
    private LocalDate startDate;

    @ApiModelProperty(value = "작무 종료일")
    private LocalDate endDate;

    private JobResponse job;
    private DepartmentWithManagerAndLocationResponse department;

    public static HistoryResponse toResponse(JobHistory history) {
        JobResponse job = JobResponse.toResponse(history.getJob());
        DepartmentWithManagerAndLocationResponse department = DepartmentWithManagerAndLocationResponse
                .toResponse(history.getDepartment());

        return HistoryResponse.builder()
                .startDate(history.getStart_date())
                .endDate(history.getEnd_date())
                .job(job)
                .department(department)
                .build();
    }
}
