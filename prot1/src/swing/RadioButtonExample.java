package swing;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class RadioButtonExample extends JFrame implements ActionListener  {

	public static void main(String[] args) {
		new RadioButtonExample();
	}

	JRadioButton rb1 = new JRadioButton("選択肢1", true);
	JRadioButton rb2 = new JRadioButton("選択肢2");
	JRadioButton rb3 = new JRadioButton("選択肢3");

	RadioButtonExample() {
		getContentPane().setLayout(new FlowLayout());
		JButton button = new JButton("OK");
		button.addActionListener(this);
		ButtonGroup bg = new ButtonGroup();

		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);

		getContentPane().add(rb1);
		getContentPane().add(rb2);
		getContentPane().add(rb3);
		getContentPane().add(button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 80);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(rb1.isSelected()) {
			System.out.println("[選択肢1]が選択されています");
		}
		if(rb2.isSelected()) {
			System.out.println("[選択肢2]が選択されています");
		}
		if(rb3.isSelected()) {
			System.out.println("[選択肢3]が選択されています");
		}
	}
}
