import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =1800;
	private static final int HEIGHT=1600;
	
	public Main () {
		super("Janie needs to change the title");
		setSize(WIDTH, HEIGHT);
		Game play = new Game();
		((Component) play).setFocusable(true);
		
		Color BabyPink = new Color(250,218,221);
		Color lyellow = new Color(255,255,224);
		
		setBackground(BabyPink);
		
		
		getContentPane().add(play);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

	public static void main(String[] args) {
		Main run = new Main();
		

	}


}
