package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.*; 
import javax.swing.*;


public class chushi extends JFrame{

	private JLabel biao1,biao2;
	private JButton jb = new JButton();
	private JTextField jt = new JTextField();
	private JPasswordField jps = new JPasswordField();
	JButton jb2 = new JButton();//？
	
	//JScrollPane scrollPane; ？
	//ImageIcon icon;
	//Image image;
	int x = 80, y = 140;
	
	
	public chushi()
	{
		super("企业管理系统");
		int x = 80, y = 140;
		setBounds(300, 200, 420, 370);
		setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)是使用 System exit 方法退出应用程序。
	    Container m = getContentPane();
	    
	    m.setLayout(null);
	    biao1 = new JLabel("用户名");
	    biao1.setBounds(x, y, 50, 20);
		jt.setBounds(x + 50, y, 200, 25);
		//jt.addActionListener(new loglistener());
		jps.setBounds(x + 50, y+30, 200, 25);
		//jps.addActionListener(new loglistener());
		biao1.setForeground(Color.black);
		m.add(biao1);
		jb.setText("登录");
		jb2.setText("退出");
		//jb.addMouseListener(new mouseEvent_1());
		//jb2.addMouseListener(new mouseEvent_2());
		biao1 = new JLabel("密码");
		biao1.setBounds(x, y + 30, 50, 25);
		biao1.setForeground(Color.black);
		jb.setBounds(x + 20, y + 80, 90, 50);
		m.add(jb);
		jb2.setBounds(x + 140, y + 80, 90, 50);
		m.add(jb2);
		m.add(biao1);
		m.add(jt);
		m.add(jps);
		
		biao2 = new JLabel("xx企业管理系统");
		biao2.setBounds(x+80, y-120, 200, 50);
		biao2.setForeground(Color.black);
		m.add(biao2);
		
		JRadioButton dan1 = new JRadioButton("员工");  
		JRadioButton dan2 = new JRadioButton("管理员");
		JRadioButton dan3 = new JRadioButton("退休人员");
		dan1.setBounds(50,y-50,100,50);    
		dan2.setBounds(150,y-50,100,50);
		dan3.setBounds(250,y-50,100,50);
		ButtonGroup bg = new ButtonGroup();  
		bg.add(dan1);  
		bg.add(dan2);
		bg.add(dan3);
		m.add(dan1);  
		m.add(dan2);
		m.add(dan3);
	
	
	
	
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		chushi  application = new chushi();
	}

}
