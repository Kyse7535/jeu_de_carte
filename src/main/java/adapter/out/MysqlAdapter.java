package adapter.out;

import adapter.out.database.CombatData;
import adapter.out.database.CompteData;
import adapter.out.database.HerosData;
import adapter.out.database.Mapper;
import application.port.out.CompteRepository;
import application.port.out.HerosRepository;
import domain.Compte;
import domain.Heros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MysqlAdapter extends PersistanceAdapter{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
    EntityManager em = emf.createEntityManager();
    @Override
    public void save(Compte compte) {
        em.getTransaction().begin();
        CompteData compteData = Mapper.comptetoData(compte);
        em.persist(compteData);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Compte load_compte(String pseudo) {
        em.getTransaction().begin();
        CompteData compteData = em.find(CompteData.class, pseudo);
        em.close();
        if (compteData != null) {
            return Mapper.compteDataToDomain(compteData);
        }
        return null;
    }

    @Override
    public void update(Compte compte) {
        em.getTransaction().begin();
        Compte compte1 = this.load_compte(compte.getPseudo());
        compte1 = compte;
        CompteData compteData = em.merge(Mapper.comptetoData(compte1));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public ArrayList<Compte> findAllPlayers() {
        em.getTransaction().begin();
        Query query = em.createQuery("select * from CompteData", CompteData.class);
        ArrayList<CompteData> compteDataList = (ArrayList<CompteData>) query.getResultList().stream().collect(Collectors.toList());
        ArrayList<Compte> comptes = Mapper.compteDataToDomain(compteDataList);
        em.close();
        return comptes;
    }

    @Override
    public void save(Heros heros) {
        em.getTransaction().begin();
        HerosData herosData = Mapper.HerotoData(heros);
        em.persist(herosData);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public Heros load_heros(String id) {
        em.getTransaction().begin();
        HerosData herosData = em.find(HerosData.class, id);
        if (herosData != null) {
            Heros heros = Mapper.heroDatatoDomain(herosData);
            return  heros;
        }
        return null;
    }

    @Override
    public void update(Heros heros) {
        em.getTransaction().begin();
        Heros heros1 = this.load_heros(heros.getId());
        heros1 = heros;
        HerosData herosData = em.merge(Mapper.HerotoData(heros1));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public ArrayList<Heros> findAllHeros() {
        em.getTransaction().begin();
        Query query = em.createQuery("select * from HerosData ", HerosData.class);
        ArrayList<HerosData> herosData = (ArrayList<HerosData>) query.getResultList().stream().collect(Collectors.toList());
        ArrayList<Heros> heros = Mapper.listHeroDataToDomain(herosData);
        em.close();
        return heros;
    }
}
