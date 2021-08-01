package com.clubmg.service;

import com.clubmg.pojo.Club;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface ChiefService {

    Club getClubByAdminLimit(Long adminId);

    void allowJoin(Long applyUid,Long currentUid);

    void refuseQuit(Long applyUid, Long currentUit);
}
