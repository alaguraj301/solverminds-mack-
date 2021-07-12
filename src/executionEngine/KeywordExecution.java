package executionEngine;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.logging.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.Keywords;
import config.SeleniumLib;
import configurationsetup.respository;
import jxl.read.biff.BiffException;
import reportGeneration.HtmlReport;
import utility.ExcelUtil;
import utility.Log;

public class KeywordExecution {
	public static String filepath;
	// public static String filepath = "E:\\Eclipse fils\\PMS_END_TO_END_FLOW.xls";
	// C:\Users\pushpakumari.d

	// public static String filepath =
	// "C:\\Users\\pushpakumari.d\\Downloads\\demo.xls";
	// @Test(invocationCount = 2)
	// @Test
	// public void Smoketesting() throws IOException, BiffException {

	public static void main(String[] args)
			throws IOException, InvalidFormatException, InterruptedException, BiffException {
		respository opj = new respository();
		opj.setup();

		filepath = respository.Filepath1;

		// ATUTestRecorder recorder;
		BasicConfigurator.configure();

		DOMConfigurator.configure("log4j.xml");
		Keywords.testRepName(filepath);
		Keywords.startTesting();
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); Date date =
		 * new Date(0); // Created object of ATUTestRecorders // Provide path to store
		 * videos and file name format. recorder = new
		 * ATUTestRecorder("H:\\ScriptVideos", "Testing-" + dateFormat.format(date),
		 * false); recorder.start();
		 */

		ExcelUtil excelSheet = new ExcelUtil();
		excelSheet.openSheet(filepath);
		Keywords.report.flush();
		File rephtmlFile = new File(
				"F:\\mack project reports\\report\\" + ExcelUtil.ScreenName + Keywords.date + ".html");

		// String filename = "D:\\e drive\\project\\New folder\\REPORT\\" +
		// ExcelUtil.ScreenName + Keywords.date + ".html";

		try {
			Desktop.getDesktop().browse(rephtmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HtmlReport nt = new HtmlReport();

		System.out.println("email process");

		try {
			nt.process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// recorder.stop();
		Log.info(
				"\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"

						+ "\nEXECUTION ENDED"
						+ "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}
}
