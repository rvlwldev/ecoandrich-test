package com.ecoandrich.maycodingTest.HR.Job;

import com.ecoandrich.maycodingTest.HR.Job.DTO.Response.JobHistoryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hr/jobs")
public class JobController {

    private final JobService service;

    JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("history/{id}")
    public ResponseEntity<JobHistoryResponse> getHistory(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.getHistory(id));
    }


}
