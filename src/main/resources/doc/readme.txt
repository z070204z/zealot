1.������Struts2��
	1)Ϊ����ʹ��ServletActionContext.getResponse��  ServletActionContext.getRequest����ͷ���
 	2)��Ϊ����Struts2Ϊ�˷���ѧϰ..
 	

2.SpringҲ��������ʹ��....
	1)HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	2)ServletWebRequest servletContainer = (ServletWebRequest)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletContainer.getRequest();
    	HttpServletResponse response = servletContainer.getResponse();
    3)@RequestMapping(value="/getReceiptAddressList.do")
	  public void getReceiptAddressList(HttpServletRequest request, HttpServletResponse response) throws Exception {};