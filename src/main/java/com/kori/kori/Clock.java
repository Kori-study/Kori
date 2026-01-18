package com.kori.kori;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Clock extends Label {

    private final Timeline timeline;
    private DateTimeFormatter dateTimeFormatter;


    public Clock(){
        this("HH:mm:ss");
    }

    public Clock(String timeFormat) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(timeFormat);

        // Set default styling
        setFont(Font.font("Monospace", 24));

        // Update the clock every second
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> updateTime()));
        timeline.setCycleCount(Animation.INDEFINITE);

        // Initial update and start
        updateTime();
        timeline.play();
    }

    private void updateTime() {
        setText(LocalTime.now().format(dateTimeFormatter));
    }

    public void setTimeFormat(String format) {
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(format);
        updateTime();
    }

    public void start() {
        timeline.play();
    }

    public void stop() {
        timeline.stop();
    }

    // Clean up when component is no longer needed
    public void dispose() {
        timeline.stop();
    }

}
