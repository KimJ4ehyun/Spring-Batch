package com.a101.ecofarming.batch.common.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class JobExecutionResponseDto {
    private Long jobId;
    private String jobName;
    private BatchStatus status;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String exitCode;
    private String exitMessage;
    private List<Throwable> failureExceptions;

    public static JobExecutionResponseDto from(JobExecution jobExecution) {
        return JobExecutionResponseDto.builder()
                .jobId(jobExecution.getJobId())
                .jobName(jobExecution.getJobInstance().getJobName())
                .status(jobExecution.getStatus())
                .startTime(jobExecution.getStartTime())
                .endTime(jobExecution.getEndTime())
                .exitCode(jobExecution.getExitStatus().getExitCode())
                .exitMessage(jobExecution.getExitStatus().getExitDescription())
                .failureExceptions(jobExecution.getFailureExceptions())
                .build();
    }
}