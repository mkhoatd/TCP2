import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public Client() {
        submitButton.addActionListener(e -> {
            try {
                var message=textField1.getText()+textField2.getText()+textField3.getText();
                var socket=new Socket("localhost", 7788);
                var dis=new DataInputStream(socket.getInputStream());
                var dos=new DataOutputStream(socket.getOutputStream());
                dos.writeUTF(message);
                var res=dis.readUTF();
                textArea1.setText(res);
                socket.close();
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Client");
        frame.setContentPane(new Client().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextArea textArea1;
    private JButton submitButton;
}
