package com.example.core.section5;

import static org.assertj.core.api.Assertions.*;

import com.example.core.config.AppConfig;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(AppConfig.class);

    @DisplayName("빈 이름으로 조회")
    @Test
    void findBeanByName() {
        MemberService memberService = context.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("이름 없이 타입만으로 조회")
    @Test
    void findBeanByType() {
        MemberService memberService = context.getBean(MemberService.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("구체 타입으로 조회")
    @Test
    void findBeanByType2() {
        MemberServiceImpl memberService = context.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @DisplayName("존재하지 않는 빈 이름으로 조회시 예외를 던진다")
    @Test
    void findBeanByUnknownName() {
        assertThatThrownBy(() -> context.getBean("xxxx"))
                .isInstanceOf(NoSuchBeanDefinitionException.class);
    }

}
