/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.Endereco;
import model.Pessoa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tony
 */
public class PessoaDao {
    
private final Session session;
public SessionFactory conexao;

public PessoaDao () {
conexao=new Configuration().configure().buildSessionFactory();
session=conexao.openSession();
}

public void inserirPessoa (Pessoa pessoa) {
Transaction tx=this.session.beginTransaction();
session.save(pessoa);
tx.commit();
session.close();
}
}
