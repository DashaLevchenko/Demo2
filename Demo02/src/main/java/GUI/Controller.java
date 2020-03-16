package GUI;

import demo.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {

    @FXML
    private ProgressBar satiety;

    @FXML
    private Label healthNumber;

    @FXML
    private ProgressBar purity;

    @FXML
    private Label ageNumbers;

    @FXML
    private ProgressBar health;

    @FXML
    private Button hideButton;

    @FXML
    private Label purityNumbers;

    @FXML
    private Button cancelButton;

    @FXML
    private ProgressBar happiness;

    @FXML
    private Label happinessNumbers;

    @FXML
    private Label satietyNumbers;

    @FXML
    private ProgressBar age;

    @FXML
    private ImageView catImage;

    private static final Duration TIME_TO_WAIT = Duration.millis(1000);
    private Cat cat = new Cat();

    private Image defaultImage = new Image("GUI/static/img/start.png");

    private Image eatImage = new Image("GUI/static/img/eat.png");
    private Image playImage = new Image("GUI/static/img/play.png");
//    private Image washImage = new Image("GUI/static/img/start.png");
//    private Image defaultImage = new Image("GUI/static/img/start.png");

    @FXML
    void toScoldButton(ActionEvent event) {

    }

    @FXML
    void toWashButton(ActionEvent event) {

    }

    @FXML
    void toPlayButton(ActionEvent event) {

    }

    @FXML
    void toHealButton(ActionEvent event) {

    }

    @FXML
    void toStrokeButton(ActionEvent event) {

    }

    @FXML
    void toFeedButton() throws PetGrewUpException, PetDiedException, PetIsDirtyException, PocheshiPuzikoException, PetIsIllException, OopsYourShoesIsWetException, PetIsHungryException, PetWantsToPalyException, PetNeedsSomethingException {
        cat.toFeed();
        changeImageAndProgresses(eatImage);
    }

    private void changeImageAndProgresses(Image image) {
        changeImage(image);
        changeProgresses();
    }

    private void changeImage(Image image) {
        catImage.setImage(image);
        waitBeforeAction(e -> catImage.setImage(defaultImage));
    }

    private void waitBeforeAction(EventHandler<ActionEvent> actionEvent) {
        Timeline timeline = new Timeline(new KeyFrame(TIME_TO_WAIT, actionEvent));
        timeline.play();
    }


    private void changeProgressBarValue(double presentValue, int maxValue, ProgressBar progressBar, Label numberProgress) {
        double progress = presentValue / maxValue;
        if (progress > 0) {
            progressBar.setProgress(progress);
        }
        String presentValueString = String.valueOf(BigDecimal.valueOf(presentValue).setScale(1, BigDecimal.ROUND_DOWN));
        numberProgress.setText(presentValueString.replace(".0", "") + "/" + maxValue);
    }

    private void changeProgresses() {
        waitBeforeAction(
                actionEvent -> {
                    changeProgressBarValue(cat.getHealthPoint(), Cat.MAX_HEALTH_POINT, health, healthNumber);
                    changeProgressBarValue(cat.getHappiness(), Cat.MAX_HAPPINESS, happiness, happinessNumbers);
                    changeProgressBarValue(cat.getSatiety(), Cat.MAX_SATIETY, satiety, satietyNumbers);
                    changeProgressBarValue(cat.getAge(), Cat.MAX_AGE, age, ageNumbers);
                    changeProgressBarValue(cat.getPurity(), Cat.MAX_PURITY, purity, purityNumbers);
                });
    }


    @FXML
    void cancelButtonPressed() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void hideButtonPressed() {
        Stage stage = (Stage) hideButton.getScene().getWindow();
        stage.setIconified(true);
    }
}