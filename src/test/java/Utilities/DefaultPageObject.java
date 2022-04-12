package Utilities;



import static com.mongodb.client.model.Filters.eq;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
/*import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.thucydides.core.pages.PageObject;

public class DefaultPageObject extends PageObject {

	public static Properties prop;
	//public static Logger logger = LogManager.getLogger(DefaultPageObject.class.getName());
	//-new public static final Logger logger = LogManager.getLogger(DefaultPageObject.class);

//encryption

	private static SecretKeySpec secretKey;
	private static byte[] key;

	private static String decryptedString;
	private static String encryptedString;
	
	public DefaultPageObject() {

		prop = new Properties();
		
		//-new	PropertyConfigurator.configure(prop);
		InputStream inputstream = getClass().getClassLoader().getResourceAsStream("config.properties");
		//prop.setProperty("log4j.appender.File.File", "C:/Users/kann2359.KSPLAD/eclipse-workspace/Framework-cucmber-serenity/logs" + "File Name");
		//String log4jConfPath = "C:/Users/kann2359.KSPLAD/eclipse-workspace/Framework-cucmber-serenity/src/test/resources/log4j2.properties";
		
		//PropertyConfigurator.configure(log4jConfPath);
		//BasicConfigurator.configure();
		try {

			prop.load(inputstream);
			//-new	logger.info("property file loaded");
			/*logger.trace("We've just greeted the user!");
			logger.debug("We've just greeted the user!");
			logger.info("We've just greeted the user!");
			logger.warn("We've just greeted the user!");
			logger.error("We've just greeted the user!");
			logger.fatal("We've just greeted the user!");*/

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//Application webtable

	public void webtable1(String Applicationid_new, String action) throws InterruptedException {

		/*int overallRows = getDriver().findElements(By.xpath(
				"//kumaran-table/div/table/tbody/tr[@class='even-row kumTr ng-star-inserted' or @class='kumTr odd-row ng-star-inserted']"))
				.size();*/
		int overallRows = getDriver().findElements(By.xpath(
		"//*[contains(@class,'even-row') or contains(@class,'odd-row')]"))
		.size();	
		

		outer: for (int i = 1; i <= overallRows; i++) {

			List<WebElement> elements = getDriver().findElements(By.xpath(
					"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
							+ i + "]/td"));

			int siz = elements.size();

			for (int column = 0; column < siz; column++) {

				String celtext = elements.get(column).getText();

				System.out.println(celtext + " ");

				if ((Applicationid_new).equalsIgnoreCase(celtext))

				{

					if (action.equals("add")) {

				/*		getDriver().findElement(By.xpath(
								"//kumaran-table/div/table/tbody/tr[@class='even-row kumTr ng-star-inserted' or @class='kumTr odd-row ng-star-inserted']["
										+ i + "]/td[5]/div/div[1]"))
								.click();*/
						
						getDriver().findElement(By.xpath(
								"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
										+ i + "]/td[5]/div/div[1]"))
								.click();

						//-new	logger.info("add icon is clicked for the" + Applicationid_new);
						Thread.sleep(5000);
						break outer;

					} else if (action.equals("edit")) {

						getDriver().findElement(By.xpath(
								"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
										+ i + "]/td[5]/div/div[2]"))
								.click();

						//-new	logger.info("edit icon is clicked for the" + Applicationid_new);
						Thread.sleep(5000);
						break outer;
					}

					else if (action.equals("view")) {

						getDriver().findElement(By.xpath(
								"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
										+ i + "]/td[5]/div/div[3]"))
								.click();

						//-new	logger.info("view icon is clicked for the" + Applicationid_new);
						Thread.sleep(5000);
						break outer;

					} else if (action.equals("expand")) {
						getDriver().findElement(By.xpath(
								"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
										+ i + "]/td[5]/div/div[4]"))
								.click();
						//-new	logger.info("expand icon is clicked for the" + Applicationid_new);
						Thread.sleep(5000);
						break outer;
					}

				}
			}

		}
		// return action;

	}

//job_webtable	

	public void job_webtable(String portal_ref_id) throws InterruptedException {

		int j = 1;
		int k = 0;

		//List<WebElement> por_ref_id = getDriver().findElements(By.xpath(
			//	"//kumaran-table/div/table/tbody/tr[@class='data-row even-row kumTr ng-star-inserted' or @class='data-row kumTr odd-row ng-star-inserted']"));

		List<WebElement> por_ref_id = getDriver().findElements(By.xpath("//*[contains(@class,'even-row') or contains(@class,'odd-row')]"));	
		
		
		int overallRows = por_ref_id.size();

		for (int i = 1; i <= overallRows; i++) {

			/*List<WebElement> elements = getDriver().findElements(By.xpath(
					"//kumaran-table/div/table/tbody/tr[@class='data-row even-row kumTr ng-star-inserted' or @class='data-row kumTr odd-row ng-star-inserted']["
							+ i + "]/td"));*/
			
		List<WebElement> elements = getDriver().findElements(By.xpath(
					"//*[contains(@class,'even-row') or contains(@class,'odd-row')]["
							+ i + "]/td"));

			int siz = elements.size();

			if (i > 1) {

				j = i + 1 + k;
				k++;

			}

			for (int column = 0; column < siz; column++) {

				String celtext = elements.get(column).getText();

				System.out.println(celtext + " ");

				if (portal_ref_id.equals(celtext)) {

					JavascriptExecutor js = (JavascriptExecutor) getDriver();
					js.executeScript("javascript:window.scrollBy(250,350)");

					WebElement checkbox = getDriver()
							.findElement(By.xpath("//tbody/tr[" + (j) + "]/td[1]/kumaran-tbl-checkbox/div/div[2]"));

					Thread.sleep(3000);

					checkbox.click();

					Thread.sleep(3000);

					//-newlogger.info("checkbox is selected for the" + portal_ref_id);

				}

			}

		}

	}

//multi_select checkbox dropdown	

	public void multiselect_dropdown(String job_server2, String job_server_dropdown2) throws InterruptedException

	{

		List<WebElement> drop = getDriver().findElements(By.xpath(job_server_dropdown2));

		// List<WebElement> drop=getDriver().findElements(job_server_dropdown2);

		int drop_size = drop.size();

		for (int o = 0; o < drop_size; o++) {

			String drop_down_values = drop.get(o).getText();

			if (drop_down_values.equals(job_server2)) {

				Thread.sleep(3000);
				getDriver().findElement(By.xpath("/html/body/div/div[2]/ul/p-multiselectitem[" + (o + 1) + "]/li/span"))
						.click();
				Thread.sleep(3000);

				//-newlogger.info("drop down values are selected as " + job_server2);
				break;
			}

		}

	}

// normal dropdown

	public void normal_dropdown(String job_server2, String job_server_dropdown2) throws InterruptedException

	{

		List<WebElement> drop = getDriver().findElements(By.xpath(job_server_dropdown2));

		// List<WebElement> drop=getDriver().findElements(job_server_dropdown2);

		int drop_size = drop.size();

		for (int o = 0; o < drop_size; o++) {

			String drop_down_values = drop.get(o).getText();

			if (drop_down_values.equals(job_server2)) {

				Thread.sleep(3000);
				getDriver().findElement(By.xpath("/html/body/div/div/ul/p-dropdownitem[" + (o + 1) + "]/li/span"))
						.click();
				Thread.sleep(3000);

				//-new	logger.info("drop down values are selected as " + job_server2);

				break;
			}

		}

	}

//Mongo db query

	public static String query_params(String collection_name, String fieldname, String query_filter_col,
			String query_filter_value) throws InterruptedException {

		String result = null;

		String port_number = prop.getProperty("mongodb.port");
		int port = Integer.parseInt(port_number);

		MongoClient mongo = new MongoClient(prop.getProperty("mongodb.host"), port);

//password decryption
		
		DefaultPageObject key=new DefaultPageObject();

		final String strPssword = key.ReadCellData(1, 0);
		//final String strPssword ="rainarocks";
		DefaultPageObject.setKey(strPssword);
		final String strToDecrypt = prop.getProperty("mongodb.password");
		DefaultPageObject.decrypt(strToDecrypt.trim());

		MongoCredential credential;
		credential = MongoCredential.createCredential(prop.getProperty("mongodb.database"),
				prop.getProperty("mongodb.username"), DefaultPageObject.decryptedString.toCharArray());

		//-new	logger.info("Connected to the database successfull");

		MongoDatabase database = mongo.getDatabase(prop.getProperty("mongodb.database"));

		MongoCollection<Document> collection = database.getCollection(collection_name);

		DistinctIterable<String> embeddedField = collection.distinct(fieldname,
				eq(query_filter_col, query_filter_value), String.class);
		// System.out.println(embeddedField);

		Iterator it = embeddedField.iterator();
		while (it.hasNext()) {

			result = it.next().toString();
			Thread.sleep(3000);
			// System.out.println(it.next());
		}

		mongo.close();

		//-newlogger.info("Connection of database is closed");
		Thread.sleep(3000);

		return result;

	}

//Password decryption

	public static String decrypt(String strToDecrypt) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			DefaultPageObject.decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));

		} catch (Exception e) {

			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}

	public static void setKey(String myKey) {

		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			System.out.println(key.length);
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16); // use only first 128 bit
			System.out.println(key.length);
			System.out.println(new String(key, "UTF-8"));
			secretKey = new SecretKeySpec(key, "AES");

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//Read particular value from the excel
	
	public String ReadCellData(int vRow, int vColumn)  
	{  
	String value=null;           
	Workbook wb=null;            
	try  
	{  
	  
	FileInputStream fis=new FileInputStream("D:\\demo\\Secretkey.xlsx");  
  
	wb=new XSSFWorkbook(fis);  
	}  
	catch(FileNotFoundException e)  
	{  
	e.printStackTrace();  
	}  
	catch(IOException e1)  
	{  
	e1.printStackTrace();  
	}  
	Sheet sheet=wb.getSheetAt(0);    
	Row row=sheet.getRow(vRow);   
	Cell cell=row.getCell(vColumn);   
	value=cell.getStringCellValue();     
	return value;                
	} 

}

/*System.out.println("the implicit wait is"+getImplicitWaitTimeout());
System.out.println("the explicit wait is"+getWaitForTimeout());*/
