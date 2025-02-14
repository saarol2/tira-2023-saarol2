package oy.interact.tira.student;

import java.util.Comparator;

public class Algorithms {

   private Algorithms() {
      // nada
   }

   ///////////////////////////////////////////
   // Insertion Sort for the whole array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array) {
      insertionSort(array, 0, array.length);
      }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      for (int i = fromIndex + 1; i < toIndex; i++){
         T key = array[i];
         int j = i -1;
         while (j >= fromIndex && key.compareTo(array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = key;
      }
   }

   //////////////////////////////////////////////////////////
   // Insertion Sort for the whole array using a Comparator
   //////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      for (int i = fromIndex + 1; i < toIndex; i++){
         T key = array[i];
         int j = i -1;
         while (j >= fromIndex && comparator.compare(key, array[j]) < 0) {
            array[j + 1] = array[j];
            j--;
         }
         array[j+1] = key;
      }
   }

   ///////////////////////////////////////////
   // Reversing an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array) {
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      int left = fromIndex;
      int right = toIndex - 1;
      while (left < right){
         T temp = array[left];
         array[left] = array[right];
         array[right] = temp;
         left++;
         right--;
      }
   }




   ///////////////////////////////////////////
   // Binary search bw indices
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex) {
      while (fromIndex < toIndex){
         int midIndex = fromIndex + (toIndex - fromIndex) / 2;
         T value = fromArray[midIndex];
         int compare = aValue.compareTo(value);
         if (compare == 0){
            return midIndex;
         }
         else if (compare < 0){
            toIndex = midIndex;
         }
         else {
            fromIndex = midIndex +1;
         }
      }
   return -1;
   }

   ///////////////////////////////////////////
   // Binary search using a Comparator
   ///////////////////////////////////////////

   public static <T> int binarySearch(T aValue, T[] fromArray, int fromIndex, int toIndex, Comparator<T> comparator) {
      while (fromIndex < toIndex){
         int midIndex = fromIndex + (toIndex - fromIndex) / 2;
         T value = fromArray[midIndex];
         int compare = comparator.compare(aValue, value);
         if (compare == 0){
            return midIndex;
         }
         else if (compare < 0){
            toIndex = midIndex;
         }
         else {
            fromIndex = midIndex +1;
         }
      }
   return -1;
   }

   
   public static <E extends Comparable<E>> void fastSort(E [] array) {
      fastSort(array, 0, array.length - 1, Comparator.naturalOrder());
   }   

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      fastSort(array, 0, array.length - 1, comparator);
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      //Toteutettu Hoaren quicksort algoritmillä
      if (fromIndex < toIndex){
         int partitionIndex = partition(array, fromIndex, toIndex, comparator);
         fastSort(array, fromIndex, partitionIndex, comparator);
         fastSort(array, partitionIndex + 1, toIndex, comparator);
      }
   }

   private static <E> int partition(E[] array, int fromIndex, int toIndex, Comparator<E> comparator){
      E pivot = array[(toIndex - fromIndex) / 2 + fromIndex];
      int low = fromIndex - 1;
      int high = toIndex + 1;
      while (true){
         do{
            low++;
         }
         while (comparator.compare(array[low], pivot) < 0);
         do{
            high--;
         }
         while (comparator.compare(array[high], pivot) > 0);
         if (low >= high){
            return high;
         }
         swap(array, low, high);
      }
   }

   private static <E> void swap(E[] array, int i, int j){
      E temp = array[i];
      array[i] = array[j];
      array[j] = temp;
   }

}
