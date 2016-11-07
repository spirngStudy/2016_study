package com.study.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.sample.dao.SampleDao;
import com.study.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService{
	
	


	private static final Logger logger = LoggerFactory.getLogger(SampleServiceImpl.class);
	
	@Resource
	private SampleDao sampleDao;
	
	
	public List<Map<String, String>> selectMemberList() {
		logger.debug("MemberListTest!!!!");
		return sampleDao.selectMemberList();
	};
	
	@Override
	public List<Map<String, String>> selectBoardList(Map<String, String> map) {
		return sampleDao.selectBoardList(map);
	}
	
	@Override
	public void insertBoard(Map<String, String> map) {
		sampleDao.insertBoard(map);
		
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
