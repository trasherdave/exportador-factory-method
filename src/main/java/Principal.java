import com.manoelcampos.exportador.ExportadorListaProduto;
import com.manoelcampos.exportador.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Executa a aplicação Exportador Simple Factory.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) {
        final List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("TV", "LG", "132-A", 120));
        produtos.add(new Produto("Notebook", "Asus", "New age", 341));
        produtos.add(new Produto("Smartphone", "Samsung", "Galaxy S10", 214));

        ExportadorListaProduto exportadorMd = ExportadorListaProduto.newInstance("md");
        exportadorMd.addNewColuna(Principal::estoqueSubtraido, "Estoque subtraído");

        ExportadorListaProduto exportadorHtml = ExportadorListaProduto.newInstance("html");
        exportadorHtml.addNewColuna(Principal::estoqueSubtraido, "Estoque subtraído");

        System.out.println(exportadorMd.exportar(produtos));
        System.out.println(exportadorHtml.exportar(produtos));
    }

    private static double estoqueSubtraido(Produto produto) {

        return produto.getEstoque() - 100;
    }

}
