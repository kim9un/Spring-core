package hello2.core.order;

import hello2.core.discount.DiscountPolicy;
import hello2.core.discount.FixDiscountPolicy;
import hello2.core.discount.RateDiscountPolicy;
import hello2.core.member.Member;
import hello2.core.member.MemberRepository;
import hello2.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPirce) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPirce);

        return new Order(memberId,itemName,itemPirce,discountPrice);
    }
    //test 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
