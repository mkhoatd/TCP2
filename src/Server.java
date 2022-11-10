import org.mariuszgromada.math.mxparser.Expression;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;

public class Server {
    public static void main(String[] args) throws Exception {
        var server = new ServerSocket(7788);
        System.out.println("server is started");
        while (true) {
            var socket = server.accept();
            var dos = new DataOutputStream(socket.getOutputStream());
            var dis = new DataInputStream(socket.getInputStream());
            var strSent = dis.readUTF();
            var ex= new Expression(strSent);
            var res=ex.calculate();
            dos.writeUTF(""+res);
//            var strRev = reverseString(strSent);
//            var strUpper = strSent.toUpperCase();
//            var strLower = strSent.toLowerCase();
//            var strRevCase = reverseCase(strSent);
//            var wordCount=countWord(strSent);
//            var vowelCount=countVowel(strSent);
//            dos.writeUTF("Input: "+strSent);
//            dos.writeUTF("\nChuoi dao nguoc: " + strRev);
//            dos.writeUTF("\nChuoi in hoa: "+strUpper);
//            dos.writeUTF("\nChuoi in thuong: "+strLower);
//            dos.writeUTF("\nChuoi vua hoa vua thuong: "+strRevCase);
//            dos.writeUTF("\nSo tu: "+wordCount);
//            dos.writeUTF("\nSo nguyen am: "+vowelCount);
            socket.close();
        }

    }

//    private static String reverseString(String ip) {
//        var rev = "";
//        for (int i = ip.length() - 1; i >= 0; i++) {
//            rev = rev + ip.charAt(i);
//        }
//        return rev;
//    }
//
//    private static String reverseCase(String ip) {
//        var res = "";
//        for (int i = 0; i < ip.length(); i++) {
//            res += Character.isUpperCase(ip.charAt(i))
//                    ? Character.toLowerCase(ip.charAt(i))
//                    : Character.toLowerCase(ip.charAt(i));
//        }
//        return res;
//    }
//
//    private static int countWord(String input) {
//        if (input == null || input.isEmpty()) {
//            return 0;
//        }
//
//        String[] words = input.split("\\s+");
//        return words.length;
//    }
//
//    private static int countVowel(String sentence) {
//        int count = 0;
//        for (int i = 0; i < sentence.length(); i++) {
//            char ch = sentence.charAt(i);
//            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == ' ') {
//                count++;
//            }
//        }
//        return count;
//    }

}