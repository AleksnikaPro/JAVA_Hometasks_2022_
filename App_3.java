// Задача 3
// Написать программу вычисления n-ого треугольного числа.

package Java_Hometasks;
import java.util.Scanner;

public class App_3 {

    static int findTriangularNumber(int number){

        int triangular_number;
        triangular_number = number * (number + 1) / 2;
        return triangular_number;
    }

    public static void main (String[] args){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = in.nextInt();
        in.close();
        // System.out.printf("Треугольное число: %d" , findTriangularNumber(number)); // вариант вывода результата
        int final_result = findTriangularNumber(number);
        System.out.printf("Треугольное число: %d" , final_result);

        
    }
         
   
}

    

