import static org.junit.Assert.*;

import org.junit.Test;

public class unit_tests {
	@Test
	public void testSearch() {
		Trie t1 = new Trie();
		t1.insert(123, "abe");
		t1.insert(124, "abd");
		t1.insert(125, "acg");
		t1.insert(126, "ach");
		t1.insert(127, "abef");
		t1.insert(128, "acgl");
		t1.insert(129, "aed");
		t1.insert(130, "ab");
		t1.insert(131, "b");
		assertEquals(t1.search("a").toString(),"[ab, aed, acgl, abef, ach, acg, abd, abe]");
		
		Trie t2 = new Trie();
		t2.insert(123, "ab");
		assertEquals(t2.search("a").toString(),"[ab]");
		
		Trie t3 = new Trie();
		t3.insert(123, "ab");
		t3.insert(124, "c");
		assertEquals(t3.search("d"),null);
		
		Trie t4 = new Trie();
		t4.insert(27514, "escola");
		t4.insert(22067, "escolas");
		t4.insert(18044, "escolha");
		t4.insert(7229, "escolher");
		t4.insert(6866, "escolhido");
		t4.insert(6184, "escolar");
		t4.insert(4008, "escolheu");
		t4.insert(3002, "esconde");
		t4.insert(2974, "escolhidos");
		t4.insert(2874, "esconder");
		t4.insert(2762, "escolhida");
		t4.insert(2542, "escolares");
		t4.insert(2287, "escolhas");
		t4.insert(1921, "escolaridade");
		assertEquals(t4.search("escol").toString(),"[escola, escolas, escolha, escolher, escolhido, escolar, escolheu, escolhidos, escolhida, escolares]");
		
		Trie t5 = new Trie();
		t5.insert(2260, "Infelizmente");
		t5.insert(2268, "Inter");
		t5.insert(2416, "International");
		t5.insert(2454, "Investimento");
		t5.insert(2510, "Inspeccao-Geral");
		t5.insert(3099, "Investimentos");
		t5.insert(3388, "Infante");
		t5.insert(3879, "Informacao");
		t5.insert(3922, "Investigacao");
		t5.insert(4053, "Independente");
		t5.insert(4505, "Industrial");
		t5.insert(5476, "Interna");
		t5.insert(5669, "Inverno");
		t5.insert(6036, "Interior");
		t5.insert(7297, "Industria");
		t5.insert(8339, "Internet");
		t5.insert(11201, "Indonesia");
		t5.insert(14421, "Inglaterra");
		t5.insert(23428, "Internacional");
		t5.insert(34837, "Instituto");
		assertEquals(t5.search("Inv").toString(),"[Inverno, Investigacao, Investimentos, Investimento]");
		assertEquals(t5.search("Inves").toString(),"[Investigacao, Investimentos, Investimento]");
	}
	
	@Test
	public void testOffer() {
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.offer(new Palavra(5,"maria"));
		pq.offer(new Palavra(4,"jaime"));
		pq.offer(new Palavra(6,"carlos"));
		pq.offer(new Palavra(7,"fernando"));
		assertEquals(pq.toString(),"[jaime, maria, carlos, fernando]");
	}
	
	@Test
	public void testPeek() {
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.offer(new Palavra(5,"maria"));
		pq.offer(new Palavra(4,"jaime"));
		pq.offer(new Palavra(6,"carlos"));
		pq.offer(new Palavra(7,"fernando"));
		assertEquals(pq.peek().toString(),"jaime");
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.offer(new Palavra(3,"maria"));
		pq2.offer(new Palavra(4,"jaime"));
		pq2.offer(new Palavra(10,"carlos"));
		pq2.offer(new Palavra(1,"fernando"));
		assertEquals(pq2.peek().toString(),"fernando");	
	}
	
	@Test
	public void testPoll() {
        Heap<Palavra> pq = new Heap<Palavra>();
		pq.offer(new Palavra(10,"maria"));
		pq.offer(new Palavra(9,"jaime"));
		pq.offer(new Palavra(8,"diego"));
		pq.offer(new Palavra(7,"paulo"));
		assertEquals(pq.poll().toString(),"paulo");
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.offer(new Palavra(3,"maria"));
		pq2.offer(new Palavra(4,"jaime"));
		pq2.offer(new Palavra(10,"carlos"));
		pq2.offer(new Palavra(1,"fernando"));
		assertEquals(pq2.poll().toString(),"fernando");
	}
	@Test
	public void testSize() {
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.offer(new Palavra(5,"maria"));
		pq.offer(new Palavra(4,"jaime"));
		pq.offer(new Palavra(6,"carlos"));
		pq.offer(new Palavra(7,"fernando"));
		assertEquals(4,pq.size());
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.offer(new Palavra(5,"maria"));
		assertEquals(1,pq2.size());
	}
	
	@Test
	public void testDownHeap(){
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.getArrayList().add(0,new Palavra(3,"fernando"));
		pq.getArrayList().add(1,new Palavra(10,"maria"));
		pq.getArrayList().add(2,new Palavra(9,"carlos"));
		pq.getArrayList().add(3,new Palavra(8,"jaime"));
		pq.getArrayList().add(4,new Palavra(7,"jose"));
		pq.downHeap(0);
		assertEquals(pq.toString(),"[fernando, maria, carlos, jaime, jose]");
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.getArrayList().add(0,new Palavra(3,"fernando"));
		pq2.getArrayList().add(1,new Palavra(10,"maria"));
		pq2.getArrayList().add(2,new Palavra(9,"carlos"));
		pq2.getArrayList().add(3,new Palavra(8,"jaime"));
		pq2.downHeap(0);
		assertEquals(pq2.toString(),"[fernando, maria, carlos, jaime]");
	}
	
	@Test
	public void testUpHeap() {
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.getArrayList().add(0,new Palavra(9,"fernando"));
		pq.getArrayList().add(1,new Palavra(8,"maria"));
		pq.getArrayList().add(2,new Palavra(7,"carlos"));
		pq.getArrayList().add(3,new Palavra(5,"jaime"));
		pq.getArrayList().add(4,new Palavra(10,"jose"));
		pq.upHeap(4);
		assertEquals(pq.toString(),"[fernando, maria, carlos, jaime, jose]");
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.getArrayList().add(0,new Palavra(9,"fernando"));
		pq2.getArrayList().add(1,new Palavra(8,"maria"));
		pq2.getArrayList().add(2,new Palavra(7,"carlos"));
		pq2.getArrayList().add(3,new Palavra(10,"jose"));
		pq2.upHeap(3);
		assertEquals(pq2.toString(),"[fernando, maria, carlos, jose]");
	}
	
	@Test
	public void testParent() {
		Heap<Palavra> pq = new Heap<Palavra>();
		assertEquals(pq.parent(10),4);
		assertEquals(pq.parent(12),5);
		assertEquals(pq.parent(3),1);
	}
	
	@Test
	public void testDelete() {
		Heap<Palavra> pq = new Heap<Palavra>();
		pq.getArrayList().add(0,new Palavra(10,"diego"));
		pq.getArrayList().add(1,new Palavra(9,"luis"));
		pq.getArrayList().add(2,new Palavra(8,"tiago"));
		pq.getArrayList().add(3,new Palavra(7,"carlos"));
		pq.delete();
		assertEquals(pq.toString(),"[carlos, luis, tiago]");
		
		Heap<Palavra> pq2 = new Heap<Palavra>();
		pq2.getArrayList().add(0,new Palavra(10,"diego"));
		pq2.getArrayList().add(1,new Palavra(9,"luis"));
		pq2.getArrayList().add(2,new Palavra(8,"tiago"));
		pq2.getArrayList().add(3,new Palavra(7,"carlos"));
		pq2.getArrayList().add(3,new Palavra(6,"paulo"));
		pq2.delete();
		assertEquals(pq2.toString(),"[carlos, luis, tiago, paulo]");		
	}
}