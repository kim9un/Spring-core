package hello2.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext();

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA : A사용자가 10000월 주문
        statefulService1.order("userA",10000);
        statefulService2.order("userB",20000);

        //ThreadA : A사용자가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price); // 20000원으로 나옴

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    @Configuration
    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
