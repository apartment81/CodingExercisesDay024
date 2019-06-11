package ro.mirodone;

import java.util.ArrayList;

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;

    // Array of cell locations
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    //set the name of the .com names
    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {

        String result = "miss";

        // check if the user guess is in the ArrayList, by asking for its index;
        //if is not in the list, indexOf returns -1
        int index = locationCells.indexOf(userInput);
        //if index >= 0, the user guess is in the list, so remove it.
        if (index >= 0) {
            locationCells.remove(index);
            //if list is empty, this was the killing blow.
            if (locationCells.isEmpty()) {
                result = "kill";
                System.out.println("You sunk " + name + " : (");
            } else {
                result = "hit";
            }
        }
        return result;

    }
}
