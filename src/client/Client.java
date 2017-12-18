package client;

import communication.Message;
import communication.MessageType;
import org.codehaus.jackson.map.ObjectMapper;
import utils.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client{
    private int uId;
    private int divId;
    private int vendorId;
    private MessageType messageType;

    public Client(){

    }

    public Client(int uId, int divId, int vendorId, MessageType messageType){
        this.uId = uId;
        this.divId = divId;
        this.vendorId = vendorId;
        this.messageType = messageType;
    }

    public void start(){
        Log.e("chat started");

        BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
        Socket socket;
        try{
            socket = new Socket("172.20.10.4", 5001);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            ReceiveThread rt = new ReceiveThread(socket);
            rt.start();
            final ObjectMapper objectMapper = new ObjectMapper();
            while(true) {
                final Message message = new Message();
                message.setUid(Integer.toString(this.uId));

                message.setType(this.messageType);
                final String msg = user.readLine();

                if(msg.equals("###")) message.setType(MessageType.EXIT);

                message.setMessage(msg);

                out.println(objectMapper.writeValueAsString(message));
                Log.i(objectMapper.writeValueAsString(message));
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

