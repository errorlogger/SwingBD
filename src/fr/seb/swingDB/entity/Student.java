
package fr.seb.swingDB.entity;


public class Student {
    
    private Integer id;
    private String prenom;
    private String nom;
    private Integer age;
    private char sex;
    

    public Student() {
    }

    public Student(String prenom, String nom, int age, char sexe) {
        this.prenom = prenom;
        this.nom = nom;
        this.age = age;
        this.sex = sexe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sexe) {
        this.sex = sexe;
    }
    
    public String civilite(){
        
        String civil;
        
        if (this.sex == 'F'){
            civil = "Madame";
        }else{
            civil = "Monsieur";
        }
        
        return civil;
    }
    public void greet(){
        StringBuilder str = new StringBuilder();
        
        str.append("Bonjour ");
        str.append(this.civilite());
        str.append(" ");
        str.append(this.nom);
        str.append(" ");
        str.append(this.prenom);
        
        System.out.println(str);
    }
}
