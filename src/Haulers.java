
public class Haulers {
	public int Xpos;
	public int Ypos;
	public boolean IsFull;
	public String[] Elements;
	
	public Haulers()
	{
		IsFull = false;
		this.Xpos = 0;
		Elements = new String[5];
		
		this.Ypos = 0;
		for(@SuppressWarnings("unused") String a : Elements)
		{
		
			a = "";

		}
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
}
