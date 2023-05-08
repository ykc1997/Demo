package excelSheet;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Reading 
{
	public static String[][] readData() throws EncryptedDocumentException, IOException 
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\Amazon\\configuration.xlsx");
		Sheet dataSheet = WorkbookFactory.create(file).getSheet("ConfigData");
		int rowCount = dataSheet.getLastRowNum();
		short totalCell = dataSheet.getRow(rowCount).getLastCellNum();
		int cellCount = totalCell-1;
		
		System.out.println(rowCount);
		System.out.println(cellCount);
		
		String cellValue [][] = new String[rowCount+1][cellCount+1];
		
		for (int i = 0; i <= rowCount; i++) 
		{
			for (int j = 0; j <= cellCount; j++) 
			{	//DataFormatter df = new DataFormatter();
				//cellValue[i][j] = df.formatCellValue(dataSheet.getRow(i).getCell(j));
				
				cellValue[i][j] = dataSheet.getRow(i).getCell(j).getStringCellValue();
			}
			
		}
		return cellValue;
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		String[][] abc = readData();
		for (int i = 0; i < abc.length; i++) 
		{
			for (int j = 0; j < abc.length; j++) 
			{
				System.out.print(abc[i][j]+" ");
			}
			System.out.println();
		}
	}
}
