package collections;

import java.util.HashMap;
import java.util.Map;

public class MapOperationCheck {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("key1", "Hi, ");
		map.put("key1", "Hello chalam.");
		System.out.println(map.entrySet().toString());

	}
}
