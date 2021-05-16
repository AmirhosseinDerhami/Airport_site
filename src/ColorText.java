public class ColorText {
    private static final String TEXT_RESET = "\u001B[0m";

    private static final String TEXT_BLACK = "\u001B[30m";
    private static final String TEXT_RED = "\u001B[31m";
    private static final String TEXT_GREEN = "\u001B[32m";
    private static final String TEXT_YELLOW = "\u001B[33m";
    private static final String TEXT_BLUE = "\u001B[34m";
    private static final String TEXT_PURPLE = "\u001B[95m";
    private static final String TEXT_CYAN = "\u001B[36m";
    private static final String TEXT_WHITE = "\u001B[37m";

    private static final String ANSI_BLACK_BACKGROUND = "\u001B[100m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[101m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[102m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    private String text;

    public String getText() {
        return text;
    }

    private void setText(String input) {
        this.text = input;
    }


    /**
     * 0 TEXT_NO_Color(default)                ~~~~~
     * 1 TEXT_BLACK                ~~~~~
     * 2 TEXT_RED                ~~~~~
     * 3 TEXT_GREEN                ~~~~~
     * 4 TEXT_YELLOW                ~~~~~
     * 5 TEXT_BLUE                ~~~~~
     * 6 TEXT_PURPLE                ~~~~~
     * 7 TEXT_CYAN                ~~~~~
     * 8 TEXT_WHITE                ~~~~~
     * 10 ANSI_RESET_BACKGROUND(default)                ~~~~~
     * 11 ANSI_BLACK_BACKGROUND                ~~~~~
     * 12 ANSI_RED_BACKGROUND                ~~~~~
     * 13 ANSI_GREEN_BACKGROUND                ~~~~~
     * 14 ANSI_YELLOW_BACKGROUND                ~~~~~
     * 15 ANSI_BLUE_BACKGROUND                ~~~~~
     * 16 ANSI_PURPLE_BACKGROUND                ~~~~~
     * 17 ANSI_CYAN_BACKGROUND                ~~~~~
     * 18 ANSI_WHITE_BACKGROUND                ~~~~~
     *
     * @param string     input
     * @param background color text background
     * @param color      color text
     */
    public ColorText(int color, int background, String string) {
        String bColor = switch (background) {
            case 11 -> ANSI_BLACK_BACKGROUND;
            case 12 -> ANSI_RED_BACKGROUND;
            case 13 -> ANSI_GREEN_BACKGROUND;
            case 14 -> ANSI_YELLOW_BACKGROUND;
            case 15 -> ANSI_BLUE_BACKGROUND;
            case 16 -> ANSI_PURPLE_BACKGROUND;
            case 17 -> ANSI_CYAN_BACKGROUND;
            case 18 -> ANSI_WHITE_BACKGROUND;
            case 10 -> "" + "";
            default -> "";
        };
        String tColor = switch (color) {
            case 0 -> "" + "";
            case 1 -> TEXT_BLACK;
            case 2 -> TEXT_RED;
            case 3 -> TEXT_GREEN;
            case 4 -> TEXT_YELLOW;
            case 5 -> TEXT_BLUE;
            case 6 -> TEXT_PURPLE;
            case 7 -> TEXT_CYAN;
            case 8 -> TEXT_WHITE;
            default -> "";
        };
        setText( bColor + tColor + string + TEXT_RESET) ;
    }
    }
