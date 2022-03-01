package models;

import java.util.ArrayList;
import java.util.List;

public class Squad {
    private String name;
    private final int maxSize;
    private String cause;
    private static final ArrayList<Hero> mHeroes = new ArrayList<Hero>();
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

    public List<Hero> getHeroes() {
        return mHeroes;
    }

    public void setHeroes(Hero hero) {
        mHeroes.add(hero);
    }


    public boolean doesHeroExist(Hero hero) {
        int counter = 0;
        for (Hero mHero : mHeroes) {
            if (mHero.getName().equals(hero.getName())) {
                counter++;
            }
        }

        return counter != 1;
    }


}
