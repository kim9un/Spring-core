package hello2.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Nova {
    private int ant;
    private String jac;

    public static void main(String[] args) {
        Nova a = new Nova();
        a.setAnt(1);
        int z= a.getAnt();
        System.out.println(z);

    }
}
