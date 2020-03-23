# Demo2

#Instructions:
Name the tamagotchi
Select the action by pressing up/down and then pressing enter
Each action will change the tamagotchi state
Green color bar means All Ok, Red means the state is critical
Select the action that increases the critical state
Repeat

#Actions:
Primary reaction
Feed -> Increases Fullness
Give Medicine -> Increases Health
Go Potty -> Increases Bowel
Play -> Increases Happiness
Put To Bed -> Increases Energy
Secondary reactions may increase/decrease other states

#Automatic Actions:
When the energy is below the lower_threshold, the pet will go to sleep.
When the bowel is below the lower_threshold, the pet will poop
Game over scenarios:
When the health is zero
When the age reaches maximum age
The user selects to quit
