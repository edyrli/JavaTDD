package UnitTests;

import AcceptanceTests.TransactionRepositoryFake;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.portfolioservice.ICalendarPort;
import org.portfolioservice.IPriceProxyPort;
import org.portfolioservice.IPrinterPort;
import org.portfolioservice.PortfolioService;
import org.portfolioservice.PrintReportService;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PortfolioServiceShould {
    private ICalendarPort _calendarPort;
    private IPriceProxyPort _priceProxyPort;
    private IPrinterPort _printerPort;
    private PrintReportService _printReportService;
    private PortfolioService _portfolioService;

    @BeforeEach
    public void Setup() {
        _calendarPort = mock(ICalendarPort.class);
        _priceProxyPort = mock(IPriceProxyPort.class);
        _printerPort = mock(IPrinterPort.class);
        _printReportService = new PrintReportService(_priceProxyPort, _printerPort);
        _portfolioService = new PortfolioService(_calendarPort, _printReportService, new TransactionRepositoryFake());
    }

    @Test
    public void PrintHeaderWhenThereAreNoTransactions(){
        var expectedOutcome = "company | shares | current price | current value | last operation";

        _portfolioService.PrintPortfolio();

        verify(_printerPort).Print(expectedOutcome);
    }

    @Test
    public void PrintHeaderAlongWithOneReportLineWhenThereIsOneBuyTransaction(){
        when(_calendarPort.Today()).thenReturn(LocalDateTime.of(2022, 06, 27, 0, 0));
        var expectedOutcome = "company | shares | current price | current value | last operation\n" +
                "Bouvet | 200 | $10.00 | $2,000.00 | bought 200 on 27/06/2022";

        _portfolioService.PrintPortfolio();

        verify(_printerPort).Print(expectedOutcome);
    }
}
