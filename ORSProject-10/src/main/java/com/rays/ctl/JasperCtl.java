package com.rays.ctl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.MarksheetDTO;
import com.rays.form.MarksheetForm;
import com.rays.service.MarksheetServiceInt;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
@RequestMapping(value = "Jasper")
public class JasperCtl extends BaseCtl<MarksheetForm, MarksheetDTO, MarksheetServiceInt> {

	@Value("${jasperCtl}")
	private String jasper;

	@PersistenceContext
	protected EntityManager entityManager;

	@GetMapping(value = "report", produces = { MediaType.APPLICATION_JSON_VALUE })
	public void display(HttpServletRequest request, HttpServletResponse response)
			throws JRException, SQLException, IOException {

		ORSResponse res = new ORSResponse();

//		DB connection store hoga.
		Connection con = null;

		JasperReport jasperReport = JasperCompileManager.compileReport(jasper);

//		 Report me parameters pass karne ke liye.
		Map<String, Object> map = new HashMap<String, Object>();

//		JPA se Hibernate session nikala.
		Session session = (Session) entityManager.unwrap(SessionFactory.class);

//       Hibernate se actual database connection nikala.
		con = ((SessionImpl) session).connection();
		
//		con = ((SessionImpl) entityManager.unwrap(Session.class)).connection();

		/*
		 * Report template load ,DB se data fetch ,Report generate
		 */

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, con);

		byte[] pdf = JasperExportManager.exportReportToPdf(jasperPrint);

		response.setContentType("application/pdf");

		response.getOutputStream().write(pdf);

		response.getOutputStream().flush();

		System.out.println("Thanks....");
	}
}
