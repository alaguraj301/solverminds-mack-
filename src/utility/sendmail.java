package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
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

import org.apache.commons.io.IOUtils;

import config.Keywords;
import reportGeneration.HtmlReport;

public class sendmail {

	public void mail() throws IOException {
		Properties props = new Properties();

		// this will set host of server- you can change based on your
		// requirement
		props.put("mail.smtp.host", "smtp.gmail.com.");

		// set the port of socket factory
		props.put("mail.smtp.socketFactory.port", "465");

		// set socket factory
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// set the authentication to true
		props.put("mail.smtp.auth", "true");

		// set the port of SMTP server
		props.put("mail.smtp.port", "465");

		// This will handle the complete authentication
		Session session = Session.getDefaultInstance(props,

				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication("testerworld301@gmail.com", "manasa@301");

					}

				});

		try {

			// Create object of MimeMessage class
			Message message = new MimeMessage(session);

			// Set the from address
			// message.setFrom(new InternetAddress("pushpakumaripush21@gmail.com"));

			message.setFrom(new InternetAddress("testerworld301@gmail.com", "NoReply"));

			// Set the recipient address

			String recipient = ExcelUtil.MailToAddre;
			String[] recipientList = recipient.split(";");

			InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];

			int counter = 0;

			for (String recipient1 : recipientList) {
				recipientAddress[counter] = new InternetAddress(recipient1.trim());
				counter++;
			}

			message.setRecipients(Message.RecipientType.TO, recipientAddress);

			// message.setRecipients(Message.RecipientType.TO,
			// InternetAddress.parse(recipientAddress));

			// Add the subject link

			// message.setSubject("MACK STANDARD PMS MODULES" + ExcelUtil.ScreenName + "_" +
			// ExcelUtil.Testcycle);
			message.setSubject("EXTERNAL INSPECTION OFFICE" + ExcelUtil.ScreenName + "_" + ExcelUtil.Testcycle);

			// message.setSubject("DAILY JOB TOOLS" + ExcelUtil.ScreenName + "_" +
			// ExcelUtil.Testcycle);

			// Create object to add multimedia type content

			// Set the body of email
			// body of the email from html file

			StringWriter writer = new StringWriter();

			IOUtils.copy(new FileInputStream(new File(
					"F:\\mack project reports\\report\\" + ExcelUtil.ScreenName + "_" + HtmlReport.date + ".html")),
					writer, "ISO-8859-1");

			// creates message part
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1.setContent(writer.toString(), "text/html");

			// Create another object to add another content
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();

			// Mention the file which you want to send

			// Create data source and pass the filename

			// File Pdffile = new File("D:\\e drive\\seliniumReport\\" +
			// ExcelUtil.ScreenName+"_"+Keywords.date + ".PDF");

			String Pdffile = "F:\\mack project reports\\report\\" + ExcelUtil.ScreenName + "_" + Keywords.date + ".PDF";

			DataSource source = new FileDataSource(Pdffile);

			// set the handler
			messageBodyPart2.setDataHandler(new DataHandler(source));

			// set the file
			// messageBodyPart2.setFileName("Pdffile");

			messageBodyPart2.setFileName(new File(Pdffile).getName());

			// Create object of MimeMultipart class
			Multipart multipart = new MimeMultipart();

			// add body part 1
			multipart.addBodyPart(messageBodyPart2);

			// add body part 2
			multipart.addBodyPart(messageBodyPart1);

			// set the content
			message.setContent(multipart);

			// finally send the email
			Transport.send(message);

			System.out.println("=====Email Sent=====");

		} catch (MessagingException e1) {

			throw new RuntimeException(e1);

		}
	}
}