/**
 * Lab Programming Assignment #1
 * @author Zixi Liu, Alex Chheng, Samuel Garcia
 * @date 9/15/2020
 */
import java.util.Scanner;

public class ModifiedInsertionSort
{
    public static void main(String[] args) 
    {
        InsertionSortImperative(args);
    }
    
    public static boolean CharKeyCompare(String[] arr, int j, String key)
    {
        int keyLength; //Used for to compare the shortest word
        String aString = arr[j];
        keyLength = Math.min(aString.length(), key.length()); //need to take in the least length
    
        for (int index = 0; index < keyLength - 1; index++) 
        {
            char aChar = aString.charAt(index);
            char bChar = key.charAt(index);
    
            if (aChar > bChar)
            { //This is when the right is less than the left
                return true;
            }
            else if (aChar < bChar)
            {
                return false;
            }
            // keyLength - 2 because if (key = boat, aString = boatcz) 
            else if (index == keyLength - 2 && aString.length() > key.length())
            { //This tells us that it match but the right is less than the left
                return true;
            }
        }
        return false;
    }
    
    public static void InsertionSortImperative(String[] originalArray)
    {
        String sortedArray[] = originalArray.clone();
        String tempArray[] = originalArray.clone();
        int[] counter = new int[originalArray.length];
        
        // Initializes counter array
        for(int i = 0; i < originalArray.length; i++)
        {
            counter[i] = 0;
        }
        
        // For loop used for sorting the array of words
        for (int i = 1; i < sortedArray.length; i++)
        {
            String key = sortedArray[i];
            int j = i - 1;
            
            boolean flag = false;
            
            while (j >= 0 && CharKeyCompare(sortedArray, j, key) == true) 
            {
                //System.out.println(CharKeyCompare(arr, j, key));
                // apple test going zebra aardvark
                // Since the comparison of apple and test returns false it breaks out.
                
                sortedArray[j + 1] = sortedArray[j];
                j = j - 1;
                counter[i]++;
    
            }
    
            sortedArray[j + 1] = key;
        }
        
        // For loop used for counting comparisions
        for (int i = 1; i < tempArray.length; i++)
        {
            String key = tempArray[i];
            int j = i - 1;
    
            while (j >= 0 && CharKeyCompare(tempArray, j, key) == false)
            {
                
                tempArray[j + 1] = tempArray[j];
                j = j - 1;
                counter[i]++;
                break;
            }
    
            tempArray[j + 1] = key;
        }
        
        PrintArray(sortedArray); 
        System.out.println();
        
        // For loops prints original order of words in original array with their comparison counter values
        for(int i = 1; i < originalArray.length; i++)
        {
            System.out.println(originalArray[i] + " " + counter[i]);
        }
    }
    
    public static void PrintArray(String[] arr)
    {
        for (String s : arr) 
        {
            System.out.print(s + " ");
        }
    }
}