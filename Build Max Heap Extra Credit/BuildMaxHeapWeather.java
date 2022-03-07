/**
 * Lab Programming Assignment #3 Extra Credit
 * @author Samuel Garcia, Jessica Banuelos, Alex Chheng
 * @date 10/20/2020
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public class BuildMaxHeapWeather
{
    public static void main(String[] args)
    {
        String location = args[0];
        String API_KEY = "PRIVATE";
        String units = "imperial";

        String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + API_KEY + "&units=" + units;
        try 
        {
            // Creates a URL object using the concatenated url string
            URL urlObj = new URL(urlString);
            HttpURLConnection urlCon = (HttpURLConnection) urlObj.openConnection();

            // Sets pulled info from website to a string
            BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
            String inputLine;
            StringBuffer onlineResponse = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
            {
                onlineResponse.append(inputLine);
            }
            in.close();

            // Creates a JSON object so that I can pull the temperature
            String weatherJSON = onlineResponse.toString();
            JSONObject jsonObj = new JSONObject(weatherJSON);
            int temp = (int)(Math.floor(jsonObj.getJSONObject("main").getDouble("temp")));

            int[] array = new int[temp];
            int min = 0;
            int max = 200;
            int randomInt = 0;
            for (int i = 0; i < array.length; i++)
            {
                randomInt = (int)(Math.random() * (max - min + 1) + min);
                array[i] = randomInt;
            }
            System.out.println(temp + " randomly generated integers:");
            printArray(array);

            System.out.println("\n\nMax Heap Array:");
            buildMaxHeap(array);
            printArray(array);
            System.out.println("\n\nHeight: " + (int)(Math.log(array.length) / Math.log(2)));
        } 
        catch (IOException | JSONException e)
        {
            e.printStackTrace();
        }   
    }

    public static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }

    public static void buildMaxHeap(int[] array)
    {
        int heapSize = array.length;
        for (int i = (heapSize / 2) - 1; i >= 0; i--)
        {
            maxHeapify(array, i);
        }
    }

    public static void maxHeapify(int[] array, int currentIndex)
    {
        int parentIndex; // parent index
        int leftIndex = (2 * currentIndex) + 1; // 2 * currentIndex yields an even node index value for left child
        int rightIndex = (2 * currentIndex + 1) + 1; // 2 * currentIndex + 1 yields an odd node index value for right child

        if (leftIndex <= array.length - 1 && array[leftIndex] > array[currentIndex])
        {
            parentIndex = leftIndex;
        }
        else
        {
            parentIndex = currentIndex; 
        }
        if (rightIndex <= array.length - 1 && array[rightIndex] > array[parentIndex])
        {
            parentIndex = rightIndex;
        }
        if (parentIndex != currentIndex)
        {
            int temp = array[currentIndex];
            array[currentIndex] = array[parentIndex];
            array[parentIndex] = temp;

            maxHeapify(array, parentIndex);
        }
    }
}