package my.examples.huestbook.servlet;

import java.time.LocalDateTime;

public class Guestbook {
    private Long id;
    private String name;
    private String content;
    private LocalDateTime regate;
    private int rownum;

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public Guestbook(){
        regate = LocalDateTime.now();
    }

    public Guestbook(String name, String content) {
        this(); // 자신의 생성자를 호출한다.
        this.name = name;
        this.content = content;
    }

    public Guestbook(Long id, String name, String content) {
        this(name,content);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getRegate() {
        return regate;
    }

    public void setRegate(LocalDateTime regate) {
        this.regate = regate;
    }
}
