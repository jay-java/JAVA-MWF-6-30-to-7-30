package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("insert button clicked");
			int id = Integer.parseInt(t1.getText());
			String name= t2.getText();
			long contact= Long.parseLong(t3.getText());
			String address = t4.getText();
			System.out.println("id : "+id);
			System.out.println("name : "+name);
			System.out.println("contact: "+contact);
			System.out.println("address : "+address);
			
		} else if (e.getSource() == b2) {
			System.out.println("search button clicked");
		} else if (e.getSource() == b3) {
			System.out.println("update button clicked");
		} else if (e.getSource() == b4) {
			System.out.println("delete button clicked");
		}

	}
}

public class P031_Swing {
	public static void main(String[] args) {
		new SwingDemo();
	}
}