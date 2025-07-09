import java.util.Stack;

public class Stock_span {
    public static void stockSpan(int stock[], int span[]) {
        // span=current index -top index in the stack
        // the stack)
        Stack<Integer> indexStack = new Stack<>();
        // IN stack indexStack we store index of the previousHigh
        span[0] = 1;
        indexStack.push(0);
        for (int i = 1; i < stock.length; i++) {
            int currPrice = stock[i];
            while (!indexStack.isEmpty() && currPrice >= stock[indexStack.peek()]) {
                indexStack.pop();
            }
            if (indexStack.isEmpty()) {
                span[i] = (i + 1);

            } else {
                int previousHigh = indexStack.peek();
                span[i] = i - previousHigh;

            }
            indexStack.push(i);
        }

    }

    public static void main(String[] args) {
        int stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[stock.length];
        stockSpan(stock, span);
        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }

    }

}
