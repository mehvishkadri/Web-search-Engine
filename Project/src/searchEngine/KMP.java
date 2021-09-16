package searchEngine;

import java.util.ArrayList;
import java.util.Iterator;

public class KMP { 
	
	ArrayList<Integer> KMPSearch(String pat, String txt){ 
		ArrayList<Integer> offSetList = new ArrayList<Integer>();
        int M = pat.length(); 
        int N = txt.length(); 
  
        
        int lps[] = new int[M]; 
        int j = 0;  
  
        
        computeLPSArray(pat, M, lps); 
  
        int i = 0; 
        while (i < N) { 
            if (pat.charAt(j) == txt.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
                
                offSetList.add(i-j);
                j = lps[j - 1]; 
            } 
  
            
            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
                
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 
        return offSetList;
    } 
  
    void computeLPSArray(String pat, int M, int lps[]) 
    { 
        
        int len = 0; 
        int i = 1; 
        lps[0] = 0; 
        while (i < M) { 
            if (pat.charAt(i) == pat.charAt(len)) { 
                len++; 
                lps[i] = len; 
                i++; 
            } 
            else 
            { 
                 
                if (len != 0) { 
                    len = lps[len - 1]; 
  
                } 
                else 
                { 
                    lps[i] = len; 
                    i++; 
                } 
            } 
        } 
    } 
    
   
    public static void main(String args[]) {
    	ArrayList<Integer> offSetList = new ArrayList<Integer>();
        String txt = "ababcababABABDABACDABABCABABABABCABABwdsaffafasABABCABAB"; 
        String pat = "ABABCABAB"; 
        offSetList = new KMP().KMPSearch(pat, txt); 
        Iterator<Integer> itr = offSetList.iterator();
        while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
    } 
    
}
