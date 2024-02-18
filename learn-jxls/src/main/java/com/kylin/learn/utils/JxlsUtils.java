package com.kylin.learn.utils;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

/**
 * @author kylin
 * @classname JxlsUtils
 * @date 2023/12/15 17:06
 */
public final class JxlsUtils {

    private JxlsUtils() {

    }

    public static void exportExcel(InputStream templateInputStream, OutputStream outputStream, Map<String, Object> data) throws IOException {
        Context context = new Context(data);
        JxlsHelper.getInstance().processTemplate(templateInputStream, outputStream, context);
    }

}