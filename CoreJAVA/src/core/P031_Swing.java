package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.JDBCType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class DataNotFound {
	public DataNotFound() {
		JFrame fr = new JFrame("Alert");
		fr.setVisible(true);
		fr.setSize(200, 150);
		fr.setLayout(null);

		JLabel l1 = new JLabel("Data not found");
		l1.setBounds(50, 75, 120, 20);
		fr.add(l1);
	}
}

class SwingDemo implements ActionListener {
	JLabel l1, l2, l3, l4;
	JTextField t1, t2, t3, t4;
	JButton b1, b2, b3, b4;

	public SwingDemo() {
		JFrame fr = new JFrame("MyApp");
		fr.setVisible(true);
		fr.setSize(700, 500);
		fr.setLayout(null);

		l1 = new JLabel("Id : ");
		l1.setBounds(100, 100, 120, 20);
		fr.add(l1);

		l2 = new JLabel("Name : ");
		l2.setBounds(100, 130, 120, 20);
		fr.add(l2);

		l3 = new JLabel("Contact : ");
		l3.setBounds(100, 160, 120, 20);
		fr.add(l3);

		l4 = new JLabel("Address : ");
		l4.setBounds(100, 190, 120, 20);
		fr.add(l4);

		t1 = new JTextField();
		t1.setBounds(220, 100, 120, 20);
		fr.add(t1);

		t2 = new JTextField();
		t2.setBounds(220, 130, 120, 20);
		fr.add(t2);

		t3 = new JTextField();
		t3.setBounds(220, 160, 120, 20);
		fr.add(t3);

		t4 = new JTextField();
		t4.setBounds(220, 190, 120, 20);
		fr.add(t4);

		b1 = new JButton("insert");
		b1.setBounds(100, 250, 120, 20);
		fr.add(b1);

		b2 = new JButton("search");
		b2.setBounds(230, 250, 120, 20);
		fr.add(b2);

		b3 = new JButton("update");
		b3.setBounds(100, 280, 120, 20);
		fr.add(b3);

		b4 = new JButton("delete");
		b4.setBounds(230, 280, 120, 20);
		fr.add(b4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
	}

	public static Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swing", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("insert button clicked");
			int id = Integer.parseInt(t1.getText());
			String name = t2.getText();
			long contact = Long.parseLong(t3.getText());
			String address = t4.getText();
			System.out.println("id : " + id);
			System.out.println("name : " + name);
			System.out.println("contact: " + contact);
			System.out.println("address : " + address);
			try {
				Connection conn = SwingDemo.createConnection();
				String url = "insert into aaa(id,name,contact,address) values(?,?,?,?)";
				PreparedStatement pst = conn.prepareStatement(url);
				pst.setInt(1, id);
				pst.setString(2, name);
				pst.setLong(3, contact);
				pst.setString(4, address);
				// DML->insert,update,delete => executeUpdate
				// DQL->select =>executeQuery
				pst.executeUpdate();
				System.out.println("data inserted");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b2) {
			System.out.println("search button clicked");
			int id = Integer.parseInt(t1.getText());
			try {
				Connection conn = SwingDemo.createConnection();
				String url = "select * from aaa where id=?";
				PreparedStatement pst = conn.prepareStatement(url);
				pst.setInt(1, id);
				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					t1.setText(String.valueOf(rs.getInt("id")));
					t2.setText(rs.getString("name"));
					t3.setText(String.valueOf(rs.getLong("contact")));
					t4.setText(rs.getString("address"));
				} else {
					System.out.println("data not found");
					new DataNotFound();
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		else if (e.getSource() == b3) {
			System.out.println("update button clicked");
			int id = Integer.parseInt(t1.getText());
			String name = t2.getText();
			long contact = Long.parseLong(t3.getText());
			String address = t4.getText();
			try {
				Connection conn = SwingDemo.createConnection();
				String url = "update aaa set name=?,contact=?,address=? where id=?";
				PreparedStatement pst = conn.prepareStatement(url);
				pst.setString(1, name);
				pst.setLong(2, contact);
				pst.setString(3, address);
				pst.setInt(4, id);
				pst.executeUpdate();
				System.out.println("data updated");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		else if (e.getSource() == b4) {
			System.out.println("delete button clicked");
			int id = Integer.parseInt(t1.getText());
			try {
				Connection conn = SwingDemo.createConnection();
				String url = "delete from aaa where id=?";
				PreparedStatement pst = conn.prepareStatement(url);
				pst.setInt(1, id);
				pst.executeUpdate();
				System.out.println("data deleted");
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}

public class P031_Swing {
	public static void main(String[] args) {
		new SwingDemo();
	}
}
