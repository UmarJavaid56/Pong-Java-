# Pong

# Opening in Visual Studio Code
1. Make sure that you have VSCode installed on your device.
2. Clone this repository to your device.
3. Install Extensions:
     1. Open VSCode.
     2. Go to the Extensions view by clicking the Extensions icon in the Activity Bar or by pressing Ctrl+Shift+X.
     3. Install the Java Extension Pack.
4. Open the Project.
5. Click on the debug icon in the Activity Bar on the side of the VS Code window.
6. Click on "create a launch.json file".
7. Ensure you have the Java Development Kit (JDK) installed and configured in VSCode. To configure the JDK in VSCode, go to File > Preferences > Settings, search for "Java Home", and set the path to your JDK installation.  You can download it from the Oracle Website: https://www.oracle.com/java/technologies/downloads/#java11
9. Right-click on the Pong_Game.java file in the Explorer view and select "Run Java".

# How to Play
## Player 1  
Move Up: W  
Move Down: S

## Player 2  
Move Up: Up Arrow Key  
Move Down: Down Arrow Key  

# Rules  
First player to reach 10 points wins the game.  
Player 1 and Player 2 must play on the same device.  
If a player scores a **hat-trick** (scores three times without the other player scoring) they will recieve a powerup. 

## PowerUps  
1. Player Paddle size increases and opponent Paddle size decreases until opponent also scores a hat-trick.  


# Repository Structure
## Key Java Source Files
- `Ball.Java` Represents the ball in the Pong game.  
- `Game_End_Sounds.java`: Handles the end game sounds.  
- `Game_Frame.java`: The main frame of the game.  
- `Game_Panel.java`: The panel where the game is drawn.  
- `Game_Start_Sound.java`: Handles the start game sounds.  
- `Paddle.java`: Represents the paddles in the game.  
- `Pong_Game.java`: The main class to start the Pong game.  
- `PowerUp_Sound.java`: Handles the power-up sounds.  
- `Score.java`: Manages the score.  
- `Sound_effects.java`: Handles the sound produced when ball hits the paddle.  
## Sound Files
- `Game_Start.wav` 
- `GameOver.wav`  
- `Pong.wav`  
- `PowerUp.wav`

  

