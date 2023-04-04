package com.onebox_comex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Column(nullable = false, length = 100)
    private String rua;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(length = 100)
    private String complemento;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String cidade;
    @Column(nullable = false, length = 2)
    private String estado;

}
