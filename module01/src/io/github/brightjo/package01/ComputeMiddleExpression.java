package io.github.brightjo.package01;

public class ComputeMiddleExpression {
    static LinkedStack<Integer> aStack = new LinkedStack<>();
    static LinkedStack<Character> opStack = new LinkedStack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String exp = "(8)^(6)#";
        char[] charArr = exp.toCharArray();
        for (char c : charArr) {
            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                String n = sb.toString();
                if (!"".equals(n)) {
                    aStack.push(Integer.parseInt(n));
                }
                sb.delete(0, sb.length());
                if (!compare(c)) { // 栈顶元素优先级高于或等于当前读入操作
                    if (opStack.peek().charValue() != '(') {
                        while ((!opStack.isEmpty()) && (opStack.peek().charValue() != '(')) {
                            compute(aStack.pop(), aStack.pop());
                        }
                    }
                }
                if (c == ')') {
                    while (opStack.peek().charValue() != '(') {
                        compute(aStack.pop(), aStack.pop());
                    }
                    opStack.pop();
                }
                else opStack.push(c);
            }
        }
        System.out.println(aStack.peek());
    }

    private static void compute(Integer oprd1, Integer oprd2) {
        int res = 0;
        switch (opStack.pop()) {
            case '+': {
                res = oprd1 + oprd2;
                break;
            }
            case '-': {
                res = oprd2 - oprd1;
                break;
            }
            case '*': {
                res = oprd1 * oprd2;
                break;
            }
            case '/': {
                res = (int) ((double) oprd2 / (double) oprd1);
                break;
            }
            case '%': {
                res = oprd2 % oprd1;
                break;
            }
            case '^': {
                res = (int) Math.pow(oprd2, oprd1);
                break;
            }
        }
        aStack.push(res);
    }

    private static boolean compare(char c) {
        if (opStack.isEmpty()) {
            return true;
        }
        return getLevel(c) > getLevel(opStack.peek());
    }

    private static int getLevel(char c) {
        int cLevel = -1;
        if (c == '+' || c == '-')
            cLevel = 1;
        else if (c == '#')
            return cLevel;
        else if (c == '*' || c == '/' || c == '%')
            cLevel = 2;
        else if (c == '^')
            cLevel = 3;
        else if (c == '(' || c == ')')
            cLevel = 4;
        return cLevel;
    }

}
