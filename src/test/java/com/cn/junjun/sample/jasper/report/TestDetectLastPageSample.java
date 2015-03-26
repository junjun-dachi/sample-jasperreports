package com.cn.junjun.sample.jasper.report;

import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.junjun.sample.jasper.report.model.Members;
import com.cn.junjun.sample.jasper.report.util.BatchJasperUtil;
import com.cn.junjun.sample.jasper.report.util.MarshallerHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/test-ctx.xml" })
public class TestDetectLastPageSample {

    @Autowired
    private BatchJasperUtil util;

    @Autowired
    private MarshallerHelper helper;

    @Value("${sample.report.jasper.data.members.xml}")
    private String xml;

    @Value("${sample.report.jasper.template.detect.last.page}")
    private String template;

    @Test
    public void test() throws Exception {

        Members members = (Members) helper.unmarshal(xml);
        JasperReport report = util.getCompiledFile(template);
        util.generateReportPDF(report, null, new JRBeanCollectionDataSource(members.getMember()), "DetectLastPageSample.pdf");
    }

}
