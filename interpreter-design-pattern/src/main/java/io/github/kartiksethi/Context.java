package io.github.kartiksethi;

import java.util.HashMap;

public class Context {
    HashMap<String, Object> variables = new HashMap<>();

    public void assign(String name, Integer value) {
        variables.put(name, value);
    }

    public Object getValue(String name) {
        variables.computeIfAbsent(name, k -> { throw new RuntimeException("Variable not found"); });
        return variables.getOrDefault(name, 0);
    }

}
