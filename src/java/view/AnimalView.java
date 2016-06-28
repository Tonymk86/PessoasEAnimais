/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.Query;
import model.Animal;
import model.Endereco;
import model.Pessoa;
import model.dao.AnimalDao;
import model.dao.EnderecoDao;
import model.dao.PessoaDao;
import org.primefaces.context.RequestContext;

/**
 *
 * @author tony
 */
@ManagedBean
public class AnimalView {

    private String nome;
    private String raca;
    private Double peso;
    private String especie;
    private String sexo;

    private String rua;
    private int numero;
    private String bairro;
    private String cep;

    private ArrayList lista_animais;

    public AnimalView() {
        System.out.println("Entrou no método construtor.");
        AnimalDao ad = new AnimalDao();
        this.lista_animais = ad.consultarAnimais();
        System.out.println("Tamanho da lista de animais: " + this.lista_animais.size());

    }

    public void buttonAction(ActionEvent actionEvent) {
        String mensagem = "Cadastrado com sucesso.";
        Endereco endereco = new Endereco();

        boolean inserir_lista=true;
        Animal animal = new Animal();
        try {
            

            animal.setEspecie(this.especie);
            animal.setNome(this.nome);
            animal.setPeso(this.peso);
            animal.setRaca(this.raca);
            animal.setSexo(this.sexo);

            endereco.setBairro(bairro);
            endereco.setCep(cep);
            endereco.setNumero(numero);
            endereco.setRua(rua);

            EnderecoDao ed = new EnderecoDao();
            ed.inserirEndereco(endereco);

            System.out.println(animal.toString());
            System.out.println(endereco.toString());
            AnimalDao ad = new AnimalDao();
            ad.inserirAnimal(animal);
            
        } catch (Exception exc) {
            inserir_lista=false;
            System.out.println(exc.toString());
            mensagem = exc.toString();
        }
        
        if(inserir_lista) {
        this.lista_animais.add(animal);
        }
        
//        } catch(Exception exc) {
//        mensagem=exc.toString();
//        }
        RequestContext requestContext = RequestContext.getCurrentInstance();  
         requestContext.execute("location.reload()");
        addMessage(mensagem);

        System.out.println("Entrou no método buttonAction");
          
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList getLista_animais() {
        return lista_animais;
    }

    public void setLista_animais(ArrayList lista_animais) {
        this.lista_animais = lista_animais;
    }
}
