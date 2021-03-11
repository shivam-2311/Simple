package testing;

import java.util.Random;

public class Testing {

    Testing() {
        Random random = new Random();
        System.out.println(random.nextInt(2));
    }

    public static void main(String args[]) {
        new Testing();
    }
}