package com.study.sample.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.sample.service.SampleService;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Resource
	private SampleService sampleService;
	
	@RequestMapping("/userInfo")
	public String test(Model model) {
		
		logger.debug("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		List<Map<String, String>> memberList = new ArrayList<Map<String, String>>();
		memberList = sampleService.selectMemberList();
		model.addAttribute("memberList", memberList);
		
		return "/testdb/test";
	}
	
	@RequestMapping(value="/sample/testMapArgumentResolver")
	public ModelAndView testMapArgumentResolver(@RequestParam Map<String, String> paramMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(paramMap.isEmpty() == false){
	        Iterator<Entry<String, String>> iterator = paramMap.entrySet().iterator();
	        Entry<String, String> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            logger.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	
	@RequestMapping("/sample/openBoardList")
	public ModelAndView openBoardList(@RequestParam Map<String, String> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		List<Map<String, String>> list = sampleService.selectBoardList(paramMap);
		mv.addObject("list", list);
		mv.setViewName("/sample/boardList");
		
		return mv;
	}
	
	@RequestMapping("/sample/openBoardWrite")
	public ModelAndView openBoardWrite() {
		ModelAndView mv = new ModelAndView("/sample/boardWrite");
		return mv;
	}
	
	@RequestMapping("/sample/testInsertBoard")
	public ModelAndView testInsertBoard(@RequestParam Map<String, String> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		logger.debug("@@@@@@@@@@@@@@@@@ TestMap @@@@@@@@@@@@@@@@@@@@@@@" + paramMap);
		
//		sampleService.insertBoard(paramMap);
		mv.setViewName("redirect:/sample/openBoardList");
		return mv;
	}
	
	@RequestMapping("/sample/insertBoard")
	public ModelAndView insertBoard(@RequestParam Map<String, String> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		logger.debug("@@@@@@@@@@@@@@@@@ Map" + paramMap);
		
		sampleService.insertBoard(paramMap);
		mv.setViewName("redirect:/sample/openBoardList");
		return mv;
	}
	
	@RequestMapping("/sample/openBoardDetail")
	public ModelAndView openBoardDetail(@RequestParam Map<String, String> paramMap) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Map<String, String> map = sampleService.selectBoardDetail(paramMap);
		mv.addObject("map", map);
		mv.setViewName("/sample/boardDetail");
		return mv;
	}
	
	@RequestMapping("/sample/openBoardUpdate")
	public ModelAndView openBoardUpdate(@RequestParam Map<String, String> paramMap) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Map<String, String> map = sampleService.selectBoardDetail(paramMap);
		mv.addObject("map", map);
		mv.setViewName("/sample/boardUpdate");
		return mv;
	}
	
	@RequestMapping("/sample/updateBoard")
	public ModelAndView updateBaord(@RequestParam Map<String, String> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		sampleService.updateBoard(paramMap);
		mv.addObject("IDX", paramMap.get("IDX"));
		mv.setViewName("redirect:/sample/openBoardDetail");
		return mv;
	}
	
	@RequestMapping("/sample/deleteBoard")
	public ModelAndView deleteBoard(@RequestParam Map<String, String> paramMap) {
		ModelAndView mv = new ModelAndView();
		
		sampleService.deleteBoard(paramMap);
		mv.setViewName("redirect:/sample/openBoardList");
		return mv;
	}
	
}
