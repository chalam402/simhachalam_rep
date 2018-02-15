import java.util.HashMap;
import java.util.Map;


public class IndividualCharactersCount {
	public static void main(String[] args) {
		String data = "gdsdgaabbabdhdfadgaabccbfadfdbabcbasfdgghfgbc";
		int counter = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0;i<data.length();i++){
			if(map.containsKey(data.charAt(i))){
				map.put(data.charAt(i), map.get(data.charAt(i))+1);
			}
			else{
				map.put(data.charAt(i), counter+1);
			}
		}
		System.out.println(map);
	}
}
