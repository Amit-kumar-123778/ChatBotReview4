package model;

public class Chatbotmodel {
	
	    private String userInput;
	    private String response;

	    public Chatbotmodel(String userInput, String response) {
	        this.userInput = userInput;
	        this.response = response;
	    }

	    public String getUserInput() {
	        return userInput;
	    }

	    public String getResponse() {
	        return response;
	    }
	}


