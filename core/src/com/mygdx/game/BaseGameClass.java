package com.mygdx.game;

import Screens.MenuScreen;
import Tools.RecourceManager;
import Tools.ScreenManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseGameClass extends Game {
	public static ScreenManager manager;
	public SpriteBatch batch;


	@Override
	public void create () {
		batch = RecourceManager.batch;
		manager = new ScreenManager(this);
		manager.setScreen("Menu");
	}


	@Override
	public void render () {
		super.render();
		System.out.println(manager.getCurrentScreen());

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
