package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //회원 등록
    Member save(Member member);
    //아이디로 조회
    Optional<Member> findById(Long id);
    //이름으로 조회
    Optional<Member> findByName(String name);
    //회원 리스트 반환
    List<Member> findAll();
}
