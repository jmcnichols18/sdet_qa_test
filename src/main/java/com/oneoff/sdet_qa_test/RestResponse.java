package com.oneoff.sdet_qa_test;

import java.util.List;

/**
 * POJO to hold rest response returned
 * @author jmcnichols
 */
public class RestResponse {
    
    private List<String> messages;
    private List<US_State> result;

    /**
     *
     * @return
     */
    public List<String> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    /**
     *
     * @return
     */
    public List<US_State> getResult() {
        return result;
    }

    /**
     *
     * @param result
     */
    public void setResult(List<US_State> result) {
        this.result = result;
    }
    
    @Override
    public String toString(){
        return result.toString();
    }
    
}
