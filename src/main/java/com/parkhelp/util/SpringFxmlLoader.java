package com.parkhelp.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringFxmlLoader {
	public  static ApplicationContext context=null;
	public static void  load () throws Exception{
			if(context==null){
				//eclipse
				context=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
				//jar
				//context=new ClassPathXmlApplicationContext("/resources/applicationContext.xml");
			}
	}

}
