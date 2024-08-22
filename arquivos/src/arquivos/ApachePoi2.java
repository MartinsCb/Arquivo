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

        // Abre o arquivo Excel
        FileInputStream entrada = new FileInputStream(new File(
                "C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo_excel.xls"));

        // Prepara o arquivo para leitura
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pega a primeira planilha
        Iterator<Row> linhaIterator = planilha.iterator();

        // Lista para armazenar objetos Person
        List<Person> pessoas = new ArrayList<>();

        // Itera sobre as linhas da planilha
        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();
            Iterator<Cell> celulaIterator = linha.iterator();

            // Cria um novo objeto Person para cada linha
            Person person = new Person();

            // Itera sobre as células da linha
            while (celulaIterator.hasNext()) {
                Cell cell = celulaIterator.next();

                // Verifica o índice da coluna para processar os dados corretamente
                switch (cell.getColumnIndex()) {
                    case 0: // Nome
                        if (cell.getCellType() == CellType.STRING) {
                            person.setName(cell.getStringCellValue());
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            person.setName(String.valueOf(cell.getNumericCellValue()));
                        }
                        break;

                    case 1: // Email
                        if (cell.getCellType() == CellType.STRING) {
                            person.setEmail(cell.getStringCellValue());
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            person.setEmail(String.valueOf(cell.getNumericCellValue()));
                        }
                        break;

                    case 2: // Idade
                        if (cell.getCellType() == CellType.NUMERIC) {
                            person.setAge((int) cell.getNumericCellValue());
                        } else if (cell.getCellType() == CellType.STRING) {
                            try {
                                person.setAge(Integer.parseInt(cell.getStringCellValue()));
                            } catch (NumberFormatException e) {
                                System.out.println("Erro ao converter idade: " + e.getMessage());
                            }
                        }
                        break;
                }
            }

            // Adiciona o objeto Person à lista
            pessoas.add(person);
        }

        // Fecha o arquivo
        entrada.close();

        // Imprime os dados das pessoas
        for (Person person : pessoas) {
            System.out.println(person);
        }
    }
}
