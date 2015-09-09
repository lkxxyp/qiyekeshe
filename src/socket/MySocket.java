package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import ui.Drawing;
import ui.Dealword;
import ui.DrawAndGuess;

public class MySocket {
	DrawAndGuess dg;
	Dealword deal;
	Socket s;
	public DataOutputStream dos;
	DataInputStream dis;

	public MySocket(DrawAndGuess dg) {
		this.dg = dg;
		deal = new Dealword(dg);
	}

	public void connect() {
		try {
			System.out.println("进入服务器连接");
			////////////////////////////////////////////////
			///////////////////////////////////////////////
			s = new Socket("127.0.0.1", 12345);
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			new Thread(new recThread()).start();
			System.out.println("服务器连接成功");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void send(String s) {
		try {
			dos.writeUTF(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class recThread implements Runnable {
		public void run() {
			try {
				String str;
				while (true) {
					str = dis.readUTF();
					System.out.println("收到了" + str);
					deal.deal(str);
				}
			} catch (IOException e) {
				System.out.println("a client connect");
			}
		}

	}

	public void send(int index, int num, Drawing d) {
		String str = "P" + index + "#" + num + "#" + d.x1 + "#" + d.x2 + "#"
				+ d.y1 + "#" + d.y2 + "#" + d.stroke + "#" + d.color.getRGB();
		System.out.println("发出了图片信息" + str);
		send(str);
	}
}
