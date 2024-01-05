package hello2.core.singleton;

import hello2.core.AppConfig;
import hello2.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){

        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 떄 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
        //2. 조회 : 호출할 떄 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        //memberService1 != memberService2
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){


        //1. 조회 : 호출할 떄 마다 객체를 생성
        SingletonService singletonService1 = SingletonService.getInstance();
        //2. 조회 : 호출할 떄 마다 객체를 생성
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + singletonService1);
        System.out.println("memberService2 = " + singletonService2);

        //memberService1 != memberService2
        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService",MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService2 = " + memberService2);
        System.out.println("memberService1 = " + memberService1);

        //memberService1 != memberService2
        assertThat(memberService1).isSameAs(memberService2);
    }





}
