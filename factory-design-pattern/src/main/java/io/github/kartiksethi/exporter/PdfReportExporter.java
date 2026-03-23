package io.github.kartiksethi.exporter;

public class PdfReportExporter implements ReportExporter {
    @Override
    public void export(String data) {
        System.out.println("Exporting data to PDF format... Saved as report.pdf with content: "+data);
    }
}
