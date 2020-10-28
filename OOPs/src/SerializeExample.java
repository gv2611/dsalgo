import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Emp implements Serializable {

	transient int rollNo;
	static int rank;
	String name;
	int age;

	public Emp(int rollNo, int rank, String name, int age) {
		this.rollNo = rollNo;
		this.rank = rank;
		this.name = name;
		this.age = age;
	}

}

public class SerializeExample

{
	public static void printData(Emp obj) {
		System.out.println("Employee with roll number " + obj.rollNo + " named " + obj.name + " aged " + obj.age
				+ " is at rank " + obj.rank);

	}

	public static void main(String[] args) {

		Emp emp1 = new Emp(12, 4, "Garima", 28);
		//Emp emp2 = new Emp(34, 2, "Nitin", 30);
		String filename = "serial.txt";

		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(emp1);
			//out.writeObject(emp2);
			System.out.println("Serialization Completed!");
			printData(emp1);
			//printData(emp2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		emp1 = null;
	//	emp2 = null;
		
		emp1.rank=34;
		
		try
		{
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			emp1 = (Emp)in.readObject();
			in.close();
			file.close();
			System.out.println("Deserialization successful!");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			System.out.println(ex);
		}
		catch (ClassNotFoundException ex)
		{
			System.out.println(ex);
		}
		
		printData(emp1);
		
	}

}
