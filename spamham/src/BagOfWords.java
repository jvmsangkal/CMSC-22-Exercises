import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

/*Author:John Viscel M.Sangkal
 * Description: Bag of Words: Ham and Spam
 * Made using eclipse.
 * 
 * 
 */
public class BagOfWords {
	static ArrayList<Word> hamBag = new ArrayList<Word>();
	static ArrayList<Word> spamBag = new ArrayList<Word>();
	static ArrayList<Word> dictionary = new ArrayList<Word>();
	static File spamFile;
	static File hamFile;
	static float totalSpam;
	static float totalHam;
	static float spamLines;
	static float hamLines;
	static float totalLines;
	
	public BagOfWords(){
		
	}
	public static void generateBagOfWords(){
		StringTokenizer st;
		totalSpam=0;
		totalHam=0;
		spamLines=0;
		hamLines=0;
		totalLines=0;
		try{
			BufferedReader br = new BufferedReader(new FileReader(hamFile));
			String line = br.readLine();
			while(line !=null){
				hamLines++;
				totalLines++;
				st=new StringTokenizer(line," \n\t.+-,():;!?");
				
				while(st.hasMoreTokens()){
				totalHam++;
				Word w = new Word(st.nextToken());
				w.setS(w.getS().replaceAll("[^a-zA-Z0-9%]", ""));
				if(hamBag.isEmpty()){
					hamBag.add(w);
				}
				else{
				boolean found=false;
				for(int j=0;j<hamBag.size();j++){
					if(hamBag.get(j).getS().equalsIgnoreCase(w.getS())){
						hamBag.get(j).setCount(hamBag.get(j).getCount()+1);
						found=true;
						break;
					}
				}
				if(!found){
					hamBag.add(w);
				}
				}
				
				if(dictionary.isEmpty()){
					dictionary.add(w);
				}
				else{
				boolean found=false;
				for(int j=0;j<dictionary.size();j++){
					if(dictionary.get(j).getS().equalsIgnoreCase(w.getS())){
						dictionary.get(j).setCount(dictionary.get(j).getCount()+1);
						found=true;
						break;
					}
				}
				if(!found){
					dictionary.add(w);
				}
				}
				
				}
				line =br.readLine();
			}
			br.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(spamFile));
			String line = br.readLine();
			while(line !=null){
				spamLines++;
				totalLines++;
				st=new StringTokenizer(line," \n\t.+-,():;!?");
				while(st.hasMoreTokens()){
				totalSpam++;
				Word w = new Word(st.nextToken());
				w.setS(w.getS().replaceAll("[^a-zA-Z0-9%]", ""));
				if(spamBag.isEmpty()){
					spamBag.add(w);
				}
				else{
				boolean found=false;
				for(int j=0;j<spamBag.size();j++){
					if(spamBag.get(j).getS().equalsIgnoreCase(w.getS())){
						spamBag.get(j).setCount(spamBag.get(j).getCount()+1);
						found=true;
						break;
					}
				}
				if(!found){
					spamBag.add(w);
				}
				}
				
				if(dictionary.isEmpty()){
					dictionary.add(w);
				}
				else{
				boolean found=false;
				for(int j=0;j<dictionary.size();j++){
					if(dictionary.get(j).getS().equalsIgnoreCase(w.getS())){
						dictionary.get(j).setCount(dictionary.get(j).getCount()+1);
						found=true;
						break;
					}
				}
				if(!found){
					dictionary.add(w);
				}
				}
				}
				line =br.readLine();
			}
			br.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		try{
			PrintWriter pw = new PrintWriter("hamBag.txt");
			pw.println("HAM");
			for(int i=0;i<hamBag.size();i++){
			pw.println(hamBag.get(i).getS()+" - "+hamBag.get(i).getCount());
			}
			pw.close();
			}
			catch(Exception e){
				
			}
		try{
			PrintWriter pw = new PrintWriter("spamBag.txt");
			pw.println("SPAM");
			for(int i=0;i<spamBag.size();i++){
			pw.println(spamBag.get(i).getS()+" - "+spamBag.get(i).getCount());
			}
			pw.close();
			}
			catch(Exception e){
				
			}
		for(int i=0;i<hamBag.size();i++){
			Vector rowData = new Vector();
			rowData.add(hamBag.get(i).getS());
			rowData.add(hamBag.get(i).getCount());
			TableOfWords.hamModel.addRow(rowData);
		}
		for(int i=0;i<spamBag.size();i++){
			Vector rowData = new Vector();
			rowData.add(spamBag.get(i).getS());
			rowData.add(spamBag.get(i).getCount());
			TableOfWords.spamModel.addRow(rowData);
		}
		
		
		
	}
}
