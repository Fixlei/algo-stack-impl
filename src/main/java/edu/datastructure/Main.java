package edu.dataStStack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class StackRunner {
  /**
   * Valid parentheses.
   *
   * @param str string.
   * @return true, stack is empty.
   */
  public static boolean isValidParentheses(String str) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char cr : str.toCharArray()) {
      if (cr == '(') {
        stack.push(')');
      } else if (cr == '{') {
        stack.push('}');
      } else if (cr == '[') {
        stack.push(']');
      } else {
        if (stack.isEmpty() || stack.pop() != cr) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static int[] dailyTemperatures(int[] temp) {

    int n = temp.length;
    int[] result = new int[n];
    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
        int idx = stack.pop();
        result[idx] = i - idx;
      }
      stack.push(i);
    }
    return result;
  }

  public static class Minstack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public  Minstack() {
      stack = new ArrayDeque<>();
      minStack  = new ArrayDeque<>();
    }

    public void push(int val) {
      stack.push(val);

      int curMin = minStack.isEmpty()?val:Math.min(val, minStack.peek());
      minStack.push(curMin);
    }
    public int pop(){
      minStack.pop();
      return stack.pop();
    }

    public int top(){
      return  stack.peek();
    }
    public int getMin(){
      return  minStack.peek();
    }


  }

  public static void main(String[] args) {

    System.out.println("=============================");
    System.out.println("||     Stack - Problems     ||");
    System.out.println("=============================");


    System.out.println( "--  #1 --");
    System.out.println("\"({[]})\"-->" + isValidParentheses("({[]})"));
    System.out.println("\"({[{}]})\"-->" + isValidParentheses("({[{}]})"));
    System.out.println("\"({[{[}]})\"-->" + isValidParentheses("({[{[}]})"));
    System.out.println("");

    System.out.println( "--  #2 --");
    int[] temps = {73, 74, 75,69, 72, 76, 73};
    System.out.println(" Input:" + Arrays.toString(temps));
    System.out.println(" Output:" + Arrays.toString(dailyTemperatures(temps)));
    System.out.println("");

    System.out.println("----#3 getMin Stack O(1) -- 6,3,4,1,8");
    Minstack minstack = new Minstack();
    minstack.push(6);
    minstack.push(3);
    minstack.push(7);
    minstack.push(1);
    System.out.println("push 6, 3,7, 1to stack.\"\nGet Min: " + minstack.getMin()); //1
    minstack.pop();
    System.out.println("after 1 popped, Get Min: " + minstack.getMin()); //3
    minstack.pop();
    System.out.println("after 3 popped, Get Min: " + minstack.getMin()); //4
    minstack.pop();
    System.out.println("after 4 popped, Get Min: " + minstack.getMin()); //6

  }
}












