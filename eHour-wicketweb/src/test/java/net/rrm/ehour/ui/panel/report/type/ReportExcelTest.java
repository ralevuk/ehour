/**
 * Created on Dec 30, 2007
 * Author: Thies
 *
 * Copyright (C) 2007 TE-CON, All Rights Reserved.
 *
 * This Software is copyright TE-CON 2007. This Software is not open source by definition. The source of the Software is available for educational purposes.
 * TE-CON holds all the ownership rights on the Software.
 * TE-CON freely grants the right to use the Software. Any reproduction or modification of this Software, whether for commercial use or open source,
 * is subject to obtaining the prior express authorization of TE-CON.
 * 
 * thies@te-con.nl
 * TE-CON
 * Legmeerstraat 4-2h, 1058ND, AMSTERDAM, The Netherlands
 *
 */

package net.rrm.ehour.ui.panel.report.type;


import net.rrm.ehour.report.reports.ReportData;
import net.rrm.ehour.ui.common.BaseUIWicketTester;
import net.rrm.ehour.ui.report.aggregate.AggregateReport;
import net.rrm.ehour.ui.report.aggregate.AggregateTestUtil;
import net.rrm.ehour.ui.report.aggregate.CustomerAggregateReport;
import net.rrm.ehour.ui.report.aggregate.ProjectAggregateReport;
import net.rrm.ehour.ui.report.aggregate.UserAggregateReport;
import net.rrm.ehour.ui.session.EhourWebSession;
import net.rrm.ehour.ui.session.ReportCache;

import org.junit.Before;
import org.junit.Test;

/**
 * Excel tester
 **/

public class ReportExcelTest extends BaseUIWicketTester
{
	private ReportCache cache;
	private ReportData reportData;
	
	@Before
	public void setUp() throws Exception
	{
		super.setUp();
		
		EhourWebSession session = this.webapp.getSession();
		cache = session.getReportCache();
		reportData = AggregateTestUtil.getReportData();
	}

	@Test
	public void testCustomerReportExcel() throws Exception
	{
		AggregateReport report = new CustomerAggregateReport(reportData);
		String reportCacheId = cache.addReportToCache(report, reportData);

		new CustomerReportExcel().getExcelData(reportCacheId);
	}
	
	@Test
	public void testEmployeeReportExcel() throws Exception
	{
		AggregateReport report = new UserAggregateReport(reportData);
		String reportCacheId = cache.addReportToCache(report, reportData);

		new EmployeeReportExcel().getExcelData(reportCacheId);
	}
	
	@Test
	public void testProjectReportExcel() throws Exception
	{
		AggregateReport report = new ProjectAggregateReport(reportData);
		String reportCacheId = cache.addReportToCache(report, reportData);

		new ProjectReportExcel().getExcelData(reportCacheId);
	}	
}