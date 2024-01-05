package hello2.core.singleton;

public class StatefulService {

    private int price;

    public void order(String name, int price){
        System.out.println("name = " + name + " price = "+ price);
        this.price = price;   // 여기가 문제이다 . 값을 공유 공유해 버리면 안된다.
    }

    public int getPrice(){
        return price;
    }
}
