package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import socket.MySocket;

public class Start {

	DrawAndGuess d = new DrawAndGuess();
	MySocket mysocket = new MySocket(d);
	Dealword deal = new Dealword(d);
	String serverip;
	String username;
	JFrame j = new JFrame("��½");
	private JLabel jl;
	private JButton jb = new JButton();
	private JTextField jt = new JTextField();
	private JPasswordField jps = new JPasswordField();
	
	JButton jb2 = new JButton();
	// //////////////////////////////////
	JScrollPane scrollPane;
	ImageIcon icon;
	Image image;
	int x = 80, y = 140;

	public void launch() {
		//ImageIcon bj = new ImageIcon("src\\images\\loginbackground.jpg");//��ȡ����ͼƬ
		//JLabel bjl = new JLabel(bj);
		//bjl.setBounds(0, 0,bj.getIconWidth(),bj.getIconHeight());//����ǩ����Ϊ����ͼһ���Ĵ�С
		//j.getLayeredPane().add(bjl, new Integer(Integer.MIN_VALUE));//����ǩ��ӵ��ڶ������
		
		//Container p1=j.getContentPane();//��ȡ�����
		//((JPanel)p1).setOpaque(false);//���������Ϊ͸��
		
		j.setLayout(null);
		jl = new JLabel("�û���");
	    jl.setBounds(x, y, 50, 20);
		jt.setBounds(x + 50, y, 200, 25);
		jt.addActionListener(new loglistener());
		jps.setBounds(x + 50, y+30, 200, 25);
		jps.addActionListener(new loglistener());
		jl.setForeground(Color.black);
		j.add(jl);
		jb.setText("��¼");
		jb2.setText("ע��");
		jb.addMouseListener(new mouseEvent_1());
		jb2.addMouseListener(new mouseEvent_2());
		jl = new JLabel("����");
		jl.setBounds(x, y + 30, 50, 25);
		jl.setForeground(Color.black);
		jb.setBounds(x + 20, y + 80, 90, 50);
		j.add(jb);
		jb2.setBounds(x + 140, y + 80, 90, 50);
		j.add(jb2);
		j.add(jl);
		j.add(jt);
		j.add(jps);

		j.setBounds(300, 200, 420, 370);
		j.setResizable(false);
		j.setVisible(true);
		mysocket.connect();
		
		
	}

	public class mouseEvent_1 implements MouseListener {
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			try {

				String s = "DL" + jt.getText() + "#"
						+ String.valueOf(jps.getPassword());
				username = jt.getText();
				mysocket.send(s);

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}
      public class mouseEvent_2 implements MouseListener {
		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseClicked(MouseEvent e) {
			try {

				new Register(mysocket).draw();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	public class loglistener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			try {
				if (e.getActionCommand().equals(" ")) {
					String s = "DL" + jt.getText() + "#"
							+ String.valueOf(jps.getPassword());
					username = jt.getText();
					mysocket.send(s);
				}
				if (e.getActionCommand().equals("  ")) {
					new Register(mysocket).draw();

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	
	public void getmeg(int i) {
		mysocket.send("DG" + i);

	}

}
