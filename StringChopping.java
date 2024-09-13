package stringchopping;
import java.util.ArrayList;

public class StringChopping {

    /**
     * Chop the specified segment of the given string <code>s</code>
     * @param s the string to chop
     * @param segment the segment of s to chop, and is one of: 'h' or 'H' for head, 'm' or 'M' for middle, 't' or 'T' for tail
     * @return the string after removing the specified segment from s
     */
    public static String chopString(String s, char segment) {
        
        if (segment == 'H') {
            
            return s.substring((int)Math.ceil(s.length() / 3.0)); // TODO add "getThird"
            
        } else if (segment == 'T'){
            
            return s.substring(0, s.length() - (int)Math.ceil(s.length() / 3.0));
            
        } else {
            
            String headSection = s.substring(0, (int)Math.ceil(s.length() / 3.0));
            String tailSection = s.substring(s.length() - (int)Math.ceil(s.length() / 3.0));
            
            return headSection + tailSection;
        }
    }

    /**
     * Determine a chop sequence that will result in the provided string being 
     * cut down to the target character
     * @param s the string to dice
     * @param target the last character that should remain after a sequence of chop operations
     * @return a string that represents the sequence of chop operations needed to obtain exactly <code>target</code> and "no" if no such sequence exists
     */
    public static String diceStringTo(String s, char target) {

        if (s.indexOf(target) == -1){
            return "NO";
        }
        
        String sequence = "";
        
        while (s.length() > 1) {
            
            if (s.indexOf(target) >= (int)Math.ceil(s.length() / 3.0)) {
                s = chopString(s, 'H');
                sequence += "H";
            } else {
                s = chopString(s, 'T');
                sequence += "T";
            }
        }
        return sequence;
     }

    /**
     * Obtain an array that contains all dice sequences for the given string,
     * with the first element of the array representing 'a' as the target
     * and the last element of the array representing 'z' as the target
     * @param s the string to dice
     * @return an array of dicing sequences for <code>s</code> 
     * with targets from 'a' to 'z', in that order
     */
    public static String[] allPossibleDicings(String s) {
        
        ArrayList<String> letterCheck = new ArrayList<String>();
        String message = s;

        for (String alphabet = "abcdefghijklmnopqrstuvwxyz"; alphabet.length() > 0; alphabet = alphabet.substring(1)){

            letterCheck.add(diceStringTo(message, alphabet.charAt(0)));

        }
        
        return letterCheck.toArray(new String[0]); 
    }
}