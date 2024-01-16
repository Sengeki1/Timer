import java.util.Random;
import java.util.TimerTask;

public class Task extends TimerTask {
    private volatile int num = 0;
    private Random rand = new Random();
    @Override
    public void run() {
        this.num = rand.nextInt(1, 100);
        System.out.println(this.num);
    }
    public int get() {
        return this.num;
    }
}
