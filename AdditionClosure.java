package additionClosure;

import java.util.List;

public class AdditionClosure {

	public static boolean isClosed(List<Integer> intList, Integer n) {
		
		int works = 0;
		
		
		for (int i = 0; i < intList.size() - 1; i++){
		    
		    for (int j = i + 1; j < intList.size(); j++){
		        
		        for (int k = 0; k < intList.size(); k++){
		            
		            if ((intList.get(i) + intList.get(j)) % n == intList.get(k) % n){
		                works ++;
		            }
		        }
		        
		        if (works == 0){
		            return false;
		        }
		        works = 0;
		    }
		}
		return true;
	}
}