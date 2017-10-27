import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Test1 implements ActionListener{
	JRadioButton b1,b2;
	Test1(){
		JFrame f = new JFrame();
		b1 = new JRadioButton("Admin");
		b2 = new JRadioButton("Attendee");
		ButtonGroup bg = new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		f.setLayout(new FlowLayout());
		f.add(b1);
		f.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		f.setSize(250,250);
		f.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==b1){
			int a = Integer.parseInt(JOptionPane.showInputDialog("1:Count 2:Setting data"));
			if(a == 1){
				int k = Integer.parseInt(JOptionPane.showInputDialog("1:Workshop Count 2:Event Count"));
				if(k == 1){
					Workshop w = new Workshop();
					JOptionPane.showMessageDialog(null,"Workshop attenders " + w.w_count);
				}
				if(k == 2){
					Event ev = new Event();
					JOptionPane.showMessageDialog(null,"Event attenders " + ev.e_count);
				}
			}
		}
		if(e.getSource()==b2){
			int b = Integer.parseInt(JOptionPane.showInputDialog("1:Workshop 2:Event"));
		}
	}
	public static void main(String []args){
		new Test1();
		Scanner inp = new Scanner(System.in);
		int m = 1;
		while(m == 1){
			System.out.println("1:Admin login 2:User login");
			int l = inp.nextInt();
			switch(l){
				case 1: System.out.println("1:Display the count of attendees 2:Setting the first ,second and third prizes");
					int k  = inp.nextInt();
					switch(k){
						case 1: System.out.println("1:Workshop count 2:Event count");
							int p = inp.nextInt();
							if(p == 1){
								Workshop w = new Workshop();
								System.out.println("No. of people attending workshop : " + w.w_count);
							}
							else{
								Event e = new Event();
								System.out.println("No. of people attending events : " + e.e_count);
							}
							break;
						case 2:System.out.println("Enter the winners of Hackathon");
						       Hackathon h = new Hackathon();
						       String f =inp.next();
						       String s = inp.next();
						       String t = inp.next();
						       h.setdata(f,s,t);
						       break;
					}
					break;
				case 2:	System.out.println("Press 1 for attending workshop 2 for attending event");
					int c;
					c = inp.nextInt();
					switch(c){
						case 1: Workshop w = new Workshop();
							w.getdata();

							System.out.println("Press 1 to pay fees");			
							int f = inp.nextInt();
							if(f == 1)
								w.payFees();
							else
								System.out.println("It is mandatory to pay the fees to attend the workshop");
							System.out.println("Press 1 to attend the workshop");
							int a = inp.nextInt();
							if(a == 1)
								w.attend();
							else
								System.out.println("You are not attending the workshop");
							w.display();
							break;
						case 2:Event e = new Event();
						       e.getdata();
						       break;
					}
					break;	
			}
			System.out.println("1:Continue 2:Exit");
			m = inp.nextInt();
		}
	}
}
