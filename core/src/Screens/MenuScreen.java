package Screens;

import Tools.RecourceManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import javax.swing.text.View;

public class MenuScreen implements Screen {
    private Sprite background;
    private OrthographicCamera gamecam;
    private Viewport viewport;
    private World world;
    private Game game;
    private SpriteBatch batch;


    public MenuScreen(){
        this.game = game;
        batch = RecourceManager.batch;
        background = new Sprite(new Texture("background.jpg"));
        gamecam = new OrthographicCamera();
        viewport = new FitViewport(1280,800, gamecam);
        gamecam.position.set(viewport.getScreenWidth() / 2, viewport.getScreenHeight() / 2,0);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        System.out.println("Who is reading it - gonna die ");
        batch.setProjectionMatrix(gamecam.combined);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
