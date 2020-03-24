package Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public abstract class  ActingObject  implements Drawable, Updatable {
    protected Vector2 position;
    protected Sprite sprite;
    protected float width, height;
    protected Body body;



}
