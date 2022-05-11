package domain;

public class Guide {
    private String name;
    private String Id;
    private String phone;
    public Guide() {
    }
    public Guide(String name, String id, String phone) {
        this.name = name;
        Id = id;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return Id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
