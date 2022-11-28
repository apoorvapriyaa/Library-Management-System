import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.*;

public class Retrieval extends JFrame {

    private JPanel panel1;
    private JButton btn;

    public Retrieval() {
        setContentPane(panel1);
        setTitle("Retrieval");
        setSize(880, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        JTable tb1 = new JTable();
        Object[] columns = {"Reference ID", "Borrower", "Book Name", "Author", "Author ID", "Issue Date", "Submission Date", "Fine"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        tb1.setModel(model);
        tb1.setBackground(Color.decode("#efd3d7"));
        tb1.setForeground(Color.black);
        Font font = new Font("", 1, 12);
        tb1.setFont(font);
        tb1.setRowHeight(30);

        JScrollPane pane = new JScrollPane(tb1);
        pane.setBounds(0, 0, 880, 200);

        setLayout(null);
        add(pane);

        JTableHeader header = tb1.getTableHeader();
        header.setBackground(Color.decode("#cbc0d3"));
        header.setForeground(Color.black);
        header.setFont(font);

        btn.setSize(880, 40);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tm = (DefaultTableModel) tb1.getModel();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Management", "root", "apoorva77");
                    Statement sm = con.createStatement();
                    String query = "Select * from Library;";
                    ResultSet rs = sm.executeQuery(query);

                    while (rs.next()) {
                        String Ref = rs.getString("ReferenceID");
                        String Borr = rs.getString("Borrower");
                        String Bkname = rs.getString("BookName");
                        String Auth = rs.getString("Author");
                        String AID = rs.getString("AuthorID");
                        String DI = rs.getString("IssueDate");
                        String DS = rs.getString("SubmissionDate");
                        String Fine = rs.getString("Fine");

                        tm.addRow(new Object[]{Ref, Borr, Bkname, Auth, AID, DI, DS, Fine});
                    }
                    rs.close();
                    sm.close();
                    con.close();

                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, "Error in connecting!");
                }
            }
        });
    }

    public static void main(String[] args) {
        Retrieval r = new Retrieval();
    }
}
