package packaging.entity;

public class Test {

    private Integer id;
    private String subject;
    private String question1;
    private String question2;
    private String question3;
    private String time;
    private Degree degree;
    private Customer customer;

    public Test() {
    }

    public Test(Integer id, String subject, String question1, String question2,
                String question3, String time, Degree degree) {
        this.id = id;
        this.subject = subject;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.time = time;
        this.degree = degree;
    }

    public Test(String subject, String question1, String question2,
                String question3, String time, Degree degree) {
        this.subject = subject;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.time = time;
        this.degree = degree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", question1='" + question1 + '\'' +
                ", question2='" + question2 + '\'' +
                ", question3='" + question3 + '\'' +
                ", time='" + time + '\'' +
                ", degree=" + degree +
                ", customer=" + customer +
                '}';
    }
}

