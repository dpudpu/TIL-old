package examples.boot.springboard.service;


import examples.boot.springboard.dto.Member;

public interface MemberService {
    public Long addMember(Member member);
    public Member getMember(String email);
}
