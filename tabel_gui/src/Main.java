import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Form tabel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.setLayout(new BorderLayout());

        String[][] data = {
                {"1", "Ilham", "Akbar", "19"},
                {"2", "Sun", "Haji", "67"}
        };

        String[] colom = {"ID", "Nama Depan", "Nama Belakang", "Usia"};

        DefaultTableModel model = new DefaultTableModel(data, colom);
        JTable tabel = new JTable(model);

        JScrollPane scroll_pane = new JScrollPane(tabel);
        frame.add(scroll_pane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField id_field = new JTextField(20);
        JTextField namaDepan_field = new JTextField(20);
        JTextField namaBelakang_field = new JTextField(20);
        JTextField usia_field = new JTextField(20);

        panel.add(new JLabel("ID"));
        panel.add(id_field);

        panel.add(new JLabel("Nama Depan"));
        panel.add(namaDepan_field);

        panel.add(new JLabel("Nama Belakang"));
        panel.add(namaBelakang_field);

        panel.add(new JLabel("Usia"));
        panel.add(usia_field);

        JButton addButton = new JButton("tambah data");
        panel.add(addButton);

        frame.add(panel, BorderLayout.NORTH);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String id = id_field.getText();
                String namaDepan = namaDepan_field.getText();
                String namaBelakang = namaBelakang_field.getText();
                String usia = usia_field.getText();

                if(id.isEmpty() || namaDepan.isEmpty() || namaBelakang.isEmpty() || usia.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "data tidak boleh ada yang kosong");
                    return;
                }

                model.addRow(new Object[]{id, namaDepan, namaBelakang, usia});

                id_field.setText("");
                namaDepan_field.setText("");
                namaBelakang_field.setText("");
                usia_field.setText("");
            }
        });
        frame.setVisible(true);
    }
}