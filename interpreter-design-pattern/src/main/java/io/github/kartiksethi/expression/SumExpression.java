package io.github.kartiksethi.expression;

import io.github.kartiksethi.Context;

public class SumExpression implements Expression {

    private final Expression leftExpression;
    private final Expression rightExpression;

    public SumExpression(Expression leftExpression, Expression rightExpression) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) + rightExpression.interpret(context);
    }
}
