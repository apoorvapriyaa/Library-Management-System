import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Update extends JFrame {
    private JPanel panel1;
    private JTextField t1;
    private JTextField t2;
    private JTextField t3;
    private JTextField t4;
    private JTextField t5;
    private JTextField t6;
    private JTextField t7;
    private JTextField t8;
    private JButton btn;
    private JButton btn2;

    public Update() {
        setContentPane(panel1);
        setTitle("Update");
        setSize(700, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        panel1.setSize(700, 700);
        pack();
        btn.setSize(100, 35);
        btn2.setSize(50, 35);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ans = JOptionPane.showConfirmDialog(null, "Confirm Update?");
                if (ans == JOptionPane.YES_OPTION) {
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "root", "password");
                        Statement stmt = con.createStatement();
                        String query;
                        query = "Update Library Set Borrower= '" + t2.getText() + "', BookName= '" + t3.getText() +
                                "', Author= '" + t4.getText() + "', AuthorID= '" + t5.getText() + "', IssueDate= '" + t6.getText() +
                                "', SubmissionDate= '" + t7.getText() + "', Fine= " + t8.getText() +
                                " where ReferenceID= '" + t1.getText() + "';";
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Record successfully updated");
                    } catch (Exception exc) {
                        JOptionPane.showMessageDialog(null, "Error in connectivity!");
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
        Update upd = new Update();
    }
}
