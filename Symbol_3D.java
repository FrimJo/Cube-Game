package rtype;

import java.util.ArrayList;

public abstract class Symbol_3D {
	
	private Vertex position;
	private ArrayList<Face> faceList;
		
	public Symbol_3D(Vertex position){
		this.faceList = new ArrayList<Face>();
		this.position = position;
	}
	
	public void setPosition(Vertex vertex){
		this.position = vertex;
	}
	
	public Vertex getPosition(){
		return this.position;
	}
	
	public ArrayList<Face> getFaceList(){
		return this.faceList;
	}
	
	public abstract void addEdges();
}
