package rtype;

public class View {
	
	private Vertex naturalVertex;
	private float angleX;
	private float angleY;
	private float angleZ;
	
	public View(int x, int y, int z){
		this.naturalVertex = new Vertex(x, y, z);
		this.angleX = 0;
		this.angleY = 0;
		this.angleZ = 0;
	}

	public float getAngleX() {
		return angleX;
	}

	public void setAngleX(float angleX) {
		this.angleX = angleX;
	}

	public float getAngleY() {
		return angleY;
	}

	public void setAngleY(float angleY) {
		this.angleY = angleY;
	}

	public float getAngleZ() {
		return angleZ;
	}

	public void setAngleZ(float angleZ) {
		this.angleZ = angleZ;
	}

	public Vertex getNaturalVertex() {
		return naturalVertex;
	}
	
	public void setNaturalVertex(Vertex naturalVertex) {
		 this.naturalVertex = naturalVertex;
	}
	
	public void calcAngles(Vertex vertex){
		//ToDo Calculate the angles of the view to look at the specific vertex.
	}
	
}
