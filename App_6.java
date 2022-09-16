// Задача 6
// Реализовать алгоритм сортировки слиянием

package Java_Hometasks;

public class App_6 {
    public static void main(String[] args) {
        int[] array = {2, 18, 5, 4, 23, 1, 6};
        mergeSort(array);
        for (int i = 0; i < array.length; i++) 
            System.out.print(array[i] + " "); 
        
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if(length == 1) return;

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];
        
        for (int i = 0; i < middle; i++) {
            left[i] = array[i];
        }
        for (int i = middle; i < length; i++) {
            right[i - middle] = array[i]; 
        }
        mergeSort(left);  
        mergeSort(right);
        merge(array, left, right);
        
    }
    // объединяем все элементы 
    private static void merge(int[] array, int[] left, int[] right) {
        int left_length = left.length;
        int right_length = right.length;
        int i = 0;
        int j = 0;
        int index = 0;

        while(i < left_length && j < right_length){
            if(left[i] < right[j]){
                array[index] = left[i];
                i++;
                index++;
            }else{
                array[index] = right[j];
                j++;
                index++;
            }
        }
        // если количество элементов в подмассивах не равное, сохраняем его так
            for(int k = i; k < left_length; k++){
                array[index++] = left[k];
            }
            for(int l = j; l < right_length; l++){
                array[index++] = right[l];
            }


    }
    
    
}

