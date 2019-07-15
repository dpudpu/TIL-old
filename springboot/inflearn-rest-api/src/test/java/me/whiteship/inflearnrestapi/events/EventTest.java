package me.whiteship.inflearnrestapi.events;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    @Test
    public void builder() {
        Event event = Event.builder()
                .name("foo")
                .description("REST API development with Spring")
                .build();
        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        // given
        Event event = new Event();
        final String name = "name";
        final String description = "description";

        // when
        event.setName(name);
        event.setDescription(description);

        // then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    public void testFree() {
        //given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isTrue();

        //given
        event = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();

        //when
        event.update();

        //then
        assertThat(event.isFree()).isFalse();
    }

    @Test
    public void testOffline() {
        //given
        Event event = Event.builder()
                .location("강남")
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isTrue();

        //given
        event = Event.builder()
                .build();

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isFalse();
    }
}