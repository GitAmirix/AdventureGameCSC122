package game;

import java.util.HashMap;
import java.util.ArrayList;

public class Room {
    private String name;
    private String image;

    private HashMap<String,Room> exits;
    private HashMap<String,String> objects;
    private ArrayList<String> items;

    public Room(String n, String i) {
        name = n;
        image = i;
        exits = new HashMap<String,Room>();
        objects = new HashMap<String,String>();
        items = new ArrayList<String>();
    }

    public String getImage() {
        return image;
    }
    
    public HashMap<String,Room> getExits() {
        return exits;
    }
	    
    public void addExit(String e, Room r) {
        exits.put(e, r);
    }
	    
    public HashMap<String,String> getObjects() {
        return objects;
    }
    
    public void addObject(String i, String d) {
        objects.put(i, d);
    }
    
    public ArrayList<String> getItems() {
        return items;
    }
    
    public void addItem(String i) {
        items.add(i);
    }
    
    public void removeItem(String i) {
        items.remove(i);
    }
    
    public String toString() {
        String s = "You are in " + name + ".\n";
	        
        s += "You see: ";
        for (String object : objects.keySet()) {
            s += object + " ";
        }
        s += "\n";
        
        s += "Exits: ";
        for (String exit : exits.keySet()) {
            s += exit + " ";
        }
        s += "\n";
	        
        return s;
    }
}

