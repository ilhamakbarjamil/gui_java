import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("Masukkan Password");
        frame.add(label);

        JPasswordField password_field = new JPasswordField(20);
        frame.add(password_field);

        JButton button = new JButton("Validasi Password");
        frame.add(button);

        JLabel result = new JLabel("password akan divalidasi di sini");
        frame.add(result);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] password = password_field.getPassword();
                String passwordText = new String(password);

                if(passwordText.length() < 7){
                    JOptionPane.showMessageDialog(frame, "password tidak valid minimal 7 karakter");
                }else if(!passwordText.matches(".*[A-Z].*")){
                    JOptionPane.showMessageDialog(frame, "password harus mengandung huruf besar");
                }else if(!passwordText.matches(".*[a-z].*")){
                    JOptionPane.showMessageDialog(frame, "password harus mengandung huruf kecil");
                }else if(!passwordText.matches(".*[0-9].*")){
                    JOptionPane.showMessageDialog(frame, "password harus mengandung angka");
                }else{
                    JOptionPane.showMessageDialog(frame, "password valid\n" + passwordText);
                }
            }
        });
        frame.setVisible(true);
    }
}