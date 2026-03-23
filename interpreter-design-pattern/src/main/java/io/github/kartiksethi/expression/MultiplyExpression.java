package io.github.kartiksethi.expression;

import io.github.kartiksethi.Context;

public class MultiplyExpression implements Expression {

    private final Expression leftExpression, rightExpression;

    public MultiplyExpression(Expression leftExpression, Expression rightExpression){
        this.leftExpression =leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int interpret(Context context) {
        return leftExpression.interpret(context) * rightExpression.interpret(context);
    }
}
