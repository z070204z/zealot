package com.zealot.common.utils.string;

import java.util.regex.Pattern;

public class StringUtils
{
	public static boolean isNotNull(String string)
	{
		boolean flog = false;
		if (string != null && !"".equals(string.trim()))
		{
			flog = true;
		}
		return flog;
	}

	public static String valueOf(Object object)
	{

		return valueOf(object, "");
	}

	public static String valueOf(Object object, String defaultEmptyValue)
	{

		if (object == null)
		{
			return defaultEmptyValue;
		}

		return String.valueOf(object);
	}

	public static boolean isEmptyOrNull(Object object)
	{

		if (valueOf(object).equals(""))
		{
			return true;
		}

		return false;
	}

	public static boolean isNotEmptyOrNull(Object object)
	{
		return !isEmptyOrNull(object);
	}

	public static String BuildSqlIds(String sourceString, String splitString)
	{
		if (isEmptyOrNull(sourceString))
		{
			return "";
		} else
		{
			String[] ids = sourceString.split(splitString);
			String IdsStr = "";
			for (String str : ids)
			{
				IdsStr += "'" + str + "',";
			}
			IdsStr = IdsStr.substring(0, IdsStr.lastIndexOf(","));
			return IdsStr;
		}
	}

	/**
	 * �滻�ַ���
	 * 
	 * @author E.FLY
	 * @date 2012-12-13
	 * @time ����06:01:34
	 * @param sourcce
	 *            Դ�ַ�
	 * @param flags
	 *            �Ƿ����ִ�Сд
	 * @param regex
	 *            ������ʽ
	 * @param replace
	 *            �滻�ɵ��ַ���
	 * @return
	 */
	public static String replaceAll(String sourcce, boolean flags, String regex, String replace)
	{
		Pattern p = flags ? Pattern.compile(regex, Pattern.CASE_INSENSITIVE) : Pattern.compile(regex);
		String replaceAll = p.matcher(sourcce).replaceAll(replace);
		return replaceAll;
	}

	 

	 

	public static String changeNull(Object value)
	{
		if (!isEmptyOrNull(value))
		{
			return value.toString().trim();
		} else
		{
			return "";
		}
	}

	public static boolean notNull(String param)
	{
		if (param != null && !"".equals(param))
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * ���ָ�����ַ����Ƿ�Ϊ�ա�
	 * 
	 * @param value
	 *            �������ַ���
	 * @return true/false
	 */
	public static boolean isEmpty(String value)
	{
		int strLen;
		if (value == null || (strLen = value.length()) == 0)
		{
			return true;
		}
		for (int i = 0; i < strLen; i++)
		{
			if ((Character.isWhitespace(value.charAt(i)) == false))
			{
				return false;
			}
		}
		return true;
	}
	public static String getIds(String id)
	{
		String ids =null;
		if(id==null) ids="";
		else{
			ids = id.replaceAll(",", "','");
			ids="'"+ids+"'";
		}
		return ids;
	}
}
