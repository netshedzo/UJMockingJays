import java.util.ArrayList;

public class Excavators {
	public int Xpos;
	public int Ypos;
	public boolean IsFull;
	public int Number ;
	int TargetX = 0;
	int TargetY =  0;
	int TargetXX = 0;
	int TargetYY =  0;
	String OutPut = "";
	boolean ToMine ;
	boolean ToFactory;
	 int ElementIndex ;
	
	public String[] Elements;
	
	public Excavators()
	{
		IsFull = false;
		this.Xpos = 0;
		this.ElementIndex = 0 ;
		Elements = new String[3];
		this.Number = 0 ;
		for(@SuppressWarnings("unused") String a : Elements)
		{
		
			a = "";

		}
		this.Ypos = 0;
	}
	
	public void Append(String Name)
	{
		boolean Check = false;
		
		for(String a : Elements)
		{
		if(	a == "" && Check == false)
		{
			a = Name;
			Check = true;
		}
		}
	}
	boolean Check()
	{
		for(String a : Elements)
		{
			if(a == "")
			return true;
		}
		return false;
	}
	
	int Check1()
	{
		int aa = 0 ;
	
		for(String a : Elements)
		{
			if(a == "")
			return aa;
			aa++;
		}
		return -1;
	}
	
	 public void DistanceAlgorith2(ArrayList<FactoryClass> ThisList)
	  {
		ArrayList<FactoryClass> ElementType = new ArrayList<FactoryClass>();
		 if(this.IsFull)
		  {
			 for(FactoryClass a : ThisList)
			 {
				 if(a.NameTag.toUpperCase() == Elements[this.ElementIndex])
				 {
					 ElementType.add(a);
				 }
			 }
			     int Index = 0 ;
			    int Distance =Math.abs(ElementType.get(0).Xpos - this.Xpos) + Math.abs(ElementType.get(0).Ypos - this.Ypos) ;
			    int LocalDistance = 0;
			    int LocalIndex =  0;
			 
			 for(FactoryClass a : ElementType)
			 {
				 LocalDistance = Math.abs(a.Xpos - this.Xpos) + Math.abs(a.Ypos - this.Ypos) ;
					if(Distance > LocalDistance)
					{
					Distance = LocalDistance;
					Index = LocalIndex;
					}
					LocalIndex++;	
			 }
			 
			    this.TargetXX =  ElementType.get(Index).Xpos;
				this.TargetYY = ElementType.get(Index).Ypos;
				this.OutPut += ElementType.get(Index).Index + "," ;
				this.ToFactory = true;
			 
		  }
	  }
		  
	  
	
	
}
