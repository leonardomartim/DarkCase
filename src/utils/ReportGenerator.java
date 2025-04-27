package utils;

import model.Case;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    // Método para gerar o relatório de análise
    public static void generateAnalysisReport(String analysisReport) {
        try {
            File reportFile = new File("Investigation_Report.txt");
            FileWriter writer = new FileWriter(reportFile);
            writer.write(analysisReport);
            writer.close();
            System.out.println("Report generated successfully: " + reportFile.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while generating the report.");
            e.printStackTrace();
        }
    }

    // Método para gerar relatório completo do caso
    public static void generateFullCaseReport(Case investigationCase, String analysisReport) {
        try {
            File caseReportFile = new File("Full_Case_Report_" + investigationCase.getCaseName() + ".txt");
            FileWriter writer = new FileWriter(caseReportFile);
            writer.write("Case Report: " + investigationCase.getCaseName() + "\n");
            writer.write("Case Description: " + investigationCase.getDescription() + "\n");
            writer.write("Case Status: " + (investigationCase.isOpen() ? "Open" : "Closed") + "\n");
            writer.write("\n--- Analysis ---\n");
            writer.write(analysisReport);
            writer.close();
            System.out.println("Full case report generated: " + caseReportFile.getName());
        } catch (IOException e) {
            System.out.println("An error occurred while generating the case report.");
            e.printStackTrace();
        }
    }
}
