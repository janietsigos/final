import javax.swing.ImageIcon;

public class Cards {

	private ImageIcon pic;
	private int x, y, w, h;
	private String picName;

	
	public Cards() {
		x=0;
		y=0;
		
		
		
	}
	
	public Cards(ImageIcon img, String picIdent) {
		pic = img;
		x=0;
		y=0;
		w=200;
		h=120;
		picName=picIdent;
		
		
		
	}
	
	
	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public boolean Collision(int mouseX, int mouseY) {
		if (x<mouseX && x+w>mouseX && y<mouseY && y+h>mouseY) {
			return true;
		}
		
		return false;
	}
	
	public ImageIcon getPic() {
		return pic;
	}

	public int getX() {
		// TODO Auto-generated method stub
		return x;
		
	}
	
	public int getY() {
		// TODO Auto-generated method stub
		return y;
		
	}
	
	public void setX(int xV) {
		x=xV;
	}
	
	public void setY(int yV) {
		y=yV;
	}

	
	
	
}