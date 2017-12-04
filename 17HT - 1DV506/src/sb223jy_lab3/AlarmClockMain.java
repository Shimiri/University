package sb223jy_lab3;

public class AlarmClockMain {
    public static void main(String[] args) {
        AlarmClock clock = new AlarmClock(23, 48);
        clock.displayTime();
        clock.setAlarm(6, 15);

        for (int i = 0; i < 500; i++) {
            clock.timeTick();
        }

        clock.displayTime();
    }
}
