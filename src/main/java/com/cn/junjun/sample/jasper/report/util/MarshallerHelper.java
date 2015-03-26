package com.cn.junjun.sample.jasper.report.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.stereotype.Component;

@Component
public class MarshallerHelper {

	@Autowired
	private Unmarshaller unmarshaller;

	@Autowired
	private Marshaller marshaller;

	public void marshal(Object obj, String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			marshaller.marshal(obj, new StreamResult(fos));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object unmarshal(String fileName) throws Exception, Exception {
		FileInputStream fis = new FileInputStream(fileName);
		return unmarshaller.unmarshal(new StreamSource(fis));

	}
}