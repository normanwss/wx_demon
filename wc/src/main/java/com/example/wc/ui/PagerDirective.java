package com.example.wc.ui;

import com.github.pagehelper.PageInfo;
import freemarker.core.Environment;
import freemarker.ext.beans.StringModel;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * 分页自定义标签
 */
@Component
public class PagerDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
            throws TemplateException, IOException {
        if (params.isEmpty()) {
            throw new TemplateModelException("缺少参数");
        }

        int pageSize = 15;
        PageInfo pager = null;

        String modelNameStr = "";
        Object modelName = params.get("pageName");
        if (modelName instanceof SimpleScalar) {
            modelNameStr = ((SimpleScalar) modelName).getAsString();
        }
        Object wrapper = env.getVariable(modelNameStr);
        Object object = null;
        if (null != wrapper) {
            if (wrapper instanceof StringModel) {
                object = ((StringModel) wrapper).getWrappedObject();
            } else {
                object = wrapper;
            }
        }
        if (object != null) {
            pager = (PageInfo) object;
        }

        String text = getPagerBar(pager, pageSize).toString();

        Writer out = env.getOut();
        out.write(text);
    }

    private <E> StringBuilder getPagerBar(PageInfo<E> page, int pageSize) {
        StringBuilder stringBuilder = new StringBuilder();
        if (page == null) {
            return stringBuilder;
        }
        stringBuilder.append("<!-- PAGE CONTENT BEGINS -->");
        stringBuilder.append("<input type=\"hidden\" id=\"pageNumber\" name=\"pageNumber\" value=\"" + page.getPageNum() + "\"  />");
        stringBuilder.append("<input type=\"hidden\" id=\"pageSize\" name=\"pageSize\" value=\"" + pageSize + "\" />");
        stringBuilder.append("<div class=\"row clearfix\" style=\"min-height:90px\">");
        if (page.getPages() > 1) {
            stringBuilder.append("   <div class=\"col-xs-3 col-sm-2\">");
            stringBuilder.append("       <div class=\"dataTables_info\" id=\"sample-table-2_info\">");
            stringBuilder.append("              共" + page.getTotal() + "条  &nbsp; 共" + page.getPages() + "页&nbsp;");
            stringBuilder.append("       </div>");
            stringBuilder.append("   </div>");

            stringBuilder.append("   <div class=\"col-xs-9  col-sm-10\">");
            stringBuilder.append("       <div class=\"dataTables_paginate paging_bootstrap\">");
            stringBuilder.append("           <ul class=\"pagination\">");
            if (page.getPageNum() != 1 && page.getPrePage() > 0) {
                stringBuilder.append("               <li class=\"prev " + ((page.getPageNum() == 1) ? "disabled" : "") + "\">");
                stringBuilder.append("                   <a href=\"javascript:gotoPage(1)\">");
                stringBuilder.append("                       <i class=\"fa fa-angle-double-left\"></i>首页");
                stringBuilder.append("                   </a>");
                stringBuilder.append("               </li>");
            }

            if (page.getPageNum() != 1 && page.getPrePage() > 0) {
                stringBuilder.append("<li class=\"prev\"><a href=\"javascript:gotoPage(" + page.getPrePage() + ")\"><i class=\"fa fa-angle-left\"></i>上一页</a></li>");
            }
            for (int i = page.getNavigateFirstPage(); i < page.getNavigateLastPage() + 1; i++) {
                if (i == page.getPageNum()) {
                    stringBuilder.append("<li class=\"active\"><a href=\"javascript:gotoPage(" + i + ")\">" + i + "</a></li>");
                } else {
                    stringBuilder.append("<li><a href=\"javascript:gotoPage(" + i + ")\">" + i + "</a></li>");
                }
            }
            if (page.getNextPage() > 0) {
                stringBuilder.append("<li class=\"next\"><a href=\"javascript:gotoPage(" + page.getNextPage() + ")\">下一页<i class=\"fa fa-angle-right\"></i></a></li>");
            }
            if (page.getPages() > page.getPageNum()) {
                stringBuilder.append("<li class=\"next\"><a href=\"javascript:gotoPage(" + page.getPages() + ")\">末页<i class=\"fa fa-angle-double-right\"></i></a></li>");
            }
            stringBuilder.append("</ul></div></div></div>");
        }

        stringBuilder.append("<!-- PAGE CONTENT END -->");
        stringBuilder.append("<script type=\"text/javascript\">");
        stringBuilder.append("function gotoPage(pageIndex){\n");
        stringBuilder.append("	var pageForm = jQuery('#pageNumber').closest(\"form\");\n");
        stringBuilder.append("	jQuery('#pageNumber').val(pageIndex);\n");
        stringBuilder.append("	pageForm.submit();");
        stringBuilder.append("}");
        stringBuilder.append("</script>	");

        return stringBuilder;
    }
}
