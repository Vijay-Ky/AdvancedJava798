package app1;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class M  
{  
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws Exception  
	{  
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system", "admin");
		
		Statement stmt = con.createStatement();
		String id, name, age;
		
		//obtaining input bytes from a file  
		FileInputStream fis = new FileInputStream("src/app1/students.xlsx");  
		//creating workbook instance that refers to .xls file  
//		HSSFWorkbook wb = new HSSFWorkbook(fis);   
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		//creating a Sheet object to retrieve the object  
		//HSSFSheet sheet = wb.getSheetAt(0); 
		XSSFSheet sheet = wb.getSheetAt(0); 
		//evaluating cell type   
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();  
		for(Row row: sheet)     //iteration over row using for each loop  
		{  
			for(Cell cell: row)    //iteration over cell using for each loop  
			{  
				switch(formulaEvaluator.evaluateInCell(cell).getCellType())  
				{  
					case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type  
						//getting the value of the cell as a number  
						System.out.print(cell.getNumericCellValue()+ "\t\t");   
						//Number m = cell.getNumericCellValue();
						//String sql1 = "INSERT INTO PERSON VALUES(" + cell.getNumericCellValue() + ",'" + cell.getNumericCellValue() + "'," + cell.getNumericCellValue() + ")";
//						stmt.execute(sql1);
						break;  
					case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
						//getting the value of the cell as a string  
						System.out.print(cell.getStringCellValue()+ "\t\t");
//						String sql2 = "INSERT INTO PERSON VALUES(" + cell.getStringCellValue() + ",'" + cell.getStringCellValue() + "'," + cell.getStringCellValue() + ")";
//						stmt.execute(sql2);
//						break;  
				}  
			}  
			System.out.println();  
		}  
		con.close();
		
		System.out.println("done");
	}  
}  