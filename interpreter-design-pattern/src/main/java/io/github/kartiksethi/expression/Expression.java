package io.github.kartiksethi.expression;

import io.github.kartiksethi.Context;

public interface Expression {
    int interpret(Context context);
}
