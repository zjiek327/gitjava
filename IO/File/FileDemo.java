

import java.io.*;
import java.util.*;

public class FileDemo{
	public static void main(String[] args){
		try{
			File file = new File(args[0]);
			if(file.isFile()){
				System.out.print(args[0] + " file:");
				System.out.print(file.canRead() ? "readable" : "unreadable");
				System.out.print(file.canWrite() ? "-writable" : "-unwritable");
				System.out.println();
				System.out.println("length:" + file.length() + "bytes");
			}
			else{ // list all file or directory
				File[] files = file.listFiles();
				ArrayList<File> fileList = new ArrayList<File>();

				for(int i=0; i<files.length; i++){
					if(files[i].isDirectory()){
						System.out.println("[" + files[i].getPath() + "]");
					}
					else{
						// add file to @fileList
						fileList.add(files[i]);
					}
				}

				// show all file
				for(File f : fileList){
					System.out.println(f.toString());
				}
				System.out.println();
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("using: java FileDemo <pathname>");
		}
	}	
}
