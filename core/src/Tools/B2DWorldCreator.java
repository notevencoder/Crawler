package Tools;

import Screens.GameScreen;
import com.badlogic.gdx.Game;
import com.mygdx.game.BaseGameClass;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;

public class B2DWorldCreator {
    private World world;
    private TiledMap map;
    private Body body;

    public B2DWorldCreator(GameScreen screen) {
        this.map = screen.getMap();
        this.world = screen.getWorld();




    }


}
