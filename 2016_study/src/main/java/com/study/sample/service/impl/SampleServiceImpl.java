package com.study.sample.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.study.common.util.FileUtil;
import com.study.sample.dao.SampleDao;
import com.study.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{

	private static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	@Resource
	private SampleDao sampleDao;
	
	@Resource
	private FileUtil fileUtil;
	
	
	public List<Map<String, String>> selectMemberList() {
		logger.debug("MemberListTest!!!!");
		return sampleDao.selectMemberList();
	};
	
	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> map) {
		return sampleDao.selectBoardList(map);
	}
	
	@Transactional
	@Override
	public void insertBoard(Map<String, Object> map, HttpServletRequest request) {
		sampleDao.insertBoard(map);
		
		List<Map<String, Object>> list = fileUtil.parseInsertFileInfo(map, request);
		for(int i=0; i < list.size(); i++) {
			sampleDao.insertFile(list.get(i));
		}
				
	}
	
	@Transactional
	@Override
	public Map<String, String> selectBoardDetail(Map<String, String> map) throws Exception {
		//TransactionTest
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Transaction Test");
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ update");
		sampleDao.updateHitCnt(map);

		logger.debug("---------------------------------------------------------- insert");
//		sampleDao.insertTest(map);
		
		Map<String, String> resultMap = sampleDao.selectBoardDetail(map);
		return resultMap;
	}

	@Override
	public void updateBoard(Map<String, String> map) {
		sampleDao.updateBoard(map);
		
	}

	@Override
	public void deleteBoard(Map<String, String> map) {
		sampleDao.deleteBaord(map);
	}
}
