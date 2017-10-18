/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.seb.swingDB.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author formation
 */
public interface DAOInterface <T,DAO,S>{

    public void deleteOneById(T st) throws SQLException;

    public int save(T st) throws SQLException;
    
    public DAO findOneById (int i) throws SQLException;
    
    public DAO findAll () throws SQLException;
    
    public T getOne() throws SQLException;
    
    public Map<S,S> getOneAsMap()throws SQLException;
    
    public List<Map<S,S>> getAllAsArray()throws SQLException;
    
    public List<T> getAll() throws SQLException;
    
}
