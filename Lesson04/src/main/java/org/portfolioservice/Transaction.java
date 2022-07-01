package org.portfolioservice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Transaction {

    public Transaction(int amountOfShares, String companyName, LocalDateTime transactionDate)
    {
        AmountOfShares = amountOfShares;
        CompanyName = companyName;
        TransactionDate = transactionDate;
    }

    public int AmountOfShares;
    public String CompanyName;
    public LocalDateTime TransactionDate;
}
