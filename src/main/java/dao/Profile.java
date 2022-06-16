package dao;
import java.util.Date;
public class Profile {
    
    private int mem_num;
    private String id;
    private String pw;
    private String name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String grade;
    private String birth;
    private int petno;
    private Date join_date;
    
    public int getMem_num() {
        return mem_num;
    }
    public void setMem_num(int mem_num) {
        this.mem_num = mem_num;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getBirth() {
        return birth;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public int getPetno() {
        return petno;
    }
    public void setPetno(int petno) {
        this.petno = petno;
    }
    public Date getJoin_date() {
        return join_date;
    }
    public void setJoin_date(Date join_date) {
        this.join_date = join_date;
    }
    
    
}