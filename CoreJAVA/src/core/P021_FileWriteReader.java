package core;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P021_FileWriteReader {
	public static void main(String[] args) throws IOException {
		String msg = "this msg will store by file writer and reader";
		
//		FileWriter fr = new FileWriter("t2.txt");
//		fr.write(msg);
//		fr.flush();
//		fr.close();
//		System.out.println("done");
		
		
		FileReader f = new FileReader("t2.txt");
		int i;
		while((i = f.read())!=-1) {
			System.out.print((char)i);
		}
	}
}
