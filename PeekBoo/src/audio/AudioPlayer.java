package audio;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.InputStream;
import java.util.Objects;

public class AudioPlayer {
    public static void playSound(String fileName) {
        try {
            InputStream audioStream = Objects.requireNonNull(AudioPlayer.class.getClassLoader()).getResourceAsStream(fileName);
            if (audioStream == null) {
                System.err.println("⚠ Arquivo de áudio não encontrado: " + fileName);
                return;
            }

            Player player = new Player(audioStream);
            player.play();
        } catch (JavaLayerException | NullPointerException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro ao tocar o áudio: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        playSound("plant_o_bem_te_vi.mp3");
    }
}
