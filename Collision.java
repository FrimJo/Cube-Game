package rtype;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Collision extends JFrame {
	
	public Collision() {
		add(new Board());
		
		//add(new Board());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setTitle("Collision");
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Collision();
    	
    	
    }
    
}
