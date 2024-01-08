package hello2.core.order;

import hello2.core.discount.RateDiscountPolicy;
import hello2.core.member.Grade;
import hello2.core.member.Member;
import hello2.core.member.MemoryMemberRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        memoryMemberRepository.save(new Member(1L,"hun", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository, new RateDiscountPolicy());
        orderService.createOrder(1L,"itmeA",10000);

    }

}