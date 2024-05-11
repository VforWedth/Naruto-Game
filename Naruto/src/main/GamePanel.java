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
	private String source = null;
	//private float xPos, yPos, Height, Width;
	Scanner input = new Scanner(System.in);
	private int charX, charY;

	public GamePanel() {
		
		mouseInputs = new MouseInputs(this);
		chooseCharacter();
		importImage();
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}
	
	public String chooseCharacter() {
		System.out.println("Choose the player: \n1)Uzumaki Naruto\n2)Hatake Kakashi\n3)Uchiha Sasuke\n4)Sakura Haruno");
		int num = input.nextInt();
		switch(num) {
		case 1:
			source = "/player.png";
			charX = 0;
			charY = 2*133;
			break;
		case 2:
			source = "/HatakeKakashi.png";
			charX = 6*123;
			charY = 0;
			break;
		case 3:
			source = "/UchihaSasuke.png";
			charX = 6*123;
			charY = 0;
			break;
		case 4:
			source = "/SakuraHaruno.png";
			charX = 6*123;
			charY = 0;
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
		return source;
		
	}
	
	private void importImage() {
		InputStream is = getClass().getResourceAsStream(source);
		try {
			img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setPanelSize() {
		Dimension size = new Dimension(1000, 600);
		setPreferredSize(size);
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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		subImg = img.getSubimage(charX, charY, 125, 133);
		g.drawImage(subImg, (int)xDelta, (int)yDelta, 125, 133, null);
	}
}
