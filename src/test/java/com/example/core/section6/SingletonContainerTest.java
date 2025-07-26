package com.example.core.section6;

import static org.assertj.core.api.Assertions.*;

import com.example.core.config.AppConfig;
import com.example.core.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonContainerTest {
    ApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("스프링 컨테이너와 싱글톤")
    @Test
    void test() {
        MemberService memberService1 = context.getBean("memberService", MemberService.class);
        MemberService memberService2 = context.getBean("memberService", MemberService.class);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
