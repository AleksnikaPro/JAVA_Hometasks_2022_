// Задача 12
// Написать программу, определяющую правильность расстановки скобок в выражении.
// Пример 1: a+(d*3) - истина
// Пример 2: [a+(1*3) - ложь
// Пример 3: [6+(3*3)] - истина
// Пример 4: {a}[+]{(d*3)} - истина
// Пример 5: <{a}+{(d*3)}> - истина
// Пример 6: {a+]}{(d*3)} - ложь

package Java_Hometasks;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
  
public class App_12 {
  
    static boolean rightOrderOfBrackets(String expression)
    {
        Deque<Character> stack = new ArrayDeque<Character>(); // ArrayDeque быстрее, чем Stack
  
        for (int i = 0; i < expression.length(); i++) 
        {
            char x = expression.charAt(i);
  
            if (x == '(' || x == '[' || x == '{' || x == '<') 
            {
                stack.push(x);
                continue;
            }
  
            if (stack.isEmpty())
                return false;

            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[' || check == '<')
                    return false;
                break;
  
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[' || check == '<')
                    return false;
                break;
  
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{' || check == '<')
                    return false;
                break;
            
            case '>':
                check = stack.pop();
                if (check == '(' || check == '{' || check == '[')
                    return false;
                break;
            }
        }
        return (stack.isEmpty());
    }
  
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение со скобками (например, (), [], {}, <>): ");
        String expression = in.nextLine();
        in.close();
  
        if (rightOrderOfBrackets(expression))
            System.out.println("Скобки в выражении расставлены правильно.");
        else
            System.out.println("Скобки в выражении расставлены НЕправильно.");
    }
}
    
