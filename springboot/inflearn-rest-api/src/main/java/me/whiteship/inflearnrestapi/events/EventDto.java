package me.whiteship.inflearnrestapi.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class EventDto {
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional)이게 없으면 온라인 모임    testCompile group: 'com.h2database', name: 'h2', version:'1.4.194'
    private int basePrice; // (optional) private int maxPrice; // (optional) private int limitOfEnrollment;
    private int maxPrice; // (optional)
    private int limitOfEnrollment;

}
