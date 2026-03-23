package io.github.kartiksethi;

import io.github.kartiksethi.exporter.CsvReportExporter;
import io.github.kartiksethi.exporter.PdfReportExporter;
import io.github.kartiksethi.exporter.ReportExporter;

public class ReportFactory {

    public static ReportExporter getReportExporter(ReportType type) {
        return switch (type){
            case ReportType.PDF -> new PdfReportExporter();
            case ReportType.CSV -> new CsvReportExporter();
            default -> throw new IllegalArgumentException("Unsupported report type: " + type);
        };
    }
}
