package gui;
import java.awt.*;
public class guiceshi {
   public static void main(String args[]){
	   Frame f = new Frame("My First Test");
	   f.setLocation(300,300);
	   f.setSize(600,600);
	   f.setVisible(true);
	   f.setResizable(false);
	   Panel p =new Panel(null);
	   p.setBounds(50,50,300,300);
	   f.add(p);
   }
}
