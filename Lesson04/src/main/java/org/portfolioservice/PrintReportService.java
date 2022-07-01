package org.portfolioservice;

import java.util.List;

public class PrintReportService {
    private IPrinterPort _printerPort;

    public PrintReportService(IPriceProxyPort priceProxyPort, IPrinterPort printerPort) {
        _printerPort = printerPort;
    }

    public void PrintReport(List<Transaction> transactions) {
        _printerPort.Print( "company | shares | current price | current value | last operation");
    }
}
