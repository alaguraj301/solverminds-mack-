package reportGeneration;

import com.google.gson.Gson;

import config.Keywords;
import executionEngine.KeywordExecution;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import reportGeneration.Data;
import utility.ExcelUtil;
import utility.sendmail;

import com.itextpdf.html2pdf.HtmlConverter;

import jxl.Sheet;
import jxl.Workbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HtmlReport {

	static int Sno = 1;
	static String file;
	static File filecrt;
	static File sendmailfilecrt;

	static BufferedWriter bw;
	static FileWriter fw;

	static BufferedWriter mw;
	static FileWriter sw;

	ArrayList employees = new ArrayList();
	ArrayList testScenarioDescription = new ArrayList();
	ArrayList testCaseDescribtion = new ArrayList();
	ArrayList nameMo;
	FileInputStream fs;
	Workbook wbWorkbook;
	Sheet shSheet;
	String col;
	public static String Url;
	public static String ScreenName, Testcycle, TestEnvironment;
	ArrayList testD = new ArrayList();
	ArrayList testCD = new ArrayList();
	public static SimpleDateFormat sDF;
	public static String date;
	public static String STime;
	public static String endTime;
	public static long TotalTime;
	public static Date d1 = null;
	public static Date d2 = null;
	public static String executedBy;
	public static Date today = null;
	public static int count1 = 0;
	public static int count2 = 0;
	public static String t;
	public static String diffMinutes;
	public static int size = 0;
	public static int count3;

	public HtmlReport() {

	}

	public void process() throws IOException {

		try {

			ExcelUtil re = new ExcelUtil();
			HashMap<String, List<String>> hp = re.passA();
			testD = (ArrayList) hp.get("testScenarioDescription");

			// System.out.println("checkNewTesttestD:" + testD);

			testCD = (ArrayList) hp.get("testCaseDescribtion");

			// System.out.println("checkNewTesttestCD:" + testCD);

			System.out.println(testD.size());

			for (int i = 0; i < testD.size() - 1; i++) {

				// System.out.println(testD.get(i).toString());

				Data objEmployee1 = new Data();
				nameMo = Keywords.kuhaName(); // status
				// System.out.println("size of the status is" +
				// nameMo.size());
				objEmployee1.setTestScenarioDescription((String) testD.get(i));
				// System.out.println("TEST"+testD.get(i));

				objEmployee1.setTestCaseSteps((String) testCD.get(i));
				// System.out.println("TEST"+testCD.get(i)+i);

				objEmployee1.setStatus((String) nameMo.get(i));
				// System.out.println("TEST"+nameMo.get(i)+i);

				employees.add(objEmployee1);

			}

			// System.out.println("TEST");
			// System.out.println("employees size is=>" + employees.size());
			date();
			repName();
			createPage();
			getscenarioTemp();
			getReportTemplate();
			getData(employees);
			getSummary();
			destroyBW();
			getPage();

			/*
			 * insertmaster(ScreenName, executedBy, t, count1, count2,STime,endTime);
			 * //filling up parent table. conNw conobj = new conNw(); //calling database to
			 * fetch p_key which is the f_key for chield. Connection con = null;
			 * PreparedStatement pstmt = null; ResultSet rs = null; con =
			 * conobj.getconection(); String sql = "select Pk_report_Id from  Reportmaster";
			 * pstmt = con.prepareStatement(sql); rs = pstmt.executeQuery(); int
			 * Pk_report_Id=0; ArrayList ar = new ArrayList(); while(rs.next()){
			 * Pk_report_Id = rs.getInt("Pk_report_Id"); ar.add(Pk_report_Id); } int
			 * pk=(int)ar.get(ar.size()-1); System.out.println("index:===>"+pk);
			 * System.out.println("size:"+ar.size()); Thread.sleep(5000); for (int i = 0; i
			 * < testD.size(); i++){ insertchild((String) testD.get(i), (String)
			 * testCD.get(i),(String) nameMo.get(i),pk); //filling up child table. }
			 */

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		clear();
	}

	public static void date() {
		sDF = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		date = sDF.format(new Date());
		System.out.println(date);
	}

	public static void repName() {
		ExcelUtil ret = new ExcelUtil();
		HashMap<String, String> hp = ret.param();
		ScreenName = hp.get("ScreenName");

		Testcycle = hp.get("Testcycle");

		TestEnvironment = hp.get("TestEnvironment");

		Url = hp.get("Url");
	}

	public static void createPage() throws IOException {
		System.out.println("File created");
		file = "F:\\mack project reports\\report\\";
		filecrt = new File(file);
		filecrt.mkdir();
		// SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

		// String date = SDF.format(new Date());
		String newfile = "/" + ScreenName + "_" + date + ".html";
		filecrt = new File(file + newfile);
		if (!filecrt.exists()) {
			filecrt.createNewFile();
			System.out.println("File created");

		}

		System.out.println("File created");
		file = "F:\\mack project reports\\report\\";
		sendmailfilecrt = new File(file);
		sendmailfilecrt.mkdir();
		// SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmss");

		// String date = SDF.format(new Date());
		String mailnewfile = "/" + ScreenName + "_" + date + ".html";
		sendmailfilecrt = new File(file + mailnewfile);
		if (!sendmailfilecrt.exists()) {
			sendmailfilecrt.createNewFile();
			System.out.println("File created");

		}

	}

	public static void getscenarioTemp() throws IOException {
		fw = new FileWriter(filecrt);

		bw = new BufferedWriter(fw);

		sw = new FileWriter(sendmailfilecrt);

		mw = new BufferedWriter(sw);

		bw.write("<!DOCTYPE html>");

		mw.write("<!DOCTYPE html>");

		bw.newLine();
		mw.newLine();

		bw.write("<html lang='en'>");
		mw.write("<html lang='en'>");

		bw.newLine();
		mw.newLine();

		bw.write("<head><title>selenium automation report</title></head>");
		bw.newLine();
		bw.write("<meta charset='utf-8'>");
		bw.newLine();
		bw.write("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		bw.newLine();
		bw.write("<link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>");
		bw.newLine();
		bw.write("<script src='http://code.jquery.com/jquery-1.9.1.js'></script>");
		bw.newLine();
		bw.write("<script src='http://code.jquery.com/ui/1.10.3/jquery-ui.js'></script>");
		bw.newLine();
		bw.write("<script src='http://code.jquery.com/jquery-1.11.1.min.js'></script>");
		bw.newLine();
		bw.write("<script src='http://cdn.datatables.net/1.10.7/js/jquery.dataTables.min.js'></script>");
		bw.newLine();
		bw.write("<link href='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css' rel='stylesheet'>");
		bw.newLine();
		bw.write("<script src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js'></script>");
		bw.newLine();
		bw.write("<link rel='stylesheet' href='http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css'>");
		bw.newLine();
		bw.write(
				"<script type='text/javascript' src='http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js'></script>");
		bw.newLine();
		bw.write(
				"<script type='text/javascript' src='http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>");
		bw.newLine();
		bw.write("<script src='http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css'></script>");
		bw.newLine();
		bw.write("<script src='http://code.highcharts.com/highcharts.js'></script>");
		bw.newLine();
		bw.write("<script src='http://code.highcharts.com/modules/exporting.js'></script>");
		bw.newLine();
		bw.write(
				"<script src='http://cdn.datatables.net/plug-ins/1.10.7/integration/jqueryui/dataTables.jqueryui.css'></script>");
		bw.newLine();
		bw.write("<div class='container-fluid'>");
		bw.newLine();
		bw.write("<body>");
		bw.write("<script>" + "$(document).ready(function(){" + "$('#myTable').dataTable({" + "\"ordering\" : false,"
				+ "});" + "});");
		bw.newLine();
		bw.write("function sendimg(a){window.open(a,'newwindow','width=300,height=250');}</script>");
		bw.newLine();
		// bw.write("<h2>MACK STANDARD REPORT - PMS</h2>");
		// bw.write("<h2>MACK STANDARD REPORT - PROCUREMENT</h2>");
		bw.write("<h2>EXTERNAL INSPECTION OFFICE_</h2>");

		// bw.write("<h2>DAILY JOB TOOLS_</h2>");

	}

	public static void getReportTemplate() throws IOException {
		bw.write("<div class='row'>");
		bw.newLine();
		bw.write("<div class='col-md-8 column'>");
		bw.newLine();
		bw.write("<div class='panel panel-primary'>");
		bw.newLine();
		bw.write(" <div class='panel-heading'><strong>Execution Report</strong></div>");
		bw.newLine();
		bw.write("<div class='panel-body'>");
		bw.newLine();
		bw.write("<table id='myTable' class='table table-striped'>");
		bw.newLine();
		bw.write(
				"<thead><tr class='info'><th>TestCaseDescription</th><th>TestCaseSteps</th><th>Status</th></tr></thead>");
	}

	public static void getData(ArrayList employee) throws IOException {

		for (int i = 0; i < employee.size(); i++) {
			String testScenarioDescription = ((Data) employee.get(i)).getTestScenarioDescription();
			String testCaseSteps = ((Data) employee.get(i)).getTestCaseSteps();
			String status = ((Data) employee.get(i)).getStatus();
			if (testScenarioDescription.equals("null")) {
				testScenarioDescription = "";
			}

			if (testScenarioDescription != " ") {
				count3++;

			}
			if (testCaseSteps == null) {
				testCaseSteps = "";
			}

			if (status == null) {
				status = "";
			}
			bw.write("<tr><td>" + testScenarioDescription + "</td><td>" + testCaseSteps + "</td><td>" + status
					+ "</td></tr>");
			bw.newLine();

		}
	}

	@SuppressWarnings("static-access")
	public static void getSummary() throws IOException, ParseException {

		ArrayList nameMo = Keywords.kuhaName();// Retrieve the arraylist
		int size = nameMo.size();
		// System.out.println("size is=>" + size);
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < size; i++) {
			String s = (String) nameMo.get(i);
			if (s.contains("PASS")) {
				count1++;
			} else {
				// if (s.equalsIgnoreCase("fail")) {
				count2++;
				// }
			}
		}
		/*
		 * Log.info(
		 * "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"
		 * + "                                      TOTAL NO OF PASS :" + count1 +"" +
		 * "                                                            \nTOTAL NO OF FAIL :"
		 * + count2 + "\nEXECUTION ENDED" +
		 * "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
		 * );
		 */System.out.println("total nor of pass is:" + count1);
		System.out.println("total nor of fail is:" + count2);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date2 = new Date();
		Date today = null;
		try {
			today = dateFormat.parse(dateFormat.format(date2));
		} catch (ParseException ex) {
			Logger.getLogger(HtmlReport.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println(today);
		ExcelUtil ret = new ExcelUtil();
		HashMap<String, String> hp = ret.param();
		ScreenName = hp.get("ScreenName");
		Testcycle = hp.get("Testcycle");

		TestEnvironment = hp.get("TestEnvironment");

		Url = hp.get("Url");

		executedBy = hp.get("executedBy");

		// STime = hp.get("StartTime");

		STime = Keywords.startTime_1;

		System.out.println("start time is:----------------------->>>>>" + STime);
		date2 = new Date();
		SimpleDateFormat ft1 = new SimpleDateFormat("HH:mm:ss");
		endTime = ft1.format(date2);
		System.out.println("end time is: " + endTime);
		d1 = ft1.parse(STime);
		d2 = ft1.parse(endTime);
		long diff = d2.getTime() - d1.getTime();
		System.out.println("check--------->>>>>>" + diff);
		long diffSeconds = diff / 1000 % 60;
		System.out.println("long diff: " + diff);
		System.out.println("long diff: " + diffSeconds);
		long diffMinutes = diff / (60 * 1000) % 60;
		System.out.println("long diff: " + diffMinutes);
		// System.out.print("Testing--->"+Minutes.minutesBetween(d2,
		// d1).getMinutes() % 60 + " minutes, ");
		//
		// HashMap hmap = null;
		// hmap = new HashMap();
		// Gson gson = new Gson(); // obj-1
		// ArrayList JsonArray = new ArrayList();
		// //
		//
		// hmap.put("selenium", "Pass");
		// hmap.put("result", count1);
		// JsonArray.add(hmap);
		//
		// hmap = new HashMap();
		// hmap.put("selenium", "Fail");
		// hmap.put("result", count2);
		// JsonArray.add(hmap);
		//
		// gson = new Gson();//obj-2
		// String json = gson.toJson(JsonArray);
		// //
		// "dataProvider":"[{"result":6,"selenium":"Pass"},{"result":0,"selenium":"Fail"}]",
		// System.out.println("JsonArray:::::::::::::::::::::::::::::::::::::" +
		// json);
		//
		// bw.write("</table></div></div></div>");
		// bw.write("<div class='col-md-4 column'>");
		// bw.write("<div class='panel panel-primary'>");
		// bw.write("<meta http-equiv= 'content-type'
		// content='text/html;charset=UTF-8'/>");
		// bw.write("<div class='panel-heading'><strong>Test Result %</strong></div>");
		//
		// // Pie Chart-1
		// bw.write("<script src=\"js/AutoInRun.js\">");
		// bw.newLine();
		// bw.write("<script type='text/javascript'>(function(){var
		// k=window.AmCharts;k.AmSlicedChart=k.Class({inherits:k.AmChart,construct:function(a){this.createEvents(\"rollOverSlice\",\"rollOutSlice\",\"clickSlice\",\"pullOutSlice\",\"pullInSlice\",\"rightClickSlice\");k.AmSlicedChart.base.construct.call(this,a);this.colors=\"#FF0F00
		// #FF6600 #FF9E01 #FCD202 #F8FF01 #B0DE09 #04D215 #0D8ECF #0D52D1 #2A0CD0
		// #8A0CCF #CD0D74 #754DEB #DDDDDD #999999 #333333 #000000 #57032A #CA9726
		// #990000 #4B0C25\".split(\"
		// \");this.alpha=1;this.groupPercent=0;this.groupedTitle=\"Other\";this.groupedPulled=!1;this.groupedAlpha=1;this.marginLeft=0;this.marginBottom=this.marginTop=10;this.marginRight=0;this.hoverAlpha=1;this.outlineColor=\"#FFFFFF\";this.outlineAlpha=0;this.outlineThickness=1;this.startAlpha=0;this.startDuration=1;this.startEffect=\"bounce\";this.sequencedAnimation=!0;this.pullOutDuration=1;this.pullOutEffect=\"bounce\";this.pullOnHover=this.pullOutOnlyOne=!1;this.labelsEnabled=!0;this.labelTickColor=\"#000000\";this.labelTickAlpha=.2;this.hideLabelsPercent=0;this.urlTarget=\"_self\";this.autoMarginOffset=10;this.gradientRatio=[];this.maxLabelWidth=200;this.accessibleLabel=\"[[title]]:
		// [[percents]]% [[value]]
		// [[description]]\";k.applyTheme(this,a,\"AmSlicedChart\")},initChart:function(){k.AmSlicedChart.base.initChart.call(this);this.dataChanged&&(this.parseData(),this.dispatchDataUpdated=!0,this.dataChanged=!1,this.setLegendData(this.chartData));this.drawChart()},handleLegendEvent:function(a){var
		// b=a.type,c=a.dataItem,d=this.legend;if(c.wedge&&c){var
		// g=c.hidden;a=a.event;switch(b){case\"clickMarker\":g||d.switchable||this.clickSlice(c,a);break;case\"clickLabel\":g||this.clickSlice(c,a,!1);break;case\"rollOverItem\":g||this.rollOverSlice(c,!1,a);break;case\"rollOutItem\":g||this.rollOutSlice(c,a);break;case\"hideItem\":this.hideSlice(c,a);break;case\"showItem\":this.showSlice(c,a)}}},invalidateVisibility:function(){this.recalculatePercents();this.initChart();var
		// a=this.legend;a&&a.invalidatfpuseSize()},addEventListeners:function(a,b){var
		// c=this;a.mouseover(function(a){c.rollOverSlice(b,!0,a)}).mouseout(function(a){c.rollOutSlice(b,a)}).touchend(function(a){c.rollOverSlice(b,a)}).mouseup(function(a){c.clickSlice(b,a)}).contextmenu(function(a){c.handleRightClick(b,a)}).focus(function(a){c.rollOverSlice(b,a)}).blur(function(a){c.rollOutSlice(b,a)})},formatString:function(a,b,c){a=k.formatValue(a,b,[\"value\"],this.nf,\"\",this.usePrefixes,this.prefixesOfSmallNumbers,this.prefixesOfBigNumbers);var
		// d=this.pf.precision;isNaN(this.tempPrec)||(this.pf.precision=this.tempPrec);a=k.formatValue(a,b,[\"percents\"],this.pf);a=k.massReplace(a,{\"[[title]]\":b.title,\"[[description]]\":b.description});this.pf.precision=d;-1!=a.indexOf(\"[[\")&&(a=k.formatDataContextValue(a,b.dataContext));a=c?k.fixNewLines(a):k.fixBrakes(a);return
		// a=k.cleanFromEmpty(a)},startSlices:function(){var
		// a;for(a=0;a<this.chartData.length;a++)0<this.startDuration&&this.sequencedAnimation?this.setStartTO(a):this.startSlice(this.chartData[a])},setStartTO:function(a){var
		// b=this;a=setTimeout(function(){b.startSequenced.call(b)},b.startDuration/\r\n"
		// +
		// "b.chartData.length*500*a);b.timeOuts.push(a)},pullSlices:function(a){var
		// b=this.chartData,c;for(c=0;c<b.length;c++){var
		// d=b[c];d.pulled&&this.pullSlice(d,1,a)}},startSequenced:function(){var
		// a=this.chartData,b;for(b=0;b<a.length;b++)if(!a[b].started){this.startSlice(this.chartData[b]);break}},startSlice:function(a){a.started=!0;var
		// b=a.wedge,c=this.startDuration,d=a.labelSet;b&&0<c&&(0<a.alpha&&b.show(),b.translate(a.startX,a.startY),this.animatable.push(b),b.animate({opacity:1,translate:\"0,0\"},c,this.startEffect));d&&0<c&&(0<a.alpha&&d.show(),d.translate(a.startX,a.startY),d.animate({opacity:1,translate:\"0,0\"},c,this.startEffect))},showLabels:function(){var
		// a=this.chartData,b;for(b=0;b<a.length;b++){var c=a[b];if(0<c.alpha){var
		// d=c.label;d&&d.show();(c=c.tick)&&c.show()}}},showSlice:function(a){isNaN(a)?a.hidden=!1:this.chartData[a].hidden=!1;this.invalidateVisibility()},hideSlice:function(a){isNaN(a)?a.hidden=!0:this.chartData[a].hidden=!0;this.hideBalloon();this.invalidateVisibility()},rollOverSlice:function(a,b,c){isNaN(a)||(a=this.chartData[a]);clearTimeout(this.hoverInt);if(!a.hidden){this.pullOnHover&&this.pullSlice(a,1);1>this.hoverAlpha&&a.wedge&&a.wedge.attr({opacity:this.hoverAlpha});var
		// d=a.balloonX,g=a.balloonY;a.pulled&&(d+=a.pullX,g+=a.pullY);var
		// f=this.formatString(this.balloonText,a,!0),h=this.balloonFunction;h&&(f=h(a,f));h=k.adjustLuminosity(a.color,-.15);f?this.showBalloon(f,h,b,d,g):this.hideBalloon();0===a.value&&this.hideBalloon();this.fire({type:\"rollOverSlice\",dataItem:a,chart:this,event:c})}},rollOutSlice:function(a,b){isNaN(a)||(a=this.chartData[a]);a.wedge&&a.wedge.attr({opacity:1});this.hideBalloon();this.fire({type:\"rollOutSlice\",dataItem:a,chart:this,event:b})},clickSlice:function(a,b,c){this.checkTouchDuration(b)&&(isNaN(a)||(a=this.chartData[a]),a.pulled?this.pullSlice(a,0):this.pullSlice(a,1),k.getURL(a.url,this.urlTarget),c||this.fire({type:\"clickSlice\",dataItem:a,chart:this,event:b}))},handleRightClick:function(a,b){isNaN(a)||(a=this.chartData[a]);this.fire({type:\"rightClickSlice\",dataItem:a,chart:this,event:b})},drawTicks:function(){var
		// a=this.chartData,b;for(b=0;b<a.length;b++){var
		// c=a[b];if(c.label&&!c.skipTick){var
		// d=c.ty,d=k.line(this.container,[c.tx0,c.tx,c.tx2],[c.ty0,d,d],this.labelTickColor,this.labelTickAlpha);k.setCN(this,d,this.type+\"-tick\");k.setCN(this,d,c.className,!0);c.tick=d;c.wedge.push(d);\"AmFunnelChart\"==this.cname&&d.toBack()}}},initialStart:function(){var
		// a=this,b=a.startDuration,c=setTimeout(function(){a.showLabels.call(a)},1E3*b);a.timeOuts.push(c);a.chartCreated?a.pullSlices(!0):(a.startSlices(),0<b?(b=setTimeout(function(){a.pullSlices.call(a)},1200*b),a.timeOuts.push(b)):a.pullSlices(!0))},pullSlice:function(a,b,c){var
		// d=this.pullOutDuration;!0===c&&(d=0);if(c=a.wedge)0<d?(c.animate({translate:b*a.pullX+\",\"+b*a.pullY},d,this.pullOutEffect),a.labelSet&&a.labelSet.animate({translate:b*a.pullX+\",\"+b*a.pullY},d,this.pullOutEffect)):(a.labelSet&&a.labelSet.translate(b*a.pullX,b*a.pullY),c.translate(b*a.pullX,b*a.pullY));1==b?(a.pulled=!0,this.pullOutOnlyOne&&this.pullInAll(a.index),a={type:\"pullOutSlice\",dataItem:a,chart:this}):(a.pulled=!1,a={type:\"pullInSlice\",dataItem:a,chart:this});this.fire(a)},pullInAll:function(a){var
		// b=this.chartData,c;for(c=0;c<this.chartData.length;c++)c!=a&&b[c].pulled&&this.pullSlice(b[c],0)},pullOutAll:function(){var
		// a=this.chartData,b;for(b=0;b<a.length;b++)a[b].pulled||this.pullSlice(a[b],1)},parseData:function(){var
		// a=[];this.chartData=a;var
		// b=this.dataProvider;isNaN(this.pieAlpha)||(this.alpha=this.pieAlpha);if(void
		// 0!==b){var c=b.length,d=0,g,f,h;for(g=0;g<c;g++){f={};var
		// e=b[g];f.dataContext=e;null!==e[this.valueField]&&(f.value=Number(e[this.valueField]));(h=e[this.titleField])||(h=\"\");f.title=h;f.pulled=k.toBoolean(e[this.pulledField],!1);(h=e[this.descriptionField])||(h=\"\");f.description=h;f.labelRadius=Number(e[this.labelRadiusField]);f.switchable=!0;f.className=e[this.classNameField];f.url=e[this.urlField];h=e[this.patternField];!h&&this.patterns&&(h=this.patterns[g]);f.pattern=h;f.visibleInLegend=k.toBoolean(e[this.visibleInLegendField],!0);h=e[this.alphaField];f.alpha=void
		// 0!==h?Number(h):this.alpha;h=e[this.colorField];void
		// 0!==h&&(f.color=h);f.labelColor=k.toColor(e[this.labelColorField]);d+=f.value;f.hidden=!1;a[g]=f}for(g=b=0;g<c;g++)f=a[g],f.percents=f.value/d*100,f.percents<this.groupPercent&&b++;1<b&&(this.groupValue=0,this.removeSmallSlices(),a.push({title:this.groupedTitle,value:this.groupValue,percents:this.groupValue/d*100,pulled:this.groupedPulled,color:this.groupedColor,url:this.groupedUrl,description:this.groupedDescription,alpha:this.groupedAlpha,pattern:this.groupedPattern,className:this.groupedClassName,dataContext:{}}));c=this.baseColor;c||(c=this.pieBaseColor);d=this.brightnessStep;d||(d=this.pieBrightnessStep);for(g=0;g<a.length;g++)c?h=k.adjustLuminosity(c,g*d/100):(h=this.colors[g],void
		// 0===h&&(h=k.randomColor())),void
		// 0===a[g].color&&(a[g].color=h);this.recalculatePercents()}},recalculatePercents:function(){var
		// a=this.chartData,b=0,c,d;for(c=0;c<a.length;c++)d=a[c],!d.hidden&&0<d.value&&(b+=d.value);for(c=0;c<a.length;c++)d=this.chartData[c],d.percents=!d.hidden&&0<d.value?100*d.value/b:0},removeSmallSlices:function(){var
		// a=this.chartData,b;for(b=a.length-1;0<=b;b--)a[b].percents<this.groupPercent&&(this.groupValue+=a[b].value,a.splice(b,1))},animateAgain:function(){var
		// a=this;a.startSlices();for(var b=0;b<a.chartData.length;b++){var
		// c=a.chartData[b];c.started=!1;var
		// d=c.wedge;d&&(d.setAttr(\"opacity\",a.startAlpha),d.translate(c.startX,c.startY));if(d=c.labelSet)d.setAttr(\"opacity\",a.startAlpha),d.translate(c.startX,c.startY)}b=a.startDuration;0<b?(b=setTimeout(function(){a.pullSlices.call(a)},1200*b),a.timeOuts.push(b)):a.pullSlices()},measureMaxLabel:function(){var
		// a=this.chartData,b=0,c;for(c=0;c<a.length;c++){var
		// d=a[c],g=this.formatString(this.labelText,d),f=this.labelFunction;f&&(g=f(d,g));d=k.text(this.container,g,this.color,this.fontFamily,this.fontSize);g=d.getBBox().width;g>b&&(b=g);d.remove()}return
		// b}})})();(function(){var
		// k=window.AmCharts;k.AmPieChart=k.Class({inherits:k.AmSlicedChart,construct:function(a){this.type=\"pie\";k.AmPieChart.base.construct.call(this,a);this.cname=\"AmPieChart\";this.pieBrightnessStep=30;this.minRadius=10;this.depth3D=0;this.startAngle=90;this.angle=this.innerRadius=0;this.startRadius=\"500%\";this.pullOutRadius=\"20%\";this.labelRadius=20;this.labelText=\"[[title]]:
		// [[percents]]%\";this.balloonText=\"[[title]]: [[percents]]%
		// ([[value]])\\n[[description]]\";this.previousScale=1;this.adjustPrecision=!1;this.gradientType=\"radial\";k.applyTheme(this,a,this.cname)},drawChart:function(){k.AmPieChart.base.drawChart.call(this);var
		// a=this.chartData;if(k.ifArray(a)){if(0<this.realWidth&&0<this.realHeight){k.VML&&(this.startAlpha=1);var
		// b=this.startDuration,c=this.container,d=this.updateWidth();this.realWidth=d;var
		// g=this.updateHeight();this.realHeight=g;var
		// f=k.toCoordinate,h=f(this.marginLeft,d),e=f(this.marginRight,d),z=f(this.marginTop,g)+this.getTitleHeight(),n=f(this.marginBottom,g)+this.depth3D,A,B,m,w=k.toNumber(this.labelRadius),q=this.measureMaxLabel();q>this.maxLabelWidth&&(q=this.maxLabelWidth);this.labelText&&this.labelsEnabled||(w=q=0);A=void
		// 0===this.pieX?(d-h-e)/2+h:f(this.pieX,this.realWidth);B=void
		// 0===this.pieY?(g-z-n)/2+z:f(this.pieY,g);m=f(this.radius,d,g);m||(d=0<=w?d-h-e-2*q:d-h-e,g=g-z-n,m=Math.min(d,g),g<d&&(m/=1-this.angle/90,m>d&&(m=d)),g=k.toCoordinate(this.pullOutRadius,m),m=(0<=w?m-1.8*(w+g):m-1.8*g)/2);m<this.minRadius&&(m=this.minRadius);g=f(this.pullOutRadius,m);\r\n"
		// +
		// "z=k.toCoordinate(this.startRadius,m);f=f(this.innerRadius,m);f>=m&&(f=m-1);n=k.fitToBounds(this.startAngle,0,360);0<this.depth3D&&(n=270<=n?270:90);n-=90;360<n&&(n-=360);d=m-m*this.angle/90;for(h=q=0;h<a.length;h++)e=a[h],!0!==e.hidden&&(q+=k.roundTo(e.percents,this.pf.precision));q=k.roundTo(q,this.pf.precision);this.tempPrec=NaN;this.adjustPrecision&&100!=q&&(this.tempPrec=this.pf.precision+1);for(var
		// E,h=0;h<a.length;h++)if(e=a[h],!0!==e.hidden&&(this.showZeroSlices||0!==e.percents)){var
		// r=360*e.percents/100,q=Math.sin((n+r/2)/180*Math.PI),C=d/m*-Math.cos((n+r/2)/180*Math.PI),p=this.outlineColor;p||(p=e.color);var
		// u=this.alpha;isNaN(e.alpha)||(u=e.alpha);p={fill:e.color,stroke:p,\"stroke-width\":this.outlineThickness,\"stroke-opacity\":this.outlineAlpha,\"fill-opacity\":u};e.url&&(p.cursor=\"pointer\");p=k.wedge(c,A,B,n,r,m,d,f,this.depth3D,p,this.gradientRatio,e.pattern,this.path,this.gradientType);k.setCN(this,p,\"pie-item\");k.setCN(this,p.wedge,\"pie-slice\");k.setCN(this,p,e.className,!0);this.addEventListeners(p,\r\n"
		// +
		// "e);e.startAngle=n;a[h].wedge=p;0<b&&(this.chartCreated||p.setAttr(\"opacity\",this.startAlpha));e.ix=q;e.iy=C;e.wedge=p;e.index=h;e.label=null;u=c.set();if(this.labelsEnabled&&this.labelText&&e.percents>=this.hideLabelsPercent){var
		// l=n+r/2;0>l&&(l+=360);360<l&&(l-=360);var
		// t=w;isNaN(e.labelRadius)||(t=e.labelRadius,0>t&&(e.skipTick=!0));var
		// r=A+q*(m+t),D=B+C*(m+t),x,v=0;isNaN(E)&&350<l&&1<a.length-h&&(E=h-1+Math.floor((a.length-h)/2));if(0<=t){var
		// y;90>=l&&0<=l?(y=0,x=\"start\",v=8):90<=l&&180>l?(y=1,\r\n"
		// +
		// "x=\"start\",v=8):180<=l&&270>l?(y=2,x=\"end\",v=-8):270<=l&&354>=l?(y=3,x=\"end\",v=-8):354<=l&&(h>E?(y=0,x=\"start\",v=8):(y=3,x=\"end\",v=-8));e.labelQuarter=y}else
		// x=\"middle\";l=this.formatString(this.labelText,e);(t=this.labelFunction)&&(l=t(e,l));t=e.labelColor;t||(t=this.color);\"\"!==l&&(l=k.wrappedText(c,l,t,this.fontFamily,this.fontSize,x,!1,this.maxLabelWidth),k.setCN(this,l,\"pie-label\"),k.setCN(this,l,e.className,!0),l.translate(r+1.5*v,D),0>w&&(l.node.style.pointerEvents=\"none\"),l.node.style.cursor=\"default\",e.ty=D,e.textX=r+1.5*v,u.push(l),this.axesSet.push(u),e.labelSet=u,e.label=l,this.addEventListeners(u,e));e.tx=r;e.tx2=r+v;e.tx0=A+q*m;e.ty0=B+C*m}r=f+(m-f)/2;e.pulled&&(r+=g);this.accessible&&this.accessibleLabel&&(D=this.formatString(this.accessibleLabel,e),this.makeAccessible(p,D));void
		// 0!==this.tabIndex&&p.setAttr(\"tabindex\",this.tabIndex);e.balloonX=q*r+A;e.balloonY=C*r+B;e.startX=Math.round(q*z);e.startY=Math.round(C*z);e.pullX=Math.round(q*g);e.pullY=Math.round(C*g);this.graphsSet.push(p);\r\n"
		// +
		// "if(0===e.alpha||0<b&&!this.chartCreated)p.hide(),u&&u.hide();n+=360*e.percents/100;360<n&&(n-=360)}0<w&&this.arrangeLabels();this.pieXReal=A;this.pieYReal=B;this.radiusReal=m;this.innerRadiusReal=f;0<w&&this.drawTicks();this.initialStart();this.setDepths()}(a=this.legend)&&a.invalidateSize()}else
		// this.cleanChart();this.dispDUpd()},setDepths:function(){var
		// a=this.chartData,b;for(b=0;b<a.length;b++){var
		// c=a[b],d=c.wedge,c=c.startAngle;0<=c&&180>c?d.toFront():180<=c&&d.toBack()}},arrangeLabels:function(){var
		// a=this.chartData,b=a.length,c,d;for(d=b-1;0<=d;d--)c=a[d],0!==c.labelQuarter||c.hidden||this.checkOverlapping(d,c,0,!0,0);for(d=0;d<b;d++)c=a[d],1!=c.labelQuarter||c.hidden||this.checkOverlapping(d,c,1,!1,0);for(d=b-1;0<=d;d--)c=a[d],2!=c.labelQuarter||c.hidden||this.checkOverlapping(d,c,2,!0,0);for(d=0;d<b;d++)c=a[d],3!=c.labelQuarter||c.hidden||this.checkOverlapping(d,c,3,!1,0)},checkOverlapping:function(a,b,c,d,g){var
		// f,h,e=this.chartData,k=e.length,n=b.label;if(n){if(!0===d)for(h=a+1;h<k;h++)e[h].labelQuarter==c&&(f=this.checkOverlappingReal(b,e[h],c))&&(h=k);else
		// for(h=a-1;0<=h;h--)e[h].labelQuarter==c&&(f=this.checkOverlappingReal(b,e[h],c))&&(h=0);!0===f&&200>g&&isNaN(b.labelRadius)&&(f=b.ty+3*b.iy,b.ty=f,n.translate(b.textX,f),this.checkOverlapping(a,b,c,d,g+1))}},checkOverlappingReal:function(a,b,c){var
		// d=!1,g=a.label,f=b.label;a.labelQuarter!=c||a.hidden||b.hidden||!f||(g=g.getBBox(),c={},c.width=g.width,c.height=g.height,c.y=a.ty,c.x=a.tx,a=f.getBBox(),f={},f.width=a.width,f.height=a.height,f.y=b.ty,f.x=b.tx,k.hitTest(c,f)&&(d=!0));return
		// d}})})();</script>");
		// bw.newLine();
		// //
		// bw.write("<script
		// type='text/javascript'>AmCharts.translations.export||(AmCharts.translations.export={}),AmCharts.translations.export.en||(AmCharts.translations.export.en={\"fallback.save.text\":\"CTRL
		// + C to copy the data into the
		// clipboard.\",\"fallback.save.image\":\"Rightclick -> Save picture as... to
		// save the
		// image.\",\"capturing.delayed.menu.label\":\"{{duration}}\",\"capturing.delayed.menu.title\":\"Click
		// to
		// cancel\",\"menu.label.print\":\"Print\",\"menu.label.undo\":\"Undo\",\"menu.label.redo\":\"Redo\",\"menu.label.cancel\":\"Cancel\",\"menu.label.save.image\":\"Download
		// as ...\",\"menu.label.save.data\":\"Save as
		// ...\",\"menu.label.draw\":\"Annotate
		// ...\",\"menu.label.draw.change\":\"Change ...\",\"menu.label.draw.add\":\"Add
		// ...\",\"menu.label.draw.shapes\":\"Shape
		// ...\",\"menu.label.draw.colors\":\"Color
		// ...\",\"menu.label.draw.widths\":\"Size
		// ...\",\"menu.label.draw.opacities\":\"Opacity
		// ...\",\"menu.label.draw.text\":\"Text\",\"menu.label.draw.modes\":\"Mode
		// ...\",\"menu.label.draw.modes.pencil\":\"Pencil\",\"menu.label.draw.modes.line\":\"Line\",\"menu.label.draw.modes.arrow\":\"Arrow\",\"label.saved.from\":\"Saved
		// from: \"}),AmCharts.export=function(e,t){var
		// a,i={name:\"export\",version:\"1.4.74\",libs:{async:!0,autoLoad:!0,reload:!1,resources:[\"fabric.js/fabric.min.js\",\"FileSaver.js/FileSaver.min.js\",{\"jszip/jszip.min.js\":[\"xlsx/xlsx.min.js\"],\"pdfmake/pdfmake.min.js\":[\"pdfmake/vfs_fonts.js\"]}],namespaces:{\"pdfmake.min.js\":\"pdfMake\",\"jszip.min.js\":\"JSZip\",\"xlsx.min.js\":\"XLSX\",\"fabric.min.js\":\"fabric\",\"FileSaver.min.js\":\"saveAs\"},loadTimeout:1e4,unsupportedIE9libs:[\"pdfmake.min.js\",\"jszip.min.js\",\"xlsx.min.js\"]},config:{},setup:{chart:e,hasBlob:!1,wrapper:!1,isIE:!!window.document.documentMode,IEversion:window.document.documentMode,hasTouch:\"object\"==typeof
		// window.Touch,focusedMenuItem:void 0,hasClasslist:\"classList\"in
		// document.createElement(\"_\")},drawing:{enabled:!1,undos:[],redos:[],buffer:{position:{x1:0,y1:0,x2:0,y2:0,xD:0,yD:0}},handler:{undo:function(e,t){var
		// a=i.drawing.undos.pop();if(a){a.selectable=!0,i.drawing.redos.push(a),\"added\"==a.action&&i.setup.fabric.remove(a.target);var
		// r=JSON.parse(a.state);a.target.set(r),a.target instanceof
		// fabric.Group&&i.drawing.handler.change({color:r.cfg.color,width:r.cfg.width,opacity:r.cfg.opacity},!0,a.target),i.setup.fabric.renderAll()}},redo:function(e,t){var
		// a=i.drawing.redos.pop();if(a){a.selectable=!0,i.drawing.undos.push(a),\"added\"==a.action&&i.setup.fabric.add(a.target);var
		// r=JSON.parse(a.state);a.target.recentState=a.state,a.target.set(r),a.target
		// instanceof
		// fabric.Group&&i.drawing.handler.change({color:r.cfg.color,width:r.cfg.width,opacity:r.cfg.opacity},!0,a.target),i.setup.fabric.renderAll()}},done:function(e){i.drawing.enabled=!1,i.drawing.buffer.enabled=!1,i.drawing.undos=[],i.drawing.redos=[],i.createMenu(i.config.menu),i.setup.fabric.deactivateAll(),i.isElement(i.setup.wrapper)&&i.isElement(i.setup.wrapper.parentNode)&&i.setup.wrapper.parentNode.removeChild&&(i.setup.wrapper.parentNode.removeChild(i.setup.wrapper),i.setup.wrapper=!1)},add:function(e){var
		// t=i.deepMerge({top:i.setup.fabric.height/2,left:i.setup.fabric.width/2},e||{});(-1!=t.url.indexOf(\".svg\")?fabric.loadSVGFromURL:fabric.Image.fromURL)(t.url,function(e,a){var
		// r=void
		// 0!==a?fabric.util.groupSVGElements(e,a):e,n=!1;(r.height>i.setup.fabric.height||r.width>i.setup.fabric.width)&&(n=i.setup.fabric.height/2/r.height),t.top>i.setup.fabric.height&&(t.top=i.setup.fabric.height/2),t.left>i.setup.fabric.width&&(t.left=i.setup.fabric.width/2),i.drawing.buffer.isDrawing=!0,r.set({originX:\"center\",originY:\"center\",top:t.top,left:t.left,width:n?r.width*n:r.width,height:n?r.height*n:r.height,fill:i.drawing.color}),i.setup.fabric.add(r)})},change:function(e,t,a){var
		// r,n,o,s=i.deepMerge({},e||{}),l=a||i.drawing.buffer.target,d=l?l._objects?l._objects:[l]:null;if(s.mode&&(i.drawing.mode=s.mode),s.width&&(i.drawing.width=s.width,i.drawing.fontSize=s.fontSize=3*s.width,1==i.drawing.width&&(i.drawing.fontSize=s.fontSize=i.defaults.fabric.drawing.fontSize)),s.fontSize&&(i.drawing.fontSize=s.fontSize),s.color&&(i.drawing.color=s.color),s.opacity&&(i.drawing.opacity=s.opacity),(o=i.getRGBA(i.drawing.color)).pop(),o.push(i.drawing.opacity),i.drawing.color=\"rgba(\"+o.join()+\")\",i.setup.fabric.freeDrawingBrush.color=i.drawing.color,i.setup.fabric.freeDrawingBrush.width=i.drawing.width,l){for((r=JSON.parse(l.recentState).cfg)&&(s.color=s.color||r.color,s.width=s.width||r.width,s.opacity=s.opacity||r.opacity,s.fontSize=s.fontSize||r.fontSize,(o=i.getRGBA(s.color)).pop(),o.push(s.opacity),s.color=\"rgba(\"+o.join()+\")\"),n=0;n<d.length;n++)d[n]instanceof
		// fabric.Text||d[n]instanceof fabric.PathGroup||d[n]instanceof
		// fabric.Triangle?((s.color||s.opacity)&&d[n].set({fill:s.color}),s.fontSize&&d[n].set({fontSize:s.fontSize})):(d[n]instanceof
		// fabric.Path||d[n]instanceof fabric.Line)&&(l instanceof
		// fabric.Group?(s.color||s.opacity)&&d[n].set({stroke:s.color}):((s.color||s.opacity)&&d[n].set({stroke:s.color}),s.width&&d[n].set({strokeWidth:s.width})));t||(r=JSON.stringify(i.deepMerge(l.saveState()._stateProperties,{cfg:{color:s.color,width:s.width,opacity:s.opacity}})),l.recentState=r,i.drawing.redos=[],i.drawing.undos.push({action:\"modified\",target:l,state:r})),i.setup.fabric.renderAll()}},text:function(e){var
		// t=i.deepMerge({text:i.i18l(\"menu.label.draw.text\"),top:i.setup.fabric.height/2,left:i.setup.fabric.width/2,fontSize:i.drawing.fontSize,fontFamily:i.setup.chart.fontFamily||\"Verdana\",fill:i.drawing.color},e||{});t.click=function(){};var
		// a=new fabric.IText(t.text,t);return
		// i.drawing.buffer.isDrawing=!0,i.setup.fabric.add(a),i.setup.fabric.setActiveObject(a),a.selectAll(),a.enterEditing(),a},line:function(e){var
		// t,a,r,n,o=i.deepMerge({x1:i.setup.fabric.width/2-i.setup.fabric.width/10,x2:i.setup.fabric.width/2+i.setup.fabric.width/10,y1:i.setup.fabric.height/2,y2:i.setup.fabric.height/2,angle:90,strokeLineCap:i.drawing.lineCap,arrow:i.drawing.arrow,color:i.drawing.color,width:i.drawing.width,group:[]},e||{}),s=new
		// fabric.Line([o.x1,o.y1,o.x2,o.y2],{stroke:o.color,strokeWidth:o.width,strokeLineCap:o.strokeLineCap});if(o.group.push(s),o.arrow&&(o.angle=o.angle?o.angle:i.getAngle(o.x1,o.y1,o.x2,o.y2),\"start\"==o.arrow?(r=o.y1+o.width/2,n=o.x1+o.width/2):\"middle\"==o.arrow?(r=o.y2+o.width/2-(o.y2-o.y1)/2,n=o.x2+o.width/2-(o.x2-o.x1)/2):(r=o.y2+o.width/2,n=o.x2+o.width/2),a=new
		// fabric.Triangle({top:r,left:n,fill:o.color,height:7*o.width,width:7*o.width,angle:o.angle,originX:\"center\",originY:\"bottom\"}),o.group.push(a)),i.drawing.buffer.isDrawing=!0,\"config\"!=o.action){if(o.arrow){var
		// l=new fabric.Group(o.group);return
		// l.set({cfg:o,fill:o.color,action:o.action,selectable:!0,known:\"change\"==o.action}),\"change\"==o.action&&i.setup.fabric.setActiveObject(l),i.setup.fabric.add(l),l}return
		// i.setup.fabric.add(s),s}for(t=0;t<o.group.length;t++)o.group[t].ignoreUndo=!0,i.setup.fabric.add(o.group[t]);return
		// o}}},defaults:{position:\"top-right\",fileName:\"amCharts\",action:\"download\",overflow:!0,path:(e.path||\"\")+\"plugins/export/\",formats:{JPG:{mimeType:\"image/jpg\",extension:\"jpg\",capture:!0},PNG:{mimeType:\"image/png\",extension:\"png\",capture:!0},SVG:{mimeType:\"text/xml\",extension:\"svg\",capture:!0},PDF:{mimeType:\"application/pdf\",extension:\"pdf\",capture:!0},CSV:{mimeType:\"text/plain\",extension:\"csv\"},JSON:{mimeType:\"text/plain\",extension:\"json\"},XLSX:{mimeType:\"application/octet-stream\",extension:\"xlsx\"}},fabric:{backgroundColor:\"#FFFFFF\",removeImages:!0,forceRemoveImages:!1,selection:!1,loadTimeout:5e3,drawing:{enabled:!0,arrow:\"end\",lineCap:\"butt\",mode:\"pencil\",modes:[\"pencil\",\"line\",\"arrow\"],color:\"#000000\",colors:[\"#000000\",\"#FFFFFF\",\"#FF0000\",\"#00FF00\",\"#0000FF\"],shapes:[\"11.svg\",\"14.svg\",\"16.svg\",\"17.svg\",\"20.svg\",\"27.svg\"],width:1,fontSize:11,widths:[1,5,10,15],opacity:1,opacities:[1,.8,.6,.4,.2],menu:void
		// 0,autoClose:!0},border:{fill:\"\",fillOpacity:0,stroke:\"#000000\",strokeWidth:1,strokeOpacity:1}},pdfMake:{images:{},pageOrientation:\"portrait\",pageMargins:40,pageOrigin:!0,pageSize:\"A4\",pageSizes:{\"4A0\":[4767.87,6740.79],\"2A0\":[3370.39,4767.87],A0:[2383.94,3370.39],A1:[1683.78,2383.94],A2:[1190.55,1683.78],A3:[841.89,1190.55],A4:[595.28,841.89],A5:[419.53,595.28],A6:[297.64,419.53],A7:[209.76,297.64],A8:[147.4,209.76],A9:[104.88,147.4],A10:[73.7,104.88],B0:[2834.65,4008.19],B1:[2004.09,2834.65],B2:[1417.32,2004.09],B3:[1000.63,1417.32],B4:[708.66,1000.63],B5:[498.9,708.66],B6:[354.33,498.9],B7:[249.45,354.33],B8:[175.75,249.45],B9:[124.72,175.75],B10:[87.87,124.72],C0:[2599.37,3676.54],C1:[1836.85,2599.37],C2:[1298.27,1836.85],C3:[918.43,1298.27],C4:[649.13,918.43],C5:[459.21,649.13],C6:[323.15,459.21],C7:[229.61,323.15],C8:[161.57,229.61],C9:[113.39,161.57],C10:[79.37,113.39],RA0:[2437.8,3458.27],RA1:[1729.13,2437.8],RA2:[1218.9,1729.13],RA3:[864.57,1218.9],RA4:[609.45,864.57],SRA0:[2551.18,3628.35],SRA1:[1814.17,2551.18],SRA2:[1275.59,1814.17],SRA3:[907.09,1275.59],SRA4:[637.8,907.09],EXECUTIVE:[521.86,756],FOLIO:[612,936],LEGAL:[612,1008],LETTER:[612,792],TABLOID:[792,1224]}},menu:void
		// 0,divId:null,menuReviver:null,menuWalker:null,fallback:!0,keyListener:!0,fileListener:!0,compress:!0,debug:!1},listenersToRemove:[],i18l:function(e,t){var
		// a=t||(i.setup.chart.language?i.setup.chart.language:\"en\");return(AmCharts.translations[i.name][a]||AmCharts.translations[i.name].en)[e]||e},download:function(e,t,a){if(window.saveAs&&i.setup.hasBlob)i.toBlob({data:e,type:t},function(e){saveAs(e,a)});else
		// if(i.config.fallback&&\"text/plain\"==t){var
		// r=document.createElement(\"div\"),n=document.createElement(\"div\"),o=document.createElement(\"textarea\");n.innerHTML=i.i18l(\"fallback.save.text\"),r.appendChild(n),r.appendChild(o),n.setAttribute(\"class\",\"amcharts-export-fallback-message\"),r.setAttribute(\"class\",\"amcharts-export-fallback\"),i.setup.chart.containerDiv.appendChild(r),o.setAttribute(\"readonly\",\"\"),o.value=e,o.focus(),o.select(),i.createMenu([{class:\"export-main
		// export-close\",label:\"Done\",click:function(){i.createMenu(i.config.menu),i.isElement(i.setup.chart.containerDiv)&&i.setup.chart.containerDiv.removeChild(r)}}])}else{if(!i.config.fallback||\"image\"!=t.split(\"/\")[0])throw
		// new Error(\"Unable to create file. Ensure saveAs (FileSaver.js) is
		// supported.\");var
		// r=document.createElement(\"div\"),n=document.createElement(\"div\"),s=i.toImage({data:e});n.innerHTML=i.i18l(\"fallback.save.image\"),r.appendChild(n),r.appendChild(s),n.setAttribute(\"class\",\"amcharts-export-fallback-message\"),r.setAttribute(\"class\",\"amcharts-export-fallback\"),i.setup.chart.containerDiv.appendChild(r),i.createMenu([{class:\"export-main
		// export-close\",label:\"Done\",click:function(){i.createMenu(i.config.menu),i.isElement(i.setup.chart.containerDiv)&&i.setup.chart.containerDiv.removeChild(r)}}])}return
		// e},loadResource:function(e,t){function a(){i.handleLog([\"amCharts[export]:
		// Loading error on \",this.src||this.href].join(\"\"))}function
		// r(){if(t)for(n=0;n<t.length;n++)i.loadResource(t[n])}var
		// n,o,s,l=-1!=e.indexOf(\"//\")?e:[i.libs.path,e].join(\"\");for(-1!=e.indexOf(\".js\")?((s=document.createElement(\"script\")).setAttribute(\"type\",\"text/javascript\"),s.setAttribute(\"src\",l),i.libs.async&&s.setAttribute(\"async\",\"\")):-1!=e.indexOf(\".css\")&&((s=document.createElement(\"link\")).setAttribute(\"type\",\"text/css\"),s.setAttribute(\"rel\",\"stylesheet\"),s.setAttribute(\"href\",l)),n=0;n<document.head.childNodes.length;n++)if(p=document.head.childNodes[n],c=!!p&&(p.src||p.href),!!p&&p.tagName,p&&c&&-1!=c.indexOf(e)){i.libs.reload&&document.head.removeChild(p),o=!0;break}for(n
		// in i.libs.namespaces){var
		// d=i.libs.namespaces[n],c=e.toLowerCase(),p=n.toLowerCase();if(-1!=c.indexOf(p)){if(i.setup.isIE&&i.setup.IEversion<=9&&i.libs.unsupportedIE9libs&&-1!=i.libs.unsupportedIE9libs.indexOf(p))return;if(void
		// 0!==window[d]){o=!0;break}}}o&&!i.libs.reload||(s.addEventListener(\"load\",r),i.addListenerToRemove(\"load\",s,r),s.addEventListener(\"error\",a),i.addListenerToRemove(\"error\",s,a),document.head.appendChild(s))},addListenerToRemove:function(e,t,a){i.listenersToRemove.push({node:t,method:a,event:e})},loadDependencies:function(){var
		// e,t;if(i.libs.autoLoad)for(e=0;e<i.libs.resources.length;e++)if(i.libs.resources[e]instanceof
		// Object)for(t in
		// i.libs.resources[e])i.loadResource(t,i.libs.resources[e][t]);else
		// i.loadResource(i.libs.resources[e])},pxToNumber:function(e,t){if(e||!t)return
		// Number(String(e).replace(\"px\",\"\"))||0},numberToPx:function(e){return
		// String(e)+\"px\"},cloneObject:function(e){var
		// t,a,r,n,o;t=Array.isArray(e)?[]:{};for(r in
		// e)n=\"object\"==typeof(a=e[r]),o=a instanceof
		// Date,t[r]=n&&!o?i.cloneObject(a):a;return t},deepMerge:function(e,t,a){var
		// r,n,o=t instanceof Array?\"array\":\"object\";if(!(e instanceof Object||e
		// instanceof Array))return e;for(r in
		// t)\"array\"==o&&isNaN(r)||(n=t[r],(e&&void 0==e[r]||a)&&(n instanceof
		// Array?e[r]=new Array:n instanceof Function?e[r]=function(){}:n instanceof
		// Date?e[r]=new Date:n instanceof Object?e[r]=new Object:n instanceof
		// Number?e[r]=new Number:n instanceof String&&(e[r]=new String)),(n instanceof
		// Object||n instanceof Array)&&!(n instanceof Function||n instanceof
		// Date||i.isElement(n))&&\"chart\"!=r&&\"scope\"!=r?i.deepMerge(e[r],n,a):e
		// instanceof Array&&!a?e.push(n):e&&(e[r]=n));return
		// e},isElement:function(e){return e instanceof
		// Object&&e&&1===e.nodeType},isHashbanged:function(e){var
		// t=String(e).replace(/\\\"/g,\"\");return\"url\"==t.slice(0,3)&&t.slice(t.indexOf(\"#\")+1,t.length-1)},isPressed:function(e){return\"mousemove\"==e.type&&1===e.which||(\"touchmove\"==e.type||1===e.buttons||1===e.button||1===e.which?i.drawing.buffer.isPressed=!0:i.drawing.buffer.isPressed=!1),i.drawing.buffer.isPressed},removeImage:function(e){if(e){if(i.config.fabric.forceRemoveImages)return!0;if(i.config.fabric.removeImages&&i.isTainted(e))return!0;if(i.setup.isIE&&(10==i.setup.IEversion||11==i.setup.IEversion)&&-1!=e.toLowerCase().indexOf(\".svg\"))return!0}return!1},isTainted:function(e){var
		// t=String(window.location.origin||window.location.protocol+\"//\"+window.location.hostname+(window.location.port?\":\"+window.location.port:\"\"));if(e){if(-1!=t.indexOf(\":\\\\\")||-1!=e.indexOf(\":\\\\\")||-1!=t.indexOf(\"file://\")||-1!=e.indexOf(\"file://\"))return!0;if(-1!=e.indexOf(\"//\")&&-1==e.indexOf(t.replace(/.*:/,\"\")))return!0}return!1},isSupported:function(){return!!i.config.enabled&&!(i.setup.isIE&&i.setup.IEversion<=9&&(!Array.prototype.indexOf||!document.head||!1===i.config.fallback))},getAngle:function(e,t,a,i){var
		// r=a-e,n=i-t;return
		// 180*(0==r?0==n?0:n>0?Math.PI/2:3*Math.PI/2:0==n?r>0?0:Math.PI:r<0?Math.atan(n/r)+Math.PI:n<0?Math.atan(n/r)+2*Math.PI:Math.atan(n/r))/Math.PI},gatherAttribute:function(e,t,a,r){var
		// n,r=r||0,a=a||3;return
		// e&&!(n=e.getAttribute(t))&&r<a?i.gatherAttribute(e.parentNode,t,a,r+1):n},gatherClassName:function(e,t,a,r){var
		// n,r=r||0,a=a||3;if(i.isElement(e)){if(!(n=-1!=(e.getAttribute(\"class\")||\"\").split(\"
		// \").indexOf(t))&&r<a)return
		// i.gatherClassName(e.parentNode,t,a,r+1);n&&(n=e)}return
		// n},gatherElements:function(e,t,a){var
		// r,n;for(r=0;r<e.children.length;r++){var
		// o=e.children[r];if(\"clipPath\"==o.tagName){var
		// s={},l=fabric.parseTransformAttribute(i.gatherAttribute(o,\"transform\"));for(n=0;n<o.childNodes.length;n++)o.childNodes[n].setAttribute(\"fill\",\"transparent\"),s={x:i.pxToNumber(o.childNodes[n].getAttribute(\"x\")),y:i.pxToNumber(o.childNodes[n].getAttribute(\"y\")),width:i.pxToNumber(o.childNodes[n].getAttribute(\"width\")),height:i.pxToNumber(o.childNodes[n].getAttribute(\"height\"))};e.clippings[o.id]={svg:o,bbox:s,transform:l}}else
		// if(\"pattern\"==o.tagName){var
		// d={node:o,source:o.getAttribute(\"xlink:href\"),width:Number(o.getAttribute(\"width\")),height:Number(o.getAttribute(\"height\")),repeat:\"repeat\",offsetX:0,offsetY:0};for(n=0;n<o.childNodes.length;n++)\"rect\"==o.childNodes[n].tagName?d.fill=o.childNodes[n].getAttribute(\"fill\"):\"image\"==o.childNodes[n].tagName&&(c=fabric.parseAttributes(o.childNodes[n],fabric.SHARED_ATTRIBUTES)).transformMatrix&&(d.offsetX=c.transformMatrix[4],d.offsetY=c.transformMatrix[5]);i.removeImage(d.source)?e.patterns[o.id]=d.fill?d.fill:\"transparent\":e.patterns[d.node.id]=d}else
		// if(\"image\"==o.tagName)a.included++,fabric.Image.fromURL(o.getAttribute(\"xlink:href\"),function(e){a.loaded++});else{var
		// c=[\"fill\",\"stroke\"];for(n=0;n<c.length;n++){var
		// p=c[n],f=o.getAttribute(p),u=i.getRGBA(f),g=i.isHashbanged(f);!f||u||g||(o.setAttribute(p,\"none\"),o.setAttribute(p+\"-opacity\",\"0\"))}}}return
		// e},getRGBA:function(e,t){return!(\"none\"==e||\"transparent\"==e||i.isHashbanged(e)||!(e=new
		// fabric.Color(e))._source)&&(t?e:e.getSource())},gatherPosition:function(e,t){var
		// a,r=i.drawing.buffer.position,n=fabric.util.invertTransform(i.setup.fabric.viewportTransform);return\"touchmove\"==e.type&&(\"touches\"in
		// e?e=e.touches[0]:\"changedTouches\"in
		// e&&(e=e.changedTouches[0])),a=fabric.util.transformPoint(i.setup.fabric.getPointer(e,!0),n),1==t&&(r.x1=a.x,r.y1=a.y),r.x2=a.x,r.y2=a.y,r.xD=r.x1-r.x2<0?-1*(r.x1-r.x2):r.x1-r.x2,r.yD=r.y1-r.y2<0?-1*(r.y1-r.y2):r.y1-r.y2,r},modifyFabric:function(){fabric.ElementsParser.prototype.resolveGradient=function(e,t){var
		// a=e.get(t);if(/^url\\(/.test(a)){var
		// r=a.slice(a.indexOf(\"#\")+1,a.length-1);if(fabric.gradientDefs[this.svgUid][r]){var
		// n=fabric.Gradient.fromElement(fabric.gradientDefs[this.svgUid][r],e);n.coords.y1&&\"pie\"!=i.setup.chart.type&&(n.coords.y2=-1*n.coords.y1,n.coords.y1=0),e.set(t,n)}}},fabric.Text.fromElement=function(e,t){if(!e)return
		// null;var
		// a=fabric.parseAttributes(e,fabric.Text.ATTRIBUTE_NAMES);(t=fabric.util.object.extend(t?fabric.util.object.clone(t):{},a)).top=t.top||0,t.left=t.left||0,\"dx\"in
		// a&&(t.left+=a.dx),\"dy\"in a&&(t.top+=a.dy),\"fontSize\"in
		// t||(t.fontSize=fabric.Text.DEFAULT_SVG_FONT_SIZE),t.originX||(t.originX=\"left\");var
		// i=\"\",r=[];if(\"textContent\"in e)if(e.childNodes)for(var
		// n=0;n<e.childNodes.length;n++)r.push(e.childNodes[n].textContent);else
		// r.push(e.textContent);else\"firstChild\"in e&&null!==e.firstChild&&\"data\"in
		// e.firstChild&&null!==e.firstChild.data&&r.push(e.firstChild.data);i=r.join(\"\\n\");var
		// o=new
		// fabric.Text(i,t),s=0;return\"left\"===o.originX&&(s=o.getWidth()/2),\"right\"===o.originX&&(s=-o.getWidth()/2),r.length>1?o.set({left:o.getLeft()+s,top:o.getTop()+o.fontSize*(r.length-1)*(.18+o._fontSizeFraction),textAlign:t.originX,lineHeight:r.length>1?.965:1.16}):o.set({left:o.getLeft()+s,top:o.getTop()-o.getHeight()/2+o.fontSize*(.18+o._fontSizeFraction)}),o}},capture:function(e,t){var
		// a,r=i.deepMerge(i.deepMerge({},i.config.fabric),e||{}),n=[],o={x:0,y:0,pX:0,pY:0,lX:0,lY:0,width:i.setup.chart.divRealWidth,height:i.setup.chart.divRealHeight},s={loaded:0,included:0},l={items:[],width:0,height:0,maxWidth:0,maxHeight:0};if(!i.handleNamespace(\"fabric\",{scope:this,cb:i.capture,args:arguments}))return!1;i.modifyFabric(),i.handleCallback(r.beforeCapture,r);var
		// d=i.setup.chart.containerDiv.getElementsByTagName(\"svg\");for(a=0;a<d.length;a++)(p={svg:d[a],parent:d[a].parentNode,children:d[a].getElementsByTagName(\"*\"),offset:{x:0,y:0},patterns:{},clippings:{},has:{legend:!1,panel:!1,scrollbar:!1}}).has.legend=i.gatherClassName(p.parent,i.setup.chart.classNamePrefix+\"-legend-div\",1),p.has.panel=i.gatherClassName(p.parent,i.setup.chart.classNamePrefix+\"-stock-panel-div\"),p.has.scrollbar=i.gatherClassName(p.parent,i.setup.chart.classNamePrefix+\"-scrollbar-chart-div\"),p=i.gatherElements(p,r,s),n.push(p);if(i.config.legend){if(\"stock\"==i.setup.chart.type)for(a=0;a<i.setup.chart.panels.length;a++)i.setup.chart.panels[a].stockLegend&&i.setup.chart.panels[a].stockLegend.divId&&l.items.push(i.setup.chart.panels[a].stockLegend);else
		// i.setup.chart.legend&&i.setup.chart.legend.divId&&l.items.push(i.setup.chart.legend);for(a=0;a<l.items.length;a++){var
		// c=l.items[a],p={svg:c.container.container,parent:c.container.container.parentNode,children:c.container.container.getElementsByTagName(\"*\"),offset:{x:0,y:0},legend:{id:a,type:-1!=[\"top\",\"left\"].indexOf(i.config.legend.position)?\"unshift\":\"push\",position:i.config.legend.position,width:i.config.legend.width?i.config.legend.width:c.container.div.offsetWidth,height:i.config.legend.height?i.config.legend.height:c.container.div.offsetHeight},patterns:{},clippings:{},has:{legend:!1,panel:!1,scrollbar:!1}};l.width+=p.legend.width,l.height+=p.legend.height,l.maxWidth=p.legend.width>l.maxWidth?p.legend.width:l.maxWidth,l.maxHeight=p.legend.height>l.maxHeight?p.legend.height:l.maxHeight,p=i.gatherElements(p,r,s),n[p.legend.type](p)}-1!=[\"top\",\"bottom\"].indexOf(i.config.legend.position)?(o.width=l.maxWidth>o.width?l.maxWidth:o.width,o.height+=l.height):-1!=[\"left\",\"right\"].indexOf(i.config.legend.position)?(o.width+=l.maxWidth,o.height=l.height>o.height?l.height:o.height):(o.height+=l.height,o.width+=l.maxWidth)}if(i.drawing.enabled=r.drawing.enabled=\"draw\"==r.action,i.drawing.buffer.enabled=i.drawing.enabled,i.setup.wrapper=document.createElement(\"div\"),i.setup.wrapper.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-canvas\"),i.setup.chart.containerDiv.appendChild(i.setup.wrapper),\"stock\"==i.setup.chart.type){var
		// f={top:0,right:0,bottom:0,left:0};i.setup.chart.leftContainer&&(o.width-=i.setup.chart.leftContainer.offsetWidth,f.left=i.setup.chart.leftContainer.offsetWidth+2*i.setup.chart.panelsSettings.panelSpacing),i.setup.chart.rightContainer&&(o.width-=i.setup.chart.rightContainer.offsetWidth,f.right=i.setup.chart.rightContainer.offsetWidth+2*i.setup.chart.panelsSettings.panelSpacing),i.setup.chart.periodSelector&&-1!=[\"top\",\"bottom\"].indexOf(i.setup.chart.periodSelector.position)&&(o.height-=i.setup.chart.periodSelector.offsetHeight+i.setup.chart.panelsSettings.panelSpacing,f[i.setup.chart.periodSelector.position]+=i.setup.chart.periodSelector.offsetHeight+i.setup.chart.panelsSettings.panelSpacing),i.setup.chart.dataSetSelector&&-1!=[\"top\",\"bottom\"].indexOf(i.setup.chart.dataSetSelector.position)&&(o.height-=i.setup.chart.dataSetSelector.offsetHeight,f[i.setup.chart.dataSetSelector.position]+=i.setup.chart.dataSetSelector.offsetHeight),i.setup.wrapper.style.paddingTop=i.numberToPx(f.top),i.setup.wrapper.style.paddingRight=i.numberToPx(f.right),i.setup.wrapper.style.paddingBottom=i.numberToPx(f.bottom),i.setup.wrapper.style.paddingLeft=i.numberToPx(f.left)}i.setup.canvas=document.createElement(\"canvas\"),i.setup.wrapper.appendChild(i.setup.canvas);var
		// u=i.removeFunctionsFromObject(i.deepMerge({width:o.width,height:o.height,isDrawingMode:!0},r));for(i.setup.fabric=new
		// fabric.Canvas(i.setup.canvas,u),i.deepMerge(i.setup.fabric,r),i.deepMerge(i.setup.fabric.freeDrawingBrush,r.drawing),i.deepMerge(i.drawing,r.drawing),i.drawing.handler.change(r.drawing),i.setup.fabric.on(\"mouse:down\",function(e){i.gatherPosition(e.e,1);i.drawing.buffer.pressedTS=Number(new
		// Date),i.isPressed(e.e),i.drawing.buffer.isDrawing=!1,i.drawing.buffer.isDrawingTimer=setTimeout(function(){i.drawing.buffer.isSelected||(i.drawing.buffer.isDrawing=!0)},200)}),i.setup.fabric.on(\"mouse:move\",function(e){var
		// t=i.gatherPosition(e.e,2);if(i.isPressed(e.e),i.drawing.buffer.isPressed&&!i.drawing.buffer.isSelected&&(i.drawing.buffer.isDrawing=!0,!i.drawing.buffer.line&&\"pencil\"!=i.drawing.mode&&(t.xD>5||t.yD>5)&&(i.setup.fabric.isDrawingMode=!1,i.setup.fabric._isCurrentlyDrawing=!1,i.drawing.buffer.ignoreUndoOnMouseUp=!0,i.setup.fabric.freeDrawingBrush.onMouseUp(),i.setup.fabric.remove(i.setup.fabric._objects.pop()),i.drawing.buffer.line=i.drawing.handler.line({x1:t.x1,y1:t.y1,x2:t.x2,y2:t.y2,arrow:\"line\"!=i.drawing.mode&&i.drawing.arrow,action:\"config\"}))),i.drawing.buffer.isSelected&&(i.setup.fabric.isDrawingMode=!1),i.drawing.buffer.line){var
		// r,n,o,s=i.drawing.buffer.line;for(s.x2=t.x2,s.y2=t.y2,a=0;a<s.group.length;a++)(r=s.group[a])instanceof
		// fabric.Line?r.set({x2:s.x2,y2:s.y2}):r instanceof
		// fabric.Triangle&&(s.angle=i.getAngle(s.x1,s.y1,s.x2,s.y2)+90,\"start\"==s.arrow?(n=s.y1+s.width/2,o=s.x1+s.width/2):\"middle\"==s.arrow?(n=s.y2+s.width/2-(s.y2-s.y1)/2,o=s.x2+s.width/2-(s.x2-s.x1)/2):(n=s.y2+s.width/2,o=s.x2+s.width/2),r.set({top:n,left:o,angle:s.angle}));i.setup.fabric.renderAll()}}),i.setup.fabric.on(\"mouse:up\",function(e){if(!i.drawing.buffer.isDrawing){var
		// t=i.setup.fabric.findTarget(e.e);t&&t.selectable&&i.setup.fabric.setActiveObject(t)}if(i.drawing.buffer.line){for(a=0;a<i.drawing.buffer.line.group.length;a++)i.drawing.buffer.line.group[a].remove();delete
		// i.drawing.buffer.line.action,delete
		// i.drawing.buffer.line.group,i.drawing.handler.line(i.drawing.buffer.line)}i.drawing.buffer.line=!1,i.drawing.buffer.hasLine=!1,i.drawing.buffer.isPressed=!1,clearTimeout(i.drawing.buffer.isDrawingTimer),i.drawing.buffer.isDrawing=!1}),i.setup.fabric.on(\"object:selected\",function(e){i.drawing.buffer.isSelected=!0,i.drawing.buffer.target=e.target,i.setup.fabric.isDrawingMode=!1}),i.setup.fabric.on(\"selection:cleared\",function(e){i.drawing.buffer.target=!1,i.drawing.buffer.isSelected&&(i.setup.fabric._isCurrentlyDrawing=!1),i.drawing.buffer.isSelected=!1,i.setup.fabric.isDrawingMode=!0}),i.setup.fabric.on(\"path:created\",function(e){var
		// t=e.path;if(!i.drawing.buffer.isDrawing||i.drawing.buffer.hasLine)return
		// i.setup.fabric.remove(t),void
		// i.setup.fabric.renderAll()}),i.setup.fabric.on(\"object:added\",function(e){var
		// t=e.target,a=i.deepMerge(t.saveState()._stateProperties,{cfg:{color:i.drawing.color,width:i.drawing.width,opacity:i.drawing.opacity,fontSize:i.drawing.fontSize}});a=JSON.stringify(a),t.recentState=a,!i.drawing.buffer.ignoreUndoOnMouseUp&&i.drawing.buffer.isDrawing?(!t.selectable||t.known||t.ignoreUndo||(t.isAnnotation=!0,i.drawing.undos.push({action:\"added\",target:t,state:a}),i.drawing.redos=[]),t.known=!0,i.setup.fabric.isDrawingMode=!0):i.drawing.buffer.ignoreUndoOnMouseUp=!1}),i.setup.fabric.on(\"object:modified\",function(e){var
		// t=e.target,a=JSON.parse(t.recentState),r=i.deepMerge(t.saveState()._stateProperties,{cfg:a.cfg});r=JSON.stringify(r),t.recentState=r,i.drawing.undos.push({action:\"modified\",target:t,state:r}),i.drawing.redos=[]}),i.setup.fabric.on(\"text:changed\",function(e){var
		// t=e.target;clearTimeout(t.timer),t.timer=setTimeout(function(){var
		// e=JSON.stringify(t.saveState()._stateProperties);t.recentState=e,i.drawing.redos=[],i.drawing.undos.push({action:\"modified\",target:t,state:e})},250)}),i.drawing.enabled?(i.setup.wrapper.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-canvas
		// active\"),i.setup.wrapper.style.backgroundColor=r.backgroundColor,i.setup.wrapper.style.display=\"block\"):(i.setup.wrapper.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-canvas\"),i.setup.wrapper.style.display=\"none\"),a=0;a<n.length;a++){p=n[a];\"stock\"==i.setup.chart.type&&i.setup.chart.legendSettings.position?-1!=[\"top\",\"bottom\"].indexOf(i.setup.chart.legendSettings.position)?p.parent.style.top&&p.parent.style.left?(p.offset.y=i.pxToNumber(p.parent.style.top),p.offset.x=i.pxToNumber(p.parent.style.left)):(p.offset.x=o.x,p.offset.y=o.y,o.y+=i.pxToNumber(p.parent.style.height),p.has.panel?(o.pY=i.pxToNumber(p.has.panel.style.marginTop),p.offset.y+=o.pY):p.has.scrollbar&&(p.offset.y+=o.pY)):-1!=[\"left\",\"right\"].indexOf(i.setup.chart.legendSettings.position)&&(p.offset.y=i.pxToNumber(p.parent.style.top)+o.pY,p.offset.x=i.pxToNumber(p.parent.style.left)+o.pX,p.has.legend?o.pY+=i.pxToNumber(p.has.panel.style.height)+i.setup.chart.panelsSettings.panelSpacing:p.has.scrollbar&&(p.offset.y-=i.setup.chart.panelsSettings.panelSpacing)):(\"absolute\"==p.parent.style.position?(p.offset.absolute=!0,p.offset.top=i.pxToNumber(p.parent.style.top),p.offset.right=i.pxToNumber(p.parent.style.right,!0),p.offset.bottom=i.pxToNumber(p.parent.style.bottom,!0),p.offset.left=i.pxToNumber(p.parent.style.left),p.offset.width=i.pxToNumber(p.parent.style.width),p.offset.height=i.pxToNumber(p.parent.style.height)):p.parent.style.top&&p.parent.style.left?(p.offset.y=i.pxToNumber(p.parent.style.top),p.offset.x=i.pxToNumber(p.parent.style.left)):p.legend?(\"left\"==p.legend.position?o.x=l.maxWidth:\"right\"==p.legend.position?p.offset.x=o.width-l.maxWidth:\"top\"==p.legend.position?o.y+=p.legend.height:\"bottom\"==p.legend.position&&(p.offset.y=o.height-l.height),p.offset.y+=o.lY,o.lY+=p.legend.height):(p.offset.x=o.x,p.offset.y=o.y+o.pY,o.y+=i.pxToNumber(p.parent.style.height)),p.has.legend&&p.has.panel&&p.has.panel.style.marginTop?(o.y+=i.pxToNumber(p.has.panel.style.marginTop),p.offset.y+=i.pxToNumber(p.has.panel.style.marginTop)):i.setup.chart.legend&&-1!=[\"left\",\"right\"].indexOf(i.setup.chart.legend.position)&&(p.offset.y=i.pxToNumber(p.parent.style.top),p.offset.x=i.pxToNumber(p.parent.style.left))),fabric.parseSVGDocument(p.svg,function(e){return
		// function(a,l){var
		// d,c=fabric.util.groupSVGElements(a,l),p=[],f={selectable:!1,isCoreElement:!0};for(e.offset.absolute?(void
		// 0!==e.offset.bottom?f.top=o.height-e.offset.height-e.offset.bottom:f.top=e.offset.top,void
		// 0!==e.offset.right?f.left=o.width-e.offset.width-e.offset.right:f.left=e.offset.left):(f.top=e.offset.y,f.left=e.offset.x),d=0;d<c.paths.length;d++){var
		// u=null;if(c.paths[d]){if(i.removeImage(c.paths[d][\"xlink:href\"]))continue;if(c.paths[d].fill
		// instanceof
		// Object)\"radial\"==c.paths[d].fill.type&&-1==[\"pie\",\"gauge\"].indexOf(i.setup.chart.type)&&(c.paths[d].fill.coords.r2=-1*c.paths[d].fill.coords.r1,c.paths[d].fill.coords.r1=0,c.paths[d].set({opacity:c.paths[d].fillOpacity}));else
		// if((u=i.isHashbanged(c.paths[d].fill))&&e.patterns&&e.patterns[u]){var
		// g=e.patterns[u];s.included++,fabric.Image.fromURL(g.source,function(e,t){return
		// function(a){s.loaded++,a.set({top:e.offsetY,left:e.offsetX,width:e.width,height:e.height}),i.setup.fabric._isRetinaScaling()&&a.set({top:e.offsetY/2,left:e.offsetX/2,scaleX:.5,scaleY:.5});var
		// r=new fabric.StaticCanvas(void
		// 0,{backgroundColor:e.fill,width:a.getWidth(),height:a.getHeight()});r.add(a);var
		// n=new
		// fabric.Pattern({source:r.getElement(),offsetX:c.paths[t].width/2,offsetY:c.paths[t].height/2,repeat:\"repeat\"});c.paths[t].set({fill:n,opacity:c.paths[t].fillOpacity})}}(g,d))}(u=i.isHashbanged(c.paths[d].clipPath))&&e.clippings&&e.clippings[u]&&(!function(t,a){var
		// i=c.paths[t].toSVG;c.paths[t].toSVG=function(t){return
		// i.apply(this,[function(i){return
		// t(i,e.clippings[a])}])}}(d,u),c.paths[d].set({clipTo:function(t,a){return
		// function(r){var
		// n=e.clippings[a],o=this.transformMatrix||[1,0,0,1,0,0],s={top:n.bbox.y,left:n.bbox.x,width:n.bbox.width,height:n.bbox.height};\"map\"==i.setup.chart.type&&(s.top+=n.transform[5],s.left+=n.transform[4]),n.bbox.x&&o[4]&&n.bbox.y&&o[5]&&(s.top-=o[5],s.left-=o[4]),void
		// 0!==i.setup.chart.smoothCustomBullets&&this.className==i.setup.chart.classNamePrefix+\"-graph-bullet\"&&\"image\"==c.paths[t].svg.tagName?(radius=n.svg.firstChild.rx.baseVal.value/2+2,r.beginPath(),r.moveTo(s.left+radius,s.top),r.lineTo(s.left+s.width-radius,s.top),r.quadraticCurveTo(s.left+s.width,s.top,s.left+s.width,s.top+radius),r.lineTo(s.left+s.width,s.top+s.height-radius),r.quadraticCurveTo(s.left+s.width,s.top+s.height,s.left+s.width-radius,s.top+s.height),r.lineTo(s.left+radius,s.top+s.height),r.quadraticCurveTo(s.left,s.top+s.height,s.left,s.top+s.height-radius),r.lineTo(s.left,s.top+radius),r.quadraticCurveTo(s.left,s.top,s.left+radius,s.top),r.closePath()):r.rect(s.left,s.top,s.width,s.height)}}(d,u)}))}p.push(c.paths[d])}if(c.paths=p,c.set(f),i.setup.fabric.add(c),e.svg.parentNode&&e.svg.parentNode.getElementsByTagName){var
		// h=e.svg.parentNode.getElementsByClassName(i.setup.chart.classNamePrefix+\"-balloon-div\");for(d=0;d<h.length;d++)if(r.balloonFunction
		// instanceof Function)r.balloonFunction.apply(i,[h[d],e]);else{var
		// m=h[d],b=fabric.parseStyleAttribute(m),v=fabric.parseStyleAttribute(m.childNodes[0]),w=new
		// fabric.Text(m.innerText||m.textContent||m.innerHTML,{selectable:!1,top:i.pxToNumber(b.top)+e.offset.y,left:i.pxToNumber(b.left)+e.offset.x,fill:v.color,fontSize:i.pxToNumber(v.fontSize||v[\"font-size\"]),fontFamily:v.fontFamily||v[\"font-family\"],textAlign:v[\"text-align\"],isCoreElement:!0});i.setup.fabric.add(w)}}if(e.svg.nextSibling&&\"A\"==e.svg.nextSibling.tagName){var
		// m=e.svg.nextSibling,b=fabric.parseStyleAttribute(m),w=new
		// fabric.Text(m.innerText||m.textContent||m.innerHTML,{selectable:!1,top:i.pxToNumber(b.top)+e.offset.y,left:i.pxToNumber(b.left)+e.offset.x,fill:b.color,fontSize:i.pxToNumber(b.fontSize||b[\"font-size\"]),fontFamily:b.fontFamily||b[\"font-family\"],opacity:b.opacity,isCoreElement:!0});e.has.scrollbar||i.setup.fabric.add(w)}if(n.pop(),!n.length)var
		// y=Number(new Date),x=setInterval(function(){var e=Number(new
		// Date);(s.loaded==s.included||e-y>i.config.fabric.loadTimeout)&&(clearTimeout(x),i.handleBorder(r),i.handleCallback(r.afterCapture,r),i.setup.fabric.renderAll(),i.handleCallback(t,r))},AmCharts.updateRate)}}(p),function(e,t){var
		// a,n=i.gatherAttribute(e,\"class\"),o=i.gatherAttribute(e,\"visibility\"),s=i.gatherAttribute(e,\"clip-path\");t.className=String(n),t.classList=String(n).split(\"
		// \"),t.clipPath=s,t.svg=e;var
		// l=[\"fill\",\"stroke\"];for(a=0;a<l.length;a++){var
		// d=l[a],c=String(e.getAttribute(d)||\"none\"),p=Number(e.getAttribute(d+\"-opacity\")||\"1\"),f=i.getRGBA(c);\"hidden\"==o&&(t.opacity=0,p=0),f&&(f.pop(),f.push(p),t[d]=\"rgba(\"+f.join()+\")\",t[d+i.capitalize(\"opacity\")]=p)}i.handleCallback(r.reviver,t,e)})}},toCanvas:function(e,t){var
		// a=i.deepMerge({},e||{}),r=i.setup.canvas;return
		// i.handleCallback(t,r,a),r},toImage:function(e,t){var
		// a=i.deepMerge({format:\"png\",quality:1,multiplier:i.config.multiplier},e||{}),r=a.data,n=document.createElement(\"img\");return!!i.handleNamespace(\"fabric\",{scope:this,cb:i.toImage,args:arguments})&&(a.data||(r=a.lossless||\"svg\"==a.format?i.toSVG(i.deepMerge(a,{getBase64:!0})):i.setup.fabric.toDataURL(a)),n.setAttribute(\"src\",r),i.handleCallback(t,n,a),n)},toBlob:function(e,t){var
		// a,r=i.deepMerge({data:\"empty\",type:\"text/plain\"},e||{}),n=/^data:.+;base64,(.*)$/.exec(r.data);return
		// n&&(r.data=n[0],r.type=r.data.slice(5,r.data.indexOf(\",\")-7),r.data=i.toByteArray({data:r.data.slice(r.data.indexOf(\",\")+1,r.data.length)})),a=r.getByteArray?r.data:new
		// Blob([r.data],{type:r.type}),i.handleCallback(t,a,r),a},toJPG:function(e,t){var
		// a=i.deepMerge({format:\"jpeg\",quality:1,multiplier:i.config.multiplier},e||{});a.format=a.format.toLowerCase();var
		// r;return/iP(hone|od|ad)/.test(navigator.platform)&&(a.multiplier=1),!!i.handleNamespace(\"fabric\",{scope:this,cb:i.toJPG,args:arguments})&&(r=i.setup.fabric.toDataURL(a),i.handleCallback(t,r,a),r)},toPNG:function(e,t){var
		// a,r=i.deepMerge({format:\"png\",quality:1,multiplier:i.config.multiplier},e||{});return/iP(hone|od|ad)/.test(navigator.platform)&&(r.multiplier=1),!!i.handleNamespace(\"fabric\",{scope:this,cb:i.toPNG,args:arguments})&&(a=i.setup.fabric.toDataURL(r),i.handleCallback(t,a,r),a)},toSVG:function(e,t){var
		// a,r=[],n=[],o=i.deepMerge({compress:i.config.compress,reviver:function(e,t){var
		// a=new
		// RegExp(/\\bstyle=(['\"])(.*?)\\1/).exec(e)[0].slice(7,-1),o=a.split(\";\"),s=[];for(i1=0;i1<o.length;i1++)if(o[i1]){var
		// l=o[i1].replace(/\\s/g,\"\").split(\":\"),d=l[0],c=l[1];if(-1!=[\"fill\",\"stroke\"].indexOf(d))if(c=i.getRGBA(c,!0)){var
		// p=\"#\"+c.toHex(),f=c._source[3];s.push([d,p].join(\":\")),s.push([d+\"-opacity\",f].join(\":\"))}else
		// s.push(o[i1]);else\"opactiy\"!=d&&s.push(o[i1])}if(e=e.replace(a,s.join(\";\")),t&&t.svg){var
		// u=t.svg.id,g=2,h=e.slice(-g);\"/>\"!=h&&(g=3,h=e.slice(-g));var
		// m=e.slice(0,e.length-g),b=' clip-path=\"url(#'+u+')\"
		// ',v=i.gatherAttribute(t.svg,\"class\");if(v=v?v.split(\"
		// \"):[],e=-1!=v.indexOf(i.setup.chart.classNamePrefix+\"-graph-line\")?m+b+h:\"<g
		// \"+b+\">\"+e+\"</g>\",-1==n.indexOf(u)){var w=(new
		// XMLSerializer).serializeToString(t.svg);r.push(w),n.push(u)}}return
		// e}},e||{});if(!i.handleNamespace(\"fabric\",{scope:this,cb:i.toSVG,args:arguments}))return!1;if(a=i.setup.fabric.toSVG(o,o.reviver),r.length){var
		// s=a.slice(0,a.length-6),l=a.slice(-6);a=s+r.join(\"\")+l}return
		// o.compress&&(a=a.replace(/[\\t\\r\\n]+/g,\"\")),o.getBase64&&(a=\"data:image/svg+xml;base64,\"+btoa(a)),i.handleCallback(t,a,o),a},toPDF:function(e,t){var
		// a,r=i.deepMerge(i.deepMerge({multiplier:i.config.multiplier||2,pageOrigin:void
		// 0===i.config.pageOrigin},i.config.pdfMake),e||{},!0);if(/iP(hone|od|ad)/.test(navigator.platform)&&(r.multiplier=1),!i.handleNamespace(\"pdfMake\",{scope:this,cb:i.toPDF,args:arguments}))return!1;if(r.images.reference=i.toPNG(r),!r.content){var
		// n=[],o=function(e,t){var
		// a=i.defaults.pdfMake.pageSizes[String(e).toUpperCase()].slice();if(!a)throw
		// new Error('The given pageSize \"'+e+'\" does not
		// exist!');return\"landscape\"==t&&a.reverse(),a}(r.pageSize,r.pageOrientation),s=function(e){if(\"number\"==typeof
		// e||e instanceof Number)e={left:e,right:e,top:e,bottom:e};else if(e instanceof
		// Array)if(2===e.length)e={left:e[0],top:e[1],right:e[0],bottom:e[1]};else{if(4!==e.length)throw\"Invalid
		// pageMargins definition\";e={left:e[0],top:e[1],right:e[2],bottom:e[3]}}else
		// e={left:i.defaults.pdfMake.pageMargins,top:i.defaults.pdfMake.pageMargins,right:i.defaults.pdfMake.pageMargins,bottom:i.defaults.pdfMake.pageMargins};return
		// e}(r.pageMargins);o[0]-=s.left+s.right,o[1]-=s.top+s.bottom,r.pageOrigin&&(n.push(i.i18l(\"label.saved.from\")),n.push(window.location.href),o[1]-=28.128),n.push({image:\"reference\",fit:o}),r.content=n}return
		// a=new pdfMake.createPdf(r),t&&a.getDataUrl(function(e){return
		// function(t){e.apply(i,arguments)}}(t)),a},toPRINT:function(e,t){var
		// a,r=i.deepMerge({delay:1,lossless:!1},e||{}),n=i.toImage(r),o=[],s=document.body.childNodes,l=document.documentElement.scrollTop||document.body.scrollTop;for(n.setAttribute(\"style\",\"width:
		// 100%; max-height:
		// 100%;\"),a=0;a<s.length;a++)i.isElement(s[a])&&(o[a]=s[a].style.display,s[a].style.display=\"none\");return
		// document.body.appendChild(n),r.delay*=1e3,/iPad|iPhone|iPod/.test(navigator.userAgent)&&!window.MSStream&&r.delay<1e3&&(r.delay=1e3),setTimeout(function(){window.print(),setTimeout(function(){for(a=0;a<s.length;a++)i.isElement(s[a])&&(s[a].style.display=o[a]);document.body.removeChild(n),document.documentElement.scrollTop=document.body.scrollTop=l,i.handleCallback(t,n,r)},r.delay)},r.delay),n},toJSON:function(e,t){var
		// a=i.deepMerge({dateFormat:i.config.dateFormat||\"dateObject\"},e||{},!0),r={};return!!i.handleNamespace(\"JSON\",{scope:this,cb:i.toJSON,args:arguments})&&(a.data=void
		// 0!==a.data?a.data:i.getChartData(a),r=JSON.stringify(a.data,void
		// 0,\"\\t\"),i.handleCallback(t,r,a),r)},toCSV:function(e,t){var
		// a,r=i.deepMerge({delimiter:\",\",quotes:!0,escape:!0,withHeader:!0},e||{},!0),n=[],o=\"\";n=i.toArray(r);for(a
		// in n)isNaN(a)||(o+=n[a].join(r.delimiter)+\"\\n\");return
		// i.handleCallback(t,o,r),o},toXLSX:function(e,t){function a(e,t){return
		// t&&(e+=1462),(Date.parse(e)-60*e.getTimezoneOffset()*1e3-new
		// Date(Date.UTC(1899,11,30)))/864e5}var
		// r=i.deepMerge({name:\"amCharts\",dateFormat:i.config.dateFormat||\"dateObject\",withHeader:!0,stringify:!1},e||{},!0),n=[],o=\"\",s={SheetNames:[],Sheets:{}};return!!i.handleNamespace(\"XLSX\",{scope:this,cb:i.toXLSX,args:arguments})&&(n=i.toArray(r),s.SheetNames.push(r.name),s.Sheets[r.name]=function(e,t){for(var
		// i={},r={s:{c:1e7,r:1e7},e:{c:0,r:0}},n=0;n!=e.length;++n)for(var
		// o=0;o!=e[n].length;++o){r.s.r>n&&(r.s.r=n),r.s.c>o&&(r.s.c=o),r.e.r<n&&(r.e.r=n),r.e.c<o&&(r.e.c=o);var
		// s={v:e[n][o]};if(null!=s.v){var
		// l=XLSX.utils.encode_cell({c:o,r:n});\"number\"==typeof
		// s.v?s.t=\"n\":\"boolean\"==typeof s.v?s.t=\"b\":s.v instanceof
		// Date?(s.t=\"n\",s.z=XLSX.SSF._table[14],s.v=a(s.v)):s.v instanceof
		// Object?(s.t=\"s\",s.v=JSON.stringify(s.v)):s.t=\"s\",i[l]=s}}return
		// r.s.c<1e7&&(i[\"!ref\"]=XLSX.utils.encode_range(r)),i}(n),o=XLSX.write(s,{bookType:\"xlsx\",bookSST:!0,type:\"base64\"}),o=\"data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,\"+o,i.handleCallback(t,o,r),o)},toArray:function(e,t){function
		// a(e){return\"string\"==typeof
		// e&&(n.escape&&(e=e.replace('\"','\"\"')),n.quotes&&(e=['\"',e,'\"'].join(\"\"))),e}var
		// r,n=i.deepMerge({withHeader:!1,stringify:!0,escape:!1,quotes:!1},e||{},!0),o=[],s=[],l=[],d=i.config.processData;if(n.processData=function(e,t){var
		// a=t.exportFields||Object.keys(t.dataFieldsMap);for(c=0;c<a.length;c++){var
		// r=a[c],n=t.dataFieldsTitlesMap[r];s.push(n)}return
		// d?i.handleCallback(d,e,t):e},n.data=void
		// 0!==n.data?i.processData(n):i.getChartData(n),n.withHeader){l=[];for(c in
		// s)isNaN(c)||l.push(a(s[c]));o.push(l)}for(r in
		// n.data)if(l=[],!isNaN(r)){for(c in s)if(!isNaN(c)){var
		// c=s[c],p=n.data[r][c];p=null==p?\"\":n.stringify?String(p):p,l.push(a(p))}o.push(l)}return
		// i.handleCallback(t,o,n),o},toByteArray:function(e,t){function a(e){var
		// t=e.charCodeAt(0);return
		// t===o?62:t===s?63:t<l?-1:t<l+10?t-l+26+26:t<c+26?t-c:t<d+26?t-d+26:void 0}var
		// r=i.deepMerge({},e||{}),n=\"undefined\"!=typeof
		// Uint8Array?Uint8Array:Array,o=\"+\".charCodeAt(0),s=\"/\".charCodeAt(0),l=\"0\".charCodeAt(0),d=\"a\".charCodeAt(0),c=\"A\".charCodeAt(0),p=function(e){function
		// t(e){d[p++]=e}var i,r,o,s,l,d;if(e.length%4>0)throw new Error(\"Invalid
		// string. Length must be a multiple of 4\");var
		// c=e.length;l=\"=\"===e.charAt(c-2)?2:\"=\"===e.charAt(c-1)?1:0,d=new
		// n(3*e.length/4-l),o=l>0?e.length-4:e.length;var
		// p=0;for(i=0,r=0;i<o;i+=4,r+=3)t((16711680&(s=a(e.charAt(i))<<18|a(e.charAt(i+1))<<12|a(e.charAt(i+2))<<6|a(e.charAt(i+3))))>>16),t((65280&s)>>8),t(255&s);return
		// 2===l?t(255&(s=a(e.charAt(i))<<2|a(e.charAt(i+1))>>4)):1===l&&(t((s=a(e.charAt(i))<<10|a(e.charAt(i+1))<<4|a(e.charAt(i+2))>>2)>>8&255),t(255&s)),d}(r.data);return
		// i.handleCallback(t,p,r),p},removeFunctionsFromObject:function(e){for(var t in
		// e)\"function\"==typeof e[t]&&delete e[t];return
		// e},handleCallback:function(e){var t,a=Array();if(e&&e instanceof
		// Function){for(t=0;t<arguments.length;t++)t>0&&a.push(arguments[t]);return
		// e.apply(i,a)}},handleLog:function(e){!0===i.config.debug&&console.log(e)},handleNamespace:function(e,t){function
		// a(){var l=Number(new Date);o=!!(e in
		// n),\"pdfMake\"==e&&o&&(o=n.pdfMake.vfs),o?(clearTimeout(r),t.cb.apply(t.scope,t.args),i.handleLog(['AmCharts
		// [export]: Namespace \"',e,'\" showed up in:
		// ',String(n)].join(\"\"))):l-s<i.libs.loadTimeout?r=setTimeout(a,250):i.handleLog(['AmCharts
		// [export]: Gave up waiting for \"',e,'\" in: ',String(n)].join(\"\"))}var
		// r,n=i.config.scope||window,o=!1,s=Number(new Date);return(o=!!(e in
		// n))||(i.handleLog(['AmCharts [export]: Could not find \"',e,'\" in:
		// ',String(n)].join(\"\")),a()),o},handleBorder:function(e){if(i.config.border
		// instanceof Object){var
		// t=i.deepMerge(i.defaults.fabric.border,e.border||{},!0),a=new
		// fabric.Rect;t.width=i.setup.fabric.width-t.strokeWidth,t.height=i.setup.fabric.height-t.strokeWidth,a.set(t),i.setup.fabric.add(a)}},handleDropbox:function(e){if(i.drawing.enabled)if(e.preventDefault(),e.stopPropagation(),\"dragover\"==e.type)i.setup.wrapper.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-canvas
		// active dropbox\");else
		// if(i.setup.wrapper.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-canvas
		// active\"),\"drop\"==e.type&&e.dataTransfer.files.length)for(var
		// t=0;t<e.dataTransfer.files.length;t++){var a=new
		// FileReader;a.onloadend=function(t){return
		// function(){i.drawing.handler.add({url:a.result,top:e.layerY-10*t,left:e.layerX-10*t})}}(t),a.readAsDataURL(e.dataTransfer.files[t])}},handleReady:function(e){var
		// t=this,a=Number(new Date);t.handleCallback(e,\"data\",!1);for(var i in
		// t.libs.namespaces)!function(i){var r=setInterval(function(){var n=Number(new
		// Date);(n-a>t.libs.loadTimeout||i in
		// window)&&(clearTimeout(r),t.handleCallback(e,i,n-a>t.libs.loadTimeout))},AmCharts.updateRate)}(t.libs.namespaces[i])},getChartData:function(e){function
		// t(e,t,a){function
		// r(e,t){return-1!=s.dataFields.indexOf(e)?r([e,\".\",t].join(\"\")):e}e&&s.exportTitles&&\"gantt\"!=i.setup.chart.type&&(g=r(e,a),s.dataFieldsMap[g]=e,s.dataFields.push(g),s.titles[g]=t||g)}var
		// a,r,n,o,s=i.deepMerge({data:[],titles:{},dateFields:[],dataFields:[],dataFieldsMap:{},exportTitles:i.config.exportTitles,exportFields:i.config.exportFields,exportSelection:i.config.exportSelection,columnNames:i.config.columnNames},e||{},!0),l=[\"valueField\",\"openField\",\"closeField\",\"highField\",\"lowField\",\"xField\",\"yField\"];if(0==s.data.length)if(\"stock\"==i.setup.chart.type){for(s.data=i.cloneObject(i.setup.chart.mainDataSet.dataProvider),t(i.setup.chart.mainDataSet.categoryField),s.dateFields.push(i.setup.chart.mainDataSet.categoryField),a=0;a<i.setup.chart.mainDataSet.fieldMappings.length;a++){u=i.setup.chart.mainDataSet.fieldMappings[a];for(r=0;r<i.setup.chart.panels.length;r++){var
		// d=i.setup.chart.panels[r];for(n=0;n<d.stockGraphs.length;n++){v=d.stockGraphs[n];for(i4=0;i4<l.length;i4++)v[l[i4]]==u.toField&&t(u.fromField,v.title,l[i4])}}}if(i.setup.chart.comparedGraphs.length){for(o=[],a=0;a<s.data.length;a++)o.push(s.data[a][i.setup.chart.mainDataSet.categoryField]);for(a=0;a<i.setup.chart.comparedGraphs.length;a++){v=i.setup.chart.comparedGraphs[a];for(r=0;r<v.dataSet.dataProvider.length;r++){var
		// c=v.dataSet.categoryField,p=v.dataSet.dataProvider[r][c],f=o.indexOf(p);if(-1!=f)for(n=0;n<v.dataSet.fieldMappings.length;n++){var
		// u=v.dataSet.fieldMappings[n],g=v.dataSet.id+\"_\"+u.toField;s.data[f][g]=v.dataSet.dataProvider[r][u.fromField],s.titles[g]||t(g,v.dataSet.title)}}}}}else
		// if(\"gantt\"==i.setup.chart.type){t(i.setup.chart.categoryField);var
		// h=i.setup.chart.segmentsField;for(a=0;a<i.setup.chart.dataProvider.length;a++){var
		// m=i.setup.chart.dataProvider[a];if(m[h])for(r=0;r<m[h].length;r++)m[h][r][i.setup.chart.categoryField]=m[i.setup.chart.categoryField],s.data.push(m[h][r])}for(a=0;a<i.setup.chart.graphs.length;a++){v=i.setup.chart.graphs[a];for(r=0;r<l.length;r++){var
		// b=v[w=l[r]];v.title;t(b,v.title,w)}}}else
		// if(-1!=[\"pie\",\"funnel\"].indexOf(i.setup.chart.type))s.data=i.setup.chart.dataProvider,t(i.setup.chart.titleField),s.dateFields.push(i.setup.chart.titleField),t(i.setup.chart.valueField);else
		// if(\"map\"!=i.setup.chart.type)for(s.data=i.setup.chart.dataProvider,i.setup.chart.categoryAxis&&(t(i.setup.chart.categoryField,i.setup.chart.categoryAxis.title),!1!==i.setup.chart.categoryAxis.parseDates&&s.dateFields.push(i.setup.chart.categoryField)),a=0;a<i.setup.chart.graphs.length;a++){var
		// v=i.setup.chart.graphs[a];for(r=0;r<l.length;r++){var
		// w=l[r];t(b=v[w],v.title,w)}}return
		// i.processData(s)},getAnnotations:function(e,t){var
		// a,r=i.deepMerge({},e||{},!0),n=[];for(a=0;a<i.setup.fabric._objects.length;a++)if(!i.setup.fabric._objects[a].isCoreElement){var
		// o=i.setup.fabric._objects[a].toJSON();i.handleCallback(r.reviver,o,a),n.push(o)}return
		// i.handleCallback(t,n),n},setAnnotations:function(e,t){var
		// a=i.deepMerge({data:[]},e||{},!0);return
		// fabric.util.enlivenObjects(a.data,function(e){e.forEach(function(e,t){i.handleCallback(a.reviver,e,t),i.setup.fabric.add(e)}),i.handleCallback(t,a)}),a.data},processData:function(t){var
		// a,r,n=i.deepMerge({data:[],titles:{},dateFields:[],dataFields:[],dataFieldsMap:{},dataFieldsTitlesMap:{},dataDateFormat:i.setup.chart.dataDateFormat,dateFormat:i.config.dateFormat||i.setup.chart.dataDateFormat||\"YYYY-MM-DD\",exportTitles:i.config.exportTitles,exportFields:i.config.exportFields,exportSelection:i.config.exportSelection,columnNames:i.config.columnNames,processData:i.config.processData},t||{},!0);if(n.data.length){for(a=0;a<n.data.length;a++)for(r
		// in
		// n.data[a])-1==n.dataFields.indexOf(r)&&(n.dataFields.push(r),n.dataFieldsMap[r]=r);void
		// 0!==n.exportFields&&(n.dataFields=n.exportFields.filter(function(e){return-1!=n.dataFields.indexOf(e)}));var
		// o=[];for(a=0;a<n.data.length;a++){var
		// s={},l=!1;for(r=0;r<n.dataFields.length;r++){var
		// d=n.dataFields[r],c=n.dataFieldsMap[d],p=n.columnNames&&n.columnNames[d]||n.titles[d]||d,f=n.data[a][c];null==f&&(f=void
		// 0),n.exportTitles&&\"gantt\"!=i.setup.chart.type&&p in s&&(p+=[\"( \",d,\"
		// )\"].join(\"\")),-1!=n.dateFields.indexOf(c)&&(n.dataDateFormat&&(f
		// instanceof String||\"string\"==typeof
		// f)?f=AmCharts.stringToDate(f,n.dataDateFormat):n.dateFormat&&(f instanceof
		// Number||\"number\"==typeof f)&&(f=new Date(f)),n.exportSelection&&(f
		// instanceof
		// Date?(f<e.startDate||f>e.endDate)&&(l=!0):(a<e.startIndex||a>e.endIndex)&&(l=!0)),n.dateFormat&&\"dateObject\"!=n.dateFormat&&f
		// instanceof
		// Date&&(f=AmCharts.formatDate(f,n.dateFormat))),n.dataFieldsTitlesMap[c]=p,s[p]=f}l||o.push(s)}n.data=o}return
		// void
		// 0!==n.processData&&(n.data=i.handleCallback(n.processData,n.data,n)),n.data},capitalize:function(e){return
		// e.charAt(0).toUpperCase()+e.slice(1).toLowerCase()},createMenu:function(t,a){function
		// r(t,a){var o,s,l=document.createElement(\"ul\");for(o=0;o<t.length;o++){var
		// d=\"string\"==typeof
		// t[o]?{format:t[o]}:t[o],c=document.createElement(\"li\"),p=document.createElement(\"a\"),f=document.createElement(\"img\"),u=document.createElement(\"span\"),g=String(d.action?d.action:d.format).toLowerCase();if(d.format=String(d.format).toUpperCase(),c.addEventListener(\"mouseleave\",function(e){this.classList.remove(\"active\")}),p.addEventListener(\"focus\",function(e){if(!i.setup.hasTouch){i.setup.focusedMenuItem=this;var
		// t=this.parentNode;\"UL\"!=t.tagName&&(t=t.parentNode);var
		// a=t.getElementsByTagName(\"li\");for(o=0;o<a.length;o++)a[o].classList.remove(\"active\");this.parentNode.classList.add(\"active\"),this.parentNode.parentNode.parentNode.classList.add(\"active\")}}),i.config.formats[d.format]?d=i.deepMerge({label:d.icon?\"\":d.format,format:d.format,mimeType:i.config.formats[d.format].mimeType,extension:i.config.formats[d.format].extension,capture:i.config.formats[d.format].capture,action:i.config.action,fileName:i.config.fileName},d):d.label||(d.label=d.label?d.label:i.i18l(\"menu.label.\"+g)),(-1==[\"CSV\",\"JSON\",\"XLSX\"].indexOf(d.format)||-1==[\"map\",\"gauge\"].indexOf(i.setup.chart.type))&&(i.setup.hasBlob||\"UNDEFINED\"==d.format||!d.mimeType||\"image\"==d.mimeType.split(\"/\")[0]||\"text/plain\"==d.mimeType)){if(\"draw\"==d.action)i.config.fabric.drawing.enabled?(d.menu=d.menu?d.menu:i.config.fabric.drawing.menu,d.click=function(e){return
		// function(){this.capture(e,function(){this.createMenu(e.menu)})}}(d)):d.menu=[];else
		// if(!d.populated&&d.action&&-1!=d.action.indexOf(\"draw.\")){var
		// h=d.action.split(\".\")[1],m=d[h]||i.config.fabric.drawing[h]||[];for(d.menu=[],d.populated=!0,s=0;s<m.length;s++){var
		// b={label:m[s]};if(\"shapes\"==h){var
		// v=-1==m[s].indexOf(\"//\"),w=(v?i.config.path+\"shapes/\":\"\")+m[s];b.action=\"add\",b.url=w,b.icon=w,b.ignore=v,b.class=\"export-drawing-shape\"}else\"colors\"==h?(b.style=\"background-color:
		// \"+m[s],b.action=\"change\",b.color=m[s],b.class=\"export-drawing-color\"):\"widths\"==h?(b.action=\"change\",b.width=m[s],b.label=document.createElement(\"span\"),b.label.style.width=i.numberToPx(m[s]),b.label.style.height=i.numberToPx(m[s]),b.class=\"export-drawing-width\"):\"opacities\"==h?(b.style=\"opacity:
		// \"+m[s],b.action=\"change\",b.opacity=m[s],b.label=100*m[s]+\"%\",b.class=\"export-drawing-opacity\"):\"modes\"==h&&(b.label=i.i18l(\"menu.label.draw.modes.\"+m[s]),b.click=function(e){return
		// function(){i.drawing.mode=e}}(m[s]),b.class=\"export-drawing-mode\");d.menu.push(b)}}else
		// d.click||d.menu||d.items||(i.drawing.handler[g]instanceof
		// Function?(d.action=g,d.click=function(e){return
		// function(){this.drawing.handler[e.action](e),\"cancel\"!=e.action&&this.createMenu(this.config.fabric.drawing.menu)}}(d)):i.drawing.enabled?d.click=function(e){return
		// function(){this.config.drawing.autoClose&&this.drawing.handler.done(),this[\"to\"+e.format](e,function(t){\"download\"==e.action&&this.download(t,e.mimeType,[e.fileName,e.extension].join(\".\"))})}}(d):\"UNDEFINED\"!=d.format&&(d.click=function(e){return
		// function(){if(e.capture||\"print\"==e.action||\"PRINT\"==e.format)this.capture(e,function(){this.drawing.handler.done(),this[\"to\"+e.format](e,function(t){\"download\"==e.action&&this.download(t,e.mimeType,[e.fileName,e.extension].join(\".\"))})});else{if(!this[\"to\"+e.format])throw
		// new Error(\"Invalid format. Could not determine output
		// type.\");this[\"to\"+e.format](e,function(t){this.download(t,e.mimeType,[e.fileName,e.extension].join(\".\"))})}}}(d)));(void
		// 0===d.menu||d.menu.length)&&(p.setAttribute(\"href\",\"#\"),i.setup.hasTouch&&c.classList?(p.addEventListener(\"touchend\",function(e,t){return
		// function(a){a.preventDefault();var
		// r=[a,t];if((\"draw\"==t.action||\"PRINT\"==t.format||\"UNDEFINED\"!=t.format&&t.capture)&&!i.drawing.enabled&&(!isNaN(t.delay)||!isNaN(i.config.delay)))return
		// t.delay=isNaN(t.delay)?i.config.delay:t.delay,void
		// i.delay(t,e);e.apply(i,r)}}(d.click||function(e){e.preventDefault()},d)),p.addEventListener(\"touchend\",function(e){return
		// function(t){function a(e){return
		// e.classList.contains(\"export-main\")||e.classList.contains(\"export-drawing\")}t.preventDefault();var
		// r=e.elements.li,s=function(e){var
		// t=e.parentNode.parentNode,a=t.classList;return!(\"LI\"!=t.tagName||!a.contains(\"active\"))}(r),l=(function(e){var
		// t=e.parentNode.children;for(o=0;o<t.length;o++){var
		// a=t[o],i=a.classList;if(a!==e&&i.contains(\"active\"))return
		// i.remove(\"active\"),!0}}(r),function(e){return
		// e.getElementsByTagName(\"ul\").length>0}(r));if(!a(r)&&l||i.setup.menu.classList.toggle(\"active\"),!s||!l)for(;n.length;){var
		// d=n.pop(),c=d!==r;a(d)?l||d.classList.remove(\"active\"):c&&d.classList.remove(\"active\")}n.push(r),l&&r.classList.toggle(\"active\")}}(d))):p.addEventListener(\"click\",function(e,t){return
		// function(a){a.preventDefault();var
		// r=[a,t];if((\"draw\"==t.action||\"PRINT\"==t.format||\"UNDEFINED\"!=t.format&&t.capture)&&!i.drawing.enabled&&(!isNaN(t.delay)||!isNaN(i.config.delay)))return
		// t.delay=isNaN(t.delay)?i.config.delay:t.delay,void
		// i.delay(t,e);e.apply(i,r)}}(d.click||function(e){e.preventDefault()},d)),c.appendChild(p),i.isElement(d.label)?u.appendChild(d.label):u.innerHTML=d.label,d.class&&(c.className=d.class),d.style&&c.setAttribute(\"style\",d.style),d.icon&&(f.setAttribute(\"src\",(d.ignore||-1!=d.icon.slice(0,10).indexOf(\"//\")?\"\":e.pathToImages)+d.icon),p.appendChild(f)),d.label&&p.appendChild(u),d.title&&p.setAttribute(\"title\",d.title),i.config.menuReviver&&(c=i.config.menuReviver.apply(i,[d,c])),d.elements={li:c,a:p,img:f,span:u},(d.menu||d.items)&&\"draw\"!=d.action?r(d.menu||d.items,c).childNodes.length&&l.appendChild(c):l.appendChild(c))}}return
		// l.childNodes.length&&a.appendChild(l),l}var n=[];return
		// a||(\"string\"==typeof
		// i.config.divId?i.config.divId=a=document.getElementById(i.config.divId):a=i.isElement(i.config.divId)?i.config.divId:i.setup.chart.containerDiv),i.isElement(i.setup.menu)?i.setup.menu.innerHTML=\"\":i.setup.menu=document.createElement(\"div\"),i.setup.menu.setAttribute(\"class\",i.setup.chart.classNamePrefix+\"-export-menu
		// \"+i.setup.chart.classNamePrefix+\"-export-menu-\"+i.config.position+\"
		// amExportButton\"),i.config.menuWalker&&(r=i.config.menuWalker),r.apply(this,[t,i.setup.menu]),i.setup.menu.childNodes.length&&a.appendChild(i.setup.menu),i.setup.menu},delay:function(e,t){var
		// a,r,n=i.deepMerge({delay:3,precision:2},e||{}),o=Number(new
		// Date),s=i.createMenu([{label:i.i18l(\"capturing.delayed.menu.label\").replace(\"{{duration}}\",AmCharts.toFixed(n.delay,n.precision)),title:i.i18l(\"capturing.delayed.menu.title\"),class:\"export-delayed-capturing\",click:function(){clearTimeout(a),clearTimeout(r),i.createMenu(i.config.menu)}}]).getElementsByTagName(\"a\")[0];a=setInterval(function(){var
		// e=n.delay-(Number(new
		// Date)-o)/1e3;e<=0?(clearTimeout(a),\"draw\"!=n.action&&i.createMenu(i.config.menu)):s&&(s.innerHTML=i.i18l(\"capturing.delayed.menu.label\").replace(\"{{duration}}\",AmCharts.toFixed(e,2)))},AmCharts.updateRate),r=setTimeout(function(){t.apply(i,arguments)},1e3*n.delay)},migrateSetup:function(e){function
		// t(e){var i;for(i in e){var
		// r=e[i];\"export\"==i.slice(0,6)&&r?a.menu.push(i.slice(6)):\"userCFG\"==i?t(r):\"menuItems\"==i?a.menu=r:\"libs\"==i?a.libs=r:\"string\"==typeof
		// i&&(a[i]=r)}}var a={enabled:!0,migrated:!0,libs:{autoLoad:!0},menu:[]};return
		// t(e),a},clear:function(){var e,t;for(void
		// 0!==i.setup.fabric&&i.setup.fabric.removeListeners(),e=0;e<i.listenersToRemove.length;e++)(t=i.listenersToRemove[e]).node.removeEventListener(t.event,t.method);i.isElement(i.setup.wrapper)&&i.isElement(i.setup.wrapper.parentNode)&&i.setup.wrapper.parentNode.removeChild&&i.setup.wrapper.parentNode.removeChild(i.setup.wrapper),i.isElement(i.setup.menu)&&i.isElement(i.setup.wrapper.parentNode)&&i.setup.wrapper.parentNode.removeChild&&i.setup.menu.parentNode.removeChild(i.setup.menu),i.listenersToRemove=[],i.setup.chart.AmExport=void
		// 0,i.setup.chart.export=void 0,i.setup=void
		// 0},loadListeners:function(){function
		// e(e){e&&(e.set({top:e.top+10,left:e.left+10}),i.setup.fabric.add(e))}i.config.keyListener&&\"attached\"!=i.config.keyListener&&(i.docListener=function(t){function
		// a(e,t){for(i1=0;i1<e.length;i1++){var
		// a=e[i1];a.parentNode.classList.remove(\"active\"),0!=i1||t||a.focus()}}function
		// r(e){i.setup.focusedMenuItem&&i.setup.focusedMenuItem.nextSibling&&(i.setup.focusedMenuItem.parentNode.classList.add(\"active\"),a(i.setup.focusedMenuItem.nextSibling.getElementsByTagName(\"a\"),e))}function
		// n(e){i.setup.focusedMenuItem&&i.setup.focusedMenuItem.parentNode.parentNode.parentNode&&(i.setup.focusedMenuItem.parentNode.classList.add(\"active\"),a(i.setup.focusedMenuItem.parentNode.parentNode.parentNode.getElementsByTagName(\"a\"),e))}var
		// o=i.drawing.buffer.target,s=[37,38,39,40,13,9,27],l=([\"top-left\",\"bottom-left\"].indexOf(i.config.position),-1!=[\"top-right\",\"bottom-right\"].indexOf(i.config.position));if(i.setup.focusedMenuItem&&-1!=s.indexOf(t.keyCode)){if(9==t.keyCode)return
		// void(i.setup.focusedMenuItem.nextSibling?t.shiftKey&&i.setup.focusedMenuItem.parentNode.classList.remove(\"active\"):(i.setup.focusedMenuItem.parentNode.classList.remove(\"active\"),i.setup.focusedMenuItem.parentNode.nextSibling||(i.setup.focusedMenuItem.parentNode.classList.remove(\"active\"),i.setup.focusedMenuItem.parentNode.parentNode.parentNode.classList.remove(\"active\"))));13==t.keyCode&&i.setup.focusedMenuItem.nextSibling&&r(),37==t.keyCode&&(l?r():n()),39==t.keyCode&&(l?n():r()),40==t.keyCode&&function(e){i.setup.focusedMenuItem&&i.setup.focusedMenuItem.parentNode.nextSibling&&(i.setup.focusedMenuItem.parentNode.classList.remove(\"active\"),a(i.setup.focusedMenuItem.parentNode.nextSibling.getElementsByTagName(\"a\"),e))}(),38==t.keyCode&&function(e){i.setup.focusedMenuItem&&i.setup.focusedMenuItem.parentNode.previousSibling&&(i.setup.focusedMenuItem.parentNode.classList.remove(\"active\"),a(i.setup.focusedMenuItem.parentNode.previousSibling.getElementsByTagName(\"a\"),e))}(),27==t.keyCode&&function(){function
		// e(t){if(i.isElement(t)){try{t.blur()}catch(e){}t.parentNode&&t.parentNode.classList.remove(\"active\"),t.classList.contains(\"amExportButton\")||e(t.parentNode)}}i.setup.focusedMenuItem&&(e(i.setup.focusedMenuItem),i.setup.focusedMenuItem=void
		// 0)}()}8!=t.keyCode&&46!=t.keyCode||!o?27==t.keyCode&&i.drawing.enabled?(t.preventDefault(),i.drawing.buffer.isSelected?i.setup.fabric.discardActiveObject():i.drawing.handler.done()):67==t.keyCode&&(t.metaKey||t.ctrlKey)&&o?i.drawing.buffer.copy=o:88==t.keyCode&&(t.metaKey||t.ctrlKey)&&o?(i.drawing.buffer.copy=o,i.setup.fabric.remove(o)):86==t.keyCode&&(t.metaKey||t.ctrlKey)?i.drawing.buffer.copy&&e(i.drawing.buffer.copy.clone(e)):90==t.keyCode&&(t.metaKey||t.ctrlKey)&&(t.preventDefault(),t.shiftKey?i.drawing.handler.redo():i.drawing.handler.undo()):(t.preventDefault(),i.setup.fabric.remove(o))},i.config.keyListener=\"attached\",document.addEventListener(\"keydown\",i.docListener),i.addListenerToRemove(\"keydown\",document,i.docListener)),i.config.fileListener&&(i.setup.chart.containerDiv.addEventListener(\"dragover\",i.handleDropbox),i.addListenerToRemove(\"dragover\",i.setup.chart.containerDiv,i.handleDropbox),i.setup.chart.containerDiv.addEventListener(\"dragleave\",i.handleDropbox),i.addListenerToRemove(\"dragleave\",i.setup.chart.containerDiv,i.handleDropbox),i.setup.chart.containerDiv.addEventListener(\"drop\",i.handleDropbox),i.addListenerToRemove(\"drop\",i.setup.chart.containerDiv,i.handleDropbox))},init:function(){clearTimeout(a),a=setInterval(function(){i.setup&&i.setup.chart.containerDiv&&(clearTimeout(a),i.config.enabled&&(i.setup.chart.AmExport=i,i.config.overflow&&(i.setup.chart.div.style.overflow=\"visible\"),i.loadListeners(),i.createMenu(i.config.menu),i.handleReady(i.config.onReady)))},AmCharts.updateRate)},construct:function(){i.drawing.handler.cancel=i.drawing.handler.done;try{i.setup.hasBlob=!!new
		// Blob}catch(e){}window.safari=window.safari?window.safari:{},i.defaults.fabric.drawing.fontSize=i.setup.chart.fontSize||11,i.config.drawing=i.deepMerge(i.defaults.fabric.drawing,i.config.drawing||{},!0),i.config.border&&(i.config.border=i.deepMerge(i.defaults.fabric.border,i.config.border||{},!0)),i.deepMerge(i.defaults.fabric,i.config,!0),i.deepMerge(i.defaults.fabric,i.config.fabric||{},!0),i.deepMerge(i.defaults.pdfMake,i.config,!0),i.deepMerge(i.defaults.pdfMake,i.config.pdfMake||{},!0),i.deepMerge(i.libs,i.config.libs||{},!0),i.config.drawing=i.defaults.fabric.drawing,i.config.fabric=i.defaults.fabric,i.config.pdfMake=i.defaults.pdfMake,i.config=i.deepMerge(i.defaults,i.config,!0),i.config.fabric.drawing.enabled&&void
		// 0===i.config.fabric.drawing.menu&&(i.config.fabric.drawing.menu=[],i.deepMerge(i.config.fabric.drawing.menu,[{class:\"export-drawing\",menu:[{label:i.i18l(\"menu.label.draw.add\"),menu:[{label:i.i18l(\"menu.label.draw.shapes\"),action:\"draw.shapes\"},{label:i.i18l(\"menu.label.draw.text\"),action:\"text\"}]},{label:i.i18l(\"menu.label.draw.change\"),menu:[{label:i.i18l(\"menu.label.draw.modes\"),action:\"draw.modes\"},{label:i.i18l(\"menu.label.draw.colors\"),action:\"draw.colors\"},{label:i.i18l(\"menu.label.draw.widths\"),action:\"draw.widths\"},{label:i.i18l(\"menu.label.draw.opacities\"),action:\"draw.opacities\"},\"UNDO\",\"REDO\"]},{label:i.i18l(\"menu.label.save.image\"),menu:[\"PNG\",\"JPG\",\"SVG\",\"PDF\"]},\"PRINT\",\"CANCEL\"]}])),void
		// 0===i.config.menu&&(i.config.menu=[],i.deepMerge(i.config,{menu:[{class:\"export-main\",menu:[{label:i.i18l(\"menu.label.save.image\"),menu:[\"PNG\",\"JPG\",\"SVG\",\"PDF\"]},{label:i.i18l(\"menu.label.save.data\"),menu:[\"CSV\",\"XLSX\",\"JSON\"]},{label:i.i18l(\"menu.label.draw\"),action:\"draw\",menu:i.config.fabric.drawing.menu},{format:\"PRINT\",label:i.i18l(\"menu.label.print\")}]}]})),i.libs.path||(i.libs.path=i.config.path+\"libs/\"),i.setup.hasClasslist||i.libs.resources.push(\"classList.js/classList.min.js\"),i.isSupported()&&(i.loadDependencies(i.libs.resources,i.libs.reload),i.setup.chart.addClassNames=!0,i.setup.chart[i.name]=i,i.init())}};if(t)i.config=t;else
		// if(i.setup.chart[i.name])i.config=i.setup.chart[i.name];else{if(!i.setup.chart.amExport&&!i.setup.chart.exportConfig)return;i.config=i.migrateSetup(i.setup.chart.amExport||i.setup.chart.exportConfig)}return
		// i.construct(),i.deepMerge(this,i)},AmCharts.addInitHandler(function(e){new
		// AmCharts.export(e)},[\"pie\",\"serial\",\"xy\",\"funnel\",\"radar\",\"gauge\",\"stock\",\"map\",\"gantt\"]);</script>");
		// bw.newLine();
		// bw.write("<style>.amcharts-export-canvas{position:absolute;display:none;z-index:1;top:0;right:0;bottom:0;left:0;background-color:#fff;}.amcharts-export-canvas.active{display:block;}.amcharts-export-menu{position:absolute;z-index:2;opacity:0.5;color:#000;}.amcharts-main-div:hover
		// .amcharts-export-menu,.amcharts-stock-div:hover
		// .amcharts-export-menu,.amcharts-export-menu.active{opacity:1;}.amcharts-export-menu-top-left>ul>li>ul:after{content:\"\";position:absolute;top:13px;right:100%;z-index:1000;border-top:7px
		// solid transparent;border-left:7px solid transparent;border-right:7px solid
		// #fff;border-bottom:7px solid
		// transparent;}.amcharts-export-menu-top-left>ul>li>ul>li:first-child>a:after{content:\"\";position:absolute;top:12px;right:100%;z-index:1001;border-top:8px
		// solid transparent;border-left:8px solid transparent;border-right:8px solid
		// #e2e2e2;border-bottom:8px solid
		// transparent;}.amcharts-export-menu-top-right>ul>li>ul:after{content:\"\";position:absolute;top:13px;left:100%;z-index:1000;border-top:7px
		// solid transparent;border-left:7px solid #fff;border-right:7px solid
		// transparent;border-bottom:7px solid
		// transparent;}.amcharts-export-menu-top-right>ul>li>ul>li:first-child>a:after{content:\"\";position:absolute;top:12px;left:100%;z-index:1001;border-top:8px
		// solid transparent;border-left:8px solid #e2e2e2;border-right:8px solid
		// transparent;border-bottom:8px solid
		// transparent;}.amcharts-export-menu-bottom-left>ul>li>ul:after{content:\"\";position:absolute;bottom:13px;right:100%;z-index:1000;border-top:7px
		// solid transparent;border-left:7px solid transparent;border-right:7px solid
		// #fff;border-bottom:7px solid
		// transparent;}.amcharts-export-menu-bottom-left>ul>li>ul>li:last-child>a:after{content:\"\";position:absolute;bottom:12px;right:100%;z-index:1001;border-top:8px
		// solid transparent;border-left:8px solid transparent;border-right:8px solid
		// #e2e2e2;border-bottom:8px solid
		// transparent;}.amcharts-export-menu-bottom-right>ul>li>ul:after{content:\"\";position:absolute;bottom:13px;left:100%;z-index:1000;border-top:7px
		// solid transparent;border-left:7px solid #fff;border-right:7px solid
		// transparent;border-bottom:7px solid
		// transparent;}.amcharts-export-menu-bottom-right>ul>li>ul>li:last-child>a:after{content:\"\";position:absolute;bottom:12px;left:100%;z-index:1001;border-top:8px
		// solid transparent;border-left:8px solid #e2e2e2;border-right:8px solid
		// transparent;border-bottom:8px solid transparent;}.amcharts-export-menu
		// ul{list-style:none;margin:0;padding:0;}.amcharts-export-menu
		// li{position:relative;display:block;z-index:1;}.amcharts-export-menu
		// li>ul{position:absolute;display:none;border:1px solid
		// #e2e2e2;margin-top:-1px;background:#fff;}.amcharts-export-menu
		// li>a{position:relative;display:block;color:#000;text-decoration:none;padding:12px
		// 12px;z-index:2;white-space:nowrap;border-bottom:1px solid
		// #f2f2f2;}.amcharts-export-menu
		// li:last-child>a{border-bottom:none;}.amcharts-export-menu
		// li>a>img{border:none;}.amcharts-export-menu-top-left{top:0;left:0;}.amcharts-export-menu-bottom-left{bottom:0;left:0;}.amcharts-export-menu-top-right{top:0;right:0;}.amcharts-export-menu-bottom-right{bottom:0;right:0;}.amcharts-export-menu
		// li:hover>ul,.amcharts-export-menu
		// li.active>ul{display:block;}.amcharts-export-menu
		// li:hover>a,.amcharts-export-menu
		// li.active>a{color:#fff;background-color:#636363;}.amcharts-export-menu-top-left
		// li:hover>ul,.amcharts-export-menu-top-left
		// li.active>ul{left:100%;top:0;}.amcharts-export-menu-bottom-left
		// li:hover>ul,.amcharts-export-menu-bottom-left
		// li.active>ul{left:100%;bottom:0;}.amcharts-export-menu-top-right
		// li:hover>ul,.amcharts-export-menu-top-right
		// li.active>ul{top:0;right:100%;}.amcharts-export-menu-bottom-right
		// li:hover>ul,.amcharts-export-menu-bottom-right
		// li.active>ul{bottom:0;right:100%;}.amcharts-export-menu
		// .export-main>a,.amcharts-export-menu .export-drawing>a,.amcharts-export-menu
		// .export-delayed-capturing>a{display:block;overflow:hidden;text-indent:-13333337px;width:36px;height:36px;padding:0;background-repeat:no-repeat;background-image:url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20width%3D%2211px%22%20height%3D%2214px%22%3E%3Cpath%20d%3D%22M3%2C0%20L8%2C0%20L8%2C5%20L11%2C5%20L5.5%2C10%20L0%2C5%20L3%2C5%20L03%2C0%22%20fill%3D%22%23888%22%2F%3E%3Crect%20x%3D%220%22%20y%3D%2212%22%20fill%3D%22%23888%22%20width%3D%2211%22%20height%3D%222%22%2F%3E%3C%2Fsvg%3E');background-color:#fff;background-position:center;-webkit-box-shadow:1px
		// 1px 3px 0px rgba(0,0,0,0.5);-moz-box-shadow:1px 1px 3px 0px
		// rgba(0,0,0,0.5);box-shadow:1px 1px 3px 0px
		// rgba(0,0,0,0.5);border-radius:18px;margin:8px 8px 0
		// 10px;}.amcharts-export-menu
		// .export-drawing>a{background-image:url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20version%3D%221.1%22%20width%3D%2216px%22%20height%3D%2217px%22%3E%3Crect%20x%3D%220%22%20y%3D%2216%22%20fill%3D%22%23888%22%20width%3D%2214%22%20height%3D%221%22%2F%3E%3Cpath%20transform%3D%22translate(-12%2C-10)%22%20fill%3D%22%23888%22%20d%3D%22M17.098%2C20.305c-0.142%2C0.146%2C0.101%2C0.04%2C0.137%2C0.004c0.027-0.028%2C0.204-0.09%2C0.484-0.09c0.338%2C0%2C0.626%2C0.092%2C0.787%2C0.255%20c0.473%2C0.472%2C0.424%2C0.932%2C0.393%2C1.078l-2.521%2C1.055l-1.577-1.577l1.054-2.52c0.039-0.009%2C0.105-0.018%2C0.188-0.018%20c0.219%2C0%2C0.555%2C0.069%2C0.893%2C0.407c0.378%2C0.378%2C0.246%2C1.188%2C0.166%2C1.271C17.062%2C20.207%2C17.062%2C20.269%2C17.098%2C20.305z%20M26.984%2C14.472c-0.008-0.674-0.61-1.257-1.31-1.933c-0.134-0.129-0.679-0.673-0.809-0.808c-0.679-0.702-1.266-1.31-1.943-1.31%20c-0.37%2C0-0.734%2C0.207-1.114%2C0.587l-6.852%2C6.847c-0.012%2C0.016-2.877%2C7.354-2.877%2C7.354c-0.012%2C0.032%2C0%2C0.063%2C0.022%2C0.091%20c0.021%2C0.021%2C0.044%2C0.029%2C0.067%2C0.029c0.01%2C0%2C0.018-0.003%2C0.028-0.007c0%2C0%2C7.357-2.864%2C7.369-2.877l6.854-6.847%20C26.803%2C15.216%2C26.988%2C14.848%2C26.984%2C14.472z%22%2F%3E%3C%2Fsvg%3E');}.amcharts-export-menu
		// .export-main:hover,.amcharts-export-menu
		// .export-drawing:hover,.amcharts-export-menu
		// .export-main.active,.amcharts-export-menu
		// .export-drawing.active{padding-bottom:100px;}.amcharts-export-menu.amcharts-export-menu-bottom-left
		// .export-main:hover,.amcharts-export-menu.amcharts-export-menu-bottom-left
		// .export-drawing:hover,.amcharts-export-menu.amcharts-export-menu-bottom-right
		// .export-main:hover,.amcharts-export-menu.amcharts-export-menu-bottom-right
		// .export-drawing:hover,.amcharts-export-menu.amcharts-export-menu-bottom-left
		// .export-main.active,.amcharts-export-menu.amcharts-export-menu-bottom-left
		// .export-drawing.active,.amcharts-export-menu.amcharts-export-menu-bottom-right
		// .export-main.active,.amcharts-export-menu.amcharts-export-menu-bottom-right
		// .export-drawing.active{padding-bottom:0;padding-top:100px;}.amcharts-export-menu
		// .export-main:hover>a,.amcharts-export-menu
		// .export-main.active>a{background-image:url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20width%3D%2211px%22%20height%3D%2214px%22%3E%3Cpath%20d%3D%22M3%2C0%20L8%2C0%20L8%2C5%20L11%2C5%20L5.5%2C10%20L0%2C5%20L3%2C5%20L03%2C0%22%20fill%3D%22%23fff%22%2F%3E%3Crect%20x%3D%220%22%20y%3D%2212%22%20fill%3D%22%23fff%22%20width%3D%2211%22%20height%3D%222%22%2F%3E%3C%2Fsvg%3E');}.amcharts-export-menu
		// .export-drawing:hover>a,.amcharts-export-menu
		// .export-drawing.active>a{background-image:url('data:image/svg+xml;charset=utf8,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20xmlns%3Axlink%3D%22http%3A%2F%2Fwww.w3.org%2F1999%2Fxlink%22%20version%3D%221.1%22%20width%3D%2216px%22%20height%3D%2217px%22%3E%3Crect%20x%3D%220%22%20y%3D%2216%22%20fill%3D%22%23FFF%22%20width%3D%2214%22%20height%3D%221%22%2F%3E%3Cpath%20transform%3D%22translate(-12%2C-10)%22%20fill%3D%22%23FFF%22%20d%3D%22M17.098%2C20.305c-0.142%2C0.146%2C0.101%2C0.04%2C0.137%2C0.004c0.027-0.028%2C0.204-0.09%2C0.484-0.09c0.338%2C0%2C0.626%2C0.092%2C0.787%2C0.255%20c0.473%2C0.472%2C0.424%2C0.932%2C0.393%2C1.078l-2.521%2C1.055l-1.577-1.577l1.054-2.52c0.039-0.009%2C0.105-0.018%2C0.188-0.018%20c0.219%2C0%2C0.555%2C0.069%2C0.893%2C0.407c0.378%2C0.378%2C0.246%2C1.188%2C0.166%2C1.271C17.062%2C20.207%2C17.062%2C20.269%2C17.098%2C20.305z%20M26.984%2C14.472c-0.008-0.674-0.61-1.257-1.31-1.933c-0.134-0.129-0.679-0.673-0.809-0.808c-0.679-0.702-1.266-1.31-1.943-1.31%20c-0.37%2C0-0.734%2C0.207-1.114%2C0.587l-6.852%2C6.847c-0.012%2C0.016-2.877%2C7.354-2.877%2C7.354c-0.012%2C0.032%2C0%2C0.063%2C0.022%2C0.091%20c0.021%2C0.021%2C0.044%2C0.029%2C0.067%2C0.029c0.01%2C0%2C0.018-0.003%2C0.028-0.007c0%2C0%2C7.357-2.864%2C7.369-2.877l6.854-6.847%20C26.803%2C15.216%2C26.988%2C14.848%2C26.984%2C14.472z%22%2F%3E%3C%2Fsvg%3E');}.amcharts-export-menu
		// .export-close>a,.amcharts-export-menu
		// .export-close:hover>a,.amcharts-export-menu
		// .export-close.active>a{background-image:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAQCAYAAADNo/U5AAAACXBIWXMAAAsTAAALEwEAmpwYAABBsGlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS41LWMwMjEgNzkuMTU1NzcyLCAyMDE0LzAxLzEzLTE5OjQ0OjAwICAgICAgICAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIKICAgICAgICAgICAgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiCiAgICAgICAgICAgIHhtbG5zOnN0RXZ0PSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VFdmVudCMiCiAgICAgICAgICAgIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIKICAgICAgICAgICAgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIgogICAgICAgICAgICB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iCiAgICAgICAgICAgIHhtbG5zOnRpZmY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vdGlmZi8xLjAvIgogICAgICAgICAgICB4bWxuczpleGlmPSJodHRwOi8vbnMuYWRvYmUuY29tL2V4aWYvMS4wLyI+CiAgICAgICAgIDx4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ+eG1wLmRpZDo4M2Q5NDllYS1lMjE3LTQ3Y2QtYTU1Ni04MTQ3NmRjNWEwYWQ8L3htcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD4KICAgICAgICAgPHhtcE1NOkRvY3VtZW50SUQ+YWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOjZhMTQ5MTc1LTNiODItMTE3OC05ZjZmLWY0MWMwNTYyYzQxYTwveG1wTU06RG9jdW1lbnRJRD4KICAgICAgICAgPHhtcE1NOkluc3RhbmNlSUQ+eG1wLmlpZDpkZGFhNTJkMi1mZDRiLTRkMmMtODEzOC01ZTEzNmQ4NGFjMDE8L3htcE1NOkluc3RhbmNlSUQ+CiAgICAgICAgIDx4bXBNTTpEZXJpdmVkRnJvbSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgIDxzdFJlZjppbnN0YW5jZUlEPnhtcC5paWQ6MDdhZmI1Y2UtYzQ1OS00YzQxLWJkMjItMTllMDJlMGE5YzVjPC9zdFJlZjppbnN0YW5jZUlEPgogICAgICAgICAgICA8c3RSZWY6ZG9jdW1lbnRJRD54bXAuZGlkOjA3YWZiNWNlLWM0NTktNGM0MS1iZDIyLTE5ZTAyZTBhOWM1Yzwvc3RSZWY6ZG9jdW1lbnRJRD4KICAgICAgICAgICAgPHN0UmVmOm9yaWdpbmFsRG9jdW1lbnRJRD54bXAuZGlkOjgzZDk0OWVhLWUyMTctNDdjZC1hNTU2LTgxNDc2ZGM1YTBhZDwvc3RSZWY6b3JpZ2luYWxEb2N1bWVudElEPgogICAgICAgICA8L3htcE1NOkRlcml2ZWRGcm9tPgogICAgICAgICA8eG1wTU06SGlzdG9yeT4KICAgICAgICAgICAgPHJkZjpTZXE+CiAgICAgICAgICAgICAgIDxyZGY6bGkgcmRmOnBhcnNlVHlwZT0iUmVzb3VyY2UiPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6YWN0aW9uPnNhdmVkPC9zdEV2dDphY3Rpb24+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDppbnN0YW5jZUlEPnhtcC5paWQ6YmY3ZmRlNGYtZDk2MS00Njk4LWI0ZjAtMDJlYjEwOWE4OTA4PC9zdEV2dDppbnN0YW5jZUlEPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6d2hlbj4yMDE1LTA1LTE1VDEzOjE3OjQ5KzAyOjAwPC9zdEV2dDp3aGVuPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6c29mdHdhcmVBZ2VudD5BZG9iZSBQaG90b3Nob3AgQ0MgMjAyMSAoTWFjaW50b3NoKTwvc3RFdnQ6c29mdHdhcmVBZ2VudD4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OmNoYW5nZWQ+Lzwvc3RFdnQ6Y2hhbmdlZD4KICAgICAgICAgICAgICAgPC9yZGY6bGk+CiAgICAgICAgICAgICAgIDxyZGY6bGkgcmRmOnBhcnNlVHlwZT0iUmVzb3VyY2UiPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6YWN0aW9uPmNvbnZlcnRlZDwvc3RFdnQ6YWN0aW9uPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6cGFyYW1ldGVycz5mcm9tIGltYWdlL3BuZyB0byBhcHBsaWNhdGlvbi92bmQuYWRvYmUucGhvdG9zaG9wPC9zdEV2dDpwYXJhbWV0ZXJzPgogICAgICAgICAgICAgICA8L3JkZjpsaT4KICAgICAgICAgICAgICAgPHJkZjpsaSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDphY3Rpb24+ZGVyaXZlZDwvc3RFdnQ6YWN0aW9uPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6cGFyYW1ldGVycz5jb252ZXJ0ZWQgZnJvbSBpbWFnZS9wbmcgdG8gYXBwbGljYXRpb24vdm5kLmFkb2JlLnBob3Rvc2hvcDwvc3RFdnQ6cGFyYW1ldGVycz4KICAgICAgICAgICAgICAgPC9yZGY6bGk+CiAgICAgICAgICAgICAgIDxyZGY6bGkgcmRmOnBhcnNlVHlwZT0iUmVzb3VyY2UiPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6YWN0aW9uPnNhdmVkPC9zdEV2dDphY3Rpb24+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDppbnN0YW5jZUlEPnhtcC5paWQ6MDdhZmI1Y2UtYzQ1OS00YzQxLWJkMjItMTllMDJlMGE5YzVjPC9zdEV2dDppbnN0YW5jZUlEPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6d2hlbj4yMDE1LTA1LTE1VDEzOjE3OjQ5KzAyOjAwPC9zdEV2dDp3aGVuPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6c29mdHdhcmVBZ2VudD5BZG9iZSBQaG90b3Nob3AgQ0MgMjAyMSAoTWFjaW50b3NoKTwvc3RFdnQ6c29mdHdhcmVBZ2VudD4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OmNoYW5nZWQ+Lzwvc3RFdnQ6Y2hhbmdlZD4KICAgICAgICAgICAgICAgPC9yZGY6bGk+CiAgICAgICAgICAgICAgIDxyZGY6bGkgcmRmOnBhcnNlVHlwZT0iUmVzb3VyY2UiPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6YWN0aW9uPmRlcml2ZWQ8L3N0RXZ0OmFjdGlvbj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OnBhcmFtZXRlcnM+Y29udmVydGVkIGZyb20gYXBwbGljYXRpb24vdm5kLmFkb2JlLnBob3Rvc2hvcCB0byBpbWFnZS9wbmc8L3N0RXZ0OnBhcmFtZXRlcnM+CiAgICAgICAgICAgICAgIDwvcmRmOmxpPgogICAgICAgICAgICAgICA8cmRmOmxpIHJkZjpwYXJzZVR5cGU9IlJlc291cmNlIj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OmFjdGlvbj5zYXZlZDwvc3RFdnQ6YWN0aW9uPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6aW5zdGFuY2VJRD54bXAuaWlkOmRkYWE1MmQyLWZkNGItNGQyYy04MTM4LTVlMTM2ZDg0YWMwMTwvc3RFdnQ6aW5zdGFuY2VJRD4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OndoZW4+MjAxNS0wNS0xNVQxMzoyMToyMSswMjowMDwvc3RFdnQ6d2hlbj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OnNvZnR3YXJlQWdlbnQ+QWRvYmUgUGhvdG9zaG9wIENDIDIwMjEgKE1hY2ludG9zaCk8L3N0RXZ0OnNvZnR3YXJlQWdlbnQ+CiAgICAgICAgICAgICAgICAgIDxzdEV2dDpjaGFuZ2VkPi88L3N0RXZ0OmNoYW5nZWQ+CiAgICAgICAgICAgICAgIDwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpTZXE+CiAgICAgICAgIDwveG1wTU06SGlzdG9yeT4KICAgICAgICAgPHhtcDpDcmVhdG9yVG9vbD5BZG9iZSBQaG90b3Nob3AgQ0MgMjAxNCAoTWFjaW50b3NoKTwveG1wOkNyZWF0b3JUb29sPgogICAgICAgICA8eG1wOkNyZWF0ZURhdGU+MjAxNS0wNS0xNVQxMzoxMzoxNyswMjowMDwveG1wOkNyZWF0ZURhdGU+CiAgICAgICAgIDx4bXA6TW9kaWZ5RGF0ZT4yMDE1LTA1LTE1VDEzOjIxOjIxKzAyOjAwPC94bXA6TW9kaWZ5RGF0ZT4KICAgICAgICAgPHhtcDpNZXRhZGF0YURhdGU+MjAxNS0wNS0xNVQxMzoyMToyMSswMjowMDwveG1wOk1ldGFkYXRhRGF0ZT4KICAgICAgICAgPGRjOmZvcm1hdD5pbWFnZS9wbmc8L2RjOmZvcm1hdD4KICAgICAgICAgPHBob3Rvc2hvcDpDb2xvck1vZGU+MzwvcGhvdG9zaG9wOkNvbG9yTW9kZT4KICAgICAgICAgPHBob3Rvc2hvcDpUZXh0TGF5ZXJzPgogICAgICAgICAgICA8cmRmOkJhZz4KICAgICAgICAgICAgICAgPHJkZjpsaSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgICAgICAgIDxwaG90b3Nob3A6TGF5ZXJOYW1lPlg8L3Bob3Rvc2hvcDpMYXllck5hbWU+CiAgICAgICAgICAgICAgICAgIDxwaG90b3Nob3A6TGF5ZXJUZXh0Plg8L3Bob3Rvc2hvcDpMYXllclRleHQ+CiAgICAgICAgICAgICAgIDwvcmRmOmxpPgogICAgICAgICAgICA8L3JkZjpCYWc+CiAgICAgICAgIDwvcGhvdG9zaG9wOlRleHRMYXllcnM+CiAgICAgICAgIDx0aWZmOk9yaWVudGF0aW9uPjE8L3RpZmY6T3JpZW50YXRpb24+CiAgICAgICAgIDx0aWZmOlhSZXNvbHV0aW9uPjcyMDAwMC8xMDAwMDwvdGlmZjpYUmVzb2x1dGlvbj4KICAgICAgICAgPHRpZmY6WVJlc29sdXRpb24+NzIwMDAwLzEwMDAwPC90aWZmOllSZXNvbHV0aW9uPgogICAgICAgICA8dGlmZjpSZXNvbHV0aW9uVW5pdD4yPC90aWZmOlJlc29sdXRpb25Vbml0PgogICAgICAgICA8ZXhpZjpDb2xvclNwYWNlPjY1NTM1PC9leGlmOkNvbG9yU3BhY2U+CiAgICAgICAgIDxleGlmOlBpeGVsWERpbWVuc2lvbj4xMzwvZXhpZjpQaXhlbFhEaW1lbnNpb24+CiAgICAgICAgIDxleGlmOlBpeGVsWURpbWVuc2lvbj4xNjwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5kPSJ3Ij8+HyMp+AAAACBjSFJNAAB6JQAAgIMAAPn/AACA6QAAdTAAAOpgAAA6mAAAF2+SX8VGAAAA3UlEQVR42rSSXZECQQyEPygMrIVFAidhkQASQEIjYVsCSOAksBJAAlhAwvKSWcJBUQVVl6fM5Ke7k4z6vudTG/OFTQAktcAs/ja2TyVBUgVsgQq42F5PItYBCn8PTFNjAYvw5wM92x3gCNSSFCh1araLvAdNBi53VgMtgCuweRqE7RyogAPQxHsdcQBGf0cuaZ80APzaXn468urtniQ1CaXoayStct5AL4QfgToKfoBzIF2BadGVkVZRkIU7UdQDkqRZoDwJl3ROzea2u4LUvtpHOavkty9H/m9XfhsA0l9VuzQDWrIAAAAASUVORK5CYII=);}.amcharts-export-menu
		// .export-drawing-color{background:#000;width:35px;}.amcharts-export-menu
		// .export-drawing-color>a{display:block;overflow:hidden;text-indent:-13333337px;}.amcharts-export-menu
		// .export-drawing-color-red{background:#f00;}.amcharts-export-menu
		// .export-drawing-color-green{background:#0f0;}.amcharts-export-menu
		// .export-drawing-color-blue{background:#00f;}.amcharts-export-menu
		// .export-drawing-color-white{background:#fff;}.amcharts-export-fallback{position:absolute;top:0;right:0;bottom:0;left:0;background-color:#fff;}.amcharts-export-fallback
		// textarea{border:none;outline:none;position:absolute;overflow:hidden;width:100%;height:100%;padding:20px;}.amcharts-export-fallback-message{position:absolute;z-index:1;padding:20px;width:100%;background-color:#fff;}.amcharts-export-menu
		// .export-delayed-capturing>a{text-indent:0px;line-height:36px;vertical-align:middle;text-align:center;background-image:none;}.amcharts-export-menu,.amcharts-export-canvas
		// .canvas-container{-webkit-transition:opacity 0.5s
		// ease-out;-moz-transition:opacity 0.5s ease-out;-ms-transition:opacity 0.5s
		// ease-out;-o-transition:opacity 0.5s ease-out;transition:opacity 0.5s
		// ease-out;}.amcharts-export-canvas.dropbox
		// .canvas-container{opacity:0.5;}.amcharts-export-menu .export-drawing-shape
		// a{font:0/0 a;text-shadow:none;color:transparent;}.amcharts-export-menu li
		// img{height:20px;}.amcharts-export-menu .export-drawing-width
		// a{text-align:center;}.amcharts-export-menu .export-drawing-width
		// span{display:block;margin:0 auto;}.amcharts-export-menu .export-drawing-width
		// span>span{display:block;background:#000;border-radius:100%;}.amcharts-export-menu
		// .export-drawing-shape a:hover img,.amcharts-export-menu
		// .export-drawing-shape.active a
		// img{-webkit-filter:invert(100%);filter:invert(100%);}</style>");
		// bw.newLine();
		// bw.write("<script
		// type='text/javascript'>AmCharts.themes.light={themeName:\"light\",AmChart:{color:\"#000000\",backgroundColor:\"#FFFFFF\"},AmCoordinateChart:{colors:[\"#67b7dc\",\"#fdd400\",\"#84b761\",\"#cc4748\",\"#cd82ad\",\"#2f4074\",\"#448e4d\",\"#b7b83f\",\"#b9783f\",\"#b93e3d\",\"#913167\"]},AmStockChart:{colors:[\"#67b7dc\",\"#fdd400\",\"#84b761\",\"#cc4748\",\"#cd82ad\",\"#2f4074\",\"#448e4d\",\"#b7b83f\",\"#b9783f\",\"#b93e3d\",\"#913167\"]},AmSlicedChart:{colors:[\"#67b7dc\",\"#fdd400\",\"#84b761\",\"#cc4748\",\"#cd82ad\",\"#2f4074\",\"#448e4d\",\"#b7b83f\",\"#b9783f\",\"#b93e3d\",\"#913167\"],outlineAlpha:1,outlineThickness:2,labelTickColor:\"#000000\",labelTickAlpha:0.3},AmRectangularChart:{zoomOutButtonColor:'#000000',zoomOutButtonRollOverAlpha:0.15,zoomOutButtonImage:\"lens\"},AxisBase:{axisColor:\"#000000\",axisAlpha:0.3,gridAlpha:0.1,gridColor:\"#000000\"},ChartScrollbar:{backgroundColor:\"#000000\",backgroundAlpha:0.12,graphFillAlpha:0.5,graphLineAlpha:0,selectedBackgroundColor:\"#FFFFFF\",selectedBackgroundAlpha:0.4,gridAlpha:0.15},ChartCursor:{cursorColor:\"#000000\",color:\"#FFFFFF\",cursorAlpha:0.5},AmLegend:{color:\"#000000\"},AmGraph:{lineAlpha:0.9},GaugeArrow:{color:\"#000000\",alpha:0.8,nailAlpha:0,innerRadius:\"40%\",nailRadius:15,startWidth:15,borderAlpha:0.8,nailBorderAlpha:0},GaugeAxis:{tickColor:\"#000000\",tickAlpha:1,tickLength:15,minorTickLength:8,axisThickness:3,axisColor:'#000000',axisAlpha:1,bandAlpha:0.8},TrendLine:{lineColor:\"#c03246\",lineAlpha:0.8},AreasSettings:{alpha:0.8,color:\"#67b7dc\",colorSolid:\"#003767\",unlistedAreasAlpha:0.4,unlistedAreasColor:\"#000000\",outlineColor:\"#FFFFFF\",outlineAlpha:0.5,outlineThickness:0.5,rollOverColor:\"#3c5bdc\",rollOverOutlineColor:\"#FFFFFF\",selectedOutlineColor:\"#FFFFFF\",selectedColor:\"#f15135\",unlistedAreasOutlineColor:\"#FFFFFF\",unlistedAreasOutlineAlpha:0.5},LinesSettings:{color:\"#000000\",alpha:0.8},ImagesSettings:{alpha:0.8,labelColor:\"#000000\",color:\"#000000\",labelRollOverColor:\"#3c5bdc\"},ZoomControl:{buttonFillAlpha:0.7,buttonIconColor:\"#a7a7a7\"},SmallMap:{mapColor:\"#000000\",rectangleColor:\"#f15135\",backgroundColor:\"#FFFFFF\",backgroundAlpha:0.7,borderThickness:1,borderAlpha:0.8},PeriodSelector:{color:\"#000000\"},PeriodButton:{color:\"#000000\",background:\"transparent\",opacity:0.7,border:\"1px
		// solid rgba(0, 0, 0,
		// .3)\",MozBorderRadius:\"5px\",borderRadius:\"5px\",margin:\"1px\",outline:\"none\",boxSizing:\"border-box\"},PeriodButtonSelected:{color:\"#000000\",backgroundColor:\"#b9cdf5\",border:\"1px
		// solid rgba(0, 0, 0,
		// .3)\",MozBorderRadius:\"5px\",borderRadius:\"5px\",margin:\"1px\",outline:\"none\",opacity:1,boxSizing:\"border-box\"},PeriodInputField:{color:\"#000000\",background:\"transparent\",border:\"1px
		// solid rgba(0, 0, 0,
		// .3)\",outline:\"none\"},DataSetSelector:{color:\"#000000\",selectedBackgroundColor:\"#b9cdf5\",rollOverBackgroundColor:\"#a8b0e4\"},DataSetCompareList:{color:\"#000000\",lineHeight:\"100%\",boxSizing:\"initial\",webkitBoxSizing:\"initial\",border:\"1px
		// solid rgba(0, 0, 0, .3)\"},DataSetSelect:{border:\"1px solid rgba(0, 0, 0,
		// .3)\",outline:\"none\"}};</script>");
		// bw.newLine();
		// bw.write("<div id='chartdiv' style='height:200px'></div>"); //
		// changes done
		// bw.newLine();
		// // Pie Chart-2
		//
		// bw.write("<script type='text/javascript'> var chart = AmCharts.makeChart(
		// \"chartdiv\", {\r\n"
		// + "\"type\": \"pie\",\r\n"
		// + "\"theme\": \"light\",\r\n"
		// + "\"dataProvider\":" + json + ",\r\n"
		// + "\"valueField\": \"result\",\r\n"
		// + "\"titleField\": \"selenium\",\r\n"
		// + "\"balloon\":{\r\n"
		// + "\"fixedPosition\":true\r\n"
		// + " },\r\n"
		// + " \"export\": {\r\n"
		// + " \"enabled\": true\r\n"
		// + " }\r\n"
		// + "} ); </script>");
		// bw.write("</table></div></div>");
		//
		bw.write("</table></div></div></div>");
		bw.write("<div class='col-md-4 column'>");
		bw.write("<div class='panel panel-primary'>");
		bw.write("<div class='panel-heading'><strong>Summary Report</strong></div>");
		bw.newLine();
		bw.write("<table class='table table-striped'>");
		bw.newLine();

		bw.write("<tr><td>Test Environment</td>" + "</td><td >" + TestEnvironment + "</td></tr>");
		bw.newLine();

		bw.write("<tr><td>URL</td>" + "</td><td >" + Url + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td>Module Name</td>" + "</td><td >" + ScreenName + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td>TestCycle No.</td>" + "</td><td >" + Testcycle + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td>Total number of scenarios</td>" + "</td><td >" + count3 + "</td></tr>");
		bw.newLine();

		bw.write("<tr><td>Total number of steps</td>" + "</td><td >" + size + "</td></tr>");
		bw.newLine();

		bw.write("<tr><td>Pass Count</td>" + "</td><td >" + count1 + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >Fail Count</td>" + "</td><td>" + count2 + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >Start Time</td>" + "</td><td>" + STime + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >End Time</td>" + "</td><td>" + endTime + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >Total time taken in minutes</td>" + "</td><td>" + diffMinutes + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >Executed By</td>" + "</td><td>" + executedBy + "</td></tr>");
		bw.newLine();
		bw.write("<tr><td >Executed On</td>" + "</td><td>" + today + "</td></tr>");
		bw.newLine();
		bw.newLine();
		bw.write("</table></div></div></div></div>");

		mw.write("</table></div></div></div>");
		mw.write("<div class='col-md-4 column'>");
		mw.write("<div class='panel panel-primary'>");
		mw.write("<div class='panel-heading'><strong>Summary Report</strong></div>");
		mw.newLine();
		mw.write("<table class='table table-striped'>");
		mw.newLine();

		mw.write("<tr><td>Test Environment</td>" + "</td><td >" + TestEnvironment + "</td></tr>");
		mw.newLine();

		mw.write("<tr><td>URL</td>" + "</td><td >" + Url + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td>Module Name</td>" + "</td><td >" + ScreenName + "</td></tr>");
		mw.newLine();

		mw.write("<tr><td>TestCycle No.</td>" + "</td><td >" + Testcycle + "</td></tr>");
		mw.newLine();

		mw.write("<tr><td>Pass Count</td>" + "</td><td >" + count1 + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >Fail Count</td>" + "</td><td>" + count2 + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >Start Time</td>" + "</td><td>" + STime + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >End Time</td>" + "</td><td>" + endTime + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >Total time taken in minutes</td>" + "</td><td>" + diffMinutes + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >Executed By</td>" + "</td><td>" + executedBy + "</td></tr>");
		mw.newLine();
		mw.write("<tr><td >Executed On</td>" + "</td><td>" + today + "</td></tr>");
		mw.newLine();
		mw.newLine();
		mw.write("</table></div></div></div></div>");

	}

	public static void destroyBW() throws IOException {
		bw.write("</body></html>");
		bw.close();

		mw.write("</body></html>");
		mw.close();

	}

	public void getSnocountzero() {
		Sno = 1;
	}

	public void clear() {
		Keywords k = new Keywords();
		k.clear();
		employees.clear();
		testScenarioDescription.clear();
		testCaseDescribtion.clear();
		nameMo.clear();
	}

	/*
	 * public void insertmaster(String moduleName, String executedBy,String
	 * executedOn, int passCount, int failCount, String startTime, String endTime)
	 * throws SQLException { conNw conobj = new conNw(); Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; String sql = null; sql =
	 * "INSERT INTO Reportmaster(moduleName,executedBy,executedOn,passCount,failCount,startTime,endTime) VALUES(?,?,?,?,?,?,?);"
	 * ; con = conobj.getconection(); pstmt = con.prepareStatement(sql); try {
	 * pstmt.setString(1, moduleName); pstmt.setString(2, executedBy);
	 * pstmt.setString(3, executedOn); pstmt.setInt(4, passCount); pstmt.setInt(5,
	 * failCount); pstmt.setString(6, startTime); pstmt.setString(7, endTime);
	 * pstmt.executeUpdate(); } catch (SQLException e) {
	 * System.out.println(e.getMessage()); } }
	 * 
	 * public void insertchild(String TestCaseDescription,String TestCaseSteps,
	 * String Status,int f_key) throws SQLException { conNw conobj = new conNw();
	 * Connection con = null; PreparedStatement pstmt = null; ResultSet rs = null;
	 * String sql = null; sql =
	 * "INSERT INTO Reportdetail(TestCaseDescription,TestCaseSteps,Status,Pk_report_Id) VALUES(?,?,?,?);"
	 * ; con = conobj.getconection(); pstmt = con.prepareStatement(sql); try {
	 * pstmt.setString(1, TestCaseDescription); pstmt.setString(2, TestCaseSteps);
	 * pstmt.setString(3, Status); pstmt.setInt(4, f_key); pstmt.executeUpdate(); }
	 * catch (SQLException e) { System.out.println(e.getMessage()); }
	 * 
	 * }
	 */
	public static void getPage() throws IOException, InterruptedException {
		System.out.println("report");
		File htmlFile = new File("F:\\mack project reports\\report" + ExcelUtil.ScreenName + "_" + date + ".html");

		Desktop.getDesktop().browse(htmlFile.toURI());

		// File mailfile = new File("D:\\e drive\\seliniumReport1\\" +
		// ExcelUtil.ScreenName + "_" + date + ".html");

		HtmlConverter.convertToPdf(new FileInputStream(htmlFile),

				new FileOutputStream(
						"F:\\mack project reports\\report" + ExcelUtil.ScreenName + "_" + Keywords.date + ".PDF"));

		// File Pdffile = new File("D:\\e drive\\seliniumReport\\" +
		// ExcelUtil.ScreenName + "_" + Keywords.date + ".PDF");

		// Desktop.getDesktop().browse(Pdffile.toURI());

		System.out.println("PDF Created!");

		sendmail pd = new sendmail();
		pd.mail();

		// File rephtmlFile = new File("E:\\seliniumReport.html");
		// Desktop.getDesktop().browse(rephtmlFile.toURI());
	}

}
