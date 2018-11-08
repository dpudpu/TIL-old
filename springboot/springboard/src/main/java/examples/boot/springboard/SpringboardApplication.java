package examples.boot.springboard;

import examples.boot.springboard.config.ServerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringboardApplication implements CommandLineRunner {
	@Autowired
	ServerInfo serverInfo;


	// static main 메소드에서는 static필드나 static 메소드만 사용할 수 있다.
	// spring이 제공하는 메소드도 아니다.
	public static void main(String[] args) {

		// 스프링 Java Config를 넣어줘야한다.
		// 설정파일이자 main을 갖고 있다.
		SpringApplication.run(SpringboardApplication.class, args);
	}

	// spring boot의 main이라고 보면 된다.
	// 자동으로 실행되는 메소드가 된다.
	@Override
	public void run(String... args) throws Exception {
		System.out.println(serverInfo.getIp());
		System.out.println(serverInfo.getPort());
	}
}
