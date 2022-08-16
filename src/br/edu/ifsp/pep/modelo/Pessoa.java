
package br.edu.ifsp.pep.modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

//add percistencia -> conectar com o banco
// add libary eclipse jpa
// toda entidade tem q ter construtor vazio
//todo tipo primitivo é instancido, nao da pra colocar null
@Entity // definir unidade de persistencia 
@Table(name = "pessoa", uniqueConstraints = {@UniqueConstraint(name="UniqueRuaAndNumero", columnNames = {"rua","numero"}),
                                            @UniqueConstraint(name="UniqueEmail", columnNames = "email")}) //define a tabela

public class Pessoa {
 
    @Id //define a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo", nullable = false)
    private Long codigo;
    
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;
    
    @Column(name = "email", nullable =false)
    private String email;
    
    @Column(name = "rua", nullable=false)
    private String rua;
    
    @Column(name = "numero", nullable=false )
    private Integer numero;        
    
    @Column(name = "salario", precision = 8, scale =2)
    //private Double salario;
    private BigDecimal salario;
    
    @Column(name = "data_nascimento",  nullable = false)    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataNascimento;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }


    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
    
}
