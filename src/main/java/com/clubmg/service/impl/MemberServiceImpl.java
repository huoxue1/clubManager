package com.clubmg.service.impl;

import com.clubmg.dao.MemberDao;
import com.clubmg.pojo.Attend;
import com.clubmg.pojo.Member;
import com.clubmg.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService {

    @Resource(name = "memberDao")
    private MemberDao memberDao;

    @Override
    public int joinClub(Long uid,Long cid) {

        int clubState = memberDao.getClubById(cid);
        if(clubState!=1)return -1;

        Member member = new Member();
        member.setUid(uid);
        member.setCid(cid);
        member.setPermit(0);
        member.setState1(1);
        memberDao.joinClub(member);

        return 0;
    }

    @Override
    public int quitClub(Long uid,Long cid) {
        Member member = memberDao.getMemberInfoByTwoKey(uid,cid);
        member.setState1(-1);
        memberDao.UpdateApply(member);
        return 0;
    }

    @Override
    public int applyPosition(Long uid, Long cid, String position) {
       Member member = memberDao.getMemberInfoByTwoKey(uid,cid);
       member.setPosition(position);
       member.setState2(1);
       memberDao.UpdateApply(member);
       return 0;
    }

    @Override
    //辞职
    public void resign(Long uid, Long cid, String position) {
        Member member = memberDao.getMemberInfoByTwoKey(uid,cid);
        member.setPosition(position);
        member.setState2(-1);
        memberDao.UpdateApply(member);
    }

    @Override
    public int attendActivity(Long aid, Long uid) {
        Attend attend = new Attend();
        attend.setUid(uid);
        attend.setAid(aid);
        memberDao.attendActivity(attend);
        return 0;
    }


}
