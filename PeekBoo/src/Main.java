import alarm.AlarmManager;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        AlarmManager alarmManager = new AlarmManager();
        String audioFileName = "plant_o_bem_te_vi.mp3"; // Apenas o nome do arquivo
        long delay = TimeUnit.SECONDS.toMillis(10); // Alarme toca em 10 segundos

        alarmManager.startAlarm(audioFileName, delay);
    }
}
