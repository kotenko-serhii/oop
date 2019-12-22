package ua.khpi.oop.kotenko08;

import java.io.File;
import java.util.Scanner;

public class Files {
	public static File[] getListOfFiles(String path) {
		File f = new File(path); 
		File[] list =  f.listFiles();
		return list;
	}

	public static void printListOfFiles(File[] list) {
		for (int i = 0; i < list.length; i++) { 
            System.out.println(i+1 + ") " +list[i].getName()); 
        } 
	}

	public static String chooseFile(File[] list) {
		 printListOfFiles(list);
		 System.out.println("Выберите подкаталог или файл:");
		 @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		 int index = in.nextInt();
		 try {
			 return new String(list[index-1].getAbsolutePath());
		 }catch(ArrayIndexOutOfBoundsException e) {
			 System.out.println("Значение вне массива!");
			 return "C:\\Users\\Сергей\\eclipse-workspace\\kotenko-serhii";
		 }
	}

	public static String createFile(String path) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String newPath = path + File.separator + in.nextLine();
		return new File(newPath).getAbsolutePath();
	}

	public static String moveHigher(String path) {
		return new StringBuilder(path).delete(path.lastIndexOf(File.separator),path.length()).toString();
	}
}
