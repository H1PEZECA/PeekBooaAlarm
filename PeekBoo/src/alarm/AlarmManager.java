package alarm;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import audio.AudioPlayer;



public class AlarmManager {
    private boolean alarmOff = false;

    public void startAlarm(String soundFilePath, long delayMillis) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("⏰ Alarme disparado! Digite 'off' para desligar.");
                new Thread(() -> playSoundLoop(soundFilePath)).start();
                listenForUserInput(soundFilePath);
            }
        }, delayMillis);
    }

    private void playSoundLoop(String filePath) {
        long startTime = System.currentTimeMillis();
        while (!alarmOff && (System.currentTimeMillis() - startTime) < 60000) { // 1 minuto
            AudioPlayer.playSound(filePath);
        }
    }

    private void listenForUserInput(String soundFilePath) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("off")) {
            alarmOff = true;
            System.out.println("✅ Alarme desligado.");
        } else {
            System.out.println("🔕 Entrando em modo soneca...");
            try {
                Thread.sleep(300000); // 5 minutos (soneca)
                alarmOff = false;
                startAlarm(soundFilePath, 0); // Recomeça o alarme imediatamente após soneca
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
