
package controller;

import dao.PizzaManager;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import model.Pizza;

@Named(value = "PizzaController")
//@WebServlet("/pizzacontroller")
@RequestScoped
public class PizzaController {
    
    @Inject
    PizzaManager pm;
    
    private String name;
    private double price;
    private String description;
    private List<Pizza> allPizzas;
    
    public void submit() {
        Pizza p = new Pizza(name, price, description);
        pm.addPizza(p);
        allPizzas = pm.getAllPizzas();
    }
    
    public void delete(Long id) {
        pm.removePizza(id);
        allPizzas = pm.getAllPizzas();
    }
    
    public void update(Long id) {
        pm.updatePizza(id);
        allPizzas = pm.getAllPizzas();
    }
    
    @PostConstruct
    public void fillArray() {
        this.allPizzas = pm.getAllPizzas();
    }

    public PizzaController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Pizza> getAllPizzas() {
        return allPizzas;
    }

    public void setAllPizzas(List<Pizza> allPizzas) {
        this.allPizzas = allPizzas;
    }
    
}
