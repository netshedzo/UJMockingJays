import java.io.File;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
	
	 File FileRead = new File("map_1.input");
	 
	 ArrayList<Miners> Miner = new ArrayList<Miners>() ;
	 ArrayList<Excavators> Excavator =  new ArrayList<Excavators>();
	 ArrayList<Haulers> aHouler = new ArrayList<Haulers>();
	 FileHandler tF = new FileHandler();
	 
	 tF.GetFromFile(FileRead);
	
	 
	 
	 for(int a = 0 ; a < tF.MineCount ; a++)
	 {
		 Miners  Mine = new Miners();
		Miner.add(Mine);
	 }
	 for(int a = 0; a < tF.ExcCount;a++)
	 {
		 Excavators Ex = new Excavators();
		 Excavator.add(Ex);
	 }
	 
	 for(int a = 0 ; a < tF.HaulerCount;a++)
	 {
		 Haulers aH = new Haulers();
		 aHouler.add(aH);
	 }
	 
	 boolean Resource = true ;
	  String aaa = " ";
	 while(Resource)
	 {
		 int Count = 6 ;
		 for(MineClass a: tF.Mine)
		 {
			 if(a.Resources > 0)
			 {
				 Count = 0 ;
			 }
		 }
		 if(Count != 0 )
			 Resource = true;
		 
		 for(Miners a : Miner)
		 {
			a.DistanceAlgorithm(tF.Mine);
			a.Move();
			a.DistanceAlgorith2(tF.Factory);
			
		    aaa += "\n"  +"M| "+ a.OutPut + "4,"+"2," + "3";
		 }
		tF.Write_to_File("Output.outPut", aaa);
		 
	 }
	
	 
	 

	}

}
