package hello2.core.discount;

import annotation.MainDiscountPolicy;
import hello2.core.member.Grade;
import hello2.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountpercent = 10; //10%할인


    @Override
    public int discount(Member member, int price) {

        if (member.getGrade() == Grade.VIP){
            return price * discountpercent/100;
        }
        else{
            return 0;
        }
    }
}
