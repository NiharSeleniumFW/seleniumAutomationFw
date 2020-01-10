package com.Vtiger.GenericLib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


	public class FileLib {
		/**
		 * it is used to read the dT from comonData.properties file
		 * @param Key
		 * @return 
		 * @throws IOException 5
		 * @throws IOException
		 */		
		
		public String getPropertyData(String Key) throws IOException {
			FileInputStream fis = new FileInputStream(".//SeleniumWebDriver/commondata.properties.txt");
			Properties p = new Properties();
			p.load(fis);
			String value = p.getProperty(Key);
			return value;
		}
		/**
		 * it is used to read data from test scriptdata.xlsx file based on user  arguments
		 * @param Sheet name
		 * @param rowNum 
		 * @param celNum
		 * @returnString data
		 * @throws throwable
		 */
		// public String getExcellData(String sheetNum,int rowNum,int celNum) {
			//return null;
		}
		 //FileInputStream fis = new FileInputStream(); 

	//}


