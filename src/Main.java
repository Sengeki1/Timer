import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        Timer timer = new Timer();
        Task task = new Task();

        timer.schedule(task, 500, 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timer.cancel();
                System.out.println("O ultimo valor gerado foi: "+ task.get());
            }
        }, rand.nextInt(10000, 30000));
    }
}