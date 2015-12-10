package HelloWorld;

import First.First;

public class HelloWorld{
	public static void main(String args[]){
		int a = 100;
		int r;
		First f = new First();
//		{
			f.setFirst(a);
			r = f.getFirst();
//		}

		System.out.println("Hello World in Ubuntu!");
		System.out.println(r);
	}
}
