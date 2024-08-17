package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFileTxt {

    public static void main(String[] args) throws FileNotFoundException {

        // Abrir o arquivo
        FileInputStream receiveFile = new FileInputStream(
                new File("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo.txt"));
        Scanner readFile = new Scanner(receiveFile, "UTF-8");

        // Lista para armazenar objetos do tipo Person
        List<Person> p = new ArrayList<Person>();

        // Ler o arquivo linha por linha
        while (readFile.hasNext()) {
            String line = readFile.nextLine();

            if (line != null && !line.isEmpty()) {
           	
                String[] dados = line.split("\\;");
                // split delimita o tipo de marcador sera usasdo ex. "\\|"

                // Criar um novo objeto Person e setar os valores
                
             Person person = new Person ();
             person.setName(dados[0].trim());
             person.setEmail(dados[1].trim());
             person.setAge(Integer.parseInt(dados[2].trim()));
             //trim Retorna o valor da string com os espaços removidos
             
             p.add(person);
             
            }
        }
        for (Person person : p)
      System.out.println(person );
    }
}
