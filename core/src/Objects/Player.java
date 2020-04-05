package Objects;

import Screens.GameScreen;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends ActingObject{

    private Screen screen;



    public Player(float x, float y, GameScreen screen){
        this.screen = screen;

        /*Box2dBodyCreator box2dBodyCreator = new Box2dBodyCreator(screen);
        this.body = box2dBodyCreator.createStaticBody(x,y);
        box2dBodyCreator.createSquareFixture(body,100,100);*/

    }

    @Override
    public void drawMe(SpriteBatch batch) {

    }


    @Override
    public void update() {

    }
}
