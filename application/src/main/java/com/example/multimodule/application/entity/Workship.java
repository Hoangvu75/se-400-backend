package com.example.multimodule.application.entity;

import jakarta.persistence.*;

@Embeddable
public class Workship {

    private String startTime;

    private String endTime;

    private String day;
}
