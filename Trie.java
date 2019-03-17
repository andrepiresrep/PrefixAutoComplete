import java.util.ArrayList;
import java.util.Collections;
public class Trie{
	private final Node root;
	public Trie() {
		root = new Node('/');
	}
	/**
	 * @return The root node of the Trie structure. By convention, we opted to choose / as the root character.
	 */
	public Node getRoot() {
		return root;
	}
	/**
	 * @param parent The parent node of the node we want to create.
	 * @param ch Character to insert in the node.
	 * @return The created node.
	 */
	public Node leftNode(Node parent,char ch) {
		Node novo = new Node(ch);
		parent.left = novo;
		novo.p = parent;
		return novo;
	}
	/**
	 * @param brother The brother node of node we want to create.
	 * @param ch Character to insert in the node.
	 * @return The created node.
	 */
	public Node rightNode(Node brother,char ch) {
		Node novo = new Node(ch);
		brother.right = novo;
		novo.p = brother.p;
		return novo;
	}
	/**
	 * The class of the nodes that represent the Trie structure.
	 * The left,right,p attributes represent the left child of the node, the right brother of the node and finally the parent of the node.
	 * The end attribute represents if a node is the ending of a word.
	 * The ch attribute represents the character to insert in the node.
	 */
	private class Node{
		char ch;
		Node left,right,p;
		int frequency;
		boolean end;
		/**
		 * @param ch Character to insert in the node.
		 */
		public Node(char ch) {
			this.ch = ch;
			left = null;
			right = null;
			p = null;
			end = false;
			frequency = -1;
		}
	}
	
	/**
	 * @param f The frequency number of the word to insert in the Trie.
	 * @param word The string of the word to insert in the Trie.
	 */
	public void insert(int f, String word) {
		Node current = root;
		int var = 0;
		int length = word.length();
		for(int i = 0; i < length; i++) {
			if(current.left == null) {
				Node novo = leftNode(current,word.charAt(i));
				current = novo;
			}
			else {
					if(current.left.ch == word.charAt(i)) {
						current = current.left;
						var = 1;
					}
					else {
						current = current.left;
						var = 0;
						while(current.right != null) {
							if(current.right.ch == word.charAt(i)) {
								current = current.right;
								var = 1;
								break;
							}
							current = current.right;
							var = 0;
						}
						if(var == 0) {
							 Node novo = rightNode(current,word.charAt(i));
						 	current = novo;
						 }
					}
				 }
		}
		current.end = true;
		current.frequency = f;
	}
	
	/**
	 * @param result The ArrayList which has the words from a certain prefix.
	 */
	public void print(ArrayList<Palavra> result) {
		if(result == null) {
			System.out.print("");
		}
		else {
			int end = result.size();
			for(int i = 0; i <end; i++) {
				System.out.println(result.get(i).getWord());
			}
		}
	}
	/**
	 * @param prefix The prefix of the words we want to search for in the Trie.
	 * @return The ArrayList with those words.
	 */
	public ArrayList<Palavra> search(String prefix){
		Node start = root;
		int flag = 0;
		int length = prefix.length();
		for(int i = 0; i< length; i++) {
			if(start.left != null) {
				if(start.left.ch == prefix.charAt(i)) {
					flag = 1;
					start = start.left;
				}
				else {
					start = start.left;
					flag = 0;
					while(start.right != null) {
						if(start.right.ch == prefix.charAt(i)) {
							start = start.right;
							flag = 1;
							break;
						}
						start = start.right;
					}
					if(flag == 0) {
						break;
					}
				}
			}
			else {
				flag = 0;
				break;
			}
		}
		if(flag == 1) {
			Heap<Palavra> heap = new Heap<Palavra>();
			Words(start,prefix,heap);
			Collections.sort(heap.getArrayList());
			return heap.getArrayList();
		}
		return null;
	}
	
	/**
	 * @param n Node
	 * @param w String of the word.
	 * @param heap Data structure to efficiently store the words in.
	 */
	private void checkInsert(Node n, String w,Heap<Palavra> heap) {
		if(n.end == true) {
			int size = heap.size();
			if(size == 10 && n.frequency > heap.peek().getFrequency()) {
				heap.getArrayList().set(0, new Palavra(n.frequency,w));
				heap.downHeap(0);
			}
			if(size < 10) {
				heap.offer(new Palavra(n.frequency,w));
			}	
		}
}
	
	/**
	 * @param start The node of the last character from a prefix.
	 * @param prefix The prefix of the words we want to search for in the Trie.
	 * @param heap Data structure to efficiently store the words in.
	 */
	private void Words(Node start, String prefix,Heap<Palavra> heap)
	{
		checkInsert(start,prefix,heap);
		Node temp = start;
		boolean stop = false;
		Node last = null;
		StringBuilder sb = new StringBuilder(prefix);
		while (stop == false) {
			if(temp.left != null && temp.left != last) {
				last = temp;
				sb.append(temp.left.ch);
				checkInsert(temp.left,sb.toString(),heap);
				temp = temp.left;
			}
			else if(temp == start) {
				stop = true;
			}
			else if(temp.right != null) {
				last = temp;
				sb.setCharAt(sb.length()-1, temp.right.ch);
				checkInsert(temp.right,sb.toString(),heap);
				temp = temp.right;
			}
			else {
				temp = temp.p;
				if(temp.right != null) {
					if(temp.right == start.right) {
						stop = true;
					}
					else {
						sb.deleteCharAt(sb.length()-1);
						sb.setCharAt(sb.length()-1, temp.right.ch);
						checkInsert(temp.right,sb.toString(),heap);
						temp = temp.right;
					}
				}
				else {
					last = temp.left;
					sb.deleteCharAt(sb.length()-1);
				}
			}
	    }
	}
}