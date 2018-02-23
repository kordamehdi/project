package animation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class fenetre extends JFrame {
	private JPanel container=new JPanel();
	private JLabel label=new JLabel("fffffffffffff");
	private JButton btn2=new JButton();
	private JButton btn1=new JButton();
	private Boolean debut;
	int i;
	
	public fenetre()
	{
		this.setTitle("Animation");

	    this.setSize(300, 300);

	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    this.setLocationRelativeTo(null);

	    this.setContentPane(container);

	    this.setVisible(true);
	    btn1.addActionListener(new btn1());
	    btn2.addActionListener(new btn2());
	    
	    label.setPreferredSize(new Dimension(145, 145));

	    JPanel pane= new JPanel();
	    btn1.setPreferredSize(new Dimension(145, 145));
	    btn2.setPreferredSize(new Dimension(145, 145));
	    pane.add(btn1, BorderLayout.WEST);
	    pane.add(btn2, BorderLayout.EAST);
	    
	    container.setLayout(new BorderLayout());
	    container.add(label, BorderLayout.NORTH);
	    container.add(pane, BorderLayout.SOUTH);
	    
	    btn1.setText("debut");
	    
	    btn2.setText("arret");
		
	}
	
	private void go()
	{
		
		while(debut)
		{
			i++;
			label.setText(String.valueOf(i));
			try {
			 Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		label.setText(String.valueOf(i));
	}
	
	class btn1 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			debut=true;
			Thread tr= new Thread(new thread());
			tr.start();
			
			
			
		}
	}
	
	class thread implements Runnable
	{

		@Override
		public void run() {
			
			go();
		}
		
	}
	
	class btn2 implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			debut=false;
			go();
			
		}
	}
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fenetre ft=new fenetre();

	}

}
