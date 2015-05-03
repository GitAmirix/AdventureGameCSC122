package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Students {
    private String name;
    private String normalImage;
    private String scaredImage;
    private String angryImage;

    private HashMap<String, Students> speak;
    private HashMap<String, String> responses;
    private ArrayList<String> motive;    

    public Students(String n, String ni, String si, String ai) {
        name = n;
        normalImage = ni;
        scaredImage = si;
        angryImage = ai;
        speak = new HashMap<String, Students>();
        responses = new HashMap<String, String>();
        motive = new ArrayList<String>();
    }

    public String getNormalImage() {
        return normalImage;
    }
    
    public String getScaredImage() {
        return scaredImage;
    }
    
    public String getAngryImage() {
        return angryImage;
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

	public ArrayList<String> getMotive() {
		return motive;
	}

	public void setMotive(ArrayList<String> motive) {
		this.motive = motive;
	}
}
