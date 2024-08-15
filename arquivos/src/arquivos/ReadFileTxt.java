package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileTxt {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileInputStream receiveFile = new FileInputStream
				(new File("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo.txt"));
		Scanner readFile = new Scanner(receiveFile, "UTF-8");
		
		while (readFile.hasNext()) {
			String line = readFile.nextLine();
			
			if (line != null && !line.isEmpty()) {
			
			System.out.println(line);
			}
		}
	}

}
