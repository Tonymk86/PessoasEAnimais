package model.dao;


import model.Endereco;
import model.Endereco;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tony
 */
public class EnderecoDao {
    
private final Session session;
public SessionFactory conexao;

public EnderecoDao () {
conexao=new Configuration().configure().buildSessionFactory();
session=conexao.openSession();
}

public void inserirEndereco (Endereco endereco) {
Transaction tx=this.session.beginTransaction();
session.save(endereco);
tx.commit();
session.close();
}
}
