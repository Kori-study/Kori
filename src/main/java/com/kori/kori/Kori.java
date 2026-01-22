package com.kori.kori;

import com.kori.kori.model.KoriState;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.util.Duration;


public class Kori extends ImageView {

    private final int height = 800;
    private final int width = 512;

    private KoriState state = KoriState.IDLE;

    private int keyframe = 0;
    private int NumberOfFrames = 10;
    private static final int SPRITE = 32;
    private static final int SCALE = 8; // 32 * 8 = 256px
    private final Image koriSpriteMap = new Image(String.valueOf(getClass().getResource("assets/kori/KoriAnimationMap.png")));

    private final Timeline animation;

    public Kori() {
        setPreserveRatio(false);
        setSmooth(false);

        setFitWidth(SPRITE * SCALE);
        setFitHeight(SPRITE * SCALE);

        setManaged(false); // optional: prevents layout from resizing it
        setCache(false);   // optional: caching can sometimes blur during transforms

        resizeImage();

        animation = new Timeline(new KeyFrame(Duration.seconds(1.0/12), e -> {
            PlayKeyFrame();
            resizeImage();
        }));
        animation.setCycleCount(Animation.INDEFINITE);
        start();
    }
    private void PlayKeyFrame(){
        this.keyframe = (this.keyframe + 1) % NumberOfFrames;
    }

    private void resizeImage() {
        int koriSize = 32;
        int x = this.keyframe * 32;
        int y = this.state.ordinal() * 32;
        PixelReader reader = koriSpriteMap.getPixelReader();
        Image currentImage  = new WritableImage(reader, x, y, koriSize, koriSize);
        this.setImage(currentImage);
    }

    private void updateAnimation() {
         resizeImage();
    }

    public void setState(KoriState s) {
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
