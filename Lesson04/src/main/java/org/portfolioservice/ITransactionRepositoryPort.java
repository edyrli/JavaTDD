package org.portfolioservice;

import java.util.List;

public interface ITransactionRepositoryPort {
    List<Transaction> GetTransactions();
}
