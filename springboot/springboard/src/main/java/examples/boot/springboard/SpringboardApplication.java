package examples.boot.springboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringboardApplication {

	public static void main(String[] args) {

		// 스프링 Java Config를 넣어줘야한다.
		// 설정파일이자 main을 갖고 있다.
		SpringApplication.run(SpringboardApplication.class, args);
	}
}
