package com.lz.commn.uitl;

import java.sql.Types;
/**
 * sql条件拼接  bate1.0
 * @author lsg
 *
 */
public class Condition{
	
	private StringBuilder sql;
	public static final int AND = 1;
	public static final int OR = 2;
	
	public Condition(String sql) {
		this.sql = new StringBuilder(sql);
		if(this.sql.indexOf("where")==-1) {
			this.sql.append(" where 1=1");
		}
	}
	
	/**
	 * 拼接大于条件
	 * @param logical ConditionUtil常亮
	 * @param field 要拼接的字段名称
	 * @param value	要拼接的值
	 * @param type	字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendBiger(int logical,String field,String value,int type) {
		if(value==null||value.equals("")) {
			return;
		}
		if(type == Types.VARCHAR||type==Types.DATE||type==Types.CHAR) {
			sql.append(" and "+field+">"+"'"+value+"'");
		}else {
			sql.append(" and "+field+">"+value);
		}
	}
	/**
	 * 拼接小于条件
	 * @param logical ConditionUtil常亮
	 * @param field 要拼接的字段名称
	 * @param value	要拼接的值
	 * @param type	字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendSmaller(int logical,String field,String value,int type) {
		if(value==null||value.equals("")) {
			return;
		}
		if(type == Types.VARCHAR||type==Types.DATE||type==Types.CHAR) {
			sql.append(" and "+field+"<"+"'"+value+"'");
		}else {
			sql.append(" and "+field+"<"+value);
		}
	}
	/**
	 * 拼接大于等于条件
	 * @param logical ConditionUtil常亮
	 * @param field 要拼接的字段名称
	 * @param value	要拼接的值
	 * @param type	字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendNoSmailler(int logical,String field,String value,int type) {
		if(value==null||value.equals("")) {
			return;
		}
		if(type == Types.VARCHAR||type==Types.DATE||type==Types.CHAR) {
			sql.append(" and "+field+">="+"'"+value+"'");
		}else {
			sql.append(" and "+field+">="+value);
		}
	}
	
	/**
	 * 拼接分页条件
	 * @param pageNum
	 * @param pageSize
	 */
	public void appendLimit(int pageNum,int pageSize) {
		sql.append(" limit "+(pageNum-1)*pageSize+","+pageSize);
	}
	
	/**
	 * 拼接小于等于条件
	 * @param logical ConditionUtil常亮
	 * @param field 要拼接的字段名称
	 * @param value	要拼接的值
	 * @param type	字段的数据类型，使用java.sql.Types的常量值表示
	 */
	public void appendNoBigger(int logical,String field,String value,int type) {
		if(value==null||value.equals("")) {
			return;
		}
		if(type == Types.VARCHAR||type==Types.DATE||type==Types.CHAR) {
			sql.append(" and "+field+"<="+"'"+value+"'");
		}else {
			sql.append(" and "+field+"<="+value);
		}
	}
	/**
	 * 拼接模糊查询条件
	 * @param logical
	 * @param field
	 * @param value
	 */
	public void appendLike(int logical,String field,String value) {
		if(logical==Condition.AND&&value!=null&&!value.equals("")) {
			sql.append(" and "+field+" like '%"+value+"%'");
		}else if(logical==Condition.OR) {
			sql.append(" or "+field+" like '%"+value+"%'");
		}
	}
	/**
	 * 拼接相等条件
	 * @param logical
	 * @param field
	 * @param value
	 * @param type
	 */
	public void appendEquals(int logical,String field,String value,int type) {
		if(value==null||value.equals("")) {
			return;
		}
		if(type == Types.VARCHAR||type==Types.DATE||type==Types.CHAR) {
			sql.append(" and "+field+"="+"'"+value+"'");
		}else {
			sql.append(" and "+field+"="+value);
		}
	}
	
	public String toString() {
		return sql.toString();
	}

}


