package com.DSI32G4.MyLab;


//Classe pour manipuler les données de l'utilisateur lors d'enregistrement
 public class RegisterData {


          int _id;
          String first_name;
          String last_name;
          String email_id;
          String DateNaissance;
          String sexe;
public String getPassword() {
        return password;
        }
        public void setPassword(String password) {
        this.password = password;
        }

        public String password;

// Empty constructor
public RegisterData(){

        }

         public String getSexe() {
                 return sexe;
         }

         public void setSexe(String sexe) {
                 this.sexe = sexe;
         }

         // constructor
public RegisterData(int id, String first_name, String  last_name,String email_id,String sexe,String DateNaissance){
        this._id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email_id=email_id;
        this.DateNaissance = DateNaissance;
        this.sexe=sexe;
        }


// getting ID
        public int getID(){
        return this._id;
        }

// setting id
        public void setID(int id){
        this._id = id;
        }

public String getfirstName() {
        // TODO Auto-generated method stub
        return first_name;
        }

        // setting  first name
        public void setfirstName(String first_name){
        this.first_name =first_name;
        }
public String getlastName() {
        // TODO Auto-generated method stub
        return last_name;
        }

        public void setlastName(String last_name){
        this.last_name =last_name;
        }
public String getEmailId() {
        // TODO Auto-generated method stub
        return email_id;
        }
        public void setEmailId(String email_id){
        this.email_id =email_id;
        }
public String getMobNo() {
        // TODO Auto-generated method stub
        return DateNaissance;
        }
         public String getDateNaissance() {
                 return DateNaissance;
         }

         public void setDateNaissance(String dateNaissance) {
                 DateNaissance = dateNaissance;
         }
 }