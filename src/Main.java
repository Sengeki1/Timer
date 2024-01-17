import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ThreadLocal<Integer> value = new ThreadLocal<>();
        int[] listDraw = new int[6];

        Timer timer = new Timer();

        for (int i = 0; i < 6; i++) {
            Thread thread = new DrawNumbers(value, listDraw, i, timer);
            thread.start();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                for (int i = 0; i < 6; i++) {
                    System.out.println("O ultimo numero gerado foi: " + listDraw[i]);
                }
            }
        }, rand.nextInt(10000, 30000));
    }
}