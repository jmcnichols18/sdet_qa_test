/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oneoff.sdet_qa_test;

/**
 * 
 * @author jmcnichols
 */
public class DataModel {
    
    private RestResponse restResponse;

    /**
     *
     * @return
     */
    public RestResponse getRestResponse() {
        return restResponse;
    }

    /**
     *
     * @param restResponse
     */
    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
    
    @Override
    public String toString(){
        return restResponse.toString();
    }
}
