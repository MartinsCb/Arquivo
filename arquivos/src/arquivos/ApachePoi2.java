package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoi2 {

    public static void main(String[] args) throws IOException {
        
        FileInputStream entrada = new FileInputStream(new File(
                "C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo_excel.xls"));
        
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // Prepara o arquivo para leitura
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pega a primeira planilha
        Iterator<Row> linhaIterator = planilha.iterator();
        
        List<Person> pessoas = new ArrayList<Person>();
        
        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();
            Iterator<Cell> celula = linha.iterator();
            
            Person person = new Person();
            
            while (celula.hasNext()) {
                Cell cell = celula.next();
                
                switch (cell.getColumnIndex()) {
                    case 0: // Coluna Nome
                        if (cell.getCellType() == CellType.STRING) {
                            person.setName(cell.getStringCellValue());
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            person.setName(String.valueOf(cell.getNumericCellValue()));
                        }
                        break;
                    case 1: // Coluna Email
                        if (cell.getCellType() == CellType.STRING) {
                            person.setEmail(cell.getStringCellValue());
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            person.setEmail(String.valueOf(cell.getNumericCellValue()));
                        }
                        break;
                    case 2: // Coluna Idade
                        if (cell.getCellType() == CellType.NUMERIC) {
                            person.setAge(Double.valueOf(cell.getNumericCellValue()).intValue());
                        } else if (cell.getCellType() == CellType.STRING) {
                            person.setAge(Integer.parseInt(cell.getStringCellValue()));
                        }
                        break;
                }
            }
            pessoas.add(person);
        }
        entrada.close();
        
        for (Person person : pessoas) {
            System.out.println(person);
        }
    }
}
