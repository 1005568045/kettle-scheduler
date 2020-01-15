package com.wh.kettlescheduler.vo.response;

import com.wh.kettlescheduler.enums.RunResultEnum;
import com.wh.kettlescheduler.vo.basic.BasicVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 转换执行记录表
 *
 * @author lyf
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "转换执行记录表-出参")
public class TransRecordRes extends BasicVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 转换ID
     */
    @ApiModelProperty(value = "转换ID")
    private Integer recordTransId;

    /**
     * 转换名称
     */
    @ApiModelProperty(value = "转换名称")
    private String transName;

    /**
     * 启动时间
     */
    @ApiModelProperty(value = "启动时间")
    private Date startTime;

    /**
     * 停止时间
     */
    @ApiModelProperty(value = "停止时间")
    private Date stopTime;

    /**
     * 任务执行结果（1：成功；0：失败）
     */
    @ApiModelProperty(value = "任务执行结果（1：成功；0：失败）")
    private Integer recordStatus;

	@ApiModelProperty(value = "任务执行结果显示值")
	public String getRecordStatusStr() {
		return RunResultEnum.getEnumDesc(recordStatus);
	}

	/**
     * 转换日志记录文件保存位置
     */
    @ApiModelProperty(value = "转换日志记录文件保存位置")
    private String logFilePath;


}