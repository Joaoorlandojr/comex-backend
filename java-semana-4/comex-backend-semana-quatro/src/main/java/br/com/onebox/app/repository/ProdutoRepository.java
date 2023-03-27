package br.com.onebox.app.repository;

import br.com.onebox.app.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProdutoRepository {
   List<Produto> findAll();
   @Query("SELECT p FROM Produto p WHERE p.quantidadeEmEstoque = 0")
   List<Produto> listaIndisponiveis(@Param("quantidadeEmEstoque") int quantidadeEmEstoque);

}
