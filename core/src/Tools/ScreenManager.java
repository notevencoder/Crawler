package Tools;

import Screens.GameScreen;
import Screens.MenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

import java.util.HashMap;

public class ScreenManager {
        private Game game;
        private HashMap<String, Screen> screens;

        private Screen gameScreen, menuScreen, currentScreen;

    public ScreenManager(Game game){
        this.game = game;
        defineScreens();

        currentScreen = screens.get("Menu");

    }

    private void defineScreens(){
        gameScreen = new GameScreen();
        menuScreen = new MenuScreen();

        screens = new HashMap<>();
        screens.put("Game", gameScreen);
        screens.put("Menu", menuScreen);
    }


    public void setScreen(String name){
        currentScreen = screens.get(name);
        game.setScreen(currentScreen);

    }
    public Screen getCurrentScreen(){
        return currentScreen;
    }




}
