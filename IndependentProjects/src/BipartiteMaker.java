import java.util.Set;

public class BipartiteMaker {

	public static Graph bipartiter(int nodeSize){
		Graph bip = new Graph();
		
		//Add Nodes
		for(int i = 0; i < nodeSize; i++){
			if(i < nodeSize/2){
				bip.addNode(i, true);
			} else {
				bip.addNode(i, false);
			}
		}
		
		Set<Node> groupA = bip.getGroup(true);
		Set<Node> groupB = bip.getGroup(false);
		
		//Makes connections from one part to other
		//TODO: MAKE CONNECTIONS! :)
		for(Node node : groupA){
			
		}
		
		return bip;
	}
	
}
