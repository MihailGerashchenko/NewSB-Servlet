package packaging.entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Integer id;
    private String login;
    private String password;
    private UserRole role;
    private List<Test> tests = new ArrayList<>();
    private String email;
    private String phone;
    private String address;

    public Customer() {
    }

    public Customer(String email, String phone, String address) {
    }

    public Customer(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Customer(Integer id, String email, String phone, String address) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(Integer id, String login, UserRole role, String email, String phone, String address) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(Integer id, String login, String password,
                    UserRole role, String email,
                    String phone, String address) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String login, String password, UserRole role,
                    String email, String phone, String address) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String login, String email, String phone, String address) {
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public void addTest(Test test) {
        tests.add(test);
        test.setCustomer(this);
    }

    public Test getTest(int index) {
        return tests.get(index);
    }

    public void clearTests() {
        tests.clear();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", tests=" + tests +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
