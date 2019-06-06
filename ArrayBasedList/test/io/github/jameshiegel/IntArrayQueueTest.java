/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jameshiegel;

import java.util.NoSuchElementException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author James
 */
public class IntArrayQueueTest {

   /**
    * Test of add method, of class IntArrayQueue.
    */
   @Test
   public void testAdd() {
      System.out.println("\nAdd");
      IntArrayQueue instance = new IntArrayQueue();
      int max = 5;
      for (int i = 1; i <= max; i++) {
         instance.add(i);
      }
      String expected = "|1|2|3|4|5|";
      System.out.println("Expected:\n" + expected);

      String output = instance.toString();
      System.out.println("Actual:\n" + output);
      assertEquals(expected, output);
   }

   /**
    * Test of remove method, of class IntArrayQueue.
    */
   @Rule
   public ExpectedException thrown = ExpectedException.none();

   @Test
   public void testRemoveThrowsException() {
      System.out.println("Remove throwing Exception");
      IntArrayQueue instance = new IntArrayQueue();
      thrown.expect(NoSuchElementException.class);
      instance.remove();
   }

   @Test
   public void testRemove() {
      System.out.println("\nRemove");
      IntArrayQueue instance = new IntArrayQueue();
      int max = 5;
      for (int i = 1; i <= max; i++) {
         instance.add(i);
      }
      String output = "Removed: " + instance.remove() + " & " + instance.remove();
      System.out.println(output);

      instance.add(6);
      instance.add(7);

      String expected = "|6|7|3|4|5|";
      System.out.println("Expected:\n" + expected);

      output = instance.toString();
      System.out.println("Actual:\n" + output);
      assertEquals(expected, output);
   }

   /**
    * Test of Resize, of class IntArrayQueue.
    */
   @Test
   public void testResize() {
      System.out.println("\nResize");
      IntArrayQueue instance = new IntArrayQueue();
      int max = 10;
      for (int i = 1; i <= max; i++) {
         instance.add(i);
      }
      String expected = "|1|2|3|4|5|6|7|8|9|10|";
      System.out.println("Expected:\n" + expected);

      String output = instance.toString();
      System.out.println("Actual:\n" + output);
      assertEquals(expected, output);
   }

   @Test
   public void testResize2() {
      System.out.println("\nRemove & Resize");
      IntArrayQueue instance = new IntArrayQueue();
      for (int i = 1; i <= 5; i++) {
         instance.add(i);
      }
      for (int i = 0; i < 2; i++) {
         instance.remove();
      }
      for (int i = 6; i <= 10; i++) {
         instance.add(i);
      }
      String expected = "|6|7|3|4|5|0|0|8|9|10|";
      System.out.println("Expected:\n" + expected);

      String output = instance.toString();
      System.out.println("Actual:\n" + output);
      assertEquals(expected, output);
   }
}
