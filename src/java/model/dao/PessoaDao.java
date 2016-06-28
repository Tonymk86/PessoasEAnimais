/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Endereco;
import model.Pessoa;
import org.hibernate.*;
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

    public PessoaDao() {
        conexao = new Configuration().configure().buildSessionFactory();
        session = conexao.openSession();
    }

    public void inserirPessoa(Pessoa pessoa) {
        Transaction tx = this.session.beginTransaction();
        session.save(pessoa);
        tx.commit();
        session.close();
    }

    public ArrayList consultarPessoas() {
        Transaction tx = this.session.beginTransaction();
        String hql = "FROM Pessoa";
        Query query = session.createQuery(hql);
        System.out.println("Testando código:" + query.toString());
        ArrayList results = (ArrayList) query.list();
        System.out.println("Testando código 2, tamanho do código:" + results.size());
        return results;
    }

    public void excluirPessoa(Pessoa pessoa) {
        Transaction tx = this.session.beginTransaction();
        session.delete(pessoa);
        tx.commit();
        session.close();
    }

}
