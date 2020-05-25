package br.com.sky.javacore.l28jdbc.interfaces;

import br.com.sky.javacore.l28jdbc.classes.Carro;

import java.util.List;

public interface CarroDAO {
    void update(Carro carro);

    List<Carro> selectAll();

    List<Carro> searchByName(String nome);

    void delete(Carro carro);

    void save(Carro carro);
}
