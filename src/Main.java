import java.sql.Array;
import java.util.*;

public class Main {
    static void check(int x){
        if (x == -1) {
            System.out.println("Нет свободных домов");
        } else {
            System.out.print(x);
        }
    }
    static  void  printArray(int[] arr){
        for (int i=0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);;
        var distance = console.nextInt();
        var street = new int[distance];
        for (int i=0; i < distance; i++) {
            street[i] = console.nextInt();
        }
        console.close();


        int leftBorder = 0;

        for ( int i = 0; i < distance; i++){
            if (street[i] == 0)
            {
                leftBorder = i;
                break;
            }
        }
        var step = leftBorder;

        for ( int i = 0; i < leftBorder; i++){
            street[i] = step;
            step--;
        }
        step=1;
        for (int i = leftBorder+1; i < distance; i++){
            if (street[i] == 0)
            {
                var stepBack = 1;
                for (int j = i - 1; j > (i + leftBorder)/2; j --)
                {
                    street[j] = stepBack;
                    stepBack++;
                }
                step = 1;
                leftBorder = i;
            }
            else {
                street[i] = step;
                step++;
            }
        }
        printArray(street);
    }
}




//        for ( int i = 0; i < distance; i++){
//            if (street[i] == 0)
//            {
//                first = i;
//                break;
//            }
//        }
//        for ( int i = 0; i < first; i++){
//            street[i] = first - i;
//        }