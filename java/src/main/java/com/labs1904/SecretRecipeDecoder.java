package com.labs1904;


import java.util.HashMap;
import java.util.Map;

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
        System.out.println(chars);

        String newOne = "";
        newOne.toString();

        //    String newBoi = Character.toString(chars[0]);
        for (Map.Entry<String , String> set : ENCODING.entrySet()){
           // System.out.println(set.getKey() + " = " + set.getValue());
           // System.out.println(ENCODING.get("z"));
           // System.out.println(ENCODING.get(newBoi));


        }
        String complete = "";

        for (int i =0;i<chars.length;i++){
            String preHold;
            String holder;
            preHold = Character.toString(chars[i]);
            holder = ENCODING.get(preHold);

          //  System.out.println("holder: " + holder);

            complete = complete.concat(holder);

            //System.out.println(complete);


        }
        str = complete;
        System.out.println(str);

        return str;


        // TODO: implement me

    }
    /**
     * Given an ingredient, decode the amount and description, and return a new Ingredient
     * @param line
     * @return
     */
    public static Ingredient decodeIngredient(String line) {
        // TODO: implement me



        return new Ingredient("1 cup", "butter");
    }

    public static void main(String[] args) {

        decodeString("hgiikf");

        // TODO: implement me
    }
}
