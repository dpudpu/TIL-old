package examples.daoexam.main;

import examples.daoexam.config.ApplicationConfig;
import examples.daoexam.dto.Member;
import examples.daoexam.service.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class MemberTest {
    public static void main(String args[]){
        ApplicationContext ac =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);

        Member member = new Member();
        member.setEmail("asdd@dasdddd");
        member.setName("asd");
        member.setPassword("asd");
        member.setRegdate(new Date());

        System.out.println(memberService.addMember(member));
        System.out.println(memberService.getMember("asdd@dasdddd").toString());
    }
}
