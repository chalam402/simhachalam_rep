package ProgramaticInterviewQuestions;
import java.util.HashMap;
import java.util.Map;


public class FirstNonRepeatedCharacterInTheString {
	public static void main(String[] args) {
		Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
		String data = "ljadsfohvlrhfruv";
		for(int i=0;i<data.length();i++){
			if(hashMap.containsKey(data.charAt(i))){
				hashMap.put(data.charAt(i), hashMap.get(data.charAt(i))+1);
			}else{
				hashMap.put(data.charAt(i), 1);
			}
		}
		System.out.println(hashMap);
		// Search characterhashtable in in order of string str
        for (int i =0 ; i < data.length() ; i++ )
        { 
            if( hashMap.get(data.charAt(i))  == 1 ){
            	System.out.println("Non repeated character is : "+data.charAt(i));
            	break;
            }
             
        }
	}
}
