package com.dao;

import java.util.List;
import com.pojo.SmbmsUser;

public interface SmbmsUserDAO {
	/**
	 * 获取用户信息
	 * @return
	 */
	List<SmbmsUser> findAll();
}