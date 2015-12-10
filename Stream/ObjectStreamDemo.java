

import java.io.*;
import java.util.*;
import User.User;

public class ObjectStreamDemo{
	public static void main(String[] args){
		User[] users = {
			new User("cat", 1),	
			new User("dog", 2),	
			new User("snake", 3)
		};

		// write in new file
		writeObjectToFile(users, args[0]);

		try{
			// read file data
			users = readObjectFromFile(args[0]);
			// show the read data
			System.out.println("First read:");
			for(User user : users){
				System.out.printf("\tname:%s\t number:%d\n", user.getName(), user.getNumber());
			}

			users = new User[2];
			users[0] = new User("apple", 4);
			users[1] = new User("orange", 5);
			/* add new object into file */
			appendObjectToFile(users, args[0]);
			
			// read file data
			users = readObjectFromFile(args[0]);
			// show the read data
			System.out.println("After append write:");
			for(User user : users){
				System.out.printf("\tname:%s\t number:%d\n", user.getName(), user.getNumber());
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You have not input filename");
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------------------------------------
	// function: write object @objs into file @filename
	public static void writeObjectToFile(Object[] objs, String filename){
		File file = new File(filename);

		try{
			// new output stream and point to @file
			ObjectOutputStream objOStream = new ObjectOutputStream(new FileOutputStream(file));
			for(Object obj : objs){
				objOStream.writeObject(obj); // write into file
			}

			// close output stream
			objOStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

//----------------------------------------------------------------------------------------------------
	// function: read object from filename
	public static User[] readObjectFromFile(String filename) throws FileNotFoundException{
		File file = new File(filename);

		// if file not exist, excute exception code
		if(!file.exists())
			throw new FileNotFoundException();

		// use List collecte data which read from @file
		List<User> userList = new ArrayList<User>();

		try{
			// new output stream and point to @file
			FileInputStream fileIStream = new FileInputStream(file);
			ObjectInputStream objIStream = new ObjectInputStream(fileIStream);

			while(fileIStream.available() > 0){
				userList.add((User)objIStream.readObject());
			}

			// close input stream
			objIStream.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}

		User[] users = new User[userList.size()];

		return userList.toArray(users);
	}

//----------------------------------------------------------------------------------------------------
	// function: append write object @objs into file @filename
	public static void appendObjectToFile(Object[] objs, String filename){
		File file = new File(filename);

		// if file not exist, excute exception code
		//if(!file.exists())
		//	throw new FileNotFoundException();

		try{
			// append mode
			// new output stream and point to @file
			ObjectOutputStream objOStream = 
				new ObjectOutputStream(new FileOutputStream(file, true)){
					protected void writeStreamHeader() throws IOException{}
				};

			for(Object obj : objs){
				objOStream.writeObject(obj); // write into file
			}

			// close output stream
			objOStream.close();
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}// end function appendObjectToFile

}// end class ObjectStreamDemo
