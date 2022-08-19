package newpackage;

import br.edu.ifsp.pep.dao.CategoriaDAO;
import br.edu.ifsp.pep.dao.ProdutoDAO;
import br.edu.ifsp.pep.modelo.Categoria;
import br.edu.ifsp.pep.modelo.Produto;
import java.math.BigDecimal;
import java.util.List;

public class TesteProdutoCategoria {

    private static final ProdutoDAO produtoDAO = new ProdutoDAO();

    public static void main(String[] args) {
        adicionarProdutos();
        exibirProdutos();
        reajustarPreco(10.0);
        exibirProdutos();

    }

    private static void adicionarProdutos() {
        for (int i = 0; i < 10; i++) {
            Categoria categoria = new Categoria();
            categoria.setDescricao("Categoria " + i);
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            categoriaDAO.inserir(categoria);

            Produto produto = new Produto();
            produto.setDescricao("Produto " + i);
            produto.setPreco(new BigDecimal(60.0 * (i + 1)));
            produto.setQuantidade(100);

            produto.setCategoria(categoria);

            produtoDAO.inserir(produto);

        }
    }

    private static void reajustarPreco(double percent) {
        List<Produto> produtos = produtoDAO.buscar();
        for (Produto p : produtos) {
            p.setPreco(new BigDecimal(p.getPreco().doubleValue() + p.getPreco().doubleValue() * percent / 100));
            produtoDAO.alterar(p);
        }
    }

    private static void exibirProdutos() {
        List<Produto> produtos = produtoDAO.buscar();
        for (Produto p : produtos) {
            System.out.println("Descri: " + p.getDescricao());
            System.out.println("Preco: " + p.getPreco());
            System.out.println("Categoria: " + p.getCategoria().getDescricao());
            System.out.println("Estoque: " + p.getQuantidade());
            System.out.println("");
        }
    }

}
