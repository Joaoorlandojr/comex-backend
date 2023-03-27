package br.com.onebox.app.service;

import br.com.onebox.app.dtos.CategoriaNomeDTO;
import br.com.onebox.app.entity.Categoria;
import br.com.onebox.app.repository.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private ModelMapper modelMapper;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria cadastrar (CategoriaNomeDTO categoriaNomeDTO) throws Exception {
        Optional<Categoria> categoriaOptional = categoriaRepository.findByNome(categoriaNomeDTO.getNome());
        try{
            if (categoriaOptional == null){
                throw new Exception("Esta categoria é nula");
            }
            if (categoriaOptional.isEmpty()){
                throw new Exception("Esta categoria está vazia");
            }
            if (categoriaOptional.isPresent()) {
                throw new Exception("Já existe uma categoria com este nome");
            }

            Categoria categoria = modelMapper.map(categoriaNomeDTO, Categoria.class);
            return categoriaRepository.save(categoria);

        } catch (Exception categoriaException){
            System.out.println("O erro ocorrido foi: " + categoriaException.getMessage());
            throw categoriaException;
        }
    }

    public CategoriaNomeDTO getById(Long id) throws Exception {
        try {
            if (id == null || id < 1) {
                throw new Exception("O id não é válido, está nulo ou negativo");
            }

            Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
            if (categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                return modelMapper.map(categoria, CategoriaNomeDTO.class);
            } else {
                throw new Exception("Não foi possível encontrar a categoria com o id informado");
            }
        } catch (Exception categoriaException) {
            System.out.println("O erro ocorrido foi: " + categoriaException.getMessage());
            throw categoriaException;
        }
    }


}
