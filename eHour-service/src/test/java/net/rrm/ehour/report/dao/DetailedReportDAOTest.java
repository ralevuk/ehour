/**
 * Created on Feb 4, 2007
 * Created by Thies Edeling
 * Copyright (C) 2005, 2006 te-con, All Rights Reserved.
 *
 * This Software is copyright TE-CON 2007. This Software is not open source by definition. The source of the Software is available for educational purposes.
 * TE-CON holds all the ownership rights on the Software.
 * TE-CON freely grants the right to use the Software. Any reproduction or modification of this Software, whether for commercial use or open source,
 * is subject to obtaining the prior express authorization of TE-CON.
 * thies@te-con.nl
 * TE-CON
 * Legmeerstraat 4-2h, 1058ND, AMSTERDAM, The Netherlands
 *
 */

package net.rrm.ehour.report.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.rrm.ehour.dao.BaseDAOTest;
import net.rrm.ehour.data.DateRange;
import net.rrm.ehour.report.reports.element.FlatReportElement;

import org.junit.Test;
/**
 * 
 **/

@SuppressWarnings("unchecked")
public class DetailedReportDAOTest extends BaseDAOTest
{
	private	DetailedReportDAO	dao;
	
	
//	public void testGetHoursPerMonthPerAssignmentForUsers()
//	{
//		List userIds = new ArrayList();
//		userIds.add(1);
//		
//		List projectIds = new ArrayList();
//		projectIds.add(1);
//		
//		DateRange dateRange = new DateRange(new Date(2006 - 1900, 12 - 1, 1), // deprecated? hmm ;) 
//			    new Date(2007 - 1900, 12 -1 , 30));
//
//		List<FlatProjectAssignmentAggregate> results = dao.getHoursPerMonthPerAssignmentForUsers(userIds, 
//				projectIds, 
//																								dateRange);
//		
//
//		
//		assertEquals(1, results.size());
//	}
//
//	public void testGetHoursPerMonthPerAssignmentForUsersIntegerArrayIntegerArrayDateRange()
//	{
//		List userIds = new ArrayList();
//		userIds.add(1);
//		
//		List projectIds = new ArrayList();
//		projectIds.add(2);
//		
//		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
//			    new Date(2006 - 1900, 10, 3));
//
//		
//		List<FlatProjectAssignmentAggregate> results = dao.getHoursPerMonthPerAssignmentForUsers(userIds, projectIds, dateRange);
//		
//		assertEquals(1, results.size());
//	}
//
//	@Test
//	public void testGetHoursPerMonthPerAssignmentForProjects()
//	{
//		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
//			    new Date(2008 - 1900, 1, 3));
//
//		List projectIds = new ArrayList();
//		projectIds.add(1);
//		
//		List<FlatProjectAssignmentAggregate> results = dao.getHoursPerMonthPerAssignmentForProjects(projectIds, dateRange);
//		
//		assertEquals(5, results.size());
//
//	}
//	
//	@Test
//	public void testGetHoursPerMonthPerAssignment()
//	{
//		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
//			    new Date(2008 - 1900, 1, 3));
//
//		List<FlatProjectAssignmentAggregate> results = dao.getHoursPerMonthPerAssignment(dateRange);
//		
//		assertEquals(6, results.size());		
//	}
//	
	@Test
	public void testGetHoursPerDayForAssignment()
	{
		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
			    new Date(2008 - 1900, 1, 3));
		List projectIds = new ArrayList();
		projectIds.add(1);
		List<FlatReportElement> results = dao.getHoursPerDayForAssignment(projectIds, dateRange);
		
		assertEquals(6, results.size());
		
		assertNotNull(results.get(0).getProjectId());
	}	
	
	@Test
	public void testGetHoursPerDayForUsers()
	{
		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
			    new Date(2008 - 1900, 1, 3));
		List userIds = new ArrayList();
		userIds.add(1);
		List<FlatReportElement> results = dao.getHoursPerDayForUsers(userIds, dateRange);
		
		assertEquals(10, results.size());
		
		assertNotNull(results.get(0).getProjectId());
	}	
	
	@Test
	public void testGetHoursPerDayForProjects()
	{
		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
			    new Date(2008 - 1900, 1, 3));
		List projectIds = new ArrayList();
		projectIds.add(2);
		List<FlatReportElement> results = dao.getHoursPerDayForProjects(projectIds, dateRange);
		
		assertEquals(4, results.size());
		
		assertEquals(2, results.get(0).getProjectId().intValue());
	}	
	
	
	@Test
	public void testGetHoursPerDayForProjectsAndUsers()
	{
		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
			    new Date(2008 - 1900, 1, 3));
		List projectIds = new ArrayList();
		projectIds.add(2);
		List userIds = new ArrayList();
		userIds.add(1);		
		
		List<FlatReportElement> results = dao.getHoursPerDayForProjectsAndUsers(projectIds, userIds, dateRange);
		
		assertEquals(2, results.size());
		
		assertEquals(2, results.get(0).getProjectId().intValue());
	}
	
	@Test
	public void testGetHoursPerDay()
	{
		DateRange dateRange = new DateRange(new Date(2006 - 1900, 5 - 1, 1), // deprecated? hmm ;) 
			    new Date(2008 - 1900, 1, 3));
		
		List<FlatReportElement> results = dao.getHoursPerDay(dateRange);
		
		assertEquals(12, results.size());
	}	
	
	/**
	 * @param dao the dao to set
	 */
	public void setDetailedReportDAO(DetailedReportDAO dao)
	{
		this.dao = dao;
	}

}