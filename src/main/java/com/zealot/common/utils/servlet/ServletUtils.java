package com.zealot.common.utils.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.zealot.common.utils.string.StringUtils;

/**
 * @Author:liangjilong
 * @Date:2013-12-24
 * @Email:jilongliang@sina.com
 * @Version:1.0
 * @Descript:
 */
public class ServletUtils {
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request)
	{
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	/**
	 * @param:HttpServletRequest(servlet)
	 * @param:ServletActionContext(Struts2)
	 */
	public static HttpServletRequest getRequest()
	{
		return ServletActionContext.getRequest();
	}

	/**
	 * 
	 * @param:HttpServletResponse(servlet)
	 * @param:ServletActionContext(Struts2)
	 * @return
	 */
	public static HttpServletResponse getResponse()
	{
		return ServletActionContext.getResponse();
	}

	/**
	 * ��ûỰ�������ֵ
	 */
	public static Object getSessionValue(HttpServletRequest request, String key)
	{
		// ����ֵ
		Object sessionValue = null;
		// ��֤����
		if (StringUtils.isEmpty(key))
		{
			HttpSession httpSession = request.getSession();
			sessionValue = httpSession.getAttribute(key);
		}
		// ���ؽ��
		return sessionValue;
	}

	/**
	 * �����������еı���ֵ
	 */
	public static String getRequestValue(HttpServletRequest request, String key)
	{
		// ����ֵ
		String requestValue = null;
		// ��֤����
		if (StringUtils.isEmpty(key))
		{
			requestValue = request.getParameter(key);
		}
		// ���ؽ��
		return requestValue;
	}

	/**
	 * �����������еı���ֵ
	 */
	public static String getRequestAttriValue(String key)
	{
		// ����ֵ
		String requestValue = "";
		// ��֤����
		if (!StringUtils.isEmpty(key))
		{
			requestValue = (String) getRequest().getAttribute(key);
			return requestValue;
		} else
		{
			return "";
		}
		// ���ؽ��
	}

	/**
	 * �����������еı���ֵ
	 */
	public static String getRequestValue(String key)
	{
		// ����ֵ
		String requestValue = "";
		// ��֤����
		if (!StringUtils.isEmpty(key))
		{
			requestValue = getRequest().getParameter(key);
			return requestValue;
		} else
		{
			return "";
		}
		// ���ؽ��
	}

	/**
	 * 
	 * @return
	 */
	public static void setWriter(String value)
	{
		HttpServletResponse response = getResponse();
		PrintWriter out = null;
		try
		{
			out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.write(value);
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (out != null)
				out.close();
		}
	}

	/**
	 * �����������еı���ֵ
	 */
	public static String[] getRequestValues(HttpServletRequest request, String key)
	{
		// ����ֵ
		String[] requestValues = null;
		// ��֤����
		if (StringUtils.isEmpty(key))
		{
			requestValues = request.getParameterValues(key);
		}
		// ���ؽ��
		return requestValues;
	}

	/**
	 * �������������������
	 */
	public static void setRequestValue(String key, Object value)
	{
		HttpServletRequest req = getRequest();
		req.setAttribute(key, value);
	}

	/**
	 * �������������������
	 */
	public static void setRequestValue(HttpServletRequest request, String key, Object value)
	{
		request.setAttribute(key, value);
	}

	/**
	 * �������л�ø�����������:..com
	 */
	public static String getRootDoamin(HttpServletRequest request)
	{
		// ���ر���
		String doamin = "";
		// ������ʱ����
		String serverName = "";
		int serverNameLength = 0;
		// �������
		serverName = request.getServerName();
		serverName = (serverName != null) ? serverName : "";
		serverNameLength = serverName.length();
		if (serverNameLength > 0)
		{
			int pos;
			pos = serverName.indexOf(".");
			if (pos > 0)
			{
				doamin = serverName.substring(pos, serverNameLength);
			}
		}
		// ����
		return doamin;
	}

	/**
	 * ����������ֵ
	 * 
	 * @param key
	 * @param value
	 */
	public static void setContextValue(String key, String value)
	{
		ActionContext.getContext().put(key, value);

	}

	/**
	 * @return ��ȡ��ȡ���·��
	 */
	public static String getRealPath(String realPath)
	{
		return ServletActionContext.getServletContext().getRealPath(realPath);
	}

	/**
	 * �������л�ö˿ڣ�����:80
	 */
	public static int getPort(HttpServletRequest request)
	{
		// ���ر���
		int serverPort;
		// �˿�
		serverPort = request.getServerPort();
		// ����
		return serverPort;
	}

	/**
	 * �������л������ǰ׺������:..com:80
	 */
	public static String getUrlPrefix(HttpServletRequest request)
	{
		// ���ر���
		String urlPrefix = "";
		// ������ʱ����
		String serverName = "";
		int serverPort = 0;
		String joinSybol = ":";
		// ����ǰ׺
		serverName = getRootDoamin(request);
		serverPort = getPort(request);
		urlPrefix = serverName + joinSybol + serverPort;
		// ����
		return urlPrefix;
	}

	/**
	 * �������л������������·��,���磺/
	 */
	public static String getContextPath(HttpServletRequest requqest)
	{
		// �������
		String contentPath = "";
		contentPath = requqest.getContextPath();
		// ����
		return contentPath;
	}

	/**
	 * �������л������������·��,���磺/
	 */
	public static String getContextPath()
	{
		// �������
		String contentPath = "";
		HttpServletRequest requqest = getRequest();
		contentPath = requqest.getContextPath();
		// ����
		return contentPath;
	}

	/**
	 * �������л������������·��,���磺/
	 */
	public static String getPath(HttpServletRequest requqest)
	{
		// �������
		String url = "";
		// ������ʱ����
		String urlPrefix = "";
		String contextPath = "";
		urlPrefix = getUrlPrefix(requqest);
		contextPath = requqest.getContextPath();
		// ����
		url = urlPrefix + contextPath;
		return url;
	}

	/**
	 * ��ȡ�ͻ���ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}