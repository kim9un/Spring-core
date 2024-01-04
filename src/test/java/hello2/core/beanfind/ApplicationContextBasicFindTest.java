package hello2.core.beanfind;

import hello2.core.AppConfig;
import hello2.core.member.Member;
import hello2.core.member.MemberService;
import hello2.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구현 타입으로 조회")
    void findBeanByName2(){
        MemberService memberService = ac.getBean("memberService",MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByNameX(){
        // ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class,
             () -> ac.getBean("xxxxx", MemberService.class));
    }






}
