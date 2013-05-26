package rtype;

public class Edge {

	private Vertex[] vertexList;
		
	public Edge(Vertex v0, Vertex v1){
		this.vertexList = new Vertex[2];
		this.vertexList[0] = v0;
		this.vertexList[1] = v1;
	}

	public Vertex[] getVertexList(){
		return this.vertexList;
	}

	
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;
        Vertex[] edgeVertexList = edge.getVertexList();
        
        boolean equals = true;
    	for (Vertex edgeVertex : edgeVertexList ){
    		if (!this.contains(edgeVertex)){
    			equals = false;
    		}
    	}
        
        return equals;
	}
	
	private boolean contains(Vertex compVertex){
		boolean contains = false;
		for (Vertex vertex : this.vertexList){
			if (vertex.equals(compVertex)){
				contains = true;
			}
		}
		return contains;
	}
	
	@Override
	public int hashCode(){
		int result = 1;
		for (Vertex vertex : this.vertexList){
			result = 31 * result + vertex.hashCode();
		}

        return result;
	}
}
