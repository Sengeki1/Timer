import java.util.Random;
import java.util.TimerTask;

public class Task extends TimerTask {
    private Random rand = new Random();
    private ThreadLocal<Integer> value;
    private int[] listDraw;
    private int index;
    public Task(ThreadLocal<Integer> value, int[] listDraw, int index) {
        this.value = value;
        this.listDraw = listDraw;
        this.index = index;
    }
    @Override
    public void run() {
        this.value.set(rand.nextInt(1, 100));
        System.out.println(this.value.get());
        synchronized (listDraw) {
            listDraw[index] = this.value.get();
        }
    }
}
