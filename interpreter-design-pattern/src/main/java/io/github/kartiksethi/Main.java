package io.github.kartiksethi;

import io.github.kartiksethi.expression.Expression;
import io.github.kartiksethi.expression.MultiplyExpression;
import io.github.kartiksethi.expression.NumberTerminalExpression;
import io.github.kartiksethi.expression.SumExpression;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.assign("a", 10);
        context.assign("b", 20);
        context.assign("c", 2);

        System.out.println("Variables in Context: a=10, b=20, c=2");
        System.out.println("Building the AST for: (a + b) * c");
        Expression nodeA = new NumberTerminalExpression("a");
        Expression nodeB = new NumberTerminalExpression("b");
        Expression nodeC = new NumberTerminalExpression("c");
        Expression addition = new SumExpression(nodeA, nodeB);

        Expression finalExpression = new MultiplyExpression(addition, nodeC);
        int result = finalExpression.interpret(context);

        System.out.println("Result: " + result);

    }
}