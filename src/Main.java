import client.Client;
import utils.Log;

import java.util.Scanner;

public class Main {
    public static void main(String ... args){
        int myNumber = -1;
        Scanner scanner = new Scanner(System.in);
        Log.i("input my number");

        try{
            myNumber = scanner.nextInt();
        }
        catch(Exception e){
            Log.e("input type err");
            return;
        }

        new Client().start(myNumber);
    }
}
