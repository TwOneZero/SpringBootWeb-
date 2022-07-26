package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberReposiitory repository = new MemoryMemberReposiitory();


    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("이일공이요");
        repository.save(member);

        Member result =  repository.findById(member.getId()).get();
        //1.Assertions.assertEquals 로 체크
//        Assertions.assertEquals(member, result);
        //2. assertj 로 체크
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("이일공인데요1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("이일공인데요2");
        repository.save(member2);

        Member resultForOne = repository.findByName("이일공인데요1").get();

        assertThat(resultForOne).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("이일공1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("이일공2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);


    }

}
