package JavaProgress.timer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TimerApp extends Application {

    private Timeline timeline;
    private Label timeLabel;
    private long startTime;

    @Override
    public void start(Stage primaryStage) {
        Button startButton = new Button("Start");
        startButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (startButton.getText().equals("Start")) {
                    startButton.setText("Stop");
                    startTimer();
                } else {
                    startButton.setText("Start");
                    stopTimer();
                }
            }
        });

        timeLabel = new Label("00:00:00");

        StackPane root = new StackPane();
        root.getChildren().add(startButton);
        root.getChildren().add(timeLabel);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Timer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startTimer() {
        startTime = System.currentTimeMillis();
        timeline = new Timeline(new KeyFrame(Duration.millis(100), ae -> updateTimerLabel()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void stopTimer() {
        timeline.stop();
    }

    private void updateTimerLabel() {
        long elapsedMillis = System.currentTimeMillis() - startTime;
        int seconds = (int) (elapsedMillis / 1000) % 60;
        int minutes = (int) ((elapsedMillis / (1000 * 60)) % 60);
        int hours = (int) ((elapsedMillis / (1000 * 60 * 60)) % 24);
        String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(timeString);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
