package com.example.core.section5;

import static org.assertj.core.api.Assertions.*;

import com.example.core.repository.MemberRepository;
import com.example.core.repository.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    @Test
    void findBeanByTypeDuplicate() {
        assertThatThrownBy(() -> context.getBean(MemberRepository.class))
                .isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    @Test
    void findBeanByName() {
        MemberRepository memberRepository = context.getBean("memberRepository2", MemberRepository.class);

        assertThat(memberRepository).isInstanceOf(MemoryMemberRepository.class);
    }

    @DisplayName("")
    @Test
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = context.getBeansOfType(MemberRepository.class);

        for(String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }

        System.out.println("beansOfType = " + beansOfType);

        assertThat(beansOfType.size()).isEqualTo(2);
  }

    @TestConfiguration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
