/**
 * Lab Programming Assignment #3
 * @author Samuel Garcia, Jessica Banuelos, Alex Chheng
 * @date 10/15/2020
 */
public class BuildMaxHeap
{
    public static void main(String[] args)
    {
        int[] array = new int[args.length];
        for (int i = 0; i < args.length; i++)
        {
            array[i] = Integer.parseInt(args[i]);
        }
        
        System.out.println("Max Heap Array:");
        buildMaxHeap(array);
        printArray(array);
        System.out.println("\n\nHeight: " + (int)(Math.log(array.length) / Math.log(2)));
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
