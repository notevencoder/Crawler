package LevelUnits;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Tile {

    private Sprite sprite;
    private Vector2 position, size;
    private boolean isSensor;
    private int tileId;


    public Tile() {

    }

    public void setSize(float width, float height){
        this.size.x = width;
        this.size.y = height;
    }

    public void setPosition(Vector2 position){
        this.position = position;
    }

    public void setPosition(float x, float y){
        this.position.x = x;
        this.position.y = y;

    }
    public void setBounds(float width, float height, Vector2 position){
        setPosition(position);
        setSize(width, height);
    }
    public void setBounds(float width, float height, float x, float y){
        setPosition(x, y);
        setSize(width, height);
    }

    public void setSensor(boolean isSensor){
        this.isSensor = isSensor;
    }

    public boolean isSensor(){
        return isSensor;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Vector2 getSize() {
        return size;
    }
}
