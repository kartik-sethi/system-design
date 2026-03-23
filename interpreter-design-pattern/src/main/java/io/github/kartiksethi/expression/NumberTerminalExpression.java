package io.github.kartiksethi.expression;

import io.github.kartiksethi.Context;

public class NumberTerminalExpression implements Expression {
    private final String val;

    public NumberTerminalExpression(String val) {
        this.val = val;
    }

    @Override
    public int interpret(Context context) {
        return (Integer) context.getValue(val);
    }
}
