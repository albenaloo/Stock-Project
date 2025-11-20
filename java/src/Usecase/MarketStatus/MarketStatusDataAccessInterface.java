package Usecase.MarketStatus;

import Entity.MarketStatus;

public interface MarketStatusDataAccessInterface {
    MarketStatus loadStatus() throws Exception;
}
