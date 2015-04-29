package game;

import java.util.HashMap;

public class Students {
    private String name;
    private String image;

    private HashMap<String, Students> speak;
    private HashMap<String, String> responses;

    public Students(String n, String i) {
        name = n;
        image = i;
        speak = new HashMap<String, Students>();
        responses = new HashMap<String, String>();
    }

    public String getImage() {
        return image;
    }
    
    public HashMap<String, Students> getspeak() {
        return speak;
    }
	    
    public void addSpeak(String e, Students r) {
        speak.put(e, r);
    }
	    
    public HashMap<String, String> getresponses() {
        return responses;
    }
    
    public void addResponse(String i, String d) {
        responses.put(i, d);
    }
    
    public String toString() {
        String s = name + ": \n\n";
        
        for (String speach : speak.keySet()) {
            s += speach + " ";
        }
        s += "\n";

        for (String response : responses.keySet()) {
            s += response + " ";
        }
        s += "\n\n";
	        
        return s;
    }
}
