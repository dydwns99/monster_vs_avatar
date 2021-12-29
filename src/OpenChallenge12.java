import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OpenChallenge12 extends JFrame {
	private JLabel abt = new JLabel("@");
	private JLabel mst = new JLabel("M");
	
	public OpenChallenge12() {
		setTitle("OpenChallenge12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container GamePanel = getContentPane();
		GamePanel.setLayout(null);
		
		
		GamePanel.add(abt);
		GamePanel.add(mst);
		abt.setSize(15,15);
		abt.setLocation(50,50);
		mst.setSize(15,15);
		mst.setLocation(100,100);
		
		GamePanel.addKeyListener(new MyKeyListener());
		GamePanel.setFocusable(true);
		GamePanel.requestFocus();
		
		MonsterThread mt = new MonsterThread(abt, mst);
		setSize(300,300);
		setVisible(true);
		
		mt.start();
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch(keyCode) {
			case KeyEvent.VK_Q:
				System.exit(0); break;
			case KeyEvent.VK_UP:
				abt.setLocation(abt.getX(), abt.getY()-10); break;
			case KeyEvent.VK_DOWN:
				abt.setLocation(abt.getX(), abt.getY()+10); break;
			case KeyEvent.VK_LEFT:
				abt.setLocation(abt.getX()-10, abt.getY()); break;
			case KeyEvent.VK_RIGHT:
				abt.setLocation(abt.getX()+10, abt.getY()); break;
			}
		}
	}
	public static void main(String [] args) {
		new OpenChallenge12();
	}
}

class MonsterThread extends Thread{
	private JLabel abt, mst;
	public MonsterThread(JLabel abt, JLabel mst) {
		this.abt = abt; this.mst = mst;
	}
	public void run() {
		while(true) {
			try {
			Thread.sleep(200);
			//아바타가 더 위에 있을경우
			if(abt.getY()<mst.getY()) {
				//아바타가 더 왼쪽에 있을 경우
				if(abt.getX()<mst.getX()) {
					mst.setLocation(mst.getX()-5, mst.getY()-5); continue;
				}
				else if(abt.getX()>mst.getX()) {
					mst.setLocation(mst.getX()+5, mst.getY()-5); continue;
				}
				else {
					mst.setLocation(mst.getX(), mst.getY()-5); continue;
				}
			}
			//아바타가 더 아래에 있을경우
			if(abt.getY()>mst.getY()) {
				//아바타가 더 왼쪽에 있을 경우
				if(abt.getX()<mst.getX()) {
					mst.setLocation(mst.getX()-5, mst.getY()+5); continue;
				}
				else if(abt.getX()>mst.getX()) {
					mst.setLocation(mst.getX()+5, mst.getY()+5); continue;
				}
				else {
					mst.setLocation(mst.getX(), mst.getY()+5); continue;
				}
			}
			//아바타가 더 왼쪽에 있을경우
			if(abt.getX()<mst.getX()) {
				//아바타가 더 위에 있을 경우
				if(abt.getY()<mst.getY()) {
					mst.setLocation(mst.getX()-5, mst.getY()-5); continue;
				}
				else if(abt.getY()>mst.getY()) {
					mst.setLocation(mst.getX()-5, mst.getY()+5); continue;
				}
				else {
					mst.setLocation(mst.getX()-5, mst.getY()); continue;
				}
			}
			//아바타가 더 오른쪽에 있을경우
			if(abt.getX()>mst.getX()) {
				//아바타가 더 위에 있을 경우
				if(abt.getY()<mst.getY()) {
					mst.setLocation(mst.getX()+5, mst.getY()-5); continue;
				}
				else if(abt.getY()>mst.getY()) {
					mst.setLocation(mst.getX()+5, mst.getY()+5); continue;
				}
				else {
					mst.setLocation(mst.getX()+5, mst.getY()); continue;
				}
			}
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}




