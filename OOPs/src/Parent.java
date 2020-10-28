class Parent { 
	private void m1() 
	{ 
		System.out.println("From parent m1()"); 
	} 

	protected void m2() 
	{ 
		System.out.println("From parent m2()"); 
	} 
} 

class Child extends Parent { 
	private void m1() 
	{ 
		System.out.println("From child m1()"); 
	} 

	@Override
	public void m2() 
	{ 
		System.out.println("From child m2()"); 
	} 
} 

class Main { 
	public static void main(String[] args) 
	{ 
		Parent obj1 = new Parent(); 
		obj1.m2(); 
		Parent obj2 = new Child(); 
      	Child obj3 = new Child(); 
      	//Child obj4= (Child) new Parent();
		obj1.m2(); 
     //	obj1.m1();
	} 
} 
