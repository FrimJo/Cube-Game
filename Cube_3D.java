package rtype;

import java.awt.Color;

public class Cube_3D extends Symbol_3D{
		
	private float width, height, depth;
		
	public Cube_3D(Vertex position, float width, float height, float depth){
		super(position);
		this.width = width;
		this.height = height;
		this.depth = depth;
		addEdges();
	}
	
	public float getWidth(){
		return this.width;
	}
	
	public float getHeight(){
		return this.height;
	}
	
	public float getDepth(){
		return this.depth;
	}
	
	@Override
	public void addEdges(){
		
		//Add all edges needed to create a Cube with the given width, height and depth
		float x = getPosition().getX();
		float y = getPosition().getY();
		float z = getPosition().getZ();
		
		float w = width/2;
		float h = height/2;
		float d = depth/2;
		
		this.getFaceList().add(
			new Face(
				new Vertex(x-w, y-h, z+d),
				new Vertex(x+w, y-h, z+d),
				new Vertex(x+w, y+h, z+d),
				new Vertex(x-w, y+h, z+d),
				Color.WHITE
			)
		);
		
		this.getFaceList().add(
			new Face(
				new Vertex(x-w, y-h, z-d),
				new Vertex(x+w, y-h, z-d),
				new Vertex(x+w, y+h, z-d),
				new Vertex(x-w, y+h, z-d),
				Color.GREEN
			)
		);
		
		this.getFaceList().add(
			new Face(
				new Vertex(x-w, y-h, z-d),
				new Vertex(x+w, y-h, z-d),
				new Vertex(x+w, y-h, z+d),
				new Vertex(x-w, y-h, z+d),
				Color.RED
			)
		);
		
		this.getFaceList().add(
			new Face(
				new Vertex(x-w, y+h, z-d),
				new Vertex(x+w, y+h, z-d),
				new Vertex(x+w, y+h, z+d),
				new Vertex(x-w, y+h, z+d),
				Color.BLUE
			)
		);
		
		this.getFaceList().add(
			new Face(
				new Vertex(x+w, y-h, z+d),
				new Vertex(x+w, y-h, z-d),
				new Vertex(x+w, y+h, z-d),
				new Vertex(x+w, y+h, z+d),
				Color.GRAY
			)
		);
			
		this.getFaceList().add(
			new Face(
				new Vertex(x-w, y-h, z+d),
				new Vertex(x-w, y-h, z-d),
				new Vertex(x-w, y+h, z-d),
				new Vertex(x-w, y+h, z+d),
				Color.PINK
			)
		);
	}
	/*
	public void rotadeAroundY(float degree){

		float rad = (float) Math.toRadians(degree);
		
		for(Face face : getFaceList() ){
			for(Vertex vertex : face.getVertexList()){
				float x = vertex.getX();
				float y = vertex.getY();
				float z = vertex.getZ();
				
				x = (float) (x*Math.cos(rad)-z*Math.sin(rad));  
			    z = (float) (x*Math.sin(rad)+z*Math.cos(rad));

				vertex.setVertex(x, y, z);
			}
		}
	}
	
	public void rotadeAroundX(float degree){

		float rad = (float) Math.toRadians(degree);
		
		for(Face face : getFaceList() ){
			for(Vertex vertex : face.getVertexList()){
				float x = vertex.getX();
				float y = vertex.getY();
				float z = vertex.getZ();
				
				 y = (float) (y*Math.cos(rad)-z*Math.sin(rad));  
				 z = (float) (y*Math.sin(rad)+z*Math.cos(rad));

				vertex.setVertex(x, y, z);
			}
		}
	}
	
	public void rotadeAroundZ(float degree){

		float rad = (float) Math.toRadians(degree);
		
		for(Face face : getFaceList() ){
			for(Vertex vertex : face.getVertexList()){
				float x = vertex.getX();
				float y = vertex.getY();
				float z = vertex.getZ();

				x = (float) (x*Math.cos(rad) - y*Math.sin(rad));
				y = (float) (x*Math.sin(rad) + y*Math.cos(rad));
				
				vertex.setVertex(x, y, z);
			}
		}
	}*/
	
}
