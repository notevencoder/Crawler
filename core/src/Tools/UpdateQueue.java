package Tools;

import Objects.Updatable;
import com.badlogic.gdx.utils.Array;

public class UpdateQueue {
    private Array<Updatable> arr;

    public UpdateQueue(){
        arr = new Array<Updatable>();
    }

    public void update(){
        for (Updatable i: arr)
            i.update();
    }
    public void add(Updatable sample){
        arr.add(sample);
    }

}
