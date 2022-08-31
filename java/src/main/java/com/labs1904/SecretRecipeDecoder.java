package com.labs1904;


import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SecretRecipeDecoder {
    private static Map<String, String> ENCODING = new HashMap<String, String>() {
        {
            put("y", "a");
            put("h", "b");
            put("v", "c");
            put("x", "d");
            put("k", "e");
            put("p", "f");
            put("z", "g");
            put("s", "h");
            put("a", "i");
            put("b", "j");
            put("e", "k");
            put("w", "l");
            put("u", "m");
            put("q", "n");
            put("n", "o");
            put("l", "p");
            put("m", "q");
            put("f", "r");
            put("o", "s");
            put("i", "t");
            put("g", "u");
            put("j", "v");
            put("t", "w");
            put("d", "x");
            put("r", "y");
            put("c", "z");
            put("3", "0");
            put("8", "1");
            put("4", "2");
            put("0", "3");
            put("2", "4");
            put("7", "5");
            put("5", "6");
            put("9", "7");
            put("1", "8");
            put("6", "9");
            put(" ", " ");
            put("-", "-");
            put("/", "/");
        }

    };



    /**
     * Given a string named str, use the Caesar encoding above to return the decoded string.
     * @param str
     * @return
     */
    public static String decodeString(String str) {
        // System.out.println("The encrypted word is: " + str);
        char[] chars = str.toCharArray();
        //System.out.println(chars);

        String newOne = "";
        newOne.toString();

        //    String newBoi = Character.toString(chars[0]);
        for (Map.Entry<String , String> set : ENCODING.entrySet()){
           // System.out.println(set.getKey() + " = " + set.getValue());
           // System.out.println(ENCODING);
           // System.out.println(ENCODING.get(newBoi));
        }
        String complete = "";

        for (int i =0;i<chars.length;i++){
            String preHold;
            String holder;
            preHold = Character.toString(chars[i]);
            holder = ENCODING.get(preHold);

          //  System.out.println("holder: " + holder);

            complete = complete +(holder);

            //System.out.println(complete);


        }
        str = complete;
       // System.out.println(str);

        return str;


        // TODO: implement me

    }
    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */

    public static Ingredient decodeIngredient(String line) throws IOException {
        // TODO: implement me
        // String filePath = "/Users/vinny/Desktop/challenge/VincentCammarataChallengeThree/java/src/main/resources/secret_recipe.txt";
        String filePath = line;
        String amt = "";
        String desc = "";

        Map<String, String> bigMap = new HashMap<String, String>() {

        };
        int count = 0;
       // BufferedReader reader = new BufferedReader(new FileReader(filePath));
       // while ((line = reader.readLine()) != null)
       // {
            String[] parts = line.split("#", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];
             //   map.put(key, value);
            // bigMap.put(key, value);
                count = count + 1;
          //  }
                 amt = decodeString(key);
                 desc = decodeString(value);
                 //System.out.println(key + " " + value);
        }
        //System.out.println(amt + " "+ desc);
           // String preAmt = map[0].toString();

        Ingredient myIngredient = new Ingredient( amt, desc );

        return  myIngredient;
    }

    public static String decodeFile(String path) throws IOException {
        //might need to create a hashmap
        String line = " ";

        String filePath = path;
        //System.out.println(path);
         BufferedReader reader = new BufferedReader(new FileReader(filePath));
        //Product[] obj = new Product[5] ;
//create & initialize actual product objects using constructor
       // obj[0] = new Product(23907,"Dell Laptop");


        Map<String, String> fileMap = new HashMap<String, String>();
        int counter = 0;
         while ((line = reader.readLine()) != null)
         {
             counter++;
             String current = "";
            System.out.println(line);
               current = decodeString(line);
               System.out.println(current);
               Ingredient iG = decodeIngredient(line);
               //fileMap.put(iG);7
            //System.out.println(decodeIngredient(decodeString(line)));
         }

        return filePath;
    };


    public static void main(String[] args) throws IOException {


        //decodeString("hgiikf");
        //decodeIngredient("8 vgl#hgiikf");
        decodeFile("/Users/vinny/Desktop/challenge/VincentCammarataChallengeThree/java/src/main/resources/secret_recipe.txt");
        // TODO: implement me
    }
}
