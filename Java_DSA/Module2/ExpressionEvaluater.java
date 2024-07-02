import java.util.Stack;

class ExpressionEvaluator {

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack.push(c); 
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else { 
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c); 
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(c - '0'); 
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop(); 
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0; 
        }
    }

    public static void main(String[] args) {
        String infixExpr = "3+5*(2-8)";
        System.out.println("Infix expression: " + infixExpr);

        String postfixExpr = infixToPostfix(infixExpr);
        System.out.println("Postfix expression: " + postfixExpr);

        int result = evaluatePostfix(postfixExpr);
        System.out.println("Result after evaluation: " + result);
    }
}
