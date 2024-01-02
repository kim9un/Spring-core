package hello2.core;


import hello2.core.member.Grade;
import hello2.core.member.Member;
import hello2.core.member.MemberService;
import hello2.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberservice = new MemberServiceImpl();
        Member member = new Member(1L,"member", Grade.VIP);
        memberservice.join(member);

        Member findMember = memberservice.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}


