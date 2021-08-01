package com.clubmg.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberService {

    int joinClub(Long uid,Long cid);

    int quitClub(Long uid,Long cid);

    int applyPosition(Long uid, Long cid, String position);

    void resign(Long uid, Long cid, String position);

    int attendActivity(Long aid, Long uid);
}