package lt.vu.mif.Repositories;

import lt.vu.mif.Entities.Driver;
import lt.vu.mif.Entities.Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ShopRepository {

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void add(Shop shop) {
        em.persist(shop);
    }

    @Transactional
    public Shop get(Integer id) {
        return em.find(Shop.class, id);
    }

    @Transactional
    public List<Shop> getAll() {
        return em.createNamedQuery("Shops.getAll", Shop.class).getResultList();
    }

    @Transactional
    public void update(Shop shop) {
        em.merge(shop);
    }

    @Transactional
    public void delete(Shop shop) {
        em.remove(shop);
    }
}
