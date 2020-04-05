package Screens;

import Objects.Player;
import Tools.Const;
import Tools.DrawQueue;
import Tools.RecourceManager;
import Tools.ResourceManager.ResourceManager;
import Tools.UpdateQueue;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ai.msg.MessageManager;
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

import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class GameScreen implements Screen {

    private Game game;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Viewport gamePort;
    private OrthographicCamera gamecam;
    private TmxMapLoader mapLoader;
    private OrthogonalTiledMapRenderer renderer;
    private TiledMap map;
    private Player player;
    private MessageManager messageManager;
    private ResourceManager rm;

    private DrawQueue drawQueue;
    private UpdateQueue updateQueue;

    public GameScreen(Game game){
        drawQueue = new DrawQueue();
        updateQueue = new UpdateQueue();

        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(RecourceManager.W_WIDTH,RecourceManager.W_HEIGHT,gamecam);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("textArea.tmx");

        renderer = new OrthogonalTiledMapRenderer(map, 2);
        b2dr = new Box2DDebugRenderer();
        world = new World(new Vector2(0,0), true);

        rm = new ResourceManager();
        rm.load();
        player = new Player( RecourceManager.W_WIDTH / 2,RecourceManager.W_HEIGHT / 2,this);
        defineMsgDispatcher();





    }

    public void handleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            messageManager.dispatchMessage(Const.MSG_A);
        }
        if (Gdx.input.isKeyPressed (Input.Keys.S)) {
            messageManager.dispatchMessage(Const.MSG_S);

        }
        if (Gdx.input.isKeyPressed (Input.Keys.D)) {
            messageManager.dispatchMessage(Const.MSG_D);

        }
        if (Gdx.input.isKeyPressed (Input.Keys.W)) {
            messageManager.dispatchMessage(Const.MSG_W);

        }
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

        world.step(0.1f, 2,6);

        gamecam.position.x = RecourceManager.W_WIDTH / 2;
        gamecam.position.y = RecourceManager.W_HEIGHT / 2;

        RecourceManager.batch.setProjectionMatrix(gamecam.combined);

        gamecam.update();
        gamecam.zoom = 1f;
        renderer.setView(gamecam);

        renderer.render();

        handleInput();

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

    public void defineMsgDispatcher(){
        messageManager = MessageManager.getInstance();
        messageManager.addListeners(player, Const.MSG_S,Const.MSG_W,Const.MSG_A,Const.MSG_D);
    }


}
