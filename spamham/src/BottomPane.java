import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class BottomPane extends JPanel{
	static JLabel hamspam=new JLabel("Spam/Ham: N/A");
	static JTextField tf=new JTextField(20);
	public BottomPane(){
		this.setPreferredSize(new Dimension(600,50));
		
		JButton detect=new JButton("Detect");
		
		detect.addActionListener(new BottomPaneListener());
		
		this.add(tf);
		this.add(detect);
		this.add(hamspam);
	}
}

class BottomPaneListener implements ActionListener{

	public BottomPaneListener(){

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<Word> al=new ArrayList<>();
		if(BagOfWords.dictionary.size()!=0 && !BottomPane.tf.getText().equals("")){
			double PSpam=BagOfWords.spamLines/BagOfWords.totalLines;
			double PHam=BagOfWords.hamLines/BagOfWords.totalLines;
			double PSubjectSpam=1;
			double PSubjectHam=1;
			String line=BottomPane.tf.getText();
			StringTokenizer st=new StringTokenizer(line," \n\t.+-,():;");
			while(st.hasMoreTokens()){
				Word w = new Word(st.nextToken());
				w.setS(w.getS().replaceAll("[^a-zA-Z0-9%]", ""));
				al.add(w);
			}
			
			for(int i=0;i<al.size();i++){
				boolean found=false;
				for(int j=0;j<BagOfWords.spamBag.size();j++){
					if(al.get(i).getS().equalsIgnoreCase(BagOfWords.spamBag.get(j).getS())){
						PSubjectSpam=PSubjectSpam*(BagOfWords.spamBag.get(j).getCount()/BagOfWords.totalSpam);
						found=true;
						break;
					}
				}
				if(!found){
				PSubjectSpam=0;	
				}
			}
			
			for(int i=0;i<al.size();i++){
				boolean found=false;
				for(int j=0;j<BagOfWords.hamBag.size();j++){
					if(al.get(i).getS().equalsIgnoreCase(BagOfWords.hamBag.get(j).getS())){
						PSubjectHam=PSubjectHam*(BagOfWords.hamBag.get(j).getCount()/BagOfWords.totalHam);
						found=true;
						break;
					}
				}
				if(!found){
					PSubjectHam=0;	
					}
			}
			
			double PSpamSubject=(PSubjectSpam*PSpam)/((PSubjectSpam*PSpam)+(PSubjectHam*PHam));
			if(PSpamSubject>0.5){
				BottomPane.hamspam.setText("Spam/Ham: Spam");
			}else{
				BottomPane.hamspam.setText("Spam/Ham: Ham");
			}
			System.out.println("P(Subject|Spam) = "+PSubjectSpam);
			System.out.println("P(Subject|Ham) = "+PSubjectHam);
			System.out.println("P(Spam) = "+PSpam);
			System.out.println("P(Ham) = "+PHam);
			System.out.println("P(Spam|Subject) = "+PSpamSubject);
		}else{
			JOptionPane op=new JOptionPane();
			op.showMessageDialog(SHRunner.pane, "Please Generate Bag of words or give an input.");
		}
	}
	
}
