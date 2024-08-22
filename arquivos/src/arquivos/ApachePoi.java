package arquivos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo_excel.xls");

        if (!file.exists()) { // cria um arquivo se não existir 
            file.createNewFile();

            // Criação de objetos Person
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

            List<Person> personList = new ArrayList<>();
            personList.add(person1);
            personList.add(person2);
            personList.add(person3);

            HSSFWorkbook hssfworkbook = new HSSFWorkbook();
            // HSSFWorkbook é usado para escrever na planilha 
            HSSFSheet personSheet = hssfworkbook.createSheet("People Spreadsheet"); // cria a planilha 

            int lineNumber = 0;
            for (Person p : personList) {
                Row line = personSheet.createRow(lineNumber++); // criando a linha na planilha 

                int cellNumber = 0;
                Cell nameCell = line.createCell(cellNumber++); // criando a célula para o nome 
                nameCell.setCellValue(p.getName());

                Cell emailCell = line.createCell(cellNumber++); // criando a célula para o email
                emailCell.setCellValue(p.getEmail());

                Cell ageCell = line.createCell(cellNumber++); // criando a célula para a idade
                ageCell.setCellValue(p.getAge());
            }

            FileOutputStream exit = new FileOutputStream(file);
            hssfworkbook.write(exit); // escreve a planilha no arquivo
            exit.flush();
            exit.close();
        }
        System.out.println("SpreadSheet created");
    }
}
