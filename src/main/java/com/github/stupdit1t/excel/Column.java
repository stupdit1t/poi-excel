package com.github.stupdit1t.excel;

/**
 * 列定义
 *
 * @author: 李涛
 * @version: 2019年08月31日 19:52
 */

import com.github.stupdit1t.excel.common.POIConstant;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

/**
 * 列的定义
 *
 * @author 625
 */
public class Column {

    /**
     * 字段名称
     */
    private String field;

    /**
     * 宽度，不设置默认自动
     */
    private int width;

    /**
     * 高度，设置是行的高度
     */
    private int height;

    /**
     * 水平定位，默认居中
     */
    private HorizontalAlignment align;

    /**
     * 垂直定位，默认居下
     */
    private VerticalAlignment valign;

    /**
     * 字体颜色，默认黑色
     */
    private IndexedColors color;

    /**
     * 背景色，默认无
     */
    private IndexedColors backColor;

    /**
     * 下拉列表数据
     */
    private String[] dorpDown;

    /**
     * 日期校验,请填写例如2018-08-09~2019-08-09
     */
    private String verifyDate;

    /**
     * 整数数字校验,请填写例如10~30
     */
    private String verifyIntNum;

    /**
     * 浮点数字校验,请填写例如10.0~30.0
     */
    private String verifyFloatNum;

    /**
     * 文本长度校验
     */
    private String verifyText;

    /**
     * 自定义表达式校验
     */
    private String verifyCustom;

    /**
     * 批注默认为空
     */
    private String comment;

    /**
     * 定义规则个数
     */
    private int verifyCount;

    /**
     * 是否为回调样式模式
     */
    private int style;

    /**
     * 判断用户是否重置样式
     */
    private int set;

    private Column(String field) {
        this.field = field;
    }

    private Column() {

    }

    /**
     * 字段名称
     *
     * @return Column
     */
    public static Column style() {
        Column column = new Column();
        column.style = 1;
        return column;
    }

    /**
     * 字段名称
     *
     * @param field 字段名称
     * @return Column
     */
    public static Column field(String field) {
        return new Column(field);
    }

    String getField() {
        return field;
    }

    int getHeight() {
        return height;
    }

    /**
     * 高度
     *
     * @param height 不设置默认
     * @return Column
     */
    public Column height(int height) {
        if (style == 1) {
            set = 1;
        }
        this.height = POIConstant.width(height);
        return this;
    }

    HorizontalAlignment getAlign() {
        return align;
    }

    protected int getWidth() {
        return width;
    }

    /**
     * 宽度
     *
     * @param width 不设置默认自动
     * @return Column
     */
    public Column width(int width) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        this.width = POIConstant.width(width);
        return this;
    }

    /**
     * 水平定位
     *
     * @param align ，CellStyle 取值
     * @return Column
     */
    public Column align(HorizontalAlignment align) {
        if (style == 1) {
            set = 1;
        }
        this.align = align;
        return this;
    }

    protected IndexedColors getColor() {
        return color;
    }

    /**
     * 设置字体颜色
     *
     * @param color HSSFColor,XSSFColor
     * @return Column
     */
    public Column color(IndexedColors color) {
        if (style == 1) {
            set = 1;
        }
        this.color = color;
        return this;
    }

    protected IndexedColors getBackColor() {
        return backColor;
    }

    /**
     * 设置背景色
     *
     * @param backColor
     * @return Column
     */
    public Column backColor(IndexedColors backColor) {
        if (style == 1) {
            set = 1;
        }
        this.backColor = backColor;
        return this;
    }

    /**
     *  批注添加
     *
     * @param comment 批注添加
     * @return Column
     */
    public Column comment(String comment) {
        if (style == 1) {
            set = 1;
        }
        this.comment = comment;
        return this;
    }

    public String getComment() {
        return comment;
    }

    VerticalAlignment getValign() {
        return valign;
    }

    /**
     * 设置垂直定位
     *
     * @param valign 默认居下
     * @return Column
     */
    public Column valign(VerticalAlignment valign) {
        if (style == 1) {
            set = 1;
        }
        this.valign = valign;
        return this;
    }

    protected  String[] getDorpDown() {
        return dorpDown;
    }

    /**
     * 下拉列表数据
     *
     * @param dorpDown 下拉列表数据
     * @return Column
     */
    public Column dorpDown(String[] dorpDown) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        this.dorpDown = dorpDown;
        return this;
    }

    protected String getVerifyDate() {
        return verifyDate;
    }

    /**
     * 日期数据校验
     *
     * @param verifyDate 表达式，请填写例如2018-08-09~2019-08-09 格式也可以 yyyy-MM-dd HH:mm:ss
     * @param msgInfo    提示消息
     * @return Column
     */
    public Column verifyDate(String verifyDate, String... msgInfo) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        if (msgInfo.length > 0) {
            this.verifyDate = verifyDate + "@" + msgInfo[0];
        } else {
            this.verifyDate = verifyDate;
        }

        return this;
    }

    protected String getVerifyIntNum() {
        return verifyIntNum;
    }

    /**
     * 整数数字数据校验
     *
     * @param verifyIntNum 表达式,请填写例如10~30
     * @param msgInfo      提示消息
     * @return Column
     */
    public Column verifyIntNum(String verifyIntNum, String... msgInfo) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        if (msgInfo.length > 0) {
            this.verifyIntNum = verifyIntNum + "@" + msgInfo[0];
        } else {
            this.verifyIntNum = verifyIntNum;
        }
        return this;
    }

    /**
     * 浮点数字数据校验
     *
     * @param verifyFloatNum 表达式,请填写例如10.0~30.0
     * @param msgInfo        提示消息
     * @return Column
     */
    public Column verifyFloatNum(String verifyFloatNum, String... msgInfo) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        if (msgInfo.length > 0) {
            this.verifyFloatNum = verifyFloatNum + "@" + msgInfo[0];
        } else {
            this.verifyFloatNum = verifyFloatNum;
        }
        return this;
    }

    protected String getVerifyText() {
        return verifyText;
    }

    protected  String getVerifyCustom() {
        return verifyCustom;
    }

    /**
     * 自定义表达式校验
     *
     * @param verifyCustom 表达式 ， 注意！！！xls格式和xlsx格式的表达式不太一样，xls从当前位置A1开始算起，xlsx从当前位置开始算起,已经修正过了
     * @param msgInfo      提示消息
     * @return Column
     */
    public Column verifyCustom(String verifyCustom, String... msgInfo) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        if (msgInfo.length > 0) {
            this.verifyCustom = verifyCustom + "@" + msgInfo[0];
        } else {
            this.verifyCustom = verifyCustom;
        }
        return this;
    }

    String getVerifyFloatNum() {
        return verifyFloatNum;
    }

    /**
     * 文本长度校验
     *
     * @param verifyText 比如输入1~2
     * @param msgInfo    提示消息
     * @return Column
     */
    public Column verifyText(String verifyText, String... msgInfo) {
        if (style == 1) {
            throw new UnsupportedOperationException("仅允许定义color/backColor/align/valign ！");
        }
        if (++verifyCount > 1) {
            throw new UnsupportedOperationException("同一列只能定义一个数据校验！");
        }
        if (msgInfo.length > 0) {
            this.verifyText = verifyText + "@" + msgInfo[0];
        } else {
            this.verifyText = verifyText;
        }

        return this;
    }

    public int getSet() {
        return this.set;
    }



}
