package com.kori.kori;

import com.kori.kori.model.KoriState;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Kori extends ImageView {

    private int height = 800;
    private int width = 512;

    private KoriState state = KoriState.IDLE;

    private Timeline animation = new Timeline();

    public Kori() {
        Image koriSpritMap = new Image("com/kori/kori/assets/icon/favicon.png", 100, 150, false, true);
        this.setImage(koriSpritMap);
        this.start();
    }

    private void updateAnimation() {
        // animation = new Timeline();
    }

    private void setState(KoriState s) {
        this.state = s;
        this.updateAnimation();
    }

    public void start() {
        animation.play();
    }

    public void stop() {
        animation.stop();
    }

    public void dispose() {
        animation.stop();
    }


}
