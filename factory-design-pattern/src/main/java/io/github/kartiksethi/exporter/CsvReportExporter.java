package io.github.kartiksethi.exporter;

public class CsvReportExporter implements ReportExporter {
    @Override
    public void export(String data) {
        System.out.println("Exporting data to CSV format... Saved as report.csv with content: "+ data);
    }
}

