import java.util.Timer;
import java.util.TimerTask;
public class TimeCounter {


    static int sayac = 0;

    TimeCounter(){

        Timer myTimer = new Timer();
        TimerTask gorev1;
        gorev1 = new TimerTask() {
            public void run() {

                sayac++;
                User.loguserban = true;
                if(sayac==PropertyReader.getBlocktime()){
                    myTimer.cancel();
                    User.loguserban = false;
                    Main.errortime = 0;
                    sayac = 0;
                }

            }
        };
        myTimer.schedule(gorev1,0, 1000);
    }


}
