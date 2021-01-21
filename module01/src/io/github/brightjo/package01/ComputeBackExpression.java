package io.github.brightjo.package01;

public class ComputeBackExpression {
    static LinkedStack<Integer> aStack = new LinkedStack<>();
    public static void main(String[] args) {
        String exp = "32422*+13*-^*5-";
        for (char c : exp.toCharArray()) {
            if (c >= '0' && c <= '9') {
                aStack.push(c - '0');
            } else {
                compute(aStack.pop(), aStack.pop(),c);
            }
        }
        System.out.println(aStack.peek());
    }

    private static void compute(Integer oprd1, Integer oprd2, char c) {
        int res = 0;
        switch (c) {
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
}
