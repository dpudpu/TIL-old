package examples.daoexam.service;

import examples.daoexam.dto.Member;

public interface MemberService {
    public Long addMember(Member member);
    public Member getMember(String email);
}
