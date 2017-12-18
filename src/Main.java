import client.Client;
import communication.MessageType;
import utils.Log;

import java.util.Scanner;

public class Main {
    public static void main(String ... args){
        int uId = -1;
        int divId = -1;
        int vendorId = -1;
        MessageType messageType = MessageType.TEXT;
        Scanner scanner = new Scanner(System.in);

        try{
            Log.i("input uid");
            uId = scanner.nextInt();
            Log.i("input divId");
            divId = scanner.nextInt();
            Log.i("input vendorId");
            vendorId = scanner.nextInt();
        }
        catch(Exception e){
            Log.e("input type err");
            return;
        }
        Client client = new Client(divId, vendorId, uId, messageType);
        client.start();
    }
}
