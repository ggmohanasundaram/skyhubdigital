package org.skyhubdigital.com.patterns;

import org.skyhubdigital.com.patterns.exceptions.WrongInputException;

import java.io.File;
import java.util.*;

/**
 * Created by MohanDivya on 8/30/2016.
 */
public class SyntaxScanner {

    private static final Map<String, String> patternsMap = new HashMap<String, String>();

    /**
     * All the valid pairs of open and closing brackets are configured in a property file.
     * User can Add new pairs if they need. No code changes required for newly added pairs
     *
     * This static block reads the property file and load the pairs of brackets in a HashMap.
     * Here Open Brackets are used as Key and Closed Brackets are used as value
     **/
    static {
        ClassLoader classLoader = SyntaxScanner.class.getClassLoader();
        File file = new File(classLoader.getResource("patterns/patternConfigurationFile.txt").getFile());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){

                String line = scanner.nextLine();
                if(line!=null){
                    String[] split = line.split("=");
                    patternsMap.put(split[0],split[1]);

                }

            }
        } catch (Exception e) {
            System.out.println("Configuration File is Not Found");
            e.printStackTrace();
        }

    }

    /**
     *
     * @param inputString
     * @return boolean
     * @throws Exception
     *  isBalancedString method parse the input string and add the open brackets into a Deque if it is configured in
     *  Property file.
     *
     *  For each Open brackets this code finds corresponding closed brackets is available and remove the elements from
     *  Deque
     *
     *  After processing all the input elements the Deque should be empty if it has proper balanced brackets and it return true
     *  else it return false.*
     *
     **/

    public static boolean isBalancedString(String inputString) throws Exception {

       if(inputString!=null){

             char[] inputArray = inputString.toCharArray();
             Deque<Character> patternStack = new ArrayDeque<Character>();

           for (char input : inputArray) {

               String stringInput = String.valueOf(input);
               if (patternsMap.containsKey(stringInput)) {
                   patternStack.add(input);
               } else if (!patternStack.isEmpty()) {

                   String closedBracket = patternsMap.get(String.valueOf(patternStack.getLast()));
                   if (closedBracket != null && closedBracket.equals(stringInput)) {
                       patternStack.removeLast();
                  }
              }
           }
           if(patternStack.isEmpty()) {
               return true;
           }
           else{
               return false;
           }
       }
       else {
           throw new WrongInputException("Input is Null");
       }
    }

}
