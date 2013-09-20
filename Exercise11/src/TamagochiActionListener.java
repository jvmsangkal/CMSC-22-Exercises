import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TamagochiActionListener implements ActionListener {
	private JButton b;
	private Pet a;
	private JLabel s;
	private JLabel w;
	private JLabel x;
	static boolean fed = false;
	public TamagochiActionListener(JButton b, Pet a, JLabel s,JLabel w, JLabel x) {
		super();
		this.b = b;
		this.a = a;
		this.s= s;
		this.w =w;
		this.x=x;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		a.setStatus("Happy");
		s.setText("Status: "+a.getStatus());
		b.setVisible(false);
		w.setVisible(false);
		x.setVisible(false);
		fed=true;
	}

}
