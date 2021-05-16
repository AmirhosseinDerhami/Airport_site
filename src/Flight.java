import java.util.ArrayList;

public class Flight {
    private String flightId;
    private String originCity;
    private String destinationCity;
    private String day;
    private String time;

    public Flight() {
    }

    public Flight(String fightId, String originCity, String destinationCity, String day, String time) {
        this.flightId = fightId;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.day = day;
        this.time = time;
    }

    public Flight empty() {
        return new Flight("_-_-_-", "_-_-_-", "_-_-_-", "_-_-_-", "_-_-_-");
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    /**
     * 0 -> fightId
     * 1 -> originCity
     * 2 -> destinationCity
     * 3 -> day
     * 4 -> time
     *
     * @param indexItem indexItem
     * @return the parameter by index
     */
    public String getByIndex(int indexItem) {
        return switch (indexItem) {
            case 0 -> flightId;
            case 1 -> originCity;
            case 2 -> destinationCity;
            case 3 -> day;
            case 4 -> time;
            default -> null;
        };
    }

    public void setFlightId(String fightId) {
        this.flightId = fightId;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }

    /**
     * check two flight are equal except flight id  *
     * @param secondFlight secondFlight
     * @return true by be equals
     */
    public boolean equalExFlightId(Flight secondFlight) {
        return (this.getFlightId().equalsIgnoreCase(secondFlight.getFlightId()) &&
                this.getDestinationCity().equalsIgnoreCase(secondFlight.getDestinationCity()) &&
                this.getOriginCity().equalsIgnoreCase(secondFlight.getOriginCity()) &&
                this.getTime().equalsIgnoreCase(secondFlight.getTime()) &&
                this.getDay().equalsIgnoreCase(secondFlight.getDay()))  ;
    }

    /**
     * print schedule of flights
     * @param table schedule
     * @param lenLine length of the line
     */
    public static void printSchedule(ArrayList<Flight> table, int lenLine) {
         /*
         -->lenFlightID = 20
         -->lenFrom = 26
         -->lenTo = 26
         -->lenDay = 18
         -->lenTime = siteLenLine - rest
        */
        int[] lensOfItems = new int[]{20, 28, 28, 18, lenLine - (20 + 28 + 28 + 18)};
        for (int i = 0; i < lensOfItems.length - 1; i++) lensOfItems[i]--;
        int[] colorTextTableRow = new int[]{1, 1, 1, 1, 1};
        int[] colorBGTableRow = new int[]{12, 17, 14, 13, 16};

        new Text().colorfulCenterLine(
                lensOfItems, ' ', "|",
                colorTextTableRow, new int[]{18, 18, 18, 18, 18},
                "Flight ID", "From", "To", "Day", "Time").println();

        if (!table.isEmpty())
            for (Flight flight : table) {
                String[] items = new String[]{flight.getFlightId(),
                        flight.getOriginCity(), flight.getDestinationCity(),
                        flight.getDay(), flight.getTime()};

                new Text("").makeCenter(lenLine, '-')
                        .colorText(8, 10).println();
                new Text().colorfulCenterLine(
                        lensOfItems, ' ', "|",
                        colorTextTableRow, colorBGTableRow,
                        items).println();
            }
        else new Text("  no flight  ").
                makeCenter(lenLine - 4 - 4, '*').
                colorText(2, 10)
                .addFirst("\n>>  ").println("  <<");
    }


    @Override
    public String toString() {
        return "Flight{" +
                "fightId=" + flightId + "\t" +
                ", originCity=" + originCity + "\t" +
                ", destinationCity=" + destinationCity + "\t" +
                ", day=" + day + "\t" +
                ", time=" + time +
                '}';
    }
}
