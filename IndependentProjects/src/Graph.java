import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph{

	private Set<Node> graph;

    /**
     * @modifies graph
     * @effects Creates new, empty graph.
     */
    public Graph(){
        graph = new HashSet<Node>();
        checkRep();
    }

    public void addNode(int value, Boolean setA){
    	if(!containsValue(value)){
        		graph.add(new Node(value, setA));
        }
        checkRep();
    }
    
    public Boolean containsValue(int value){
    	List<Node> nodes = getNodes();
    	for(Node vertex: nodes){
    		if(vertex.getVal() == value){
    			return true;
    		}
    	}
    	return false;
    }

    public List<Node> getNodes(){
        List<Node> nodes = new ArrayList<Node>();
        for(Node item: graph){
                nodes.add(item);
        }
        return nodes;
    }
    
    public Set<Node> getGroup(Boolean setA){
    	List<Node> nodes = getNodes();
    	Set<Node> nodesToReturn = new HashSet<Node>();
    	for(Node vertex : nodes){
    		if(setA && vertex.groupA){
    			nodesToReturn.add(vertex);
    		}
    		if(!setA && !vertex.groupA){
    			nodesToReturn.add(vertex);
    		}
    	}
    	return nodesToReturn;
    }
    

    /**
     * @Throws RuntimeException if graph is null.
     */
    private void checkRep(){
            if(graph == null){
                    throw new RuntimeException();
            }
    }    
}
