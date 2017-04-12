package com.sixth.sport.dao;

import java.util.List;
import com.sixth.sport.domain.Systemddl;

public interface SystemDao {
	/**
	 * ��ѯ���ظ���KeyWord
	 * 
	 * @return List<Systemddl>
	 */
	public List<Systemddl> findKeyWord();
	/**
	 * ͨ��keyword��ѯ
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyWord(List<Object> params);
	/**
	 * ��ӱ�������
	 * @param params
	 */
	public void saveSystemddl(List<Object> params);
	/**
	 * �༭����
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void updateSystemddl(List<Object> params);
	
	/**
	 * ����ddlcode��keyword��ѯ��Ӧ��ddlname
	 * @param ddlcode
	 * @param keyword
	 * @return
	 */
	public String findByddlName(List<Object> params);
	/**
	 * ɾ������
	 * @param delid
	 * @return
	 */
	public boolean delSystemddl(int delid);

}
