package com.kylin.learn.jxls;

import com.kylin.learn.domain.Employee;
import lombok.extern.slf4j.Slf4j;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author kylin
 * @classname JxlsMain
 * @date 2023/12/18 22:00
 */
@Slf4j
public class JxlsMain {
    public static void main(String[] args) throws IOException {
        log.info("Running Object Collection demo");
        List<Employee> employees = generateSampleEmployeeData();
        try (InputStream is = new FileInputStream("/Volumes/Document/Workspace/workspace_hk/learn/learn-jxls/src/main/resources/templates/object_collection_template.xlsx");
             FileOutputStream os = new FileOutputStream("target/object_collection_output.xlsx")) {
                Context context = new Context();
                context.putVar("employees", employees);
                JxlsHelper.getInstance().processTemplate(is, os, context);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    // 生成示例员工数据的方法
    private static List<Employee> generateSampleEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = "Employee" + i;
            // 示例：年龄从25开始，每增加一个员工年龄增加1
            int age = 25 + i;
            // 假设所有员工都在同一个部门
            String department = "Department A";
            employees.add(new Employee(name, new Date(), BigDecimal.valueOf(age),BigDecimal.valueOf(age)));
        }
        return employees;
    }
}
