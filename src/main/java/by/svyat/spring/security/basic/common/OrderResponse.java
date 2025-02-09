package by.svyat.spring.security.basic.common;

public class OrderResponse {
    public String name;
    public OrderResponse(String name) {
        this.name = name;
    }

    public OrderResponse() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
