package swing;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class clip1 extends JFrame {

	private JLabel label;

  public clip1(){

    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.addWindowListener(new WindowAdapter(){

    	public void windowActivated(WindowEvent e){
        label.setText(getTextFromClip());
      }

      public void windowDeactivated(WindowEvent e){
        setTextToClip(label.getText());
      }
    });

    this.addKeyListener(new KeyAdapter(){
      public void keyPressed(KeyEvent e) {
        String msg = label.getText() + e.getKeyChar();
        label.setText(msg);
      }
    });

    label = new JLabel();
    label.addMouseListener(new MouseAdapter(){
      public void mouseClicked(MouseEvent e){
        if (e.getClickCount() == 2){
          label.setText("");
        }
      }
    });
    this.add(label,BorderLayout.CENTER);
    label.setText(this.getTextFromClip());
  }

  public String getTextFromClip(){
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    Transferable object = clipboard.getContents(null);
    String str = "";
    try {
      str = (String)object.getTransferData(DataFlavor.stringFlavor);
    } catch(UnsupportedFlavorException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }

  public void setTextToClip(String str){
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection selection = new StringSelection(str);
    clipboard.setContents(selection, null);
  }

  public static void main(String[] args) {
    new clip1().setVisible(true);
  }
}