

import Eraser.Eraser;
import java.util.Scanner;

public class EraserThreadDemo{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		while(true){
			System.out.print("Please input name:");
			String name = scanner.next();

			System.out.print("Please input password:");

			Eraser eraser = new Eraser('#');
			// start Thread
			Thread eraserT = new Thread(eraser);
			eraserT.start();
			String password = scanner.next();
			eraser.setActive(false);

			if("test".equals(name) && "test".equals(password)){
				System.out.println("Welcome");
				break;
			}
			else{
				System.out.println("Name or password error, please input again");
			}
		}
	}	
}
