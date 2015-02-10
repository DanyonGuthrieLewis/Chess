package other;

import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;

public class StatisticsWindow extends JFrame{
	private final static int width = 500;
	private final static int height = 400;
	JPanel info = new JPanel();
	JButton exit = new JButton("Exit");
	JButton save = new JButton("Save and Exit");
	public StatisticsWindow(String stats){
		super("Moves");
		JTextArea text = new JTextArea(stats);
		ScrollPane scroll = new ScrollPane();
		scroll.setSize(500,300);
		setSize(width, height);		
		exit.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		save.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				SaveFile.saveStatistics(stats);
				System.exit(0);
			}
		});
		
		scroll.add(text);
		info.add(scroll);
		info.add(exit);
		info.add(save);
		info.setVisible(true);
		add(info);
		setVisible(true);
	}
}
