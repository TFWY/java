package com.sixth.sport.service;

import java.util.List;

import com.sixth.sport.domain.Systemddl;

public interface SystemService {
	/**
	 * ��ѯ���ظ���KeyWord
	 * 
	 * @return List<Systemddl>
	 */
	public List<Systemddl> findKeyWord();

	/**
	 * ͨ��keyword��ѯ
	 * 
	 * @param keyword
	 * @return
	 */
	public List<Systemddl> findByKeyWord(String keyword);

	/**
	 * ��ӱ���
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void saveSystemddl(String keywordnew, String[] itemname);

	/**
	 * �༭����
	 * 
	 * @param keywordnew
	 * @param itemname
	 */
	public void updateSystemddl(String keywordnew, String[] itemname);
/**
 * ����ddlcode��keyword��ѯ��Ӧ��ddlname
 * @param ddlcode
 * @param keyword
 * @return
 */
	public String findByddlName(String ddlcode, String keyword);
/**
 * ɾ������
 * @param delid
 */

public boolean delSystemddl(int delid);

}
