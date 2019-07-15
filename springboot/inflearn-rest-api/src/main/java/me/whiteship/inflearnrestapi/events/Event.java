package me.whiteship.inflearnrestapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")  // 기본적으로 모든 필드를 사용하는데, 엔티티에서 상호 참조하는 관계가 되면 스택오버 플로우가 발생할 수 있어서 id로 한다.
@Entity
public class Event {
    @Id
    @GeneratedValue
    private Integer id;
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
    private boolean offline;
    private boolean free;
    @Enumerated(value = EnumType.STRING) //Ordinal 이 디폴트인데 순서에 따라서 하므로 나중에 변경되면 꼬임
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {
        this.free = this.basePrice == 0 && this.maxPrice == 0;

        this.offline = !(this.location == null || this.location.isBlank());
    }
}
