package com.study.sample.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface SampleService {
	
	List<Map<String, String>> selectBoardList(Map<String, String> map);

	List<Map<String, String>> selectMemberList();

	void insertBoard(Map<String, Object> map, HttpServletRequest request);

	Map<String, String> selectBoardDetail(Map<String, String> map) throws Exception;

	void updateBoard(Map<String, String> map);

	void deleteBoard(Map<String, String> map);
}
