package utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import frameworkBasics.BaseMethods;

public class DataReader extends BaseMethods{
	
	public static String[][] readData(String dataWBookName) {

		String[][] data = null ;

		try {
			FileInputStream fis = new FileInputStream("./inputdata/"+dataWBookName+".xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			// get the number of rows
			int rowCount = sheet.getLastRowNum();
//			System.out.println(rowCount);

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
//			System.out.println(columnCount);
			data = new String[rowCount][columnCount];
			
			// loop through the rows
			for(int i=1; i <=rowCount; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){
								e.printStackTrace();
							}

							data[i-1][j]  = cellValue; // add each cell value to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			workbook.close(); // Close workbook
			fis.close(); // Close file stream
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data; // returns the collected data to the method call 
	}

}