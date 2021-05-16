public class Text {
    private String text;

    public Text() {
    }

    public Text(String text) {
        setText(text);
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /**
     * print and add extraObject
     */
    public void print(Object... extraObject) {
        System.out.print(add(extraObject).getText());
    }

    /**
     * print and add extraObject(s) to end of text and go to the next line
     */
    public void println(Object... extraObject) {
        System.out.println(add(extraObject).getText());
    }


  //. /**
  //  * print object and sleep by millisecond delay
  //  *
  //  * @param delay delay
  //  * @throws InterruptedException InterruptedException
  //  */
  //. public void printByDelay(int delay) throws InterruptedException {
  //     System.out.print(getText());
  //     Thread.sleep(delay);
  // }

    /**
     * print current text chars and sleep by millisecond delay
     * one delay is for between chars but two is also have one delay for after print
     *
     * @param delay delay
     * @throws InterruptedException InterruptedException
     */
    @SuppressWarnings("BusyWait")
    public void printByDelayChar(int... delay) throws InterruptedException {
        String string = getText();
        for (int iChar = 0; iChar < string.length(); iChar++) {
            System.out.print(string.charAt(iChar));
            Thread.sleep(delay[0]);
        }try {
            Thread.sleep(delay[1]);
        }catch (Exception e){System.out.print("");}

    }

    /**
     * menu by title
     *
     * @param title  title
     * @param inputs inputs
     * @return the menu by type Text
     */
    public Text menu(String title, String... inputs) {
        StringBuilder txt = new StringBuilder(title);
        for (int i = 0; i < inputs.length; i++)
            txt.append("\n").append(i + 1).append(inputs[i]);
        return new Text(txt.toString());
    }

   //. /**
   //  * colorful text and go to the next line
   //  * 0 TEXT_NO_Color(default)                ~~~~~
   //  * 1 TEXT_BLACK                ~~~~~
   //  * 2 TEXT_RED                ~~~~~
   //  * 3 TEXT_GREEN                ~~~~~
   //  * 4 TEXT_YELLOW                ~~~~~
   //  * 5 TEXT_BLUE                ~~~~~
   //  * 6 TEXT_PURPLE                ~~~~~
   //  * 7 TEXT_CYAN                ~~~~~
   //  * 8 TEXT_WHITE                ~~~~~
   //  * 10 ANSI_RESET_BACKGROUND(default)                ~~~~~
   //  * 11 ANSI_BLACK_BACKGROUND                ~~~~~
   //  * 12 ANSI_RED_BACKGROUND                ~~~~~
   //  * 13 ANSI_GREEN_BACKGROUND                ~~~~~
   //  * 14 ANSI_YELLOW_BACKGROUND                ~~~~~
   //  * 15 ANSI_BLUE_BACKGROUND                ~~~~~
   //  * 16 ANSI_PURPLE_BACKGROUND                ~~~~~
   //  * 17 ANSI_CYAN_BACKGROUND                ~~~~~
   //  * 18 ANSI_WHITE_BACKGROUND                ~~~~~
   //  *
   //  * @param textColor       textColor
   //  * @param backGroundColor backGroundColor
   //  * @param input           input
   //  */
   //. public Text colorText(int textColor, int backGroundColor, String input) {
   //     return new Text(
   //             new ColorText(textColor, backGroundColor, input).getText());
   // }

    /**
     * colorful the current text and go to the next line
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
     * @param textColor       textColor
     * @param backGroundColor backGroundColor
     */
    public Text colorText(int textColor, int backGroundColor) {
        return new Text(
                new ColorText(textColor, backGroundColor, getText()).getText());
    }

    /**
     * make the string in center by length len , the rest of sentence is filled by fillChar
     *
     * @param input    input string
     * @param len      line length
     * @param fillChar char
     * @return the string that make centered
     */
    private String makeCenterStr(int len, char fillChar, String input) {
        if (len <= input.length()) return input.substring(0, len);
        String charStr = String.valueOf(fillChar);
        String repeatStr = charStr.repeat((len / 2) - (input.length() / 2));
        String centerStr = String.format("%s%s%s", repeatStr, input, repeatStr);
        int length = centerStr.length();
        if (length == len) return centerStr;
        if (length > len) return centerStr.substring(0, len);
        return centerStr + charStr.repeat(len - length);
    }

    /**
     * make the current text in center by length len , the rest of sentence is filled by fillChar
     *
     * @param len      len
     * @param fillChar fillChar
     * @return make centered
     */
    public Text makeCenter(int len, char fillChar) {
        return new Text(makeCenterStr(len, fillChar, getText()));
    }

    /**
     * gets the needed primates and print and go to next line for every input that make center by there own length lenLine
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
     * @param lenEachItem     lenEachItem
     * @param fillChar        fillChar
     * @param betweenItems    betweenItems
     * @param textColor       textColor
     * @param backGroundColor backGroundColor
     * @param inputs          inputs
     * @return colorful text line
     */
    public Text colorfulCenterLine(int[] lenEachItem, char fillChar, String betweenItems
            , int[] textColor, int[] backGroundColor, String... inputs) {
        StringBuilder textLine = new StringBuilder(new Text(inputs[0]).makeCenter(lenEachItem[0], fillChar)
                .colorText(textColor[0], backGroundColor[0])
                .getText());
        for (int iItems = 1; iItems < inputs.length; iItems++) {
            textLine.append(betweenItems).append(new Text(inputs[iItems]).makeCenter(lenEachItem[iItems], fillChar)
                    .colorText(textColor[iItems], backGroundColor[iItems])
                    .getText());
        }
        return new Text(textLine.toString());
    }

  //. /**
  //.  * gets the needed primates and print and go to next line for every input that make center by there own length lenLine
  //.  * 0 TEXT_NO_Color(default)                ~~~~~
  //.  * 1 TEXT_BLACK                ~~~~~
  //.  * 2 TEXT_RED                ~~~~~
  //.  * 3 TEXT_GREEN                ~~~~~
  //.  * 4 TEXT_YELLOW                ~~~~~
  //.  * 5 TEXT_BLUE                ~~~~~
  //.  * 6 TEXT_PURPLE                ~~~~~
  //.  * 7 TEXT_CYAN                ~~~~~
  //.  * 8 TEXT_WHITE                ~~~~~
  //.  * 10 ANSI_RESET_BACKGROUND(default)                ~~~~~
  //.  * 11 ANSI_BLACK_BACKGROUND                ~~~~~
  //.  * 12 ANSI_RED_BACKGROUND                ~~~~~
  //.  * 13 ANSI_GREEN_BACKGROUND                ~~~~~
  //.  * 14 ANSI_YELLOW_BACKGROUND                ~~~~~
  //.  * 15 ANSI_BLUE_BACKGROUND                ~~~~~
  //.  * 16 ANSI_PURPLE_BACKGROUND                ~~~~~
  //.  * 17 ANSI_CYAN_BACKGROUND                ~~~~~
  //.  * 18 ANSI_WHITE_BACKGROUND                ~~~~~
  //.  *
  //.  * @param lenEachItem     lenEachItem
  //.  * @param fillChar        fillChar
  //.  * @param betweenItems    betweenItems
  //.  * @param textColor       textColor
  //.  * @param backGroundColor backGroundColor
  //.  * @param inputs          inputs
  //.  * @return colorful text line
  //.  */
  //. public Text colorfulCenterLine(int[] lenEachItem, char fillChar, String betweenItems
  //.         , int[] textColor, int[] backGroundColor, ArrayList<String> inputs) {
  //.     int size = inputs.size();
  //.     String[] inputsArr = new String[size];
  //.     for (int index = 0; index < size; index++) inputsArr[index] = String.valueOf(inputs.get(index));
  //.     return colorfulCenterLine(lenEachItem, fillChar, betweenItems
  //.             , textColor, backGroundColor, inputsArr);
  //. }


  //. /**
  //.  * gets the needed primates and print and go to next line for every input that make center by there own length lenLine
  //.  * 0 TEXT_NO_Color(default)                ~~~~~
  //.  * 1 TEXT_BLACK                ~~~~~
  //.  * 2 TEXT_RED                ~~~~~
  //.  * 3 TEXT_GREEN                ~~~~~
  //.  * 4 TEXT_YELLOW                ~~~~~
  //.  * 5 TEXT_BLUE                ~~~~~
  //.  * 6 TEXT_PURPLE                ~~~~~
  //.  * 7 TEXT_CYAN                ~~~~~
  //.  * 8 TEXT_WHITE                ~~~~~
  //.  * 10 ANSI_RESET_BACKGROUND(default)                ~~~~~
  //.  * 11 ANSI_BLACK_BACKGROUND                ~~~~~
  //.  * 12 ANSI_RED_BACKGROUND                ~~~~~
  //.  * 13 ANSI_GREEN_BACKGROUND                ~~~~~
  //.  * 14 ANSI_YELLOW_BACKGROUND                ~~~~~
  //.  * 15 ANSI_BLUE_BACKGROUND                ~~~~~
  //.  * 16 ANSI_PURPLE_BACKGROUND                ~~~~~
  //.  * 17 ANSI_CYAN_BACKGROUND                ~~~~~
  //.  * 18 ANSI_WHITE_BACKGROUND                ~~~~~
  //.  *
  //.  * @param lenEachItem     lenEachItem
  //.  * @param fillChar        fillChar
  //.  * @param textColor       textColor
  //.  * @param backGroundColor backGroundColor
  //.  * @param inputs          inputs
  //.  * @return colorful text line
  //.  */
  //. public Text colorfulCenterLine(int[] lenEachItem, char fillChar,
  //.                                int[] textColor, int[] backGroundColor, String... inputs) {
  //.     return new Text().colorfulCenterLine(lenEachItem, fillChar, "",
  //.             textColor, backGroundColor, inputs);
  //. }

    /**
     * add entered Object(s) to first the current text
     *
     * @param addingObjects addingObject(s)
     */
    public Text addFirst(Object... addingObjects) {
        StringBuilder addString = new StringBuilder();
        for (Object addingObject : addingObjects) addString.append(addingObject);
        return new Text(addString + getText());
    }

    /**
     * add entered Object(s) to end the current text
     *
     * @param addingObjects addingObject(s)
     */
    public Text add(Object... addingObjects) {
        StringBuilder addString = new StringBuilder();
        for (Object addingObject : addingObjects) addString.append(addingObject);
        return new Text(getText() + addString);
    }


}
