package me.whiteship.inflearnrestapi.events;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")  // 기본적으로 모든 필드를 사용하는데, 엔티티에서 상호 참조하는 관계가 되면 스택오버 플로우가 발생할 수 있어서 id로 한다.
public class Event {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location; // (optional)이게 없으면 온라인 모임
    private int basePrice; // (optional) private int maxPrice; // (optional) private int limitOfEnrollment;
    private int maxPrice; // (optional)
    private boolean offline;
    private boolean free;
    private EventStatus eventStatus = EventStatus.DRAFT;
}
