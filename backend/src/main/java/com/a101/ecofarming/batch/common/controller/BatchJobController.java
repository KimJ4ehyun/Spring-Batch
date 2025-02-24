package com.a101.ecofarming.batch.common.controller;

import com.a101.ecofarming.batch.common.dto.JobExecutionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/batch")
public class BatchJobController {

    private final JobExplorer jobExplorer;

    @GetMapping("/jobs/completed")
    public List<JobExecutionResponseDto> getCompletedJobs() {
        return jobExplorer.findRunningJobExecutions("").stream()
                .filter(jobExecution -> jobExecution.getStatus() == BatchStatus.COMPLETED)
                .map(JobExecutionResponseDto::from)
                .collect(Collectors.toList());
    }
}
