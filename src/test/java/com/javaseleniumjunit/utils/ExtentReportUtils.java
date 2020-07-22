package com.javaseleniumjunit.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUtils {


    private static  ExtentHtmlReporter HTML_REPORTER =null ;
    public static ExtentTest TEST;
    public static ExtentReports extentReporter= null;
//    static String projectBinDebugPath = AppDomain.CurrentDomain.BaseDirectory;
//    static FileInfo fileInfo = new FileInfo(projectBinDebugPath);
//    static DirectoryInfo projectFolder = fileInfo.Directory;
//    static String projectFolderPath = projectFolder.FullName;
//    static String reportRootPath = projectFolderPath + "/Reports/";
//    static String reportPath = projectFolderPath + "/Reports/" + reportName + "/";
//    static String fileName = reportName + ".html";
//    static String fullReportFilePath = reportPath + "_" + fileName;

    public static void createReport() {


        HTML_REPORTER = new ExtentHtmlReporter("C:\\RepositoriodeProjetos\\javaseleniumjunitextentreport\\reports\\teste.html");
        extentReporter = new ExtentReports();
        extentReporter.attachReporter(HTML_REPORTER);
    }

    public static void addTest(String testName, String testCategory){
        TEST = extentReporter.createTest(testName).assignCategory(testCategory.replace("Tests",""));
    }

    public static void addTestInfo(String testName){
        TEST.log(Status.INFO,testName );
    }

    public static void generateReport(){
        extentReporter.flush();
    }

}
