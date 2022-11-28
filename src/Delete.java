import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Delete extends JFrame {
    private JTextField t;
    private JButton btn1;
    private JButton btn2;
    private JPanel panel1;

    public Delete() {
        setContentPane(panel1);
        setTitle("Delete");
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        t.setSize(300, 35);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Delete the Record?");
                if (ans == JOptionPane.YES_OPTION) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "root", "password");
                        Statement stmt = con.createStatement();
                        String query;
                        query = "Delete from Library where ReferenceID= '" + t.getText() + "';";
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Record Successfully Deleted");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Error in Connectivity!");
                    }
                    t.setText("");
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Delete del = new Delete();
    }
}
