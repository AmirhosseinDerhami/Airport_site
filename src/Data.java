import java.util.*;

public class Data {
    private static final Data DATA = new Data();
    private ArrayList<User> users;
    private ArrayList<Flight> flightSchedule;

    private static String[] CITY_ARRAY;
    private static String[] DAY_ARRAY;
    private static int[] TIME_ARRAY;

    private Data() {
        setArrays();
        //default users
        users = new ArrayList() {{
            for (int num = 1, nTemp = 0, nId = 0; num <= 20; num++) {
                User userTemp = new User("u" + num, "p" + num, 100 + (nId++) * 3);
                int nFlightRow = new Random().nextInt(5);
                userTemp.addFlights(new FlightGenerator().getSchedule(nFlightRow));
                for (int i = 0; i < nFlightRow; i++, nTemp += new Random().nextInt(10) + 1)
                    userTemp.getFlights().get(i).setFlightId(String.format("%03d%s", nTemp,
                            userTemp.getFlights().get(i).getFlightId().substring(3)));

                add(userTemp);
            }
        }};
        //------
        setFlightSchedule(new FlightGenerator().getSchedule(4));
        flightSchedule.add(new Flight().empty());//add empty line at the end
    }

    private void setArrays() {
        CITY_ARRAY = new String[]{
                "Azarbayjan", "Ardebil", "Isfahan", "Alborz", "Semnan",
                "Bousher", "Tehran", "Chahar Mahal Bakhtiari", "Khorasan Jonoubi",
                "Khorasan Razavi", "Khorasan Shomali", "Khouzestan", "Fars", "Ilam",
                "Hormozgan", "Zanjan", "Sistan Balouchestan", "Qazvin", "Hamedan",
                "Gilan", "Kordestan", "Kerman", "Kermanshah", "Kohkiloyeh Bourahmad",
                "Qom", "Lorestan", "Mazandaran", "Markazi", "Golestan", "Yazd"};
        DAY_ARRAY = new String[]{
                "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        TIME_ARRAY = new int[]{0, 3, 5, 8, 10, 13, 17, 18, 20, 21, 22/*hour*/};
    }

    /**
     * to get instance
     *
     * @return instance
     */
    public static Data gIns() {
        return DATA;
    }

    public ArrayList<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(ArrayList<Flight> schedule) {
        flightSchedule = schedule;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(int index) {
        return users.get(index);
    }

    /**
     * add user to the users list
     * @param user user
     */
    public void addUser(User user) {
        users.add(user);
    }

    public static ArrayList<String> getCityList() {
        return new ArrayList() {{
            for (String str : CITY_ARRAY) add(str);
        }};
    }

    public static ArrayList<String> getDayList() {
        return new ArrayList() {{
            for (String str : DAY_ARRAY) add(str);
        }};
    }

    public static ArrayList<Integer> getTimeList() {
        return new ArrayList() {{
            for (int i : TIME_ARRAY) add(i);
        }};
    }

    /**
     * search user by username
     *
     * @param username username
     * @return user index intended or when not found -1
     */
    public int searchUser(String username) {
        for (int index = 0; index < users.size(); index++)
            if (Data.gIns().getUser(index).getUsername().equals(username))
                return index;
        return -1;
    }

    /**
     * check there username is in usernames
     *
     * @param username username
     * @return true when there is before in usernames
     */
    public boolean checkUsername(String username) {
        if (username.isEmpty()) {
            System.out.println("\t\t >username can't be empty ");
            return true;
        }

      /*/  for (int index = 0; index < users.size(); index++)
            if (Data.gIns().getUser(index).getUsername().equals(username))
                return true;*/
        for (User user:Data.gIns().getUsers())
            if (user.getUsername().equals(username))
                return true;
        return false;
    }

}