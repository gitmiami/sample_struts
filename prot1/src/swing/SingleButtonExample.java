package swing;
import javax.swing.*;
import java.awt.event.*;

public class SingleButtonExample extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new SingleButtonExample();
	}

	SingleButtonExample() {

		JButton button = new JButton("ボタン");

		button.addActionListener(this);
		getContentPane().add(button);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		System.out.println("ボタンが押されました");
	}
}
