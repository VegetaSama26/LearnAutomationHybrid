package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider()
	{
		File f= new File("./Configuration/config.properties");
		try 
		{
			FileInputStream fis=new FileInputStream(f);
			prop=new Properties();
			prop.load(fis);
			
		} catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	
	public String getApplicationURL()
	{
		String url=prop.getProperty("URL");
		return url;
	}
	
	public String getChromePath()
	{
		String cpath=prop.getProperty("ChromeDriver");
		return cpath;
	}
	
	public String getIEPath()
	{
		String iepath=prop.getProperty("IEDriver");
		return iepath;
	}
	
}
