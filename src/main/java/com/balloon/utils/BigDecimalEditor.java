package com.balloon.utils;

/**
 * Project Name:jrx
 * File Name:BigDecimalEditor.java
 * Package Name:cn.bluemobi.jrx.core.util
 * Date:2015Âπ?8Êú?19Êó•‰∏ãÂç?1:18:50
 * Copyright (c) 2015, bluemobi.cn All Rights Reserved.
 *
*/


import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author Administrator
 *
 */
public class BigDecimalEditor extends PropertyEditorSupport {

    public void setAsText(String text) throws IllegalArgumentException {
        if (StringUtils.isEmpty(text)) {
            setValue(null);
        } else {
            setValue(new BigDecimal(text));
        }
    }
}
