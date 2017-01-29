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

import java.util.Stack;

/**
 * James Hiegel CMSC 350 UMUC Spring 2017 Project 1
 */
public class InfixEvaluator {
//Instance variables

   private String expression;
   private Stack<Integer> operandStack = new Stack<Integer>();
   private Stack<Character> operatorStack = new Stack<Character>();
   private int result;

//Constructor(s)
   InfixEvaluator(String expression) {
      this.expression = expression;
   }

   public int evaluate() {
      for (char ch : expression.toCharArray()) {
         if (ch >= '0' && ch <= '9') {//push number
            operandStack.push(Integer.parseInt(String.valueOf(ch)));
         } else if (ch == '(') {//push left parenthesis
            operatorStack.push(ch);
         } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            if (operatorStack.isEmpty()) {
               operatorStack.push(ch);//push to operator stack if empty
            } else if (orderOfOperations(ch) > orderOfOperations(operatorStack.peek())) {
               operatorStack.push(ch);//push to operator stack if higher precedence
            } else {
               //process operator with lower precedence
               while (!operatorStack.isEmpty() && orderOfOperations(ch)
                       <= orderOfOperations(operatorStack.peek())) {
                  result = calculate(Integer.parseInt(String.valueOf(operandStack.pop())),
                          Integer.parseInt(String.valueOf(operandStack.pop())),
                          operatorStack.pop());
                  operandStack.push(result);//put the result back on the stack
               }
               operatorStack.push(ch);
            }
         } else if (ch == ')') {
            while (operatorStack.peek() != '(') {
               result = calculate(Integer.parseInt(String.valueOf(operandStack.pop())),
                       Integer.parseInt(String.valueOf(operandStack.pop())),
                       operatorStack.pop());
               operandStack.push(result);
            }
            operatorStack.pop();
         }
      }
      while(!operatorStack.isEmpty()){
         result = calculate(Integer.parseInt(String.valueOf(operandStack.pop())),
                       Integer.parseInt(String.valueOf(operandStack.pop())),
                       operatorStack.pop());
               operandStack.push(result);
      }
      result = operandStack.peek();
      return result;
   }

   private int orderOfOperations(char ch) {
      switch (ch) {
         case '(':
            return 0;
         case ')':
            return 0;
         case '+':
            return 1;
         case '-':
            return 1;
         case '*':
            return 2;
         case '/':
            return 2;
         case '=':
            return 3;
      }
      return -1;
   }

   private int calculate(int x, int y, char op) {
      int output = 0;
      switch (op) {
         case '+':
            output = x + y;
            break;
         case '-':
            output = y - x;
            break;
         case '*':
            output = x * y;
            break;
         case '/':
            if (x == 0) throw new ArithmeticException();
            output = y / x;
            break;
      }
      return output;
   }
}