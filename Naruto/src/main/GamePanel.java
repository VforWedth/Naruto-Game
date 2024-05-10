package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100; 
	private BufferedImage img, subImg;
	private String source;
	//private float xPos, yPos, Height, Width;
	private Scanner input = new Scanner(System.in);

	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);
		chooseCharacter();
		importImage();
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public void chooseCharacter() {
		System.out.println("Choose the player: \n 1)Naruto\n2)Kakashi\n3)Sakura");
		int num = input.nextInt();
		switch(num) {
		case 1:
			source = "/player.png";
			break;
		case 2:
			source = "/KakashiSprite.png";
			break;
		case 3:
			source = "/SakuraSprite.png";
			break;
		}
		
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream("source");
		try {
			img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setPanelSize() {
		Dimension size = new Dimension(1000, 600);
		setMinimumSize(size);
		setMaximumSize(size);
	}
	
	public void changeXDelta(int value) {
		this.xDelta += value;
	}
	
	public void changeYDelta(int value) {
		this.yDelta += value;
	}
	
	public void setRectPos(int x , int y) {
		this.xDelta = x;
		this.yDelta = y;
	}

	public void painComponent(Graphics g) {
		super.paintComponent(g);
		
		subImg = img.getSubimage(5*123, 0, 125, 133);
		g.drawImage(subImg, (int)xDelta, (int)yDelta, 125, 133, null);
	}
}
