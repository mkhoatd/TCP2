import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Clientdddd {
    public static void main(String[] args) throws Exception {
        var socket=new Socket("localhost", 7788);
        var dis=new DataInputStream(socket.getInputStream());
        var dos=new DataOutputStream(socket.getOutputStream());
        var sc=new Scanner(System.in);
        var str=sc.nextLine();
        sc.close();
        dos.writeUTF(str);
        var op=dis.readUTF();
        System.out.println(op);
        socket.close();
    }
}
