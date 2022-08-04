package hello.hellospring.domain;

import javax.persistence.*;

//jpa 가 관리하는 엔티티
@Entity
public class Member {

    //@GeneratedValue ID 를 자동으로 생성하는 것읠 IDENTITY 전략이라고 함
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
