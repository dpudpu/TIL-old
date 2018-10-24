package examples.daoexam.service;

import examples.daoexam.dao.MemberDao;
import examples.daoexam.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;

    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    @Transactional
    public Long addMember(Member member) {
        return memberDao.addMember(member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(String email) {
        return memberDao.getMember(email);
    }
}
