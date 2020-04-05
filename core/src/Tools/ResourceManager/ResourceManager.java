package Tools.ResourceManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Класс для загрузки и хранения всех анимаций
 */
public class ResourceManager {

    private HashMap<String, HashMap<String, Animation>> objAnims;
    public ResourceManager() {
        objAnims = new HashMap<>();
    }
    /** load удаляет все загруженные анимации и загружает новые в зависимости от номера уровня
    * Сейчас он просто загружает анимации всех объектов, указанных в файле ObjNames.json
    */
    public void load() {
        TextureAtlas atlas;
        objAnims.clear();
        HashMap<String, Animation> animations = new HashMap<>();
        Array<TextureRegion> frames = new Array<TextureRegion>();
        TextureRegion currRegion;
        Json json = new Json();
        FileHandle file = Gdx.files.internal(RMConfig.OBJ_NAMES_PATH);
        /* В файле ObjNames должны храниться названия всех объектов, для которых нужно загрузить анимации.
        *  В будущем для каждого уровня будет свой файл со списком объектов. Так бы будем определять, что нам необходимо загрузить.
        */
        ObjList objList = json.fromJson(ObjList.class, file.readString());
        for (String objName : objList.animList){
            /* Атласы и json файлы, описывающие анимации, хранятся в одной директории
            *  Название файлов и папки должно совпадать с названием объекта
            */
            file = Gdx.files.internal(RMConfig.OBJECTS_PATH + objName + "/" + objName + ".json");
            atlas = new TextureAtlas(RMConfig.OBJECTS_PATH + objName + "/" + objName + ".pack");
            ObjectData obj = json.fromJson(ObjectData.class, file.readString());
            for (AnimationData anim : obj.animations) {
                currRegion = atlas.findRegion(anim.name);
                int width = currRegion.getRegionWidth()/anim.frameCount;
                for (int i = 0; i < anim.frameCount; i++) {
                    frames.add(new TextureRegion(currRegion, i * width, 0, width,currRegion.getRegionHeight()));
                }
                animations.put(anim.name, new Animation(RMConfig.FRAME_DUR, frames));
                frames.clear();
            }
            objAnims.put(objName,animations);
            animations.clear();
        }
    }
    public HashMap <String, Animation> getAnims(String objName){
        return objAnims.get(objName);
    }

    //Добавил метод для одной анимации на всякий случай
    public Animation getAnim(String objName, String animName){
        return objAnims.get(objName).get(animName);
    }
}

