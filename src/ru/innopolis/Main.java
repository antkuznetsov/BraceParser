package ru.innopolis;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //InputStream str = System.in;
        //System.out.println(str);

        //String str = "([](){([])})";
        String str = "()[]}";

        Stack stack = new Stack();

        /*
        s1.push(3);
        s1.push(10);
        s1.push(16);
        s1.push(1);
        /s1.pop();
        */

        for (int i = 0; i < str.length(); i++) {

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
                    System.out.println(b.position);
                    break;
                }
                System.out.println("Succes");
            }

        }
    }
}

class Stack {
    Brace stck[] = new Brace[100];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(Brace item) {
        if (tos == 99) {
            System.out.println("Стек заполнен");
        } else {
            stck[++tos] = item;
        }
    }

    Brace pop() {
        if (tos < 0) {
            return new Brace('x', -1);
        } else {
            return stck[tos--];
        }
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