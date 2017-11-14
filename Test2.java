import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Test2 implements ActionListener{
	JFrame f1, f2;
	JRadioButton b1,b2;
	ButtonGroup bg1;
	JButton b, btn1;
	JPasswordField p;
	JLabel l;
	Test2(){
		f1 = new JFrame("Symposium");
		f1.setLayout(new FlowLayout());
		b1 = new JRadioButton("Admin");
		b2 = new JRadioButton("Attendee");
		bg1 = new ButtonGroup();
		b = new JButton("Log in");
		bg1.add(b1);
		bg1.add(b2);
		f1.add(b1);
		f1.add(b2);
		f1.add(b);
		b.addActionListener(this);
		f1.setSize(250,250);
		f1.setVisible(true);
	}
	public boolean comp(char[] a,String b){
		if(a.length!=4)
			return false;
		for(int i = 0;i<4;i++){
			if(a[i] != b.charAt(i))
				return false;
		}
		return true;
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b){
			if(b1.isSelected()){
				f2 = new JFrame("Symposium");
				p = new JPasswordField(20);
				l = new JLabel("Enter your password");
				btn1 = new JButton("Submit");
				f2.setLayout(new FlowLayout());
				f2.add(l);
				f2.add(p);
				f2.add(btn1);
				btn1.addActionListener(this);
				f2.setSize(250,250);
				f2.setVisible(true);
			}
		}
		if(e.getSource()==btn1){
			if(comp(p.getPassword(),"1234")){
				f2.setVisible(false);
				JFrame f3 = new JFrame("Symposium");
				JButton btn2 = new JButton("Add Workshop");
				JButton btn3 = new JButton("Add Event");
				JButton btn4 = new JButton("View Count");
				f3.setLayout(new FlowLayout());
				f3.add(btn2);
				f3.add(btn3);
				f3.add(btn4);
				f3.setSize(250,250);
				f3.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null,"Incorrect Password");
				p.setText("");
			}
		}
	}
	public static void main(String[] args){
		new Test2();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data","root","joker@23599");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM details");
			while(rs.next()){
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			con.close();
		}
		catch (Exception e){
			System.out.println(e);
		}
	}
}
