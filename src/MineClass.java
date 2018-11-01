
public class MineClass {
	public String NameTag  ;
	public int Index;
	public int Xpos ;
	public int Ypos;
	public int Resources;
    boolean Collected ;
	
	public MineClass(String Name, int Index,int Xpos,int Ypos ,int Resource)
	{
		this.NameTag = Name;
		this.Index = Index;
		this.Xpos = Xpos;
		this.Ypos = Ypos;
		this.Resources = Resource;
		Collected = false;
		
	}
	public void TakeResource()
	{
		Resources--;
		if(this.Resources == 0 )
		{
			Collected = true;
		}
	}

}
