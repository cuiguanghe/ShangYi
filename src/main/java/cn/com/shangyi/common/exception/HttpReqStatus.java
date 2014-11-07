package cn.com.shangyi.common.exception;

/**
 * 请求状态码
 * 
 * @version 1.0
 * @author Darren
 * 
 */
public class HttpReqStatus {
	/**
	 * 异常code，均为四位代码，表示各种异常
	 */
	public final static String DataAccess_Exception = "1001";// 数据库操作失败！
	public final static String Nullpointer_Exception = "1002";// 空指针，调用了未经初始化或者是不存在的对象！
	public final static String IOE_Excerption = "1003";// IO读写异常！
	public final static String ClassNotFound_Exception = "1004";// 指定的类不存在！
	public final static String Arithmetic_Exception = "1005";// 数学运算异常！
	public final static String ArrayIndexOutOfBounds_Exception = "1006";// 数组下标越界！
	public final static String IllegalArgument_Exception = "1007";// 调用方法的参数错误！
	public final static String ClassCast_Exception = "1008";// 类型强制转换错误！
	public final static String Security_Exception = "1009";// 违背安全原则异常！
	public final static String SQL_Exception = "1010";// 操作数据库异常！
	public final static String NoSuchMethod_Error = "1011";// 调用了未定义的方法！
	public final static String Internal_Error = "1012";// Java虚拟机发生了内部错误！
	public final static String Exception = "1013";// 程序内部错误，操作失败！
	/**
	 * 请求成功是返回的代码
	 */
	public final static String Success = "200";
}
