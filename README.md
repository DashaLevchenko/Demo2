# Demo2

#Setup:
- Clone this repo to your local machine using [demo](https://github.com/DashaLevchenko/Demo2.git)
- Use Java 8
- Copy "style.css" and "TamagochiView.fxml" to output path ".../Demo2/gui", if this files aren't exist in output path ".../Demo2/gui"

# Instructions:
When the programm starts you need to enter your pet's name and click the "Create button". Please note that only Latin characters are allowed.

After the valid name is entered you will be able to select 6 actions that will be applied to the Cat: Feed, Scold, Wash, Play, Stroke, Heal. You can either fulfill the needs of the pet by pressing the 6 six buttons in the specified order or just click on them randomly. Each action will change the pet state.

Some parameters, as Health, Satiety and Age are critical. When Health parameter points reach zero, the cat dies and game overs. When Satiety parameter is zero, the cat dies and game overs. When Age reaches maximum age, the cat is considered to be grown up and the game overs.

# Actions:
- Feed -> Increases health point, happiness, satiety. Decreases purity.
- Scold -> Decreases happiness, satiety, health.
- Wash -> Increases health, purity. Decreases satiety.
- Play -> Increases happiness. Decreases satiety, purity, health.
- Stroke -> Increases happiness. Decreases satiety.
- Heal -> Increases health. Decreases satiety, purity, happiness.

# Game over scenarios:
- When the health is zero.
- When the age reaches maximum age.
- The user selects to quit.
