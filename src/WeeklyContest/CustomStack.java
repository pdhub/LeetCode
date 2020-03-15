package WeeklyContest;

public class CustomStack {

    int[] stack;
    int counter;
    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        counter = -1;
    }

    public void push(int x) {
        if (counter == stack.length)
            return;
        stack[++counter] = x;
    }

    public int pop() {
        if (counter < 0)
            return -1;
        return stack[counter--];
    }

    public void increment(int k, int val) {
        if (k > counter)
            k = counter;
        for (int i = 0; i < k; i++) {
              stack[i] = stack[i] + val;
        }
    }
}
