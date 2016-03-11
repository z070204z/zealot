package com.zealot.controller;

import com.zealot.common.JsonUtil;
import com.zealot.common.LigerUIBo;
import com.zealot.common.Page;
import com.zealot.entity.InterceptNumber;
import com.zealot.entity.InterceptRecord;
import com.zealot.service.InterceptNumberService;
import com.zealot.service.InterceptRecordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *@Author:liangjilong
 *@Date:2014-2-25
 *@Version:1.0
 *@Description:
 */
@Controller
public class InterceptController{

	@Resource
	private InterceptNumberService interceptNumberService;
	
	@Resource
	private InterceptRecordService interceptRecordService;
	
	/**
	 * 添加拦截记录
	 * @param record
	 * @throws Exception
	 */
	@RequestMapping(value="/addInterceptRecord.do")
	@ResponseBody
	public void addInterceptRecord(InterceptRecord record) throws Exception {
		interceptRecordService.saveInterceptRecord(record);
	}
	
	/**
	 * 分页查询拦截记录
	 * @param param
	 * @param p
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findInterceptRecordPage.do")
	@ResponseBody
	public LigerUIBo findInterceptRecordPage(InterceptRecord param,Page p) throws Exception {
		LigerUIBo bo = new LigerUIBo();
		List<InterceptRecord> list = interceptRecordService.queryInterceptRecordPage(param, p);
		bo.setRows(list);
		bo.setTotal(p.getTotalRecord().toString());
		return bo;
	}
	
	/**
	 * 删除拦截记录
	 * @param json
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteInterceptRecord.do")
	@ResponseBody
	public void deleteInterceptRecord(String json) throws Exception {
		@SuppressWarnings("unchecked")
		List<InterceptRecord> list = JsonUtil.getDTOList(json, InterceptRecord.class);
		interceptRecordService.deleteInterceptRecord(list);
	}
	
	/**
	 * 查询所有拦截号码
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findInterceptNumber.do")
	@ResponseBody
	public List<InterceptNumber> findInterceptNumber() throws Exception {
		return interceptNumberService.queryInterceptNumber(new InterceptNumber());
	}
	
	/**
	 * 分页查询拦截号码
	 * @param param
	 * @param p
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/findInterceptNumberPage.do")
	@ResponseBody
	public LigerUIBo findInterceptNumberPage(InterceptNumber param,Page p,HttpServletRequest req) throws Exception {
		LigerUIBo bo = new LigerUIBo();
		List<InterceptNumber> list = interceptNumberService.queryInterceptNumberPage(param, p);
		bo.setRows(list);
		bo.setTotal(p.getTotalRecord().toString());
		return bo;
	}
	
	/**
	 * 添加拦截号码
	 * @param interceptNumber
	 * @throws Exception
	 */
	@RequestMapping(value="/addInterceptNumber.do")
	@ResponseBody
	public void addInterceptNumber(InterceptNumber interceptNumber) throws Exception {
		interceptNumberService.saveInterceptNumber(interceptNumber);
	}
	
	/**
	 * 修改拦截号码
	 * @param interceptNumber
	 * @throws Exception
	 */
	@RequestMapping(value="/updateInterceptNumber.do")
	@ResponseBody
	public void updateInterceptNumber(InterceptNumber interceptNumber) throws Exception {
		interceptNumberService.updateInterceptNumber(interceptNumber);
	}
	
	/**
	 * 删除拦截号码
	 * @param json
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteInterceptNumber.do")
	@ResponseBody
	public void deleteInterceptNumber(String json) throws Exception {
		@SuppressWarnings("unchecked")
		List<InterceptNumber> list = JsonUtil.getDTOList(json, InterceptNumber.class);
		interceptNumberService.deleteInterceptNumber(list);
	}
	
	/*@RequestMapping(value="/userList2.do")
	public ModelAndView geUserList2(HttpServletRequest request ,HttpServletResponse response) throws Exception {
		return new ModelAndView("/user/userList");
	}*/

}
