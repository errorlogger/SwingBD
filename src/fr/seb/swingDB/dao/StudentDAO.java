
package fr.seb.swingDB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fr.seb.swingDB.entity.Student;
import java.sql.Statement;

public class StudentDAO implements DAOInterface <Student,StudentDAO,String> {
    
    /* persistence de l'entité student*/
    
    private Connection dbConnection;
    private PreparedStatement state;
    private ResultSet rst;
    
    
    public StudentDAO(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
    
    @Override
    public int save(Student st) throws SQLException{
        int affectedRows;
   
        if (st.getId()==null){
            affectedRows = insert(st);
        }else{
            affectedRows = update(st);
        }
    
        return affectedRows;
    }

    //insert dans la base de données
    private int insert(Student st) throws SQLException{
        String sql ="INSERT INTO students (name,first_name,age, sex) VALUES(?,?,?,?)";
        state = dbConnection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//pour recuperer l'id du dernier insert
        
        state.setString(1,st.getNom());
        state.setString(2,st.getPrenom());
        state.setInt(3,st.getAge());
        state.setString(4,String.valueOf(st.getSex()));
        
        ResultSet key = state.getGeneratedKeys();
        if(key.next()){
            st.setId(key.getInt("id"));
        }
        
        return state.executeUpdate();
    }
    
    private int update(Student st) throws SQLException{
        
        String sql ="UPDATE  students SET name = ? , first_name = ? , age = ? , sex = ? WHERE id = ?)";
        state = dbConnection.prepareStatement(sql);
        
        state.setString(1,st.getNom());
        state.setString(2,st.getPrenom());
        state.setInt(3,st.getAge());
        state.setString(4,String.valueOf(st.getSex()));
        state.setInt(5,st.getId());
        
        return state.executeUpdate();
    }
    
    @Override
    public void deleteOneById(Student st) throws SQLException{
        if (st.getId()!=null){
            String sql = "DELETE FROM students WHERE id =?";
            
            state = dbConnection.prepareStatement(sql);
            state.setInt(1,st.getId());
            
            state.executeUpdate();
        }
    }
    
    @Override
    public StudentDAO findOneById (int i) throws SQLException{
        
        String sql = "SELECT * FROM students WHERE id = ?";
        state = dbConnection.prepareStatement(sql);
        state.setInt(1,i);
            
        rst = state.executeQuery();
        return this;
    }
    
    
    @Override
    public StudentDAO findAll () throws SQLException{
        
        String sql = "SELECT * FROM students ";
        state = dbConnection.prepareStatement(sql);
        rst = state.executeQuery();
        return this;
    }

    @Override
    public Student getOne() throws SQLException{
        
        Student st = new Student();
        
        if (rst.next()){
            st.setNom(rst.getString("name"));
            st.setPrenom(rst.getString("first_name"));
            st.setAge(rst.getInt("age"));
            st.setSex(rst.getString("sex").charAt(0));
        }
        
        return st;
    }
    
    // recuperation des donées sous forme de tableau 'MAP'
    @Override
    public Map<String,String> getOneAsMap() throws SQLException{
        
        Map<String,String> mapDonnees = new HashMap<>();
        
        if (rst.next()){
            mapDonnees.put("name",rst.getString("name"));
            mapDonnees.put("first_marc",rst.getString("name"));
            mapDonnees.put("age",String.valueOf(rst.getInt("age")));
            mapDonnees.put("id",rst.getString("sex"));
        }
        
        return mapDonnees;
    }
    
    public List<Student> getAll() throws SQLException{
        List<Student> ls = new ArrayList<>();
        
        if (rst.isBeforeFirst()){
            while(!rst.isLast()){
            ls.add(this.getOne());
            }
        }
        return ls;
    }


    public List<Map<String,String>> getAllAsArray() throws SQLException{
        List<Map<String,String>> lsMap = new ArrayList<>();
        
        if (rst.isBeforeFirst()){
            while(!rst.isLast()){
            lsMap.add(this.getOneAsMap());
            }
        }
        return lsMap;
    }
}