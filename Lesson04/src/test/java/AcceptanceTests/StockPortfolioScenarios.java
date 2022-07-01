package AcceptanceTests;

// Given I bought 1000 shares of "Old School Waterfall Software LTD" on 14/02/1990
// And I bought 400 shares of "Crafter Masters Limited" on 09/06/2016
// And I bought 700 shares of "XP Practitioners Incorporated" on 10/12/2018
// And I sold 500 shares of "Old School Waterfall Software LTD" on 11/12/2018
// And the current share value of "Old School Waterfall Software LTD" is $5.75
// And the current share value of "Crafter Masters Limited" is $17.25
// And the current share value of "XP Practitioners Incorporated" is $25.55
// When I print my current portfolio
// Then the outcome displayed should be:
//
//      company | shares | current price | current value | last operation
//      Old School Waterfall Software LTD | 500 | $5.75 | $2,875.00 | sold 500 on 11/12/2018
//      Crafter Masters Limited | 400 | $17.25 | $6,900.00 | bought 400 on 09/06/2016
//      XP Practitioners Incorporated | 700 | $25.55 | $17,885.00 | bought 700 on 10/12/2018

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.portfolioservice.*;

import java.time.LocalDateTime;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StockPortfolioScenarios {
    private ICalendarPort _calendarPort;
    private IPriceProxyPort _priceProxyPort;
    private IPrinterPort _printerPort;
    private PrintReportService _printReportService;
    private PortfolioService _portfolioService;

    @BeforeAll
    public void Setup() {
        _calendarPort = mock(ICalendarPort.class);
        _priceProxyPort = mock(IPriceProxyPort.class);
        _printerPort = mock(IPrinterPort.class);
        _printReportService = new PrintReportService(_priceProxyPort, _printerPort);
        _portfolioService = new PortfolioService(_calendarPort, _printReportService, new TransactionRepositoryFake());
    }

    @Test
    public void PrintPortfolioWithSomeTransactions() {
        BuyShares(1000, "Old School Waterfall Software LTD", LocalDateTime.of(1990, 2, 14, 0, 0));
        SellShares(500, "Old School Waterfall Software LTD", LocalDateTime.of(2018, 12, 11, 0, 0));
        CurrentShareValueIs("Old School Waterfall Software LTD", 5.75);

        PrintMyCurrentPortfolio();

        var expectedOutcome = "company | shares | current price | current value | last operation\n" +
                "Old School Waterfall Software LTD | 500 | $5.75 | $2,875.00 | sold 500 on 11/12/2018\n" +
                "Crafter Masters Limited | 400 | $17.25 | $6,900.00 | bought 400 on 09/06/2016\n" +
                "XP Practitioners Incorporated | 700 | $25.55 | $17,885.00 | bought 700 on 10/12/2018";
        TheOutcomeShouldBe(expectedOutcome);
    }

    private void BuyShares(int amountOfShares, String companyName, LocalDateTime shareValue) {
    }

    private void CurrentShareValueIs(String companyName, double shareValue) {

    }

    private void SellShares(int amountOfShares, String companyName, LocalDateTime shareValue) {

    }

    private void PrintMyCurrentPortfolio() {
    }

    private void TheOutcomeShouldBe(String report) {
        verify(_printerPort).Print(report);
    }
}
