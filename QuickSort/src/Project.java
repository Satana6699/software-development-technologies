import java.util.Scanner;
import java.util.Arrays;
public class Project {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите кол-во элементов в массиву: ");
        int n = in.nextInt();
        int[] array = new int[n];
        System.out.println("Введите элементы поочередно либо через пробел: ");
        for(int i = 0; i < array.length; i++){
            array[i] = in.nextInt();
        }
        System.out.println("Массив: " + Arrays.toString(array));
        in.close();
        QuickSort.quickSort(array, 0, array.length - 1);
        System.out.println("Сортированный массив: " + Arrays.toString(array));
    }
}
