package FindDuplicates;

import java.util.HashMap;
import java.util.Map;

public class DuplicateCharCount {
	public static void main(String[] args) {
		String data = "a,b,c,d,a,f,b,d";
		String[] dataArray = data.split(",");
		Map<String, Integer> map = new HashMap<>();
		for(int i=0;i<dataArray.length;i++){
			if(map.containsKey(dataArray[i])){
				map.put(dataArray[i], map.get(dataArray[i])+1);
			}else{
				map.put(dataArray[i], 1);
			}
		}
		System.out.println(map);
	}
}
