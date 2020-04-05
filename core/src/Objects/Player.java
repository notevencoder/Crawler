package Objects;

import Screens.GameScreen;
import Tools.Const;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.msg.Telegram;
import com.badlogic.gdx.ai.msg.Telegraph;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.utils.Box2DBuild;

public class Player extends ActingObject implements Telegraph {

    private Screen screen;
    private World world;
    private Vector2 position;




    public Player(float x, float y, GameScreen screen){
        this.screen = screen;
        this.world = screen.getWorld();
        this.position = new Vector2(x, y);

        BodyDef bdef = new BodyDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        body = world.createBody(bdef);
        FixtureDef fdef = new FixtureDef();

        CircleShape shape = new CircleShape();
        shape.setRadius(10f);
        fdef.shape = shape;
        fdef.friction = 0;

        body.createFixture(fdef);


    }

    @Override
    public void drawMe(SpriteBatch batch) {

    }


    @Override
    public void update() {

    }

    @Override
    public boolean handleMessage(Telegram msg) {
        switch (msg.message){
            case(Const.MSG_A):
                System.out.println("Got Msg: " + msg.message + " " + body.getPosition() );
                body.applyForce(new Vector2(-10,0),body.getPosition(),true);
                break;
            case(Const.MSG_S):
                System.out.println("Got Msg: " + msg.message);
                body.applyForce(new Vector2(0,-10),body.getPosition(),true);
                break;
            case(Const.MSG_D):
                System.out.println("Got Msg: " + msg.message);
                body.applyForce(new Vector2(10,0),body.getPosition(),true);
                break;
            case(Const.MSG_W):
                System.out.println("Got Msg: " + msg.message);
                body.applyForce(new Vector2(0,10),body.getPosition(),true);
                break;

        }
        return true;
    }
}
