package breaker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TestHackerRank {

	public static int countDuplicate(List<Integer> numbers) {
		int countOfDuplicateElements = 0;

		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.size(); i++) {
			if (!count.containsKey(numbers.get(i))) {
				count.put(numbers.get(i), 1);
			} else if (count.containsKey(numbers.get(i))) {
				int value = count.get(numbers.get(i));
				count.remove(numbers.get(i));
				count.put(numbers.get(i), value + 1);
			}
		}
		Iterator it = count.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) it.next();
			if (pair.getValue() > 1) {
				countOfDuplicateElements++;
			}
		}
		return countOfDuplicateElements;
	}

	public static void main(String[] args) {

		TestHackerRank test1 = new TestHackerRank();
		ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 3, 1, 4, 5, 6, 3, 2));
		System.out.println(test1.countDuplicate(numbers));

	}

}
