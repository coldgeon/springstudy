package org.example.SpringTest3;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable=false)
    private Long id; // DB 테이블의 id 칼럼과 매치

    @Column(name="name", nullable=false)
    private String name; // DB 테이블의 name 컬럼과 매칭
}


