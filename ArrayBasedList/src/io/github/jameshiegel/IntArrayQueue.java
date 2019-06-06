/** This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <http://www.gnu.org/licenses/>.
 */
package io.github.jameshiegel;

import static java.lang.Math.max;
import java.util.NoSuchElementException;

/**
 * James Hiegel
 */
public class IntArrayQueue {

//Instance variables
   private final static int DEFAULT_SIZE = 5;
   private int next; //next element in the array to be removed
   private int total; //total number of elements in the array
   private int[] array; //an array of integers

//Constructor(s)
   public IntArrayQueue() {
      this(DEFAULT_SIZE);
   }

   public IntArrayQueue(int size) {
      array = new int[size];
   }

//Setters
   public void add(int e) {
      if (total + 1 > array.length) resize();
      array[(next + total) % array.length] = e;
      total++;
   }

   public int remove() {
      if (total == 0) {
         throw new NoSuchElementException();
      }
      int e = array[next];
      array[next] = 0;
      next = (next + 1) % array.length;
      total--;
      return e;
   }
   
   public void resize() {
      int temp[] = new int[max(1, total * 2)];
      System.arraycopy(array, 0, temp, 0, total);
      array = temp;
   }
   
//Getters
   public int get(int e) {
      return array[e];
   }

   public int next() {
      return next;
   }

   public int size() {
      return total;
   }
   
   public String toString() {
      String output = "|";
      for (int i = 0; i < array.length; i++) {
         output += array[i] + "|";
      }
      return output;
   }
}
