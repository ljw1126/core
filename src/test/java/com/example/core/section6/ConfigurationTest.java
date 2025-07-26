package com.example.core.section6;

import com.example.core.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ConfigurationTest {

    @DisplayName("바이트 코드를 조작해 AppConfig를 상속받은 CGLIB 프록시 객체가 출력된다")
    @Test
    void configurationDeep() {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = context.getBean(AppConfig.class);

        // bean = class com.example.core.config.AppConfig$$SpringCGLIB$$0
        System.out.println("bean = " + bean.getClass());
    }
}
