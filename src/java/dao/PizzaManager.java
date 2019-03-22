
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Pizza;

                       @Stateless
public class PizzaManager {

    @PersistenceContext
    EntityManager em;
    
    public void addPizza(Pizza p) {
        em.persist(p);
    }
    
    public void removePizza(Long id) {
        em.remove(em.find(Pizza.class, id));
    }
    
    public void updatePizza(Long id) {
        em.merge(em.find(Pizza.class, id));
    }
    
    public List<Pizza> getAllPizzas() {
        Query q = em.createQuery("SELECT p FROM Pizza p");
        return q.getResultList();
    }
    
}
