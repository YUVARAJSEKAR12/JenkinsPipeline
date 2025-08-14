package com.app.pojo;


	import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

	public class ImageTextRead 
	{
		public static void main(String[] args) {
			ITesseract img = new Tesseract();
			img.setDatapath("C:\\Users\\Yazhlvan\\eclipse-workspace_newV\\ImageRead\\tessdata");
			try {
				String text = img.doOCR(new File("D:\\Study\\Selenium\\Okta-Captcha1.jpeg"));
				System.out.println(text);
				
			} catch (TesseractException e) {
				e.printStackTrace();
			}	
		}
		
	
}
