/**
 * Lab Programming Assignment #2
 * @author Samuel Garcia, Zixi Liu, Alex Chheng
 * @date 9/27/2020
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
public class Search
{
    public static void main(String[] args)
    {
        // Reads in a file.
        Scanner read = null;
        ArrayList<String> list = new ArrayList<>();
        try
        {
            read = new Scanner(new File(args[0]));
            while(read.hasNextLine())
            {
                list.add(read.nextLine());
            }
            read.close();
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println("File was not found.");
        }
        
        String searchWord = args[1];
        String foundWord = "";
        String sortedSearchWord = sortWord(searchWord);
        String sortedFoundWord = "";
        int foundWordIndex = 0;
        // Linear Search
        for (int i = 0; i < list.size(); i++)
        {
            sortedFoundWord = sortWord(list.get(i));
            if (sortedFoundWord.compareTo(sortedSearchWord) == 0)
            {
                foundWord = list.get(i);
                foundWordIndex = i + 1; // Line index starts at 1
                break;
            }
        }
        if (foundWordIndex == 0)
        {
            System.out.println("String not found");
        }
        else
        {
            System.out.print("Found search string: " + foundWord + "\n");
            System.out.print("Line Number: " + foundWordIndex + "\n");
        }
    }
    public static String sortWord(String word)
    {
        word = word.toLowerCase();
        char temp[] = word.toCharArray();
        Arrays.sort(temp);
        
        return new String(temp);
    }
}
