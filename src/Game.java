
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.*; 


public class Game  extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	
	private BufferedImage back; 
	private int key, xco, yco, click; 
	private ArrayList <Cards> gameCards,   cardsChosen, correctCards;
	private Pics p;
	private boolean playMusic, win;
	private ArrayList <XY> xyvalues;
	private ImageIcon lolly, vol;
	private Player play;
	

	public Game() {
		new Thread(this).start();	
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		key =-1; 
		p= new Pics();
		gameCards = setDeck();
		xyvalues=setAllXYVal();
		Shuffle();
		cardsChosen= new ArrayList <Cards> ();
		correctCards= new ArrayList <Cards> ();
		click=0;
		lolly= new ImageIcon("lollipops.png");
		vol= new ImageIcon("mute1.png");
		play =new Player();
		playMusic = true;
		play.playmusic("happymusic.wav");
		win=false;
	}

	
	
	
	
	private ArrayList<XY> setAllXYVal() {
		// TODO Auto-generated method stub
		ArrayList <XY> temp = new ArrayList <XY>();
		
		temp.add(new XY(200,100));
		temp.add(new XY(200,260));
		temp.add(new XY(200,420));
		temp.add(new XY(200,580));
		temp.add(new XY(440,100));
		temp.add(new XY(440,260));
		temp.add(new XY(440,420));
		temp.add(new XY(440,580));
		temp.add(new XY(680,100));
		temp.add(new XY(680,260));
		temp.add(new XY(680,420));
		temp.add(new XY(680,580));
		temp.add(new XY(920,100));
		temp.add(new XY(920,260));
		temp.add(new XY(920,420));
		temp.add(new XY(920,580));
		
		
		return temp;
	}




	private ArrayList<Cards> setDeck() {
		// TODO Auto-generated method stub
		ArrayList <Cards> temp = new ArrayList <Cards> ();
		
		for (int i=0; i<p.getPics().length; i++) {
			temp.add(new Cards( new ImageIcon(p.getPics()[i]), p.getPics()[i]));
		}
		
		
		
		
		return temp;
	}

	public int setRandomX () {
		return (int)(Math.random()*(xyvalues.size()-1));
	}


	
	public void Shuffle() {
		
		for (int i=0; i<gameCards.size(); i++) {
		
			int random= setRandomX();
			gameCards.get(i).setX(xyvalues.get(random).getX());
			gameCards.get(i).setY(xyvalues.get(random).getY());
			
			
			xyvalues.remove(random);
		}
	}
	
	

	public void run()
	   {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }
	   		catch(Exception e)
	      {
	      }
	  	}
	

	
	
	
	public void paint(Graphics g){
		
		Graphics2D twoDgraph = (Graphics2D) g; 
		if( back ==null)
			back=(BufferedImage)( (createImage(getWidth(), getHeight()))); 
		

		Graphics g2d = back.createGraphics();
	
		g2d.clearRect(0,0,getSize().width, getSize().height);
		Color lblue = new Color(173,216,230);
		Color lyellow = new Color(255,255,224);
		g2d.setFont(new Font ("Cooper Black", Font.PLAIN, 70));
		g2d.setColor(lblue);
		g2d.drawString("memory card mania!", 40, 60);
		
		
		g2d.drawImage(lolly.getImage(),50,80,100,100, this);
		g2d.drawImage(lolly.getImage(),50,200,100,100, this);
		g2d.drawImage(lolly.getImage(),50,340,100,100, this);
		g2d.drawImage(lolly.getImage(),50,480,100,100, this);
		g2d.drawImage(lolly.getImage(),50,620,100,100, this);
		g2d.drawImage(lolly.getImage(),50,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+140,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+280,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+420,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+560,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+700,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+840,760,100,100, this);
		g2d.drawImage(lolly.getImage(),190+980,760,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,80,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,200,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,340,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,480,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,620,100,100, this);
		g2d.drawImage(lolly.getImage(),1170,760,100,100, this);
		
		g2d.fillRect(1070, 10, 200, 70);
		g2d.setColor(lyellow);
		g2d.setFont(new Font ("Cooper Black", Font.PLAIN, 40));
		g2d.drawString("reset", 1120, 55);
		g2d.drawRect(1070, 10, 200, 70);
		g2d.drawImage(vol.getImage(),900,10,200,80, this);
		
		
		
		for(int i=0; i<gameCards.size(); i++) {
			g2d.setColor(lyellow);
			g2d.fillRect(gameCards.get(i).getX(), gameCards.get(i).getY(), gameCards.get(i).getW(), gameCards.get(i).getH());
			
		}
		
		for (int i=0; i<cardsChosen.size(); i++) {
			if (!cardsChosen.isEmpty()) {
			
				g2d.drawImage(cardsChosen.get(i).getPic().getImage(), cardsChosen.get(i).getX(), cardsChosen.get(i).getY(), cardsChosen.get(i).getW(), cardsChosen.get(i).getH(), this);
				
			}
			
			
			}
		
		drawCorrectCards(g2d);
		
		
		if (correctCards.size()>15) {
			g2d.setFont(new Font ("Cooper Black", Font.PLAIN, 200));
			g2d.setColor(lblue);
			win=true;
			g2d.drawString("You Win!!!", 150, 390);
		}
	
		twoDgraph.drawImage(back, null, 0, 0);

	}

	public void reset() {
		gameCards = setDeck();
		xyvalues=setAllXYVal();
		Shuffle();
		cardsChosen= new ArrayList <Cards> ();
		correctCards= new ArrayList <Cards> ();
		click=0;
		win=false;
	}


	private void drawCorrectCards(Graphics g2d) {
		// TODO Auto-generated method stub
		for (int i=0; i<correctCards.size(); i++) {
			if (!correctCards.isEmpty()) {
			
				g2d.drawImage(correctCards.get(i).getPic().getImage(), correctCards.get(i).getX(), correctCards.get(i).getY(), correctCards.get(i).getW(), correctCards.get(i).getH(), this);
				
			}
			
			
			}
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		key= e.getKeyCode();
		System.out.println(key);
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
	
		
		
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		xco = e.getX();
		yco = e.getY();
		System.out.println(cardsChosen.size());

		for (int i=0; i<gameCards.size(); i++) {
			if (gameCards.get(i).Collision(xco, yco)) {
				cardsChosen.add(gameCards.get(i));
			}
		}
		
		
		
		
		click++;
		
		//call check cards method first
		if( cardsChosen.size()>=2 && cardCheck() && !win) {
			correctCards.add(cardsChosen.get(0));
			correctCards.add(cardsChosen.get(1));
			clear();
		}
		
		if(click>2) {
		clear();
		}
		
		
		if (xco>1070 && xco<1270 && yco>10 && yco<80) {
			reset();
		}
		
		System.out.println("xc"+xco);
		System.out.println("yc"+yco);
		if (xco>900 && xco<1100 && yco<90 && yco>10) {
			play.playmusic("stop");
		}
	}



	private void clear() {
		// TODO Auto-generated method stub
		cardsChosen.clear();
		click=0;
	}





	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public boolean cardCheck() {
		
		if(cardsChosen.get(0).getPicName().equals(cardsChosen.get(1).getPicName()))
			return true;
		return false;
	}

	
}
