package Tools.ResourceManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.*;

import java.util.ArrayList;
import java.util.HashMap;

public class ResourceManager {
    private TextureAtlas atlas;
    private HashMap<String, Animation> animations;
    private static ResourceManager instance;

    public ResourceManager(){
        animations = new HashMap<>();
        atlas = new TextureAtlas("InsertAtlasPath");
    }
    public static ResourceManager getInstance(){
        if(instance ==null) {
            instance = new ResourceManager();
        }
        return instance;
    }
    public void load(int LvlNum) {
        ArrayList<String> objList;
        animations.clear();
        Array<TextureRegion> frames = new Array<TextureRegion>();
        TextureRegion currRegion;
        FileHandle file = Gdx.files.internal("data/JSONTest.json");
        Json json = new Json();
        ObjectData obj = json.fromJson(ObjectData.class, file.readString());
        for (AnimationData anim : obj.animations) {
            System.out.println(anim.animName);
            currRegion = atlas.findRegion(anim.txRegionName);
            for (int i = 0; i < anim.frameCount; i++) {
                frames.add(new TextureRegion(currRegion, i * obj.width, 0, obj.width, obj.height));
            }
            animations.put(anim.animName, new Animation(anim.frameDur, frames));
            frames.clear();
        }
    }
}

