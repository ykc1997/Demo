package excelSheet;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Writing {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException  
	{
		FileOutputStream file = new FileOutputStream("C:\\Users\\Dell\\eclipse-workspace\\Amazon\\testData1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("Student Info");  //Creating Sheet in excel file
		
		XSSFRow header = sheet.createRow(0);   // Creating 1st row i.e. header
		header.createCell(0).setCellValue("Sr.No.");
		header.createCell(1).setCellValue("Name");
		header.createCell(2).setCellValue("Address");
		header.createCell(3).setCellValue("Mobile No.");

		//Creating 2nd row & Inserting data
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("1");
		row1.createCell(1).setCellValue("Yogesh");
		row1.createCell(2).setCellValue("Pusad");
		row1.createCell(3).setCellValue("7741010704");

		//Creating 3rd row & Inserting data
		XSSFRow row2 = sheet.createRow(2);
		row2.createCell(0).setCellValue("2");
		row2.createCell(1).setCellValue("Anup");
		row2.createCell(2).setCellValue("Solapur");
		row2.createCell(3).setCellValue("2222222222");

		//Creating 4th row & Inserting data
		XSSFRow row3 = sheet.createRow(3);
		row3.createCell(0).setCellValue("3");
		row3.createCell(1).setCellValue("Bhima");
		row3.createCell(2).setCellValue("Pune");
		row3.createCell(3).setCellValue("3333333333");

		wb.write(file);
		//wb.close();

		System.out.println("Congratulations you wrote the data in Excel sheet Successfully..");
	}

}
