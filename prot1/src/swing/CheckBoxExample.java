package swing;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CheckBoxExample extends JFrame implements ActionListener {

	public static void main(String[] args) {
		new CheckBoxExample();
	}

	JCheckBox checkBox;

	CheckBoxExample() {
		getContentPane().setLayout(new FlowLayout());

		JButton button = new JButton("OK");
		button.addActionListener(this);

		checkBox = new JCheckBox("�`�F�b�N�{�b�N�X");
		getContentPane().add(checkBox);
		getContentPane().add(button);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250, 80);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(checkBox.isSelected()) {
			System.out.println("�`�F�b�N�{�b�N�X��ON�ł�");
		} else {
			System.out.println("�`�F�b�N�{�b�N�X��OFF�ł�");			}
	}
}
