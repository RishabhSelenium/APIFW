package org.testing.runner;

import java.io.IOException;

import org.testing.TestScripts.TC01_GetData;
import org.testing.TestScripts.TC1_PostRequest;
import org.testing.TestScripts.TC2_GetRequest;
import org.testing.TestScripts.TC3_GetAllRecords;
import org.testing.TestScripts.TC4_PutRequest;
import org.testing.TestScripts.TC5_DeleteRequest;
import org.testing.TestScripts.TC6_GetEmployeeRequest;
import org.testing.TestScripts.TC7_PostRequest_empData;
import org.testing.TestScripts.TC8_GetAll_empData;

public class Runner {
public static void main(String[] args) throws IOException {
//	TC1_PostRequest tc1 = new TC1_PostRequest();
//	tc1.testcase1();
//	TC2_GetRequest tc2 = new TC2_GetRequest();
//	tc2.testcase2();
//	TC3_GetAllRecords tc3 = new TC3_GetAllRecords();
//	tc3.testcase3();
//	TC4_PutRequest tc4 = new TC4_PutRequest();
//	tc4.testcase4();
//	TC5_DeleteRequest tc5 = new TC5_DeleteRequest();
//	tc5.testCase5();
//	TC6_GetEmployeeRequest tc6 = new TC6_GetEmployeeRequest();
//	tc6.testCase6();
//	TC7_PostRequest_empData tc7= new TC7_PostRequest_empData();
//    tc7.testCase7();
//    TC8_GetAll_empData tc8 = new TC8_GetAll_empData();
//    tc8.testcase8();
	
	TC01_GetData gt = new TC01_GetData();
	gt.testCase();
	
	
}
}
