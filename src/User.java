import java.util.*;

public class User {
    private String username;
    private String password;
    private int userId;
    private ArrayList<Flight> flights;

    public User() {
        flights = new ArrayList<>();
    }

    public User(String username, String password) {
        this();
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, int userId) {
        this(username, password);
        this.userId = userId;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
public String getPassword(){return password;}
    /**
     * add this flight(s) to flights list
     *
     * @param flights flights
     */
    public void addFlights(ArrayList<Flight> flights) {
       /*/for (Flight flight : flights)
            this.flights.add(flight);*/
        this.flights.addAll(flights);
    }

    /**
     * remove this flight(s) to flights list
     *
     * @param flights flights
     */
    public void removeFlights(ArrayList<Flight> flights) {
        for (Flight flight : flights)
            this.flights.remove(flight);
    }

    public String getUsername() {
        return username;
    }

    /**
     * @return simple string of user info
     */
    @Override
    public String toString() {
        return String.format("userID :%d \t username :%s \t\tpassword :%s \n"
                , userId
                , username
                , password);
    }
}
