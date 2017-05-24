package cs1410;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.*;

public class Demo extends JFrame implements ActionListener {

	public static void main(String[] args) {
		Demo p = new Demo();
		p.setVisible(true);
	}
	
	private JMenuItem closeItem;
	
	public Demo () {
		
		// Exit on close
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// Make the PaintPanel the content pane
		setContentPane(new Demo2());
		
		// Add a File menu
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		closeItem = new JMenuItem("Close");
		closeItem.addActionListener(this);
		fileMenu.add(closeItem);
		menubar.add(fileMenu);
		setJMenuBar(menubar);
		
		// Ready to go
		setPreferredSize(new Dimension(300,300));
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		
		// Close the window
		if (e.getSource() == closeItem) {
			dispose();
		}
		
	}

}