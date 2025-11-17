package DataAccess;

import Entity.EarningsRecord;
import java.util.List;

public interface EarningsGateway {
    List<EarningsRecord> fetchHistory(String symbol, Integer limit) throws Exception;
}