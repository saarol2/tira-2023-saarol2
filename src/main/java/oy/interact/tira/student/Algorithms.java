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
      // TODO: Student, implement this.
      insertionSort(array, 0, array.length);
      }

   ///////////////////////////////////////////
   // Insertion Sort for a slice of the array
   ///////////////////////////////////////////

   public static <T extends Comparable<T>> void insertionSort(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
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
      // TODO: Student, implement this.
      insertionSort(array, 0, array.length, comparator);
   }

   ////////////////////////////////////////////////////////////
   // Insertion Sort for slice of the array using a Comparator
   ////////////////////////////////////////////////////////////

   public static <T> void insertionSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
      // TODO: Student, implement this.
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
      // TODO: Student, implement this.
      reverse(array, 0, array.length);
   }

   ///////////////////////////////////////////
   // Reversing a slice of an array
   ///////////////////////////////////////////

   public static <T> void reverse(T[] array, int fromIndex, int toIndex) {
      // TODO: Student, implement this.
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
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

   public static <E> void fastSort(E [] array, int fromIndex, int toIndex, Comparator<E> comparator) {
      // TODO: Student, implement this.
   }

}
