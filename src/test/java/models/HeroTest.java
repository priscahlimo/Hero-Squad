package models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HeroTest {
    //    check to see if an object is correctly created
    @Before
    public void tearDown(){
        Hero.clearAllHeroes();
    }

    @Test
    public void heroObjectIsCorrectlyCreated_true() {
        Hero superHero = new Hero("Priscah", 25, "Super Coder", "My Patience", "Restorer");
        assertEquals(true, superHero instanceof Hero);
    }

    @Test
    public void allHeroesContainsAllHeroes_true() {
        Hero superHero = new Hero("Priscah", 25, "Super Coder", "My Patience", "Restorer");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience", "Lawyers");
        assertEquals(true, Hero.getAll().contains(superHero));
        assertEquals(true, Hero.getAll().contains(secondSuperHero));
    }

    @Test
    public void getId_heroInstantiatesWithAnID_1() throws Exception {
        Hero superHero = new Hero("Priscah", 25, "Super Coder", "My Patience", "Restorer");
        Hero secondSuperHero = new Hero("Ilham", 21, "Super Wifie", "Patience", "Lawyers");

    }



    @Test
    public void delete_deleteASpecificHero() throws Exception{
        Hero priscah = setUpNewHero();
        Hero ilham = new Hero("Ilham", 20, "Super wifie", "Patience", "Lawyers");
        priscah.deleteHero();
        assertEquals(1, Hero.getAll().size());
    }

    @Test
    public void updateChangesHeroContent() throws Exception {
        Hero hero = setUpNewHero();


        String formerName = hero.getName();
        int formerAge = hero.getAge();
        String formerSpecialPower = hero.getSpecialPower();
        String formerWeakness = hero.getWeakness();

        hero.setName("Ilham");
        hero.setAge(20);
        hero.setSpecialPower("Singing");
        hero.setWeakness("Laziness");


        assertNotEquals(formerName, hero.getName());
        assertNotEquals(formerAge, hero.getAge());
        assertNotEquals(formerSpecialPower, hero.getSpecialPower());
        assertNotEquals(formerWeakness, hero.getWeakness());
    }

    @Test
    public void squad_correctlyInstantiatesSquadObject(){
        Hero priscah = setUpNewHero();
        Squad flash = setUpNewSquad();
        assertEquals(true, flash instanceof Squad);
    }

    @Test
    public void squad_ensuresHeroChoosesASquad(){
        Hero priscah = setUpNewHero();
        Squad flash = setUpNewSquad();
        boolean exists = false;
        for(Hero hero: flash.getHeroes()){
            if (flash.doesHeroExist(priscah)){
                System.out.println(hero + "exists");
                exists = true;
            }
        }

        if(!exists){
            flash.getHeroes().add(priscah);
        }

        assertEquals(priscah, flash.getHeroes().get(0));
    }

    private Hero setUpNewHero(){
        return new Hero("Priscah", 25, "Super Coder", "My Patience", "restorer");
    }

    private Squad setUpNewSquad(){
        return new Squad("Flash", 9, "restore");
    }
}