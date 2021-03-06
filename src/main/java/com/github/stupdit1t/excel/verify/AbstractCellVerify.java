package com.github.stupdit1t.excel.verify;

/**
 * 列校验和格式化接口
 * 
 * @author 625
 *
 */
public abstract class AbstractCellVerify {

	/**
	 * 校验单元格值
	 * @param cellValue
	 * @return Object
	 * @throws Exception
	 */
	public abstract Object verify(Object cellValue) throws Exception;
}
