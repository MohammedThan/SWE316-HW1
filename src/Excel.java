import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.logging.LogManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.temporal.IsoFields;
import java.util.ArrayList;

import com.aspose.cells.Column;
import com.aspose.cells.ColumnCollection;
import com.aspose.cells.Range;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import javax.lang.model.util.ElementScanner6;

import org.apache.logging.log4j.spi.LoggerContext;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.Configurator;
import org.apache.poi.xdgf.util.Util;  


class Excel{
    String pFile;
    String sFile;
    String sdFile;
    String msFile="src/mergeStages.xls";

    Excel(String projectsFile, String stagesFile, String stagesDetaildFile){
        pFile = projectsFile;
        sFile = stagesFile;
        sdFile = stagesDetaildFile;
    }

    ArrayList ReadFile(String filename) throws IOException{

    try
    {


    //obtaining input bytes from a file  
    FileInputStream fis=new FileInputStream(new File(filename));  

    //creating workbook instance that refers to .xls file  
    HSSFWorkbook wb=new HSSFWorkbook(fis);   

    //creating a Sheet object to retrieve the object  
    HSSFSheet sheet=wb.getSheetAt(0); 

    int rows=sheet.getLastRowNum();
    int cols=sheet.getRow(0).getLastCellNum();

    ArrayList rowsList= new ArrayList();
    ArrayList colsList= new ArrayList();


    for(int r=0;r<=rows;r++){

        colsList= new ArrayList();
        HSSFRow row=sheet.getRow(r);

        for(int c=0;c<cols;c++){

            HSSFCell cell =row.getCell(c,Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

            if(cell==null){
                colsList.add(null);
            
            }
            else if(cell.getCellType()==CellType.STRING){
                if(IsDate(cell.getStringCellValue())){

                colsList.add(cell.getStringCellValue());

                }else {
                colsList.add(cell.getStringCellValue());
                }
            }
            else if(DateUtil.isCellDateFormatted(cell)){
                
                colsList.add(new Date(DateUtil.getJavaDate(cell.getNumericCellValue()).getTime())); 
            }
            else if(cell.getCellType() == CellType.NUMERIC){


                colsList.add(cell.getNumericCellValue());

            }else{
                throw new Exception("invalid cell type: " + cell.getCellType());
            }
            }
            rowsList.add(colsList);

        }
            
        return rowsList;


    }   catch (Exception e){
            e.printStackTrace();
    }
    return null; 
}

Boolean IsDate(String date){

    if(  date.contains(":"))
        return true;
    return false;
}

Date CreateDate(String date) throws Exception{


    if(date.contains(":")){


        return  new Date(Integer.parseInt(date.substring(6, 10))-1900,
        Integer.parseInt(date.substring(3, 5)),
        Integer.parseInt(date.substring(0, 2)));


    }else {
        throw new Exception("invalid date format"+ date);
    }
}

/**
 * 
 */
void mergeStages(){
    if (!new File(msFile).isFile()){

    try{
Workbook SourceBook1 = new Workbook(sFile);

    // Open the second excel file.
Workbook SourceBook2 = new Workbook(sdFile);


// Copy worksheets of second Excel file to the first workbook.
SourceBook1.combine(SourceBook2);


// Save the updated first excel file as a new file.
SourceBook1.save(sdFile);

// Open a Workbook.
Workbook workbook = new Workbook(sdFile);


// Add a worksheet named Summary_sheet
Worksheet summarySheet = workbook.getWorksheets().add("Summary_sheet");

// Iterate over worksheets to copy columns to the
// summary worksheet
String[] nameOfSourceWorksheets = { "Sheet1", "Sheet1 (2)" };
int totalCol = 0; 

for (String sheetName : nameOfSourceWorksheets) {

  Worksheet sourceSheet = workbook.getWorksheets().get(sheetName);
 
    // Get worksheet columns collection
    ColumnCollection columns = sourceSheet.getCells().getColumns();
    if(sheetName.equals("Sheet1 (2)")){
        columns.removeAt(0);
        columns.removeAt(0);
    }
    // copy column to summaySheet
    for (Column column : (Iterable<Column>) columns)
    {
        
      summarySheet.getCells().copyColumn(sourceSheet.getCells(), column.getIndex(), totalCol);
      totalCol = totalCol + 1;
        }
    
    

// Save the excel file.

    workbook.save(sdFile);

    Workbook wrDelete = new Workbook(sdFile);
    wrDelete.getWorksheets().removeAt(0);
    wrDelete.getWorksheets().removeAt(0);
    wrDelete.getWorksheets().removeAt(0);
    wrDelete.getWorksheets().removeAt(1);
    wrDelete.save(sdFile);


   
    }
    }catch(Exception e){
        e.printStackTrace();

    }
} 
else
    System.out.println("file exist");
}

}