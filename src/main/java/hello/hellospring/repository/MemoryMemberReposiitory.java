package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberReposiitory implements MemberRepository{

    //레포지토리의 역할을 배우기 위해 memory 로 저장할거임
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        //시퀀스 증가 후 아이디 저장
        member.setId(++sequence);
        //메모리에 저장
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //Optional 로 Null 반환 대비
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        //list 로 반환
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }


}
