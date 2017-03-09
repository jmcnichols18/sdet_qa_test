package com.oneoff.sdet_qa_test;

/**
 * POJO to hold individual state information returned
 * @author jmcnichols
 */
public class US_State {

    private String country;
    private String name;
    private String abbr;
    private String area;
    private String largest_city;
    private String capital;
    
    /**
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAbbr() {
        return abbr;
    }

    /**
     *
     * @param abbr
     */
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    /**
     *
     * @return
     */
    public String getArea() {
        return area;
    }

    /**
     *
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     *
     * @return
     */
    public String getLargest_city() {
        return largest_city;
    }

    /**
     *
     * @param largest_city
     */
    public void setLargest_city(String largest_city) {
        this.largest_city = largest_city;
    }

    /**
     *
     * @return
     */
    public String getCapital() {
        return capital;
    }

    /**
     *
     * @param capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return name + " " + abbr;
    }
}
