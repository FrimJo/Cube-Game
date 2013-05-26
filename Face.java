package rtype;

import java.awt.Color;

import javax.swing.ImageIcon;

public class Face {
	private Vertex[] vertexList;
	
	private Color color;
	
	public Face(Vertex v0, Vertex v1, Vertex v2, Vertex v3, Color color){
		this.color = color;
		this.vertexList = new Vertex[4];
		this.vertexList[0] = v0;
		this.vertexList[1] = v1; 
		this.vertexList[2] = v2; 
		this.vertexList[3] = v3;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public Vertex[] getVertexList(){
		return this.vertexList;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		for (Vertex vertex : this.vertexList){
			result = 31 * result + vertex.hashCode();
		}
        return result;
	}
	
	@Override
	public boolean equals(Object o){
		
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Face face = (Face) o;
        Vertex[] vertexList = face.getVertexList();
        
        boolean equals = true;
    	for (Vertex vertex : vertexList ){
    		if (!this.contains(vertex)){
    			equals = false;
    		}
    	}
		return equals;
	}
	
	private boolean contains(Vertex compVertex){
		for (Vertex vertex : this.vertexList){
			if (vertex.equals(compVertex)){
				return true;
			}
		}
		return false;
	}
}
