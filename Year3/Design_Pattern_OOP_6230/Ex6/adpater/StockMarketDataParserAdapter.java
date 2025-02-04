public class StockMarketDataParserAdapter implements CSVParser {
    private StockMarketDataParser stockMarketDataParser;

    public StockMarketDataParserAdapter(StockMarketDataParser stockMarketDataParser) {
        this.stockMarketDataParser = stockMarketDataParser;
    }

    @Override
    public void parseCSV() {
        stockMarketDataParser.parseFromCSV();
    }
}
