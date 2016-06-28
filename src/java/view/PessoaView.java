/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author tony
 */
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import model.Endereco;
import model.Pessoa;
import model.dao.EnderecoDao;
import model.dao.PessoaDao;

@ManagedBean
public class PessoaView {

    private String sexo;
    private String nome;
    private String cpf;
    private String rg;

    private String rua;
    private int numero;
    private String bairro;
    private String cep;

    private ArrayList lista_pessoas;

    public PessoaView() {
        PessoaDao ad = new PessoaDao();
        this.lista_pessoas = ad.consultarPessoas();
    }

    public void imprimir() {
        System.out.println("PessoaView{" + "sexo=" + sexo + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + '}');
    }

    public void excluirPessoa(Pessoa pessoa) {
        PessoaDao ad = new PessoaDao();
        ad.excluirPessoa(pessoa);
        this.lista_pessoas.remove(pessoa);
    }

    public void cadastrarPessoa() {
        String mensagem = "Cadastrado com sucesso.";
        Endereco endereco = new Endereco();

        System.out.println("cadastrarPessoa()");
        
        boolean s = true;
//        if (this.sexo.equals("Masculino")) {
//            sexo=true;
//        } else {
//            sexo=false;
//        }
//try {
        //try {
        Pessoa pessoa=new Pessoa();

        pessoa.setCpf(this.cpf);
        pessoa.setEndereco(endereco);
        pessoa.setNome(this.nome);
        pessoa.setRg(rg);
        pessoa.setSexo(s);

        endereco.setBairro(bairro);
        endereco.setCep(cep);
        endereco.setNumero(numero);
        endereco.setRua(rua);

        EnderecoDao ed = new EnderecoDao();
        ed.inserirEndereco(endereco);

        System.out.println("CPF: " + this.cpf);

        pessoa.setCpf(this.cpf);
        pessoa.setNome(nome);
        pessoa.setRg(rg);
        pessoa.setEndereco(endereco);
        pessoa.setSexo(s);

        System.out.println(pessoa.toString());
        System.out.println(endereco.toString());
        PessoaDao pd = new PessoaDao();
        pd.inserirPessoa(pessoa);
        //} catch(Exception exc) {
        //System.out.println(exc.toString());
        //}
//        } catch(Exception exc) {
//        mensagem=exc.toString();
//        }
        addMessage(mensagem);

        System.out.println("Entrou no método buttonAction");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    @Override
    public String toString() {
        return "PessoaView{" + "sexo=" + sexo + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + '}';
    }

    public ArrayList getLista_pessoas() {
        return lista_pessoas;
    }

    public void setLista_pessoas(ArrayList lista_pessoas) {
        this.lista_pessoas = lista_pessoas;
    }
}
