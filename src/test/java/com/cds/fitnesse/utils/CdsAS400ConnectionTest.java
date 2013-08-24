package com.cds.fitnesse.utils;

import com.cds.fitnesse.fixture.CmdCallFixtureTest;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CdsAS400ConnectionTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CdsAS400ConnectionTest( String testName )
    {
        super( testName );
    }
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CdsAS400ConnectionTest.class );
    }    
    public void testCdsAS400ConnectionOk()
    {
    	CdsAS400Connection con = new CdsAS400Connection("C:/users/mpatrick/db.properties");
    	assertNotNull(con);
    	assertEquals("username", "MPATRICK", con.getUser());
    }
    public void testCdsAS400ConnectionFileNotFound()
    {
    	CdsAS400Connection con = new CdsAS400Connection("db9.properties");
    	// There should be something better than the '==' operator here
    	assert(con == null);
    }    
    public void testUser()
    {
    	CdsAS400Connection con = new CdsAS400Connection("c:/users/mpatrick/db.properties");
    	assertEquals("username", "MPATRICK", con.getUser());
    	assertEquals("username", "HOUDINI", con.setUser("HOUDINI"));
    	assertEquals("username", "HOUDINI", con.getUser());
    	String emptyString = "";
    	assertEquals("username", "HOUDINI", con.setUser(emptyString));
    	assertEquals("username", "HOUDINI", con.getUser());
    }    
    public void testPassword()
    {
    	CdsAS400Connection con = new CdsAS400Connection("c:/users/mpatrick/db.properties");
    	assertEquals("password", "MYPASS", con.getPassword());
    	assertEquals("password", "DUMMYPASS", con.setPassword("DUMMYPASS"));
    	assertEquals("DUMMYPASS", "DUMMYPASS", con.getPassword());
    	String emptyString = "";
    	assertEquals("password", "DUMMYPASS", con.setPassword(emptyString));
    	assertEquals("password", "DUMMYPASS", con.getPassword());
    }        
    public void testDataSource()
    {
    	String url = "jdbc:as400://serv.cdsfulfillment.com;naming=sql;";
    	CdsAS400Connection con = new CdsAS400Connection("c:/users/mpatrick/db.properties");
    	assertEquals("url", url, con.getDataSource());
    	assertEquals("url", "http://google.com", con.setDataSource("http://google.com"));
    	assertEquals("password", "http://google.com", con.getDataSource());
    	String emptyString = "";
    	assertEquals("url", "http://google.com", con.setDataSource(emptyString));
    	assertEquals("url", "http://google.com", con.getDataSource());
    }     
}