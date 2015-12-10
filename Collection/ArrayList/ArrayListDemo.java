//package bin.ArrayList;

import java.util.*;

public class ArrayListDemo{
	public static void main(String[] args){
		int listLen = 0;
		int i = 0;

		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		
		System.out.println("Please input name(type 'quit' to end):");

		while(true){
			System.out.print("# ");	

			String input = scanner.next();
			if(input.equals("quit"))
				break;
			list.add(input);
		}

// generic
/*
		listLen = list.size();
		while(i < listLen){
			System.out.print(list.get(i++) + "  ");	
		}
		System.out.println();
*/

// use Iterator
/*
		Iterator iterator = list.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + "  ");	
		}
		System.out.println();
*/

		for(String s : list){
			System.out.print(s + "  ");
		}
		System.out.println();
	}	
}
