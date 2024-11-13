package com.example.multimodule.application.service;

import com.example.multimodule.application.dto.request.JobCreationRequest;
import com.example.multimodule.application.dto.response.ApiResponse;
import com.example.multimodule.application.dto.response.JobResponse;
import com.example.multimodule.application.entity.Category;
import com.example.multimodule.application.entity.Employer;
import com.example.multimodule.application.entity.Job;
import com.example.multimodule.application.exception.AppException;
import com.example.multimodule.application.exception.ErrorCode;
import com.example.multimodule.application.mapper.JobMapper;
import com.example.multimodule.application.repository.CategoryRepository;
import com.example.multimodule.application.repository.EmployerRepository;
import com.example.multimodule.application.repository.JobRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class JobService {
    JobMapper jobMapper;
    JobRepository jobRepository;
    EmployerRepository employerRepository;
    CategoryRepository categoryRepository;

    public List<JobResponse> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobResponses = new ArrayList<>();
        for (Job job : jobs) {
            JobResponse jobResponse = jobMapper.toJobResponse(job)  ;
            jobResponses.add(jobResponse);
        }
        return jobResponses;
    }

    public JobResponse createJob(JobCreationRequest request) {
        Job job = jobMapper.toJob(request);
        Employer employer = employerRepository.findById(request.getEmployerId()).get();
        Category category = categoryRepository.findById(request.getCategoryId()).get();
        job.setEmployer(employer);
        job.setJobCategory(category);
        jobRepository.save(job);
        return jobMapper.toJobResponse(job);
    }

    public ApiResponse<String> deleteJob(String id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.JOB_NOT_FOUND));

        if (job.getUser() != null) {
            throw new AppException(ErrorCode.JOB_ACCEPTED);
        }

        jobRepository.deleteById(id);
        return ApiResponse.<String>builder()
                .code(2000)
                .message("Delete job successfully")
                .result(null)
                .build();
    }

}
