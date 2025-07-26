package com.example.core.section6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @DisplayName("싱글톤 인스턴스의 상태값을 변경하게 되면 전파된다")
    @Test
    void test() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = context.getBean(StatefulService.class);
        StatefulService statefulService2 = context.getBean(StatefulService.class);

        statefulService1.order("userA", 1000);
        statefulService2.order("userB", 2000);

        // 1000원을 기대했찌만 2000원이 출력된다
        assertThat(statefulService1.getPrice()).isEqualTo(2000);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
