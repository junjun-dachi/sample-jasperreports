package com.cn.junjun.sample.jasper.report.util;

import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.stereotype.Component;


@Component
public class BatchJasperUtil {

    public void generateReportPDF(JasperReport report, Map<String, Object> param, JRBeanCollectionDataSource ds, String destFileName) throws JRException {
        JasperPrint print = JasperFillManager.fillReport(report, param, ds);
        JasperExportManager.exportReportToPdfFile(print, destFileName);
    }

    public JasperReport getCompiledFile(String japerTemplate) throws JRException {
        return (JasperReport) JRLoader.loadObjectFromFile(japerTemplate);
    }

}
