package com.wh.kettlescheduler.vo.request;

import com.wh.kettlescheduler.vo.basic.BasicVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 数据库连接类型表
 *
 * @author lyf
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "数据库连接类型表-入参")
public class DatabaseTypeReq extends BasicVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编码
     */
    @ApiModelProperty(value = "编码")
    private String code;

    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;


}