package com.example.core.section5;

import static org.assertj.core.api.Assertions.*;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext context
            = new AnnotationConfigApplicationContext(TestConfig.class);

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 중복 예외를 던진다")
    @Test
    void findBeanByParentTypeDuplicate() {
        assertThatThrownBy(() -> context.getBean(DiscountPolicy.class))
                .isInstanceOf(NoUniqueBeanDefinitionException.class);
    }

    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면 빈 이름을 지정하면 된다")
    @Test
    void findBeanByParentTypeBeanName() {
        DiscountPolicy discountPolicy = context.getBean("rateDiscountPolicy", DiscountPolicy.class);

        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("특정 하위 타입으로 조회")
    @Test
    void findBeanBySubtype() {
        RateDiscountPolicy bean = context.getBean(RateDiscountPolicy.class);

        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @DisplayName("부모 타입으로 모두 조회하기 - 인터페이스")
    @Test
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = context.getBeansOfType(DiscountPolicy.class);

        assertThat(beansOfType).hasSize(2);
    }

    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    @Test
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = context.getBeansOfType(Object.class);
        for(String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixedDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }
}
