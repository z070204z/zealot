1.整合了Struts2是
	1)为方便使用ServletActionContext.getResponse和  ServletActionContext.getRequest对象和方法
 	2)是为保留Struts2为了方便学习..
 	

2.Spring也可以这样使用....
	1)HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	2)ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletContainer.getRequest();
    	HttpServletResponse response = servletContainer.getResponse();
    3)@RequestMapping(value="/getReceiptAddressList.do")
	  public void getReceiptAddressList(HttpServletRequest request, HttpServletResponse response) throws Exception {};