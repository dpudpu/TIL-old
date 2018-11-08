package examples.boot.springboard.dto;

import java.util.Date;

public class Member {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Date regdate;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regdate +
                '}';
    }
}

/*
CREATE TABLE member (
    id bigint(20) unsigned not null auto_increment,
    name varchar(20) not null,
    email varchar(255) not null,
    password varchar(255) not null,
    regddate datetime,
    primary key(id)
);

 */
