package datastructures.linear.stack;


public class Runner {
    public static void main(String[] args) {
        StackADT s = new StackADT();
        String prefixExpr = "*-562";
        String infixExpr = "(A+B^C)*D+E^5";
        String postExpr = "23+79/-";

        System.out.println("====================================================");
        System.out.println("Infix Expression => "+s.prefixToInfix(prefixExpr.replaceAll("\\s", "")));
        System.out.println("Postfix Expression => "+s.prefixToPostfix(prefixExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");
        System.out.println("Prefix Expression => "+s.infixToPrefix(infixExpr.replaceAll("\\s", "")));
        System.out.println("Postfix Expression => "+s.infixToPostfix(infixExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");
        System.out.println("Prefix Expression => "+s.postfixToPrefix(postExpr.replaceAll("\\s", "")));
        System.out.println("Infix Expression => "+s.postfixToInfix(postExpr.replaceAll("\\s", "")));
        System.out.println("====================================================");

    }
}
