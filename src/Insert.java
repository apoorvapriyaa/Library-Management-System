import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Insert extends JFrame {
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JButton btn;
    private JPanel panel1;
    private JButton btn2;

    public Insert() {
        setContentPane(panel1);
        setTitle("Insert");
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        btn.setSize(100, 35);
        btn2.setSize(50, 35);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Insert the entered record?");
                if (ans == JOptionPane.YES_OPTION) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "root", "password");
                        Statement stmt = con.createStatement();
                        String query;
                        query = "Insert into Library values("
                                + "'" + t1.getText() + "'"
                                + "," + "'" + t2.getText() + "'"
                                + "," + "'" + t3.getText() + "'"
                                + "," + "'" + t4.getText() + "'"
                                + "," + "'" + t5.getText() + "'"
                                + "," + "'" + t6.getText() + "'"
                                + "," + "'" + t7.getText() + "'"
                                + "," + t8.getText()
                                + ");";
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Record Successfully Inserted!");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Error in Connectivity!");
                    }
                }
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Insert i = new Insert();
    }
}
