package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecContext {
    private Stack<Double> stack = new Stack<>();
    private Map<String, Double> vars = new HashMap<>();

    public int getStackSize() {
        return stack.size();
    }

    public void push(Double value) {
        stack.push(value);
    }

    public Double pop() {
        return stack.pop();
    }

    public Double peek() {
        return stack.peek();
    }

    public void addVar(String name, double value) {
        vars.put(name, value);
    }

    public double getVar(String name) {
        return vars.get(name);
    }

    public boolean containsVar(String name) {
        return vars.containsKey(name);
    }
}
