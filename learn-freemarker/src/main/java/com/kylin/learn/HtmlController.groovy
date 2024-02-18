package com.kylin.learn

import freemarker.template.Configuration
import freemarker.template.Template
import freemarker.template.TemplateExceptionHandler
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 * @author kylin
 * @classname HtmlController
 * @date 2023/12/15 13:00
 */

@Controller
class HtmlController {

    @GetMapping("/generate-html")
    String generateHtml(Model model) {
        // 创建 FreeMarker 配置
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31)
        cfg.setClassForTemplateLoading(getClass(), "/templates")
        cfg.setDefaultEncoding("UTF-8")
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)

        // 准备数据模型
        def dataModel = [
                "title": "Dynamic HTML Generation",
                "users": [
                        ["name": "John", "age": 28],
                        ["name": "Jane", "age": 24],
                        ["name": "Bob", "age": 32]
                ]
        ]

        // 加载 FreeMarker 模板
        Template template = cfg.getTemplate("main.ftl")

        // 渲染模板并将结果放入 Model
        StringWriter writer = new StringWriter()
        template.process(dataModel, writer)
        println(writer.toString())
        // 将内容写入 HTML 文件
        writeToFile(writer.toString(), "generated-html-output.html")

        // 返回模板名称
        return "generated-html"
    }

    private void writeToFile(String content, String fileName) {
        try {
            File file = new File(fileName)
            Writer writer = new BufferedWriter(new FileWriter(file))
            writer.write(content)
            writer.close()
            println("HTML content has been written to: " + file.absolutePath)
        } catch (Exception e) {
            e.printStackTrace()
        }
    }
}
