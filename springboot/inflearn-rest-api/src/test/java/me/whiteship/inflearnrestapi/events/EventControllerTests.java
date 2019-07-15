package me.whiteship.inflearnrestapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.whiteship.inflearnrestapi.common.TestDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest // 웹과 관련된 빈만 등록해서 테스트하기 때문에 슬라이스 테스트라고 부르고 속도도 빠르다. 단위 테스트라고 보에는 이미 많은 것이 관련되어 있다.
// 목킹할 것이 너무 많아서 슬라이스보단 SpringBootTest로 하는 것이 편하다.
public class EventControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @TestDescription("입력값을 제대로 입력하는 경우 성공 테스트")
    public void createEvent() throws Exception {
        EventDto event = EventDto.builder()
                .name("name")
                .description("description")
                .beginEnrollmentDateTime(LocalDateTime.of(2019, 7, 15, 9, 21, 18))
                .closeEnrollmentDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .beginEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .endEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .build();

        mockMvc.perform(post("/api/events/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(header().exists(HttpHeaders.LOCATION))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_UTF8_VALUE))
                .andExpect(jsonPath("free").value(false))
                .andExpect(jsonPath("offline").value(true))
                .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
        ;
        // 테스트 케이스를 하나만이 아닌 3개정도는 해야 진정한 TDD
    }

    @Test
    @TestDescription("입력 받을 수 없는 값을 사용한 경우에 에러가 발생하는 테스")
    public void createEvent_Bad_Request() throws Exception {
        Event event = Event.builder()
                .id(100)
                .beginEnrollmentDateTime(LocalDateTime.of(2019, 7, 15, 9, 21, 18))
                .closeEnrollmentDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .beginEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .endEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .free(true)
                .offline(false)
                .eventStatus(EventStatus.PUBLISHED)
                .build();

        mockMvc.perform(post("/api/events/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    @TestDescription("입력값이 비어있는 경우에 에러가 발생하는 테승트")
    public void createEvent_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder().build();

        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(eventDto)))
                .andExpect(status().isBadRequest())
        ;
    }

    @Test
    public void createEvent_Bad_Request_Wrong_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("name")
                .description("description")
                .beginEnrollmentDateTime(LocalDateTime.of(2019, 7, 15, 9, 21, 18))
                .closeEnrollmentDateTime(LocalDateTime.of(2019, 5, 15, 9, 21, 18))
                .beginEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .endEventDateTime(LocalDateTime.of(2019, 10, 15, 9, 21, 18))
                .basePrice(10000)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역")
                .build();

        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].objectName").exists())
                .andExpect(jsonPath("$[0].defaultMessage").exists())
                .andExpect(jsonPath("$[0].code").exists())
        ;
    }
}
