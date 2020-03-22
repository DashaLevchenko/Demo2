package gui;

import demo.*;
import demo.exceptions.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Controller {

    public static final int FAST_WAITING_MILLISECOND = 2000;
    public static final int SLOW_WAITING_MILLISECONDS = 3500;

    @FXML
    private ProgressBar satiety;

    @FXML
    private Label messageGameOver;

    @FXML
    private Label healthNumber;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private Label nameErrorLabelForCharacters;

    @FXML
    private ProgressBar purity;

    @FXML
    private Label ageNumbers;

    @FXML
    private ProgressBar health;

    @FXML
    private TextField nameTextInput;

    @FXML
    private Button hideButton;

    @FXML
    private AnchorPane starGameWindow;

    @FXML
    private Label purityNumbers;

    @FXML
    private Label catNameLabel;

    @FXML
    private Label thinkCloudText;

    @FXML
    private Button cancelButton;

    @FXML
    private AnchorPane gameOverWindow;

    @FXML
    private AnchorPane anchorPaneWithInterface;

    @FXML
    private ProgressBar happiness;

    @FXML
    private Group thinkCloud;

    @FXML
    private Label happinessNumbers;

    @FXML
    private Label satietyNumbers;

    @FXML
    private ProgressBar age;

    @FXML
    private ImageView catImage;

    private Cat cat;


    private Image defaultImage = new Image("gui/static/img/start.png");
    private Image eatingImage = new Image("gui/static/img/action/eating.png");
    private Image playing = new Image("gui/static/img/action/playing.png");
    private Image scratchingTummy = new Image("gui/static/img/action/scratchingTummy.png");
    private Image treatment = new Image("gui/static/img/action/treatment.png");
    private Image washing = new Image("gui/static/img/action/washing.png");
    private Image scolding = new Image("gui/static/img/action/scold.png");

    private HashMap<String, Image> imageHashMap = new HashMap<>();

    {
        imageHashMap.put("I'm dirty. You know what to do!", new Image("gui/static/img/state/dirty.png"));
        imageHashMap.put("Something wrong, I'm feeling bad...", new Image("gui/static/img/state/needMedicine.png"));
        imageHashMap.put("I'm hungry!", new Image("gui/static/img/state/wantToEat.png"));
        imageHashMap.put("Play with me!", new Image("gui/static/img/state/wantToPlay.png"));
        imageHashMap.put("Purrr! Scratch my tummy!", new Image("gui/static/img/state/wantToScratchTummy.png"));
        imageHashMap.put("Oops, your shoes are wet", new Image("gui/static/img/state/slippers.png"));    }

    public void printNextAction(String nextAction) {
        setCatImage(imageHashMap.get(nextAction));
        printThinkCloudMessage(nextAction);
    }

    @FXML
    void toScoldButton() {
        catImage.setImage(scolding);
        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toScold();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);
        changeProgresses();
    }

    @FXML
    void toWashButton() {
        catImage.setImage(washing);

        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toWash();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        changeProgresses();
    }

    @FXML
    void toPlayButton() {
        catImage.setImage(playing);

        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toPlay();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        changeProgresses();
    }

    private void setCatImage(Image image) {
        catImage.setImage(image);
    }

    @FXML
    void toHealButton() {
        catImage.setImage(treatment);

        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toHeal();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        changeProgresses();
    }

    @FXML
    void toStrokeButton() {
        catImage.setImage(scratchingTummy);

        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toStroke();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        changeProgresses();
    }

    @FXML
    void toFeedButton() {
        catImage.setImage(eatingImage);

        waitBeforeAction(action -> {
            try {
                String nextAction = cat.toFeed();
                printNextAction(nextAction);
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        changeProgresses();
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

    Pattern onlyLatinAlphabet = Pattern.compile("[a-zA-Z]{0,20}[^0-9]");

    @FXML
    void createPet() {
        String inputName = nameTextInput.getText();
        if (inputName.isEmpty()) {
            nameErrorLabel.setVisible(true);
            nameErrorLabelForCharacters.setVisible(false);
            }
          else if (inputName.matches(String.valueOf(onlyLatinAlphabet))) {
                cat = new Cat(inputName);
                changeProgresses();
                nameErrorLabel.setVisible(false);
                starGameWindow.setVisible(false);
                catNameLabel.setText(inputName);
                anchorPaneWithInterface.setDisable(false);
                printThinkCloudMessage("Hello, my name is " + cat.getName());
            }
          else
              nameErrorLabel.setVisible(false);
          nameErrorLabelForCharacters.setVisible(true);
        }
    @FXML
    void gameOverButtonPressed() {
        cancelButtonPressed();
    }

    private void printGameOverException(String message) {
        gameOverWindow.setVisible(true);
        anchorPaneWithInterface.setDisable(true);
        messageGameOver.setText(message);
    }


    private void printThinkCloudMessage(String message) {
        thinkCloud.setVisible(true);
        thinkCloudText.setText(message);
        waitBeforeAction(actionEvent -> thinkCloud.setVisible(false), FAST_WAITING_MILLISECOND);
    }

    /*private void setDefaultImage() {
        waitBeforeAction(actionEvent -> catImage.setImage(defaultImage), SLOW_WAITING_MILLISECONDS);
    }*/

    private void waitBeforeAction(EventHandler<ActionEvent> actionEvent, int millis) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(millis), actionEvent));
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
                }, FAST_WAITING_MILLISECOND);
    }
}
