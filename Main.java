import java.util.Scanner;
/**
 * In the Main class we create an object of type Trie which will hold all of the words with their respective frequency number and string.
 * The first integer received represents the number of words to insert. After inserting all of them we receive another integer which represents the number of prefixes to search
 * for. The output is a list of words that start with the selected prefix or a blank line if no words match that prefix.
 * @author Andre Pires
 * @see Heap
 * @see Palavra
 * @see Trie
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Trie t = new Trie();
		for(int i = 0; i <size; i++) {
			t.insert(sc.nextInt(), sc.next());
		}
		size = sc.nextInt();
		String[] search = new String[size];
		for(int i = 0; i<size; i++) {
			search[i] = sc.next();
		}
		sc.close();
		for(int i = 0; i<size; i++) {
			t.print(t.search(search[i]));
		}
	}
}

