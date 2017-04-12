package com.sixth.sport.dao;

import java.util.List;
import com.sixth.sport.domain.Systemddl;

public interface SystemDao {
	/**
	 * 查询不重复的KeyWord
	 * 
	 * @return List<Systemddl>
	 */
	public List<Systemddl> findKeyWord();
	/**
	 * 通过keyword查询
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyWord(List<Object> params);
	/**
	 * 添加保存数据
	 * @param params
	 */
	public void saveSystemddl(List<Object> params);
	/**
	 * 编辑保存
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void updateSystemddl(List<Object> params);
	
	/**
	 * 根据ddlcode和keyword查询对应的ddlname
	 * @param ddlcode
	 * @param keyword
	 * @return
	 */
	public String findByddlName(List<Object> params);
	/**
	 * 删除数据
	 * @param delid
	 * @return
	 */
	public boolean delSystemddl(int delid);

}
