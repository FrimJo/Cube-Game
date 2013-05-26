package rtype;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Player extends Rectangle{
	
	private int dx, dy;
	private boolean visible;
	
	public Player(int width, int height){
		super(40, 60, width, height);
		this.visible = true;
	}
	
	public void move(){
		this.setLocation( (int) (this.getX()) + dx, (int) this.getY() + dy);
	}

	public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisible() {
        return visible;
    }
	    
	public void keyPressed(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT){
			dx = -1;
		}
		if (key == KeyEvent.VK_RIGHT){
			dx = 1;
		}
		if (key == KeyEvent.VK_UP){
			dy = -1;
		}
		if (key == KeyEvent.VK_DOWN){
			dy = 1;
		}

	}
	
	public void keyRelease(KeyEvent e){
		
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
			dx = 0;
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
	}
	
}
