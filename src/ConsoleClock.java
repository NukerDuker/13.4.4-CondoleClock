import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ConsoleClock extends Thread implements Runnable{

    Calendar time;
    SimpleDateFormat sTime;
    boolean stopped;

    public ConsoleClock() {
        sTime = new SimpleDateFormat("HH:mm:ss");
    }


    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            time = Calendar.getInstance();
            try{
                System.out.println(sTime.format(time.getTime()));
                sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("The clock was stopped");
                interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ConsoleClock thread1 = new ConsoleClock();
        thread1.start();
        Thread.sleep(3000);
        thread1.interrupt();
    }

}