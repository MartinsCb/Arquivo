package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApachePoiEdit2 {

    public static void main(String[] args) throws IOException {

        File file = new File(
                "C:\\Users\\marti\\git\\repository5\\arquivos\\src\\arquivos\\arquivo_excel.xls");

        FileInputStream entrada = new FileInputStream(file);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); // Prepara a entrada do arquivo
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0); // Pega a planilha
        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()) {
            Row linha = linhaIterator.next();

            String cellValue = linha.getCell(0).getStringCellValue();//ediat uma celula ja existente 
            linha.getCell(0).setCellValue(cellValue + " value recording in the class");
           
        }
        entrada.close();

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida); // Escrita para a saída
        saida.flush();
        saida.close();

        hssfWorkbook.close(); // Fecha o workbook para liberar recursos

        System.out.println("SpreadSheet Updated");
    }
}
