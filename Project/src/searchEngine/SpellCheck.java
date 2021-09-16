package searchEngine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SpellCheck {
	
	//for testing
	public static void main(String[] args) {
		  String word="anglar";
		  Boolean Value = checkSpelling(word);
		
	}

	
	public static Boolean checkSpelling(String keyword){
		String directoryPath = "WebPages/testingData";
		String [] words = Helper.GetWordsFromDirectory(directoryPath);
		Set<String> uniqueWords = new HashSet<String>(Arrays.asList(words));
		int calculatedDist; 
	    int storedDistance=0;
	    boolean flag=false;
	    ArrayList<String> arr = new ArrayList<String>();
	    for(String keys: uniqueWords) {
		   calculatedDist= EditDistance.minDist(keys,keyword);
		   if(calculatedDist==0) {
			   flag=true;
			   break;
		   }else if(storedDistance==0) {
			   storedDistance = calculatedDist;
			   arr.add(keys);
		   }else if(calculatedDist<storedDistance){
			   storedDistance = calculatedDist;
			   arr.clear();
			   arr.add(keys.toLowerCase());
			   
		   }else if(calculatedDist==storedDistance){
			  if(!arr.contains(keys.toLowerCase())) {
				  arr.add(keys.toLowerCase());
			  }   
		   }
	    }
	    if(!flag) {
		   String possibleWords="";
		   if(arr.size()>0) {
			   for(int i=0;i<arr.size();i++) {
				   if(possibleWords.length()>0) {
					   possibleWords+=",";
				   }
				   possibleWords+=arr.get(i);
				   if(i==4) {
					   break;
				   }
			   }
		   }
		   System.out.println("Do you want to find " +" '" +possibleWords +"'?"); 
		   return false;
	    }else {
		   return true;
	    }
	 }
}
 
