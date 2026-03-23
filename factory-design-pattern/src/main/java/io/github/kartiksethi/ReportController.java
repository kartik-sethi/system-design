package io.github.kartiksethi;

import io.github.kartiksethi.exporter.ReportExporter;

public class ReportController {

    public void generateReport(ReportType reportType) {

        String data = "This is sample report..";
        ReportExporter exporter = ReportFactory.getReportExporter(reportType);

        exporter.export(data);
    }
}