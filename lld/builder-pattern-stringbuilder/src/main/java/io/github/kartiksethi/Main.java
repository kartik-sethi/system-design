package io.github.kartiksethi;

public class Main {
    public static void main(String[] args) {
        CustomStringBuilder sb = new CustomStringBuilder();
        sb.append("Hello ").append("World").append(123);
        System.out.println(sb); // Hello World123
    }
}