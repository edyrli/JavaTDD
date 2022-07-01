package AcceptanceTests;

import org.portfolioservice.ITransactionRepositoryPort;
import org.portfolioservice.Transaction;

import java.util.List;

public class TransactionRepositoryFake implements ITransactionRepositoryPort {
    @Override
    public List<Transaction> GetTransactions() {
        return null;
    }
}
