/**
 * This class represents the data structure which holds the words to insert in the Trie.
 * @author Andre Pires
 */
public class Palavra implements Comparable<Palavra> {
	private String word;
	private int frequency;
	/**
	 * @param f The frequency number for the word.
	 * @param w This string that represents the word.
	 */
	public Palavra(int f,String w) {
		word = w;
		frequency = f;
	}
	/**
	 * @return The string of the word.
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @return The frequency of the word.
	 */
	public int getFrequency() {
		return frequency;
	}
	/**
	 * @param f Setting the frequency of the word.
	 */
	public void setFrequency(int f) {
		frequency = f;
	}
	/**
	 * @param w Setting the string of the word.
	 */
	public void setWord(String w) {
		word = w;
	}
	/**
	 * @return An integer which defines the comparison of two objects of type Palavra.
	 */
	public int compareTo(Palavra item) {
		int result = -(this.frequency - item.frequency);
		if(result == 0) {
			result = this.word.compareTo(item.word);
		}
		return result;
	}
	/**
	 * @return A string representation of an object of type Palavra.
	 */
	public String toString() {
		return this.word;
	}
}
