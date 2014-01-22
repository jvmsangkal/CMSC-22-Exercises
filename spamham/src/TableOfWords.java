import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableOfWords extends JPanel{
	static JTable spamTable=new JTable(){
		 public boolean isCellEditable(int row, int column) {
		      return false;
		   }
	};
	static JTable hamTable=new JTable(){
		 public boolean isCellEditable(int row, int column) {
		      return false;
		   }
	};
	static DefaultTableModel spamModel;
	static DefaultTableModel hamModel;
	static JLabel dictionarySize=new JLabel("Dictionary Size = "+BagOfWords.dictionary.size());
	
	public TableOfWords(){
		this.setLayout(new GridLayout(1,3,5,5));
		this.setPreferredSize(new Dimension(600,400));
		Vector columnNames=new Vector();
		columnNames.add("Words");
		columnNames.add("Count");
		
		spamModel=new DefaultTableModel(columnNames, 40);
		hamModel=new DefaultTableModel(columnNames, 40);
		
		spamTable.setPreferredScrollableViewportSize(new Dimension(600, 400));
		spamTable.setFillsViewportHeight(false);
		
		hamTable.setPreferredScrollableViewportSize(new Dimension(600, 400));
		hamTable.setFillsViewportHeight(false);
		
		JScrollPane scroll = new JScrollPane(spamTable);
		JScrollPane scroll2 = new JScrollPane(hamTable);
		
		spamTable.setFocusable(false);
		hamTable.setFocusable(false);
		
		
		spamTable.setShowHorizontalLines( true );
		hamTable.setShowHorizontalLines( true );
		
		spamTable.setShowVerticalLines(true);
		hamTable.setShowVerticalLines(true);
		
		spamTable.setModel(spamModel);
		hamTable.setModel(hamModel);
		
		spamTable.getTableHeader().setReorderingAllowed(false);
		hamTable.getTableHeader().setReorderingAllowed(false);
		this.add(scroll);
		this.add(scroll2);
		this.add(dictionarySize);
	
	}

}
