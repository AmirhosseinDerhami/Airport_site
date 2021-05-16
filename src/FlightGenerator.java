import java.util.*;

public class FlightGenerator {
    public Random rand = new Random();

    public ArrayList<Flight> getSchedule(int numOfFlight) {
        /*.Set<Flight> schedule = new HashSet<>();
        while (schedule.size() < numOfFlight) schedule.add(getFlight());*/

        ArrayList<Flight> schedule = new ArrayList();
        while (schedule.size() < numOfFlight) {
            Flight tempFlight = getFlight();
            boolean check = true;
            for (Flight flight : schedule) {
                if (tempFlight.equalExFlightId(flight)) {
                    check = false;
                    break;
                }
            }
            if (check) schedule.add(tempFlight);
        }

        return new ArrayList() {{
            this.addAll(schedule);
        }};
    }

    /**
     *
     * @return get random flight
     */
    public Flight getFlight() {
        Flight flight = new Flight();
        //id
        flight.setFlightId(
                String.format("%c%d%c", '5', (rand.nextInt(10000 - 1 - 1000)) + 1000, '0'));
        //origin
        List<String> cityListTemp = Data.getCityList();
        flight.setOriginCity(cityListTemp.get(
                rand.nextInt(cityListTemp.size())
        ));
        //destination
        cityListTemp.remove(flight.getOriginCity());
        flight.setDestinationCity(cityListTemp.get(
                rand.nextInt(cityListTemp.size())
        ));
        //day
        flight.setDay(Data.getDayList().get(
                rand.nextInt(Data.getDayList().size())
        ));
        //time
        flight.setTime(String.format("%02d", Data.getTimeList().get(
                rand.nextInt(Data.getTimeList().size())
        )));
        //return
        return flight;
    }
}