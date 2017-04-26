package ru.innopolis;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //InputStream str = System.in;
        //System.out.println(str);

        String str = "()[]{}";

        Stack stack = new Stack();

        for (int i = 0; i < str.length(); i++) {

            Brace brace = new Brace(str.charAt(i), i);
            stack.push(brace);

            /*
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                Brace brace = new Brace(str.charAt(i), i);
                stack.push(brace);
            } else {
                Brace b = stack.pop();
                if (
                        (str.charAt(i) == ')' && b.type != '(') ||
                        (str.charAt(i) == ']' && b.type != '[') ||
                        (str.charAt(i) == '}' && b.type != '{')
                    ) {
                    System.out.println(b.position+1);
                }
            }
            */
        }
        System.out.println(stack);

        for (int i = 0; i < str.length(); i++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.pop());
    }
}

class Stack {

    Brace stck[] = new Brace[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(Brace item) {
        if (tos == 9) {
            System.out.println("Стек заполнен");
        } else {
            stck[++tos] = item;
        }
    }

    Brace pop() {
        if (tos < 0) {
            System.out.println("Стек не загружен");
            return null;
        } else {
            return stck[tos--];
        }
    }

    @Override
    public String toString() {
        return "Stack{" +
                "stck=" + Arrays.toString(stck) +
                ", tos=" + tos +
                '}';
    }
}

class Brace {
    char type;
    int position;

    public Brace(char type, int position) {
        this.type = type;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Brace{" +
                "type=" + type +
                ", position=" + position +
                '}';
    }
}