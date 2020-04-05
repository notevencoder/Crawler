package com.mygdx.game;

import Tools.ResourceManager.ResourceManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;

import Tools.ConfigsStuff.ConfigCreator;
import Tools.RecourceManager;
import Tools.ScreenManager;
import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.imageio.plugins.jpeg.JPEGImageReader;
import com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi;
import com.sun.imageio.plugins.jpeg.*;
import com.sun.imageio.plugins.png.*;
import javax.imageio.*;
import javax.imageio.stream.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageReader;
import java.awt.image.BufferedImage;
import java.nio.file.Paths;

public class BaseGameClass extends Game {
	public static ScreenManager manager;
	public SpriteBatch batch;


	@Override
	public void create () {

		ResourceManager rm = new ResourceManager();
		//rm.load();

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
