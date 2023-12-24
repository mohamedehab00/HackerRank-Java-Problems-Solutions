import java.io.*;
import java.util.*;

class MyQueue{
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    int flag;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        flag = 1;
    }

    public void enqueue(Integer integer){
        stack1.push(integer);
    }
    public Integer dequeue(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
    public Integer peek(){
        if (!stack2.isEmpty()){
            return stack2.peek();
        }
        else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyQueue queue = new MyQueue();

        int t = scanner.nextInt();

        while (t-- > 0){
            int type = scanner.nextInt();
            switch (type){
                case 1:
                    int num = scanner.nextInt();
                    queue.enqueue(num);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println(queue.peek());
                    break;
                default:
                    break;
            }
        }
    }
}