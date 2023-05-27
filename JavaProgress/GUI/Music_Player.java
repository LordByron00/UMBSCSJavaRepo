package JavaProgress.GUI;

import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Music_Player extends Application {

    private JFrame frame;
    private JPanel panel;
    private JLabel label;
    private JButton playButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JButton selectButton;
    private MediaPlayer mediaPlayer;

    public Music_Player() {
        frame = new JFrame("Music Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        label = new JLabel("No song selected");
        playButton = new JButton("Play");
        pauseButton = new JButton("Pause");
        stopButton = new JButton("Stop");
        selectButton = new JButton("Select Song");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null) {
                    mediaPlayer.play();
                }
            }
        });

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                }
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                }
            }
        });

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        Media media = new Media(file.toURI().toString());
                        mediaPlayer = new MediaPlayer(media);
                        label.setText(file.getName());
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        panel.add(label);
        panel.add(playButton);
        panel.add(pauseButton);
        panel.add(stopButton);
        panel.add(selectButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Leave it empty for now
    }

    public static void main(String[] args) {
        launch(Music_Player.class, args);
    }
}
