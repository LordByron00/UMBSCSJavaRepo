package JavaProgress;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class audio {
    public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        Scanner console = new Scanner(System.in);
        File file = new File("C:\\Users\\nilsa\\OneDrive\\Documents\\Lelouch Files\\Audio\\Lemon Tea.wav");
        AudioInputStream audioIO = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIO);
        System.out.print("P:Play\nS:Stop\nQ:Quit\n");

        boolean MusicMenuLoop = true;
        while (MusicMenuLoop) {
            String x = console.nextLine();
            x = x.toUpperCase();
            switch (x) {
                case "P":
                    clip.start();
                    System.out.println("Music has started playing!");
                    break;
                case "S":
                    clip.stop();
                    System.out.println("Music paused.");
                    break;
                case "Q":
                    clip.close();
                    System.out.println("Music session ended.");
                    MusicMenuLoop = false;
                    break;
                default:
                    System.out.print("Music session ended.");
                    MusicMenuLoop = false;
            }
        }


    }
}
