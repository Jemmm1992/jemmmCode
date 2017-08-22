package com.utils.excelUtil_726;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xu_zj on 2017/8/17.
 */
@Getter
@Setter
public class CategoryConfigVo {
    public CategoryConfigVo() {
        this.data = new ArrayList<>();
    }

    // 小类的名称
    String categoryName;
    // 起始位置
    int beginIndex;
    // 终止位置
    int endIndex;
    // 存放该范围内的数据内容
    List<TravelerBaseInfoVo> data;
}
