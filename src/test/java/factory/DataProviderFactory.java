package factory;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;

//we need this it will create object and return object directly so we dont haev to create object everytime

public class DataProviderFactory {
	
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config=new ConfigDataProvider();
		return config;
	}

	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel=new ExcelDataProvider();
		return excel;
	}
}
