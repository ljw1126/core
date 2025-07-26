package com.example.core.section6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingletonServiceTest {

    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    @Test
    void isSameTest() {
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        assertThat(instance1).isSameAs(instance2);
    }
}
