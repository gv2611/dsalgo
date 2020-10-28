class Book
{
	int pageNumbers;
	int bookMark;
	String authorName;
	int coverType;
	Book(int pageNumbers, int bookMark, String authorName)
	{
		this.pageNumbers=pageNumbers;
		this.bookMark=bookMark;
		this.authorName=authorName;
	}
}

class ContactsManager
{
	
}


public class OOPs {
	String str=new String();

	public static void main(String[] args) {
		
		Book tagore=new Book(345,23,"Rabindranath Tagore");
		Book murakami=new Book (87,8,"Haruki Murakami");
		System.out.println("Number of pages in Book by "+tagore.authorName+" is "+tagore.pageNumbers+" and is bookmarked at page number "+tagore.bookMark);
		System.out.println("Number of pages in Book by "+murakami.authorName+" is "+murakami.pageNumbers+" and is bookmarked at page number "+murakami.bookMark);
		System.out.println(murakami.coverType);
		

	}

}
