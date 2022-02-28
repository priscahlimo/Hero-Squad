package models;

import java.util.ArrayList;

public class Squad {
    private String name;
    private int maxSize;
    private String cause;
    private static ArrayList<Squad> instance = new ArrayList<Squad>();
    private int id;


    public Squad(String name, int maxSize, String cause){
        this.name = name;
        this.maxSize = maxSize;
        this.cause = cause;
        instance.add(this);
        this.id = instance.size();
    }

    public String getName() {
        return name;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getCause() {
        return cause;
    }

    public int getId() {
        return id;
    }

    public static  ArrayList<Squad> getAll(){
        return instance;
    }

    public void setId(int id) {
        this.id = id;
    }

}
