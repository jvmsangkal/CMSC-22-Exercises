import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Buttons extends JPanel{
	
	public Buttons(){
		this.setLayout(new GridLayout(1,3,5,5));
		this.setPreferredSize(new Dimension(600,50));
		
		JButton browseSpam=new JButton("Browse Spam File");
		JButton browseHam=new JButton("Browse Ham File");
		JButton generateBag=new JButton("Generate Bag of Words");
		
		this.add(browseSpam);
		this.add(browseHam);
		this.add(generateBag);
		
		browseSpam.addActionListener(new ButtonsListener(browseSpam));
		browseHam.addActionListener(new ButtonsListener(browseHam));
		generateBag.addActionListener(new ButtonsListener(generateBag));
	}

}

class ButtonsListener implements ActionListener{
	JButton b;
	JFileChooser fc = new JFileChooser();
	public ButtonsListener(JButton b){
		this.b=b;
	}
	
	public void actionPerformed(ActionEvent e) {
		String s=b.getText();
		if(s.equals("Browse Spam File")){
			int returnVal = fc.showOpenDialog(SHRunner.pane);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            BagOfWords.spamFile = fc.getSelectedFile();
	            //This is where a real application would open the file.
	            System.out.println("Opening: " + BagOfWords.spamFile.getName() + ".");
	        } else {
	            System.out.println("Open command cancelled by user.");
	        }
		}else if(s.equals("Browse Ham File")){
			int returnVal = fc.showOpenDialog(SHRunner.pane);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
	            BagOfWords.hamFile = fc.getSelectedFile();
	            //This is where a real application would open the file.
	            System.out.println("Opening: " + BagOfWords.hamFile.getName() + ".");
	        } else {
	            System.out.println("Open command cancelled by user.");
	        }
		}else if(s.equals("Generate Bag of Words")){
			JOptionPane op=new JOptionPane();
			if(BagOfWords.hamFile==null || BagOfWords.spamFile==null){
			op.showMessageDialog(SHRunner.pane, "Please select a file for spam and ham");
			}else{
			BagOfWords.dictionary.clear();
			TableOfWords.hamModel.setRowCount(0);
			TableOfWords.spamModel.setRowCount(0);
			BagOfWords.spamBag.clear();
			BagOfWords.hamBag.clear();
			BagOfWords.generateBagOfWords();
			
			TableOfWords.dictionarySize.setText("Dictionary Size = "+BagOfWords.dictionary.size());
			}
		}
	}

}
