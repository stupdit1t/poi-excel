/*
 * Copyright (c) 2015-2018 SHENZHEN TOMTOP SCIENCE AND TECHNOLOGY DEVELOP CO., LTD. All rights reserved.
 *
 * 注意：本内容仅限于深圳市通拓科技研发有限公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package excel.imports;

import com.github.stupdit1t.excel.verify.AbstractVerifyBuidler;
import com.github.stupdit1t.excel.verify.CellVerifyEntity;
import com.github.stupdit1t.excel.verify.DateTimeVerify;
import com.github.stupdit1t.excel.verify.DoubleVerify;
import com.github.stupdit1t.excel.verify.ImgVerify;
import com.github.stupdit1t.excel.verify.IntegerVerify;
import com.github.stupdit1t.excel.verify.StringVerify;

import java.util.ArrayList;
import java.util.List;

/**
 * 导入用户校验类
 * 
 * @author 625
 *
 */
public class ProjectVerifyBuilder extends AbstractVerifyBuidler {


	@Override
	protected List<CellVerifyEntity> buildRule() {
		List<CellVerifyEntity> cellEntitys = new ArrayList<>();
		cellEntitys.add(new CellVerifyEntity("projectName", "B", new StringVerify("项目名称", true)));
		cellEntitys.add(new CellVerifyEntity("areaName", "C", new StringVerify("所属区域", true)));
		cellEntitys.add(new CellVerifyEntity("province", "D", new StringVerify("省份", true)));
		cellEntitys.add(new CellVerifyEntity("city", "E", new StringVerify("市", true)));
		cellEntitys.add(new CellVerifyEntity("people", "F", new StringVerify("项目所属人", true)));
		cellEntitys.add(new CellVerifyEntity("leader", "G", new StringVerify("项目领导人", true)));
		cellEntitys.add(new CellVerifyEntity("scount", "H", new IntegerVerify("总分", true)));
		cellEntitys.add(new CellVerifyEntity("avg", "I", new DoubleVerify("历史平均分", true)));
		cellEntitys.add(new CellVerifyEntity("createTime", "J", new DateTimeVerify("创建时间", "yyyy-MM-dd HH:mm", true)));
		cellEntitys.add(new CellVerifyEntity("img", "K", new ImgVerify("图片", false)));
		return cellEntitys;
	}
}
