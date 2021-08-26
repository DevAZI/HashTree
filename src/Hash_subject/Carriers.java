package Hash_subject;

public class Carriers {
	
	private String name;
	private int number;
	public Carriers(String name ,Integer number) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.number = number;
	}
	
	public String toString()
	{
		return name+"\t"+number;
	}
	
}
