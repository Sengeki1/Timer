import java.util.Timer;

public class DrawNumbers extends Thread{
    private Timer timer;
    private ThreadLocal<Integer> value;
    private int[] listDraw;
    private int index;
    public DrawNumbers(ThreadLocal<Integer> value, int[] listDraw, int i, Timer timer) {
        this.value = value;
        this.listDraw = listDraw;
        this.index = i;
        this.timer = timer;
    }

    @Override
    public void run() {
        timer.schedule(new Task(value, listDraw, this.index), 500, 1000);
    }
}
