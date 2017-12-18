package client;

import utils.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    public void start(int myNumber){
        Log.e("chat started");
        int userNumber = myNumber;

        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        try{
            socket = new Socket("172.20.10.4", 5001);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ReceiveThread rt = new ReceiveThread(socket);
            rt.start();
            while(true) {
                final String msg = "{\"msg\":\"" + user.readLine() + "\"}";
                out.println(msg);
                Log.i(msg);
            }
        }
        catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class ReceiveThread extends Thread{
    Socket socket;

    public ReceiveThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        BufferedReader in;
        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true)
                Log.e("received", in.readLine());

        }
        catch (IOException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        super.run();
    }
}

