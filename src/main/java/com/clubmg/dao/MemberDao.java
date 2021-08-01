package com.clubmg.dao;

import com.clubmg.pojo.Attend;
import com.clubmg.pojo.Member;


public interface MemberDao {

    int getClubById(Long cid);

    Member getMemberInfoByTwoKey(Long uid, Long cid);

    void joinClub(Member member);

    void UpdateApply(Member newMemberInfo);

    void attendActivity(Attend attend);
}
