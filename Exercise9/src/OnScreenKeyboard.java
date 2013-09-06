import java.awt.*;

import javax.swing.*;
public class OnScreenKeyboard {
	public static void main (String[] args){
		JButton[] alphabet = new JButton[28];
		JTextField tf=new JTextField(70);
		for(int i=0;i<28;i++){
			alphabet[i]=new JButton();
			alphabet[i].addActionListener(new ExerActionListener(alphabet[i],tf));
			alphabet[i].addKeyListener(new ExerKeyListener(tf));
		}
		alphabet[0].setText("Q");
		alphabet[1].setText("W");
		alphabet[2].setText("E");
		alphabet[3].setText("R");
		alphabet[4].setText("T");
		alphabet[5].setText("Y");
		alphabet[6].setText("U");
		alphabet[7].setText("I");
		alphabet[8].setText("O");
		alphabet[9].setText("P");
		alphabet[10].setText("A");
		alphabet[11].setText("S");
		alphabet[12].setText("D");
		alphabet[13].setText("F");
		alphabet[14].setText("G");
		alphabet[15].setText("H");
		alphabet[16].setText("J");
		alphabet[17].setText("K");
		alphabet[18].setText("L");
		alphabet[19].setText("Z");
		alphabet[20].setText("X");
		alphabet[21].setText("C");
		alphabet[22].setText("V");
		alphabet[23].setText("B");
		alphabet[24].setText("N");
		alphabet[25].setText("M");
		alphabet[26].setText("SPACE");
		alphabet[27].setText("Backspace");

		JButton[] num = new JButton[10];
		for(int i=0;i<10;i++){
			num[i]=new JButton();
			num[i].addActionListener(new ExerActionListener(num[i],tf));
			num[i].addKeyListener(new ExerKeyListener(tf));
		}
		
		num[0].setText("7");
		num[1].setText("8");
		num[2].setText("9");
		num[3].setText("4");
		num[4].setText("5");
		num[5].setText("6");
		num[6].setText("1");
		num[7].setText("2");
		num[8].setText("3");
		num[9].setText("0");
		
		JFrame mf = new JFrame("On-Screen Keyboard");
		mf.setSize(800,500);
		JPanel pane = new JPanel();
		JPanel console = new JPanel();
		JPanel qwerty = new JPanel();
		JPanel numpad = new JPanel();
		mf.setContentPane(pane);
		
		pane.setLayout(new BorderLayout());
		pane.add(console,BorderLayout.NORTH);
		pane.add(qwerty,BorderLayout.CENTER);
		pane.add(numpad,BorderLayout.EAST);
		numpad.setLayout(new GridBagLayout());
		for(int i=0;i<10;i++){
			qwerty.add(alphabet[i]);
		}
			qwerty.add(alphabet[27]);
			
		for(int i=10;i<19;i++){
			qwerty.add(alphabet[i]);
		}
	
		for(int i=19;i<26;i++){
			qwerty.add(alphabet[i]);
		}
		qwerty.add(alphabet[26]);
		console.add(tf);
		
		for(int i=0;i<10;i++){
			numpad.add(num[i]);
		}
		
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mf.setVisible(true);
	}

}
