package GUI;

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

public class Controller {

    public static final int FAST_WAITING_MILLISECOND = 1500;
    public static final int SLOW_WAITING_MILLISECONDS = 2700;
    @FXML
    private ProgressBar satiety;

    @FXML
    private Label messageGameOver;

    @FXML
    private Label healthNumber;

    @FXML
    private Label nameErrorLabel;

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

    //region Description
    private Image defaultImage = new Image("GUI/static/img/start.png");

    private Image eatingImage = new Image("GUI/static/img/action/eating.png");
    private Image playing = new Image("GUI/static/img/action/playing.png");
    private Image scratchingTummy = new Image("GUI/static/img/action/scratchingTummy.png");
    private Image treatment = new Image("GUI/static/img/action/treatment.png");
    private Image washing = new Image("GUI/static/img/action/washing.png");
    private Image scolding = new Image("GUI/static/img/action/scold.png");
    //endregion

    private HashMap<String, Image> exceptionsImage = new HashMap<>();

    {
        exceptionsImage.put(PetIsDirtyException.class.getSimpleName(), new Image("GUI/static/img/state/dirty.png"));
        exceptionsImage.put(PetIsIllException.class.getSimpleName(), new Image("GUI/static/img/state/needMedicine.png"));
        exceptionsImage.put(PetIsHungryException.class.getSimpleName(), new Image("GUI/static/img/state/wantToEat.png"));
        exceptionsImage.put(PetWantsToPlayException.class.getSimpleName(), new Image("GUI/static/img/state/wantToPlay.png"));
        exceptionsImage.put(PetWantsToScratchTummyException.class.getSimpleName(), new Image("GUI/static/img/state/wantToScratchTummy.png"));
        exceptionsImage.put(OopsYourShoesIsWetException.class.getSimpleName(), new Image("GUI/static/img/state/slippers.png"));
    }

    @FXML
    void toScoldButton() {
        catImage.setImage(scolding);
        waitBeforeAction(action -> {
            try {
                cat.toScold();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            } catch (PetIsDirtyException | PetWantsToScratchTummyException | PetIsIllException |
                    OopsYourShoesIsWetException | PetWantsToPlayException | PetIsHungryException e) {
                printStateExceptionText(e);
            }
        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
        changeProgresses();
    }

    @FXML
    void toWashButton() {
        catImage.setImage(washing);

        waitBeforeAction(action -> {
            try {
                cat.toWash();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            } catch (PetIsDirtyException | PetWantsToScratchTummyException | PetIsIllException |
                    OopsYourShoesIsWetException | PetWantsToPlayException | PetIsHungryException e) {
                printStateExceptionText(e);
            }

        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
        changeProgresses();
    }

    @FXML
    void toPlayButton() {
        catImage.setImage(playing);

        waitBeforeAction(action -> {
            try {
                cat.toPlay();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
        changeProgresses();
    }

    @FXML
    void toHealButton() {
        catImage.setImage(treatment);

        waitBeforeAction(action -> {
            try {
                cat.toHeal();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            }
        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
        changeProgresses();
    }

    @FXML
    void toStrokeButton() {
        catImage.setImage(scratchingTummy);

        waitBeforeAction(action -> {
            try {
                cat.toStroke();

            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            } catch (PetIsDirtyException | PetWantsToScratchTummyException | PetIsIllException |
                    OopsYourShoesIsWetException | PetWantsToPlayException | PetIsHungryException e) {
                printStateExceptionText(e);
            }
        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
        changeProgresses();
    }

    @FXML
    void toFeedButton() {
        catImage.setImage(eatingImage);

        waitBeforeAction(action -> {
            try {
                cat.toFeed();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            } catch (PetIsDirtyException | PetWantsToScratchTummyException | PetIsIllException |
                    OopsYourShoesIsWetException | PetWantsToPlayException | PetIsHungryException e) {
                printStateExceptionText(e);
            }
        }, FAST_WAITING_MILLISECOND);

        setDefaultImage();
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

    @FXML
    void createPet() {
        String inputName = nameTextInput.getText();
        if (inputName.isEmpty()) {
            nameErrorLabel.setVisible(true);
        } else {
            cat = new Cat(inputName);
            nameErrorLabel.setVisible(false);
            starGameWindow.setVisible(false);
            catNameLabel.setText(inputName);
            anchorPaneWithInterface.setDisable(false);
            printThinkCloudMessage("Hello, my name is " + cat.getName());
        }
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

    private void printStateExceptionText(Exception exception) {
        String exceptionName = exception.getClass().getSimpleName();
        catImage.setImage(exceptionsImage.get(exceptionName));

        printThinkCloudMessage(exception.getMessage());
    }

    private void printThinkCloudMessage(String message) {
        thinkCloud.setVisible(true);
        thinkCloudText.setText(message);
        waitBeforeAction(actionEvent -> thinkCloud.setVisible(false), FAST_WAITING_MILLISECOND);
    }

    private void setDefaultImage() {
        waitBeforeAction(actionEvent -> catImage.setImage(defaultImage), SLOW_WAITING_MILLISECONDS);
    }

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