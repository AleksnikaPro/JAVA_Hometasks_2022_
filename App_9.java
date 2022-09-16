// Задача 9. 
// Реализовать алгоритм пирамидальной сортировки (HeapSort).
// maxHeap

package Java_Hometasks;
import java.util.Scanner;

public class App_9 {
   
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) { // заполняем массив элементами, введёнными с клавиатуры
            System.out.print("Enter array length: ");
            int size = input.nextInt(); // Читаем с клавиатуры размер массива и записываем в size
            int array[] = new int[size]; // Создаём массив int размером в size
            System.out.print("Insert array elements: ");
            /*Пройдёмся по всему массиву, заполняя его*/
            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
            }
            System.out.print("Inserted array elements: ");
            for (int i = 0; i < size; i++) {
                System.out.print (" " + array[i]); // Выводим на экран, полученный массив
            }
            System.out.println();


            // int[] array = {100, 5, 7, 3, -5, 2, 50, 13, 19, 123}; // вариант без введения с клавиатуры
            heapSort(array);
            System.out.print("HeapSort: ");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
        }
    }
    // строим бинарное дерево , нулевой элемент будет максимальным
    private static void heapSort(int[] arr) {
        int length = arr.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, length); 
        }
               
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, 0, i);
        }
        
    }

    private static void heapify(int[] array, int i, int length) {
        int left_child = 2 * i + 1;
        int right_child= 2 * i + 2;
        int largest = i; // Инициализируем наибольшее как root


        if(left_child < length &&  array[left_child] > array[largest])
            largest = left_child;

        if(right_child < length &&  array[right_child] > array[largest])
            largest = right_child;
        // если один из детей оказался больше родителя, мы меняем их местами
        if(i != largest) {
            int temp =  array[i];
            array[i] =  array[largest];
            array[largest] = temp;

            heapify(array, largest, length);

        }

    }
}





