package com.example.core.section6;

import static org.assertj.core.api.Assertions.*;

import com.example.core.config.AppConfig;
import com.example.core.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig  appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
