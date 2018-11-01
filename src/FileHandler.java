import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;




public class FileHandler {
	ArrayList<MineClass> Mine ;
	ArrayList<FactoryClass> Factory;
	int SizeX;
	int SizeY;
	int MineCount;
	int ExcCount;
	int HaulerCount;
	int NumMines;
	int NumFact;
	int Budget;
	
	public FileHandler()
	{
		Mine = new ArrayList<MineClass>();
		Factory = new ArrayList<FactoryClass>();
		
	}
	 public  void GetFromFile(File FileData) {
	       Scanner scFileData = null;
	       try {
	    	   scFileData = new Scanner(FileData);
	    	   String strLine = scFileData.nextLine();
	    	   StringTokenizer MapDataTokenizer = new StringTokenizer(strLine," ");
	    	   String strR = MapDataTokenizer.nextToken();
	    	   int MpR = Integer.parseInt(strR);
	    	   this.SizeY = MpR;
	    	   String strC = MapDataTokenizer.nextToken();
	    	   int MpC = Integer.parseInt(strC);
	    	   this.SizeX = MpC;
	    	   String StrM = MapDataTokenizer.nextToken();
	    	   int MpM = Integer.parseInt(StrM);
	    	   this.MineCount  = MpM;
	    	   String strE =MapDataTokenizer.nextToken();
	    	   int MpE = Integer.parseInt(strE);
	    	   this.ExcCount = MpE;
	    	   String strHC = MapDataTokenizer.nextToken();
	    	   int HC = Integer.parseInt(strHC);
	    	   this.HaulerCount = HC;
	    	   String strMn = MapDataTokenizer.nextToken();
	    	   int MpMn = Integer.parseInt(strMn);
	    	   this.NumMines = MpMn;
	    	   String strF =MapDataTokenizer.nextToken();
	    	   int MpF = Integer.parseInt(strF);
	    	   this.NumFact =MpF ;
	    	   String strBu =MapDataTokenizer.nextToken();
	    	   int MpBu = Integer.parseInt(strBu);
	    	   this.Budget = MpBu;
	    	   

	    		 	   int Count = 7;
	    		 	   while(Count > 0)
	    		 	   {
	    		 		   Count--;
	    		 		  strLine = scFileData.nextLine();
	        		   StringTokenizer DataTokenizer = new StringTokenizer(strLine," ");
	        		   String MnIndex = DataTokenizer.nextToken();
	        		   int IndexM = Integer.parseInt(MnIndex);
	        		   String MnElement = DataTokenizer.nextToken();
	        		   String MnX = DataTokenizer.nextToken();
	        		   int Mx =Integer.parseInt(MnX);
	        		   String MnY = DataTokenizer.nextToken();
	        		   int My = Integer.parseInt(MnY);
	        		   String NumRes = DataTokenizer.nextToken();
	        		   int Res = Integer.parseInt(NumRes);
	        		   MineClass thisMine = new MineClass(MnElement,IndexM,Mx,My,Res);
	        		   Mine.add(thisMine);
	        		 
	       
	    		 	   }
	    		 	   Count = 9;
	    		 	   while(Count > 0)
	    		 	   {
	    		 		   Count --;
	    		 		  strLine = scFileData.nextLine();
	        		   StringTokenizer DataTokenizer = new StringTokenizer(strLine," ");
	        		   String FcIndex = DataTokenizer.nextToken();
	        		   int IndexF = Integer.parseInt(FcIndex);
	        		   String FcElement = DataTokenizer.nextToken();
	        		   String FcX = DataTokenizer.nextToken();
	        		   int Fx =Integer.parseInt(FcX);
	        		   String FcY = DataTokenizer.nextToken();
	        		   int Fy = Integer.parseInt(FcY);
	        		   FactoryClass thisFac = new FactoryClass(FcElement,IndexF,Fx,Fy);
	        		   this.Factory.add(thisFac);
	        		   
	        		   
	        		   
	    		 	   }
	    		 
	    	   
	    	   
	       }catch(FileNotFoundException e) {
	    	   e.printStackTrace();
	       }finally {
	    	   if
	    	   (scFileData != null) scFileData.close();
	       }
	 }
	
	 
	 
	
		
		public void Write_to_File(String StrLine,String File) {
			File outFile = new File(StrLine);
			
			PrintWriter txtout = null;
			try {
				txtout = new PrintWriter(outFile); 
				txtout.println(File);
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				if
				(txtout != null) txtout.close();
			}
		}
	
}
