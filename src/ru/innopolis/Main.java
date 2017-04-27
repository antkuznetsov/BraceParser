package ru.innopolis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String str = in.readLine(); // Читаем текст из консоли

        Stack stack = new Stack();

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {

                stack.push(new Brace(str.charAt(i), i)); // Если символ это скобка, кладем его в стек

            } else {
                // Если символ это скобка
                if (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}') {

                    //Проверяем была ли она открыта
                    if (stack.tos < 0) {

                        //System.out.println("Не хватает открывающихся скобок");
                        System.out.print(i + 1);
                        return;

                    } else {

                        Brace b = stack.pop();

                        //Проверяем тип открывающей скобки
                        if (
                                (str.charAt(i) == ')' && b.type != '(') ||
                                        (str.charAt(i) == ']' && b.type != '[') ||
                                        (str.charAt(i) == '}' && b.type != '{')
                                ) {
                            //System.out.println("Баланс не соблюден");
                            System.out.print(i + 1);
                            return;
                        }

                    }

                }

            }
        }
        // Проверяем не осталось ли открытых скобок
        if (stack.tos < 0) {
            System.out.print("Success");
        } else {
            //System.out.print("Не хватает закрывающихся скобок");
            System.out.print(stack.pop().position + 1);
        }
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
            System.out.print("Стек заполнен");
        } else {
            stck[++tos] = item;
        }
    }

    Brace pop() {
        if (tos < 0) {
            System.out.print("Стек не загружен");
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