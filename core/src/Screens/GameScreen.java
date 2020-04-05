package Screens;

import Tools.DrawQueue;
import Tools.RecourceManager;
import Tools.UpdateQueue;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {

    private Game game;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Viewport gamePort;
    private OrthographicCamera gamecam;
    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;

    private DrawQueue drawQueue;
    private UpdateQueue updateQueue;

    public GameScreen(Game game){
        drawQueue = new DrawQueue();
        updateQueue = new UpdateQueue();
       // box2dBodyCreator = new Box2dBodyCreator(this);
        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(RecourceManager.W_WIDTH,RecourceManager.W_HEIGHT,gamecam);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("textArea.tmx");

        renderer = new OrthogonalTiledMapRenderer(map, 2);
        b2dr = new Box2DDebugRenderer();
        world = new World(new Vector2(0,0), true);






    }

    public World getWorld(){
        return world;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gamecam.position.x = RecourceManager.W_WIDTH / 2;
        gamecam.position.y = RecourceManager.W_HEIGHT / 2;
        RecourceManager.batch.setProjectionMatrix(gamecam.combined);
        gamecam.update();
        gamecam.zoom = 1f;
        renderer.setView(gamecam);
        renderer.render();
        b2dr.render(world, gamecam.combined);
    }

    public TiledMap getMap(){
        return map;
    }
    @Override
    public void resize(int width, int height) {
        gamePort.update(width,height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
