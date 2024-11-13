package com.example.multimodule.application.mapper;

import com.example.multimodule.application.dto.request.JobCreationRequest;
import com.example.multimodule.application.dto.response.JobResponse;
import com.example.multimodule.application.entity.Job;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface JobMapper {
    @Mapping(target = "employer", ignore = true)
    @Mapping(target = "jobCategory", ignore = true)
    Job toJob(JobCreationRequest request);

    @Mapping(source = "employer.name", target = "employerName")
    @Mapping(source = "jobCategory.name", target = "jobCategory")
    JobResponse toJobResponse(Job job);

}
