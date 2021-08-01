package com.clubmg.dao;

import com.clubmg.pojo.Club;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ChiefDao {
    Club getClubByAdminLimit(Long adminId);
}
