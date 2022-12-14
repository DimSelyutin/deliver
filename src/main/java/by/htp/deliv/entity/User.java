package by.htp.deliv.entity;



public class User {
    private static final long serialVersionUID = 1L; 

    private int id;
    private String login;
    private String email;

    
    private String password;
    
    private String phone;
    
    
    
    
    public User(int id, String login, String phone){
        this.id = id;
        this.login = login;
        // this.email = email;
        this.phone = phone;

    }
    
    public User(String login, String password, String phone) {
        this.login = login;
        // this.email = email;
        this.password = password;
        this.phone = phone;
    }
   
    
    public String getLogin() {
        return login;
        
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [login=" + login + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
    }

    

   

    

    

   

    


}
