
package com.pagina.crud.desarrollo.models;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;


public class read {
     @SuppressWarnings({"unchecked", "rawtypes"})

    public static ArrayList readExcelFile(String fileName) {

        ArrayList cellArrayLisstHolder = new ArrayList();
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("C:\\Users\\SQA\\Downloads\\personasexcel.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);

            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();

                Iterator cells = row.cellIterator();

                ArrayList cellStoreArrayList = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    cellStoreArrayList.add(cell);
                    CellType cellType = cell.getCellType();
                    if (cellType == CellType.STRING) {
                        HSSFRichTextString strData = cell.getRichStringCellValue();
                        System.out.println("String data=" + strData.getString());
                    } else if (cellType == CellType.NUMERIC) {
                        double data = cell.getNumericCellValue();
                        System.out.println("Numeric data=" + data);
                    }
                }
                cellArrayLisstHolder.add(cellStoreArrayList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellArrayLisstHolder;
    }
}
