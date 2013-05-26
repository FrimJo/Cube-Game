package rtype;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener{

	private Timer timer;
	private int width, height;
	private long startTime;
	private HashMap<Face, Face> faceHash;
	private ArrayList<Cube_3D> cubeList;
	//private View view;
	private final static int SPEED = 5;
	private final static int SIZE = 64;
	double eX = 0;
	double eY = 128;
	double eZ = -256;
	double cX = 0;
	double cY = 128;
	double cZ = -256;
	double thetaX = 0;
	double thetaY = 0;
	double thetaZ = 0;
	
	public Board(){
		
		this.width = 1280;
		this.height = 720;
		
		this.faceHash = new HashMap<Face, Face>();
		this.cubeList = new ArrayList<Cube_3D>();
		
		this.addKeyListener(new TAdapter());
		this.setFocusable(true);
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.setSize(width,height);
		
		try {
			int data, x = 0, y = 0, dataInt;
			
			Reader reader = new FileReader("world01.world");
			while( (data = reader.read() ) != -1 ){	/* While the reader hasn't reached end of file. */
				
				if (data == 10){					/* If the reader has reached new line. */
					x = 0;
					y++;
				}else{
					
		    		dataInt = Character.getNumericValue(data);
		    		for (int i = 0; i < dataInt; i++){
		    			this.cubeList.add(new Cube_3D(new Vertex(x*SIZE, i*SIZE, y*SIZE), SIZE, SIZE, SIZE));	
		    		}
		    		
		    		
		    		
		    		x++;
				}
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

        
        for (Cube_3D cube : this.cubeList){
			for (Face face : cube.getFaceList()){
				if( this.faceHash.containsKey(face) ){
					this.faceHash.remove(face);
				}else{
					this.faceHash.put(face,face);
				}
			}
        }
        
		this.timer = new Timer(5, this);
		this.timer.start();
		
		this.startTime = System.currentTimeMillis();
	}
	
	public void addNotify(){
		super.addNotify();
	}
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
	        
    	Vertex vertexList[];
    	for (Face face : this.faceHash.values()){
    		//Om spelaren ser face gšr fšljande.
    		vertexList = face.getVertexList();
    		
    		double aX,aY,aZ;
    		double dX,dY,dZ;
    		

    		aZ = vertexList[0].getZ();
    		aY = vertexList[0].getY();
    		aX = vertexList[0].getX();
    		
    		dX = Math.cos(Math.toRadians(thetaY))*
    				( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) )
    				- Math.sin(Math.toRadians(thetaY))*(aZ-cZ);
    		dY = Math.sin(Math.toRadians(thetaX))*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				+ Math.cos(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		dZ = Math.cos(thetaX)*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				- Math.sin(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		
    		int bX0 = (int) (eZ/dZ*dX-eX);
    		int bY0 = (int) (eZ/dZ*dY-eY);
    		
    		aZ = vertexList[1].getZ();
    		aY = vertexList[1].getY();
    		aX = vertexList[1].getX();
    		
    		dX = Math.cos(Math.toRadians(thetaY))*
    				( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) )
    				- Math.sin(Math.toRadians(thetaY))*(aZ-cZ);
    		dY = Math.sin(Math.toRadians(thetaX))*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				+ Math.cos(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		dZ = Math.cos(thetaX)*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				- Math.sin(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		
    		int bX1 = (int) (eZ/dZ*dX-eX);
    		int bY1 = (int) (eZ/dZ*dY-eY);
    		
    		
    		aZ = vertexList[2].getZ();
    		aY = vertexList[2].getY();
    		aX = vertexList[2].getX();
    		
    		dX = Math.cos(Math.toRadians(thetaY))*
    				( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) )
    				- Math.sin(Math.toRadians(thetaY))*(aZ-cZ);
    		dY = Math.sin(Math.toRadians(thetaX))*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				+ Math.cos(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		dZ = Math.cos(thetaX)*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				- Math.sin(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		
    		int bX2 = (int) (eZ/dZ*dX-eX);
    		int bY2 = (int) (eZ/dZ*dY-eY);
    		
    		
    		aZ = vertexList[3].getZ();
    		aY = vertexList[3].getY();
    		aX = vertexList[3].getX();
    		
    		dX = Math.cos(Math.toRadians(thetaY))*
    				( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) )
    				- Math.sin(Math.toRadians(thetaY))*(aZ-cZ);
    		dY = Math.sin(Math.toRadians(thetaX))*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				+ Math.cos(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		dZ = Math.cos(thetaX)*
    				( Math.cos(Math.toRadians(thetaY))*(aZ-cZ) + Math.sin(Math.toRadians(thetaY))*( Math.sin(Math.toRadians(thetaZ))*(aY-cY) + Math.cos(Math.toRadians(thetaZ))*(aX-cX) ) )
    				- Math.sin(Math.toRadians(thetaX))*( Math.cos(Math.toRadians(thetaX))*(aY-cY) - Math.sin(Math.toRadians(thetaZ))*(aX-cX) );
    		
    		int bX3 = (int) (eZ/dZ*dX-eX);
    		int bY3 = (int) (eZ/dZ*dY-eY);
    		int nPoints = 4;
    		int xPoints[] = new int[nPoints];
    		int yPoints[] = new int[nPoints];
    		
    		xPoints[0] = bX0+640;
    		xPoints[1] = bX1+640;
    		xPoints[2] = bX2+640;
    		xPoints[3] = bX3+640;
    		
    		yPoints[0] = bY0+360;
    		yPoints[1] = bY1+360;
    		yPoints[2] = bY2+360;
    		yPoints[3] = bY3+360;
    		
    		
    		g2d.setColor(Color.RED);
    		
    		g2d.drawLine(bX0+640, bY0+360, bX1+640, bY1+360);
    		g2d.drawLine(bX1+640, bY1+360, bX2+640, bY2+360);
    		g2d.drawLine(bX2+640, bY2+360, bX3+640, bY3+360);
    		g2d.drawLine(bX3+640, bY3+360, bX0+640, bY0+360);
    		
    		//g2d.setColor(Color.WHITE);
    		g2d.setColor(face.getColor());
    		g2d.fillPolygon(xPoints, yPoints, nPoints);
    		
    	}
    	g2d.setColor(Color.WHITE);
       	g2d.drawString("Elaped time: " + currentTime() , 5, 15);
        
        Toolkit.getDefaultToolkit().sync();
        
        g.dispose();
        
    }

    public String currentTime(){
    	int currentTime = (int) (System.currentTimeMillis() - this.startTime);
    	int sec = (currentTime / 1000);
    	int min = (sec / 60);
    	int hours = (min / 60);
    	String s = "";
    	if(hours < 10)
    		s += "0";
    	s += hours + ":";
    	if( (min%60) < 10)
    		s += "0";
    	s += (min%60) + ":";
    	if( (sec%60) < 10)
    		s += "0";
    	s += (sec%60);
    	
    	return s;
    }
    
    public void actionPerformed(ActionEvent e) {    	
        repaint();  
    }

    private class TAdapter extends KeyAdapter {

        public void keyReleased(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
        	
        	char keyChar = e.getKeyChar();

    		if (keyChar == 'a'){
    			cX += SPEED;
    			eX -= SPEED;
    		}
    		if (keyChar == 'd'){
    			cX -= SPEED;
    			eX += SPEED;
    		}
    		if (keyChar == 'w'){
    			cZ += SPEED;
    			eZ -= SPEED;
    		}
    		if (keyChar == 's'){
    			cZ -= SPEED;
    			eZ += SPEED;
    		}
    		if(keyChar == 'r'){
    			cY += SPEED;
    			eY -= SPEED;
    		}
    		if(keyChar == 'f'){
    			cY -= SPEED;
    			eY += SPEED;
    		}
    		if(keyChar == 'q'){
    			
    		}
    		if(keyChar == 'e'){
    			
    		}
        }
    }
}
