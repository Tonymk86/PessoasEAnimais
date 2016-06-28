/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import model.Endereco;
import model.Pessoa;
import model.dao.EnderecoDao;
import model.dao.PessoaDao;

/**
 *
 * @author tony
 */

public class PessoaBean {
    
    Pessoa pessoa;
    
    public static void main(String args[]) {

            Endereco endereco=new Endereco();
            endereco.setBairro("Centro");
            endereco.setCep("28740000");
            endereco.setNumero(43);
            endereco.setRua("Rua Abelardo de Carvalho");
            EnderecoDao ed=new EnderecoDao();
            ed.inserirEndereco(endereco);
            
//    	    Pessoa e=new Pessoa(null, true, Long.MIN_VALUE, null, endereco);
//            e.setCpf("13051947725");
//            e.setNome("Tony Kristiansen");
//            e.setRg("2758692567");
//            e.setSexo(true);
//            e.setEndereco(endereco);
//            PessoaDao pd=new PessoaDao();
//            pd.inserirPessoa(e);
    }
    
    public void cadastrarPessoa() {
    
    }
}