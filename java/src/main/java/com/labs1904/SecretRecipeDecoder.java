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

    public static Ingredient decodeIngredient(String line)  {

        String filePath = line;
        String amt = "";
        String desc = "";
        int count = 0;

        String[] parts = line.split("#", 2);
        if (parts.length >= 2)
        {
            String key = parts[0];
            String value = parts[1];

            count = count + 1;
            //key and value before decode
            amt = decodeString(key);
            desc = decodeString(value);
        }

        Ingredient myIngredient = new Ingredient( amt, desc );
        return  myIngredient;
    }

    public static String decodeFile(String fileLine) throws IOException{
        int count = 0;
        String theLine = "";
        String bigLine = "";
        String holderLine = "";
        BufferedReader reader = new BufferedReader(new FileReader(fileLine));
        while ((fileLine = reader.readLine()) != null)
        {
            String[] parts = fileLine.split("#", 2);
            if (parts.length >= 2)
            {
                String key = parts[0];
                String value = parts[1];

                count = count + 1;
                theLine = key + " " + value;
                theLine = decodeString(theLine);
                holderLine = theLine + " \n";
                bigLine =  bigLine.concat(holderLine);
            }
        }
        reader.close();
        return bigLine;
    }


    public static String decodeString(String str) {
        char[] chars = str.toCharArray();
        String newOne = "";
        newOne.toString();
        String complete = "";

        for (int i =0;i<chars.length;i++){
            String preHold;
            String holder;
            preHold = Character.toString(chars[i]);
            holder = ENCODING.get(preHold);
            complete = complete +(holder);
        }
        str = complete;
        return str;
    }

    public static String fileMethod(String bigStr){
        Path path = Paths.get("./decoded_recipe.txt");
        try {
            Files.writeString(path, bigStr, StandardCharsets.UTF_8);
        }
        catch (IOException ex) {
            System.out.print("Invalid Path");
        }
        return bigStr;
    }

    public static void main(String[] args) throws IOException {

        decodeString("4 kzzo");
        decodeIngredient("8 vgl#hgiikf");
        fileMethod(decodeFile("src/main/resources/secret_recipe.txt"));

    }
}
