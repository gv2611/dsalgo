import java.io.Serializable;

public class SerializationDemo implements Serializable {
	
	private String name;
	private int id;
	private int salary;
	
	SerializationDemo(String name, int id, int salary)
	{
		this.name=name;
		this.salary=salary;
		this.id=id;
	}
	
	public String toString()
	{
		return this.name+" "+this.id+" "+this.salary;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getSalary()
	{
		return salary;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public void setId(int id)
	{
		this.id=id;
	}
	
	public void setSalary(int salary)
	{
		this.salary=salary;
	}

	public static void main(String[] args) {
		SerializationDemo sd= new SerializationDemo("Garima",10,11);
		System.out.println(sd);
		

	}

}
