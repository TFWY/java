package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Systemddl;

public interface SystemService {
	/**
	 * 查询不重复的KeyWord
	 * 
	 * @return List<Systemddl>
	 */
	public List<Systemddl> findKeyWord();

	/**
	 * 通过keyword查询
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyWord(String keyword);

	/**
	 * 添加保存
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void saveSystemddl(String keywordnew, String[] itemname);

	/**
	 * 编辑保存
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void updateSystemddl(String keywordnew, String[] itemname);
/**
 * 根据ddlcode和keyword查询对应的ddlname
 * @param ddlcode
 * @param keyword
 * @return
 */
	public String findByddlName(String ddlcode, String keyword);
/**
 * 删除数据
 * @param delid
 */

public boolean delSystemddl(int delid);

}
