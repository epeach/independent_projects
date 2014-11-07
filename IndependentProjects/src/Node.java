import java.util.HashSet;
import java.util.Set;

public class Node{

	Set<Node> edges;
	int val;
	Boolean groupA;

	public Node(int intVal, Boolean setA){
		edges = new HashSet<Node>();
		val = intVal;
		groupA = setA;
	}

	public int getVal(){
		return val;
	}
	
	public Boolean groupA(){
		return groupA;
	}
	
	public void addEdge(Node end){
		edges.add(end);
	}

	public Set<Node> getChildren(){
		Set<Node> childrenToReturn = new HashSet<Node>();
		for(Node item: edges){
			childrenToReturn.add(item);
		}
		return childrenToReturn;
    }

    /**
     * @throws RuntimeException if edges == null
     */
    private void checkRep(){
    	if(edges == null){
    		throw new RuntimeException();
    	}
    }
}

