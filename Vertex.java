package rtype;

public class Vertex {
	
	private float x, y, z;
	
	public Vertex(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vertex(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
		
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public float getZ(){
		return this.z;
	}
	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (this.x != vertex.getX()) return false;
        if (this.y != vertex.getY()) return false;
        if (this.z != vertex.getZ()) return false;
		
        return true;
	}
	
	@Override
	public int hashCode(){
		int result = (int) (this.x);
        result = 31 * result + (int) (this.y);
        result = 31 * result + (int) (this.z);
        return result;
	}
	
	@Override
	public String toString(){
		String string = "";
		string+= "(" + this.x + "," + this.y + "," + this.z + ")";
		return string;
	}
}
