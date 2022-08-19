package br.edu.ifsp.pep.dao;

import br.edu.ifsp.pep.modelo.Categoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class CategoriaDAO {

    private EntityManagerFactory emf;

    public CategoriaDAO() {
        emf = Persistence.createEntityManagerFactory("Aula01-29_07PU");
    }

    private EntityManager getEntityManager() {
        return this.emf.createEntityManager();
    }

    public void inserir(Categoria categoria) {
        
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.persist(categoria);

        em.getTransaction().commit();
    }
    
    public void alterar(Categoria categoria) {
        
        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        em.merge(categoria);

        em.getTransaction().commit();
    }
    
    public List<Categoria> buscar(){
        //JPQL
        //Sempre pensar em classe esquece tabela
        //SELECT p FROM Produto p
        TypedQuery<Categoria> query = getEntityManager().createQuery("SELECT c FROM Categoria c", Categoria.class);
        
        return query.getResultList();
    }
}
