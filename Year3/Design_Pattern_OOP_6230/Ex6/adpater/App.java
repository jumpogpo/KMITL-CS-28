public class App { 
    public static void main(String[] args) {
        CSVParser realEstate = new RealEstateMarketDataParser();
        CSVParser machineLearning = new MachineLearningDataParser();
        
        StockMarketDataParser stockParser = new StockMarketDataParser();
        CSVParser stockMarket = new StockMarketDataParserAdapter(stockParser);
        
        parse(realEstate);
        parse(machineLearning);
        parse(stockMarket);
    }

    public static void parse(CSVParser parser) {
        parser.parseCSV();
    }
}
