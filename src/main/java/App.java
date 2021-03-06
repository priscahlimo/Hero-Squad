import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "squad.hbs");
        },new HandlebarsTemplateEngine());

        post("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");
            Squad squad = new Squad(name,maxSize,cause);
            return new ModelAndView(model, "successSquad.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squads/list", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getAll();
            model.put("squads", squads);

            return new ModelAndView(model, "squadList.hbs");
        }, new HandlebarsTemplateEngine());

//        heroes part

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> foundHero = Hero.getAll();
            ArrayList<Squad> allSquads = Squad.getAll();
            model.put("heroes",foundHero);
            model.put("squads", allSquads);

            return new ModelAndView(model, "Heroes.hbs");
        }, new HandlebarsTemplateEngine());

        get("/heroes/list", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Hero> heroes = Hero.getAll();

            model.put("heroes", heroes);
            return new ModelAndView(model, "totalheros.hbs");
        }, new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String specialPower = request.queryParams("special-power");
            String weakness = request.queryParams("weakness");

            model.put("name", name);
            model.put("age", age);
            model.put("specialPower", specialPower);
            model.put("weakness", weakness);



            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }

}
