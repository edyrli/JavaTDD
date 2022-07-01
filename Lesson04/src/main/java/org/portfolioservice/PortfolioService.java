package org.portfolioservice;

public class PortfolioService {
    private ITransactionRepositoryPort _transactionRepositoryPort;
    private PrintReportService _printReportService;

    public PortfolioService(ICalendarPort calendarPort, PrintReportService printReportService, ITransactionRepositoryPort transactionRepositoryPort) {
        _transactionRepositoryPort = transactionRepositoryPort;
        _printReportService = printReportService;
    }

    public void PrintPortfolio() {
        var transactions = _transactionRepositoryPort.GetTransactions();
        _printReportService.PrintReport(transactions);
    }
}
