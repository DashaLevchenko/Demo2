package GUI;

import demo.*;
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

public class Controller {

    @FXML
    private ProgressBar satiety;

    @FXML
    private Button createPetButtonMessage;

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
    //endregion

    private Image dirty = new Image("GUI/static/img/state/dirty.png");
    private Image needMedicine = new Image("GUI/static/img/state/needMedicine.png");
    private Image wantToEat = new Image("GUI/static/img/state/wantToEat.png");
    private Image wantToPlay = new Image("GUI/static/img/state/wantToPlay.png");
    private Image wantToScratchTummy = new Image("GUI/static/img/state/wantToScratchTummy.png");


    @FXML
    void toScoldButton() {
        try {
            cat.toScold();
        } catch (PetGrewUpException | PetDiedException e) {
            gameOverWindow.setVisible(true);
        } catch (PetIsDirtyException e) {
            printStateExceptionText(e.getMessage());
        } catch (PocheshiPuzikoException e) {
            printStateExceptionText(e.getMessage());
        } catch (PetIsIllException e) {
            printStateExceptionText(e.getMessage());
        } catch (OopsYourShoesIsWetException e) {
            printStateExceptionText(e.getMessage());
        } catch (PetWantsToPalyException e) {
            printStateExceptionText(e.getMessage());
        } catch (PetIsHungryException e) {
            printStateExceptionText(e.getMessage());
        }
    }

    @FXML
    void toWashButton() {
        catImage.setImage(washing);

        waitBeforeAction(action -> {
            try {
                cat.toWash();
            } catch (PetDiedException | PetGrewUpException e) {
                printGameOverException(e.getMessage());
            } catch (PetIsDirtyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PocheshiPuzikoException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsIllException e) {
                printStateExceptionText(e.getMessage());
            } catch (OopsYourShoesIsWetException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetWantsToPalyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsHungryException e) {
                printStateExceptionText(e.getMessage());
            }
        }, 1500);

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
        }, 1500);

        setDefaultImage();
        changeProgresses();
    }

    private void printGameOverException(String message) {
        gameOverWindow.setVisible(true);
        anchorPaneWithInterface.setDisable(true);
        messageGameOver.setText(message);
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
        }, 1500);

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
            } catch (PetIsDirtyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PocheshiPuzikoException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsIllException e) {
                printStateExceptionText(e.getMessage());
            } catch (OopsYourShoesIsWetException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetWantsToPalyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsHungryException e) {
                printStateExceptionText(e.getMessage());
            }
        }, 1500);

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
            } catch (PetIsDirtyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PocheshiPuzikoException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsIllException e) {
                printStateExceptionText(e.getMessage());
            } catch (OopsYourShoesIsWetException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetWantsToPalyException e) {
                printStateExceptionText(e.getMessage());
            } catch (PetIsHungryException e) {
                printStateExceptionText(e.getMessage());
            }
        }, 1500);

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
            printThinkCloudMessage("Hello, my name is " + inputName);
        }
    }


    @FXML
    void gameOverButtonPressed() {
        cancelButtonPressed();
    }

    private void printStateExceptionText(String message) {
        if (message.contains("dirty")) {
            catImage.setImage(dirty);
        }

        if (message.contains("feeling bad")) {
            catImage.setImage(needMedicine);
        }

        if (message.contains("tummy")) {
            catImage.setImage(wantToScratchTummy);
        }

        if (message.contains("play")) {
            catImage.setImage(wantToPlay);
        }

        if (message.contains("hungry")) {
            catImage.setImage(wantToEat);
        }

        printThinkCloudMessage(message);
    }

    private void printThinkCloudMessage(String message) {
        thinkCloud.setVisible(true);
        thinkCloudText.setText(message);
        waitBeforeAction(actionEvent -> thinkCloud.setVisible(false), 1500);
    }

    private void setDefaultImage() {
        waitBeforeAction(actionEvent -> catImage.setImage(defaultImage), 2700);
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
                }, 1500);
    }
}