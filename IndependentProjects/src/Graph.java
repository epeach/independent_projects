import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
	/**
	 * <b>Graph</b> represents a graph which can store String nodes and
	 *	the String edges between them. Does not contain duplicates of nodes.
	*   Can add nodes and edges to the graph and query the contents of the
	*   graph as a whole or the children of individual nodes.
	*   The data type T represents the data type of the nodes in the graph.
	*   The data type E represents the data type of the edges in the graph.
	*
	*   @specfield graph = collection of nodes that store the nodes to which
	*   they are connected and the edges that connect them
	*/

	//TODO: Fix graph to make it simple (no multi-edges)
	public class Graph<T, E>{

        /*
         * Representation Invariant: graph != null and does not contain duplicate
         * nodes where the values of two nodes in the graph are never equal.
         *
         * Abstract Function: AF(r) == Graph h where h.graph contains a key
         * representing each node in r.
         * Each key maps to an Edge that maps the value of the nodes to
         * which the node of value key connects to the values of the
         * connections between the nodes.
         */

        private Map<T, Edge> graph;

        /**
         * @modifies graph
         * @effects Creates new, empty graph.
         */
        public Graph(){
            graph = new HashMap<T, Edge>();
            checkRep();
        }

        /**
         * @param value
         * @requires value != null
         * @modifies graph
         * @effects Adds a new node to graph representing the parameter 'value'. If
         * 'value' already exists in graph, no effect
         **/
        public void addNode(T value){
            if(!graph.containsKey(value)){
                    graph.put(value, new Edge());
            }
            checkRep();
        }

        /**
         * @param node1
         * @param node2
         * @param connection
         * @requires node1 != null and node2 != null.
         *                      node1 and node2 are contained in graph.
         *                      connection != null
         * @modifies graph
         * @effects adds edge from node1 to node 2 in graph. If identical edge
         * already exists, no effect.
         */
        public void addEdge(T node1, T node2, E connection){
            if(graph.get(node1) == null){
                    throw new NoSuchElementException();
            }
            if(graph.get(node2) == null){
                    throw new NoSuchElementException();
            }
            graph.get(node1).addEdge(connection, node2);
        }

        /**
         * @param target
     	* @requires target != null and target is contained in graph
     	* @return list of type T containing the children of 'target'.
     	*/
        public List<T> getChildren(T target){
            if(target == null || graph.get(target) == null){
                    throw new NoSuchElementException();
            }
            List<T> children = new ArrayList<T>();
            Edge data = graph.get(target);
            children = data.getEdgeChildren();
            //Collections.sort(children);
            return children;
        }

        /**
         * @return an alphabetically ordered list of type T containing all the
         * node values in the graph
         */
        public List<T> getNodes(){
            List<T> nodes = new ArrayList<T>();
            for(T item: graph.keySet()){
                    nodes.add(item);
            }
            return nodes;
        }

        /**
         *
         */
        //TODO
        public E getEdgeBetweenNodes(T target, T destination){
        	return null;
        }

        /**
         * @Throws RuntimeException if graph is null.
         */
        private void checkRep(){
                if(graph == null){
                        throw new RuntimeException();
                }
                //Cannot contain duplicate keys because it is a map, so guaranteed
                //that there are no duplicate nodes in the graph where duplicates
                //are defined by nodes with the same string value.
        }

        /** <b>Edge</b> represents an edge which maps the name of nodes to the
         *  strings that arrive at them from other nodes. Does not contain
         *  duplicates of nodes. Can add edges to the graph and query the
         *  nodes associated with this edge and the edges associated between
         *  the current node and a given node in the edge.
         *
         *  @specfield edges = collection of type T that maps the
         *  value of nodes to which they are connecte and the 
         *  edges that connect them
         */
        private class Edge{

           /*
            * Representation Invariant: edges != null and does not contain
            * duplicate nodes where the values of two nodes in the
            * graph are never equal.
            *
            * Abstract Function: AF(r) == Edge h where h.edges contains a key
            * representing each nodes at which an edge arrives.
            * Each key maps to a list of type T representing the edges
            * that arrive at the key node from one node in particular.
            */

        	Map<T, List<E>> edges;
        	/**
        	 * @effects Creates new, empty Edge
        	 */
        	private Edge(){
        		edges = new HashMap<T, List<E>>();
        	}

        	/**
             * add Edge of the given value that ends at the given end
             * @param value of edge to be added
             * @param end, node to where connection goes
             * @requires value != null and end != null
             * @modifies edges
             * @effects if no edges currently exist to that node, add a node end
             * and connection of value to end. If edges currently exist to
             * that node, add value to other connections.
             */
        	private void addEdge(E value, T end){
        		if(edges.containsKey(end)){
        			edges.get(end).add(value);
        		} else {
        			List<E> first = new ArrayList<E>();
        			first.add(value);
        			edges.put(end, first);
        		}
        		checkRep();
        	}

        	/**
        	 * returns list of all nodes stored in this Edge
        	 * @return list of type T of all nodes stored in this Edge
        	 */
        	private List<T> getEdgeChildren(){
        		List<T> childrenToReturn = new ArrayList<T>();
        		for(T item: edges.keySet()){
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
            	//Don't need to check that does not contain duplicate nodes
            	//since the nodes are stored as keys in the map and map keys
            	//cannot contain duplicates
            }
        }
	}
