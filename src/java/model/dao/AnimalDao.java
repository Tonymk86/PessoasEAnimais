/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Animal;
import model.Endereco;
import org.hibernate.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tony
 */
public class AnimalDao {
    
private final Session session;
public SessionFactory conexao;

public AnimalDao () {
conexao=new Configuration().configure().buildSessionFactory();
session=conexao.openSession();
}

public void inserirAnimal (Animal animal) {
Transaction tx=this.session.beginTransaction();
session.save(animal);
tx.commit();
session.close();
}

public ArrayList consultarAnimais() {
Transaction tx=this.session.beginTransaction();
 String hql = "FROM Animal";
        Query query=session.createQuery(hql);
        ArrayList results=(ArrayList) query.list();
        return results;
}

public void excluirAnimal(Animal animal) {
    Transaction tx=this.session.beginTransaction();
    session.delete(animal);
    tx.commit();
    session.close();
}

}
