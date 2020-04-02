package com.mygdx.game;

import Tools.ResourceManager.ResourceManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BaseGameClass extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		ResourceManager rm = new ResourceManager();
		rm.load();
	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {

	}
}
