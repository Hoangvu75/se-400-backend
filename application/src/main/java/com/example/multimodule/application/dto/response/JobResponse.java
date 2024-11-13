package com.example.multimodule.application.dto.response;

import com.example.multimodule.application.entity.Workship;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobResponse {
    String name;
    String description;
    Date recruitedDate;
    String jobCategory;
    double wage;
    String address;
    String contactInfo;
    String requirements;
    String employerName;
    List<Workship> schedule;
}
