package com.oneoff.sdet_qa_test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Standardized QA SDET Code examination
 * @author jmcnichols
 */
public class CityCapitalSearch {

    /**
     * Program that returns both largest city and capital based on user input for state name or state abbreviation.
     * User input can be done in any format, including but not limited to prompts and console entries.  
     * Program must continue running until the user exits the program.
     * @param args
     */
    public static void main(String args[]) {

        String input;
        CityCapitalSearch mySearch = new CityCapitalSearch();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter State name or abbreviation (q to Quit): ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Exiting!");
                System.exit(0);
            }

            mySearch.setState(input);
            System.out.println("Searching for State: " + input);
            
            if (mySearch.getMyState() != null) {
                System.out.println("Found State: " + mySearch.getMyState());
                System.out.println("Largest City: " + mySearch.getLargestCity());
                System.out.println("State Capital: " + mySearch.getCapital());
            } else {
                 System.out.println("No State found for input: " + input);
            }
        }
    }

    
    private final String SEARCH_URL = "http://services.groupkt.com/state/get/USA/all";
    private String state;
    private String output;
    private US_State myState;

    /**
     * Perform the rest call once on creation since data is static and 
     * returns full list of state info
     */
    CityCapitalSearch() {
        
        Client client = Client.create();
        WebResource webResource = client.resource(SEARCH_URL);
        ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        output = response.getEntity(String.class);
    }

    /**
     * Set new state variable, reset US_State object that holds retrieved state 
     * info to null. This will trigger a new search when trying to retrieve
     * new state info.
     * @param state
     */
    public void setState(String state) {
        this.state = state;
        this.myState = null;
    }

    /**
     * Return largest city value for state if it exists, otherwise return the capital
     * @return
     */
    public String getLargestCity() {
        return (getMyState().getLargest_city() != null)
                ? getMyState().getLargest_city() : getCapital();
    }

    /**
     * Return capital value for the state
     * @return
     */
    public String getCapital() {
        return getMyState().getCapital();
    }

    /**
     * If myState object is currently null, parse returned data again and 
     * iterate through results until the inputed state is found.
     * Match on state name or abbreviation. 
     * @return
     */
    public US_State getMyState() {
        if (myState == null) {
            ObjectMapper mapper = new ObjectMapper();

            try {
                // Convert JSON string to Object
                DataModel response = mapper.readValue(
                        output.replace("RestResponse", "restResponse"), DataModel.class);
                for (US_State s : response.getRestResponse().getResult()) {                    
                    if (s.getName().equalsIgnoreCase(state) || s.getAbbr().equalsIgnoreCase(state)) {
                        myState = s;
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(CityCapitalSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return myState;
    }

}
