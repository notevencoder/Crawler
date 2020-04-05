package com.mygdx.game;
import Tools.RecourceManager;
import Tools.ScreenManager;
import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseGameClass extends Game {
	public static ScreenManager manager;
	public SpriteBatch batch;


	@Override
	public void create () {
		batch = RecourceManager.batch;
		manager = new ScreenManager(this);
		manager.setScreen("Game");

		//ConfigCreator cc = new ConfigCreator(Paths.get("C:\\Users\\AsisT\\Desktop\\crawler\\core\\assets\\frames"),Paths.get("C:\\Users\\AsisT\\Desktop\\crawler\\core\\assets\\Animations"));

	}


	@Override
	public void render () {
		super.render();
		//System.out.println(manager.getCurrentScreen());

	}



	@Override
	public void dispose () {
		batch.dispose();
	}
}
