import java.util.ArrayList;

public class Miners {

	public int Xpos;
	public int Ypos;
	public boolean IsFull;
	public String Element ;
	int TargetX = 0;
	int TargetY =  0;
	int TargetXX = 0;
	int TargetYY =  0;
	String OutPut = "";
	boolean ToMine ;
	boolean ToFactory;
	
	 public void Reset()
	 {
		 IsFull = false;
		this.ToMine = false;
		this.ToFactory = false; 
		
		OutPut = "M| ";
	 }
	public Miners()
	{
		IsFull = false;
		this.Xpos = 0;
		this.Ypos = 0;
		this.ToMine = false;
		this.ToFactory = false;
		
		Element = "";
	}
	
	
	public void Append(String Name)
	{
		if(	Element == "")
		{
			Element = Name;
			IsFull = true;
		}
	}
	
	public void DistanceAlgorithm(ArrayList<MineClass> ThisList)
	{
	  if(Element == "")
	  {
		 
	    int Index = 0 ;
	    int Distance =Math.abs(ThisList.get(0).Xpos - this.Xpos) + Math.abs(ThisList.get(0).Ypos - this.Ypos) ;
	    int LocalDistance = 0;
	    int LocalIndex =  0;
		for(MineClass a : ThisList)
		{
			LocalDistance = Math.abs(a.Xpos - this.Xpos) + Math.abs(a.Ypos - this.Ypos) ;
			if(Distance > LocalDistance)
			{
			Distance = LocalDistance;
			Index = LocalIndex;
			}
			LocalIndex++;	
		}
		Element = ThisList.get(Index).NameTag;
		this.TargetX =  ThisList.get(Index).Xpos;
		this.TargetY = ThisList.get(Index).Ypos;
		ThisList.get(Index).TakeResource();
		this.ToMine = true;
		this.OutPut += ThisList.get(Index).Index + "," ;
	  }
			
	}
	
	public void Move()
	{
		if(this.ToMine)
		{
	     this.Xpos = this.TargetX;
	     this.Ypos = this.TargetY;
	     this.TargetX = 0 ;
	     this.TargetY = 0 ;
	     ToMine = false;
		}
		if(this.ToFactory)
		{
	     this.Xpos = this.TargetXX;
	     this.Ypos = this.TargetYY;
	     this.TargetXX = 0 ;
	     this.TargetYY = 0 ;
	    this.ToFactory = false ;
		}
	}
	
	
	 public void DistanceAlgorith2(ArrayList<FactoryClass> ThisList)
	  {
		ArrayList<FactoryClass> ElementType = new ArrayList<FactoryClass>();
		 if(Element != "")
		  {
			 for(FactoryClass a : ThisList)
			 {
				 if(a.NameTag.toUpperCase() == Element)
				 {
			     
					 ElementType.add(a);
				 }
			 }
			     int Index = 0 ;
			   try
			   {
			    int Distance =Math.abs(ElementType.get(0).Xpos - this.Xpos) + Math.abs(ElementType.get(0).Ypos - this.Ypos) ;
			    if(Distance  < 0) 
					 Distance = Distance*-1;
			    System.out.println("I wad here");
			    int LocalDistance = 0;
			    int LocalIndex =  0;
			     
			 
			 for(FactoryClass a : ElementType)
			 {
				 LocalDistance = Math.abs(a.Xpos - this.Xpos) + Math.abs(a.Ypos - this.Ypos) ;
				 if(LocalDistance  < 0) 
					 LocalDistance = LocalDistance*-1;
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
			   }catch(IndexOutOfBoundsException ex)
			   {
				   
			   }
			 
		  }
		  
	  }
	
}
