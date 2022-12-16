//package mititelu.laura.udemy.mititelu.laura.udemy.reflection1;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//public class StudentUtilTest {
//
//    @Test
//    public void testCalculateGPA(){
//        int[] studentIdList = {1001, 1002, 1003};
//        char[][] studentGrades = {{'A', 'A', 'A', 'B'}, {'B','B','B','A'}};
//
//        double[] gpaList = StudentUtil.calculateGPA(studentIdList, studentGrades);
//
//        System.out.println(Arrays.toString(gpaList));
//        assertTrue("GPA calculation failded",
//                (truncate(gpaList[0])==3.75) && (truncate(gpaList[1])==3.25) && (truncate(gpaList[2])==3.25));
//        System.out.println(truncate(gpaList[0]));
//        System.out.println(truncate(gpaList[1]));
//        System.out.println(truncate(gpaList[2]));
//
//    }
//
//    @Test
//    public void testGetStudentsByGPA(){
//        int[] studentIdList = {1001, 1002, 1003};
//        char[][] studentGrades = {{'A', 'A', 'A', 'B'}, {'B','B','B','A'}};
//        assertTrue("testGetStudentsByGPA failed - number of students returned is incorrect");
//        assertTrue("testGetStudentsByGPA failed - studentID returned is incorrect");
//        assertNotNull("Failure - getStudentByGPA should have returned null when lower >high");
//        assertNotNull("Failure - getStudentByGPA should have returned null when lower >high");
//
//
//    }
//}
