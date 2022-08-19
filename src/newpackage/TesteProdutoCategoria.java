package newpackage;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;

public class TesteProdutoCategoria {

    public static void main(String[] args) {
        
        
        Categoria categoria = new Categoria();
        categoria.setDescricao("Informatica");
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.inserir(categoria);
        
        Produto produto = new Produto();
        produto.setDescricao("Teclado");
        produto.setPreco(new BigDecimal(60.0));
        produto.setQuantidade(100);
        
        produto.setCategoria(categoria);
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        
        produtoDAO.inserir(produto);
        
      
        List<Produto> produtos = produtoDAO.buscar();
        for(Produto p: produtos){
            System.out.println("Descricao: "+ p.getDescricao());
            System.out.println("Categoria: "+ p.getCategoria().getDescricao());
        }
        
       
   }

}
