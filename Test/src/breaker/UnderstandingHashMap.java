package breaker;

import java.util.HashMap;
import java.util.Iterator;

public class UnderstandingHashMap {

	public static void main(String[] args) {
		UnderstandingHashMap hm = new UnderstandingHashMap();
		HashMap<Integer, Integer> demo = new HashMap<Integer, Integer>();

		hm.understandHm(demo);

	}

	private void understandHm(HashMap<Integer, Integer> demo) {
		
		demo.put(41, 4);
		demo.put(41, 3);
		Iterator it = demo.entrySet().iterator();
		System.out.println(demo);

		while(it.hasNext())
		{
		}
	}

}
