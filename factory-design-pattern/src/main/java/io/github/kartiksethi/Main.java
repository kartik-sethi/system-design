package io.github.kartiksethi;

public class Main {
    public static void main(String[] args) {

        ReportController reportController = new ReportController();
        reportController.generateReport(ReportType.PDF);
        reportController.generateReport(ReportType.CSV);
    }
}