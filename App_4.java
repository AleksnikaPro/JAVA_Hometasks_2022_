// Задача 4
// Написать программу, показывающую последовательность действий для игры “Ханойская башня”


package Java_Hometasks;
import java.util.Scanner;

 
class App_4{
   
    static void towerOfHanoi(int n, String from_rod, String to_rod, String extra_rod)
    {
        if (n == 1){


            System.out.println("Переместите диск 1 со стержня " +  from_rod + " на стержень " + extra_rod);
            return;
        }else{                // A       C         B
            towerOfHanoi(n-1, from_rod, extra_rod, to_rod);// передвигаем с А на B  (если изначально у нас 100 дисков, берем 99)
                                                                            // А                           С
            System.out.println("Переместите диск " + n + " со стержня " +  from_rod + " на стержень " + extra_rod);// передвигаем последний(самый большой)
                              // B       A         C
            towerOfHanoi(n-1, to_rod, from_rod, extra_rod);// передвигаем с B на C (n-1 = 99 дисков)
        }
    }
     
    
    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int n = in.nextInt(); // количество дисков
        in.close();
       
        String from_rod = "A" ;
        String to_rod = "B";
        String extra_rod = "C";
        towerOfHanoi(n, from_rod, to_rod, extra_rod);  
    }
}


// алгоритм с 3 стержнями  

// 1 шаг               A          C        B
// towerOfHanoi(n-1, from_rod, extra_rod, to_rod); (move n-1 disks from A > B)
// 1 диск  A > C
// 2 диск  A > B
// 1 диск  C > B

// 2 шаг                                                             A                             C
// System.out.println("Переместите диск " + n + " со стержня " +  from_rod + " на стержень " + extra_rod);(move the largest disk to C)
// 3 диск  A > C

// 3 шаг               B         A       C
// towerOfHanoi(n-1, to_rod, from_rod, extra_rod);(move n-1 disks from B > C)
// 1 диск  B > A
// 2 диск  B > C
// 1 диск  A > C
