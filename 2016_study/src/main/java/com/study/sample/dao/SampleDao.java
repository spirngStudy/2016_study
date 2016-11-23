package com.study.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.study.common.util.QueryMapper;

@Repository
public class SampleDao extends QueryMapper {
	
	private String namespace = "com.study.sample.";
	
	@SuppressWarnings("unchecked")
	public List<Map<String, String>> selectMemberList() {
		return selectList(namespace + "selectMemberList");
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> selectBoardList(Map<String, String> map) {
		return selectList(namespace + "selectBoardList");
	}

	public void insertBoard(Map<String, String> map) {
		insert(namespace + "insertBoard", map);
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> selectBoardDetail(Map<String, String> map) throws Exception {
		return (Map<String, String>) selectOne(namespace + "selectBoardDetail", map);
	}

	public void updateHitCnt(Map<String, String> map) throws Exception {
		update(namespace + "updateHitCnt", map);
	}

	public void insertTest(Map<String, String> map) throws Exception {
		insert(namespace + "insertTest", map);
	}

	public void updateBoard(Map<String, String> map) {
		update(namespace + "updateBoard", map);
	}

	public void deleteBaord(Map<String, String> map) {
		delete(namespace + "deleteBoard", map);
	}


}
