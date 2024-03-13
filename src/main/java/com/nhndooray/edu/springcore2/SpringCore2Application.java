package com.nhndooray.edu.springcore2;

import com.nhndooray.edu.springcore2.repository.MemberRepository;
import com.nhndooray.edu.springcore2.repository.PasswordRepository;
import com.nhndooray.edu.springcore2.service.CreateMemberCommand;
import com.nhndooray.edu.springcore2.service.CreateMemberService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCore2Application {

    public static void main(String[] args) {
        ApplicationContext ctxt = SpringApplication.run(SpringCore2Application.class, args);
        CreateMemberService service = ctxt.getBean("createMemberService", CreateMemberService.class);

        service.create(new CreateMemberCommand("byungboo.kim", "qwerty!@#"));

        ctxt.getBean("memberRepository", MemberRepository.class).findAll().stream().forEach(System.out::println);
        ctxt.getBean("passwordRepository", PasswordRepository.class).findAll().stream().forEach(System.out::println);
    }

}
