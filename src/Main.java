import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] dataPoints = new int [100];
        int totalVal = 0;
        int valAvrg = 0;
        int maxVal = 0;
        int minVal = 100;
        int userVal = 0;
        int valTimes = 0;
        int valPosition = -1;

        for(int i = 0; i < dataPoints.length; i++){
            dataPoints[i] = (int)(Math.random() * 100) + 1;
        }

        for(int i = 0; i < dataPoints.length; i++){
            totalVal += dataPoints[i];
        }

        for(int i = 0; i < dataPoints.length; i++){
            valAvrg = totalVal / dataPoints.length;
        }

        for(int i = 0; i < dataPoints.length; i++){
            if(dataPoints[i] > maxVal){
                maxVal = dataPoints[i];
            }
        }

        for(int i = 0; i < dataPoints.length; i++){
            if(dataPoints[i] <= minVal){
                minVal = dataPoints[i];
            }
        }

        for(int i = 0; i < dataPoints.length; i++){
            System.out.print(dataPoints[i] + " | ");

        }
        System.out.println("\n");
        System.out.println("The total of all the values is: " + totalVal);
        System.out.println("The average of all the values is: " + valAvrg);
        System.out.println("The maximum value is: " + maxVal);
        System.out.println("The minimum value is: " + minVal);

        System.out.println("\n");
        userVal = getRangedInt(scan, "Enter a value you would like to find: ", 1,100);


        for(int i = 0; i < dataPoints.length; i++){
            if(userVal == dataPoints[i]){
                valTimes++;
            }
        }
        System.out.println("Your value was used "+ valTimes + " times. ");

        for(int i = 0; i < dataPoints.length; i++){
            if(dataPoints[i] == userVal){
                valPosition = i + 1;
                break;
            }
        }
        if(valPosition != -1 ) {
            System.out.println("The value " + userVal + " was found at array index " + valPosition);
        }else{
            System.out.println("Your value was not found.");
        }
    }

    public static int getRangedInt(Scanner in, String prompt, int min, int max){
        boolean done = false;
        int x = 0;

        System.out.println(prompt);
        do {
            if(in.hasNextInt()){
                x = in.nextInt();
                //check to see if value is in range.
                if(x <= max && x >= min){
                    done = true;
                }else{
                    System.out.println("Invalid input. Do better.");
                }
            }else{
                System.out.println("Invalid input. Do better.");
            }
            in.nextLine(); //clear buffer
        }while(!done);
        return x;
    }
}