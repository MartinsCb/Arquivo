package arquivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {

    public static void main(String[] args) {
    	
    	Person person1 = new Person();
    	person1.setName("Andre");
    	person1.setEmail("andremartins.a@outlook.com");
    	person1.setAge(33);
    	
    	Person person2 = new Person();
    	person2.setName("Delane");
    	person2.setEmail("delane@gmail.com");
    	person2.setAge(32);
    	
    	Person person3 = new Person();
    	person3.setName("Barbara");
    	person3.setEmail("barbara@gmail.com");
    	person3.setAge(34);
    	
    	//put on the list (person 1,2 and 3 )
    	//it can go for a database or any other sources
    	List<Person> person = new ArrayList<Person>();
    	person.add(person1);
    	person.add(person2);
    	person.add(person3);
    	
        try {
            // Define the file path
            File arquivo = new File("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo.txt");

            // Check if the file exists, if not, create it
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            // Use try-with-resources to manage FileWriter and ensure the file is closed properly
            try (FileWriter escreverArquivo = new FileWriter(arquivo)) {
                
              for (Person p : person) {
            	  escreverArquivo.write(p.getName()+ " ; " + p.getEmail()+ " ; " + p.getAge()+ "\n");
            
              }
                escreverArquivo.close();
                // No need to call flush() explicitly, close() will do it
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
