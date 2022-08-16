
package newpackage;

import br.edu.ifsp.pep.modelo.Pessoa;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aula01-29_07PU");
        
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(new Date());
        pessoa.setNome("Natália");
        pessoa.setSalario(new BigDecimal(555.999999d));
        pessoa.setEmail("email");
        pessoa.setRua("rua 1");
        pessoa.setNumero(12);
        
        Pessoa pessoa2 = new Pessoa();
        pessoa2.setDataNascimento(new Date());
        pessoa2.setNome("Natália");
        pessoa2.setSalario(new BigDecimal(555.999999d));
        pessoa2.setEmail("emai");
        pessoa2.setRua("rua 1");
        pessoa2.setNumero(10);
        
        //define o gerenciador de entidade
        EntityManager em = emf.createEntityManager();
        
        // transacao faz tudo ou nada (se acabar a energia
        em.getTransaction().begin();// inicia a transacao
        
        //em.persist(pessoa); // insert
        em.merge(pessoa); //update, se ele exite altera se nao insere
        em.merge(pessoa2);
        
        em.getTransaction().commit(); // finaliza a transacao
    }
}
