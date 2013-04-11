package quest_55243;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 25.03.13
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class TestConsole {
    private static Scanner in = new Scanner(System.in);
    private static final String ADD = "add" ;
    private static final String LIST = "list" ;
    private static final String SORT =  "sort";
    private static final String REMOVE =  "remove";
    private static final String SAVE =  "save";

    private static ArrayList<Student> students = new ArrayList<Student>();


    public static void main(String[] args) throws IOException {
        while (true)
        {
            System.out.print("Enter what you want to do- ADD, REMOVE, LIST, SAVE, SORT: ");
            String action = in.nextLine();
            if ( action.equalsIgnoreCase(ADD) )
                add();
            if (action.equalsIgnoreCase(LIST))
                list();
            if (action.equalsIgnoreCase(SORT))
                sort();
            if (action.equalsIgnoreCase(REMOVE))
                remove();
            if (action.equalsIgnoreCase(SAVE))
                save();
        }
    }

    private static void add()
    {
        System.out.print("Enter the Student's first name: ");
        String firstName = in.nextLine();
        System.out.print("Enter the Student's last name: ");
        String lastName = in.nextLine();
        System.out.print("Enter the Student's UID: ");
        String uid = in.nextLine();
        System.out.print("Enter the student status: GRADUATE, UNDECLARED, or UNDERGRADUATE: ");
        StudentType studentType = StudentType.valueOf(in.nextLine().toUpperCase());
        switch (studentType){
            case GRADUATE:
                System.out.print("Enter YES for having a thesis option else NO: ");
                boolean thesisOption = readThesisOption();
                System.out.print("Enter Masters for Master Studies or Phd for Phd studies: ");
                ClassStanding classStanding = readClassStanding();
                System.out.print("Enter the name of the major professor: ");
                String majorProfessor = in.nextLine();
                students.add(new Graduate(firstName,lastName,uid,studentType,classStanding,majorProfessor,thesisOption));
                break;
            case UNDERGRADUATE:
                System.out.print("Enter the student's major: CS, CEG, EE, ISE, BME, ME, MET, or UNKNOWN: ");
                Major studentMajor = readStudentMajor();
                System.out.print("Enter the student's overall GPA: ");
                double overallGPA = Double.parseDouble(in.nextLine());
                System.out.print("Enter the student's major GPA: ");
                double majorGPA = Double.parseDouble(in.nextLine());
                System.out.print("Enter the student class standing: \n" +
                        "Freshman, Sophomore, Junior, Senior, or Unknown: ");
                ClassStanding studentClassStanding = ClassStanding.valueOf(in.nextLine().toUpperCase());
                students.add(new UnderGraduate(firstName,lastName, uid, studentType, studentClassStanding, studentMajor, overallGPA, majorGPA));
                break;
            case UNDECLARED:
                System.out.print("Enter the student class standing: \n" +
                        "Freshman, Sophomore, Junior, Senior, or Unknown: ");
                ClassStanding studentClassStanding1 = ClassStanding.valueOf(in.nextLine().toUpperCase());
                students.add(new Student(firstName, lastName, uid, studentType, studentClassStanding1));
                break;
        }
    }

    public static void list(){
        for (Student student: students)
            System.out.println(student.toString());
    }

    public static void sort(){
        Collections.sort(students,new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (Integer.parseInt(o1.getUid())>Integer.parseInt(o2.getUid()))
                    return 1;
                return -1;
            }
        });
    }

    public static void remove(){
        System.out.print("Enter the UID of the student that is to be removed: ");
        String uidRemove = in.nextLine();
        if (getStudentOfUid(uidRemove)!=null){
            System.out.println("Student with UID " + uidRemove + " has been removed.");
            students.remove(getStudentOfUid(uidRemove));
        }
        else
            System.out.println("Student with UID " + uidRemove + " not found!");
    }

    public static void save() throws IOException {
        System.out.print("Enter the file name: ");
        String fileName = in.nextLine();
        OutputStream outputStream = new FileOutputStream(fileName,true);
        for (Student student: students){
            outputStream.write((student.getFirstName()+"\n").getBytes());
            outputStream.write((student.getLastName()+"\n").getBytes());
            outputStream.write((student.getUid()+"\n").getBytes());
            outputStream.write((student.getStudentType().toString()+"\n").getBytes());
            outputStream.write((student.getClassStanding().toString()+"\n").getBytes());
            switch (student.getStudentType()){
                case GRADUATE:
                {
                    outputStream.write((((Graduate) student).getMajorProfessor()+"\n").getBytes());
                    outputStream.write((((Graduate) student).isThesisOption().toString()+"\n").getBytes());
                    break;
                }
                case UNDERGRADUATE:
                {
                    outputStream.write((((UnderGraduate)student).getMajor().toString()+"\n").getBytes());
                    outputStream.write(((UnderGraduate)student).getOverallGPA().byteValue());
                    outputStream.write("\n".getBytes());
                    outputStream.write(((UnderGraduate) student).getMajorGPA().byteValue());
                    outputStream.write("\n".getBytes());
                    break;
                }
                case UNDECLARED:
                {
                    break;
                }
            }
        }
        outputStream.close();
    }

    private static Student getStudentOfUid(String uid) {
        for (Student student: students){
            if (Integer.parseInt(student.getUid())==Integer.parseInt(uid))
                return student;
        }

        return  null;
    }


    private static Major readStudentMajor() {
        String studentMajor = in.nextLine();
        if (studentMajor.equalsIgnoreCase("cs"))
            return Major.CS;
        else if (studentMajor.equalsIgnoreCase("ceg"))
                return Major.CEG;
        else if (studentMajor.equalsIgnoreCase("ee"))
                return Major.EE;
        else if (studentMajor.equalsIgnoreCase("ise"))
                return Major.ISE;
        else if (studentMajor.equalsIgnoreCase("bme"))
                return Major.BME;
        else if (studentMajor.equalsIgnoreCase("me"))
                return Major.ME;
        else if (studentMajor.equalsIgnoreCase("met"))
                return Major.MET;
        else if (studentMajor.equalsIgnoreCase("unknown"))
                return Major.UNKNOWN;
        System.out.print("Incorrect enter! Enter the student's major: CS, CEG, EE, ISE, BME, ME, MET, or UNKNOWN: ");
        return readStudentMajor();

    }

    private static boolean readThesisOption() {
        String thesisOption = in.nextLine();
        if (thesisOption.equalsIgnoreCase("yes"))
            return true;
        if (thesisOption.equalsIgnoreCase("no"))
            return  false;

        System.out.print("Incorrect enter! Enter YES for having a thesis option else NO: ");
        return readThesisOption();
    }

    private static StudentType readStudentType(){
        System.out.print("Enter the student status: GRADUATE, UNDECLARED, or UNDERGRADUATE: ");
        String studentStatus = in.nextLine();
        if (studentStatus.equalsIgnoreCase(StudentType.GRADUATE.name()))
            return StudentType.GRADUATE;
        else if (studentStatus.equalsIgnoreCase(StudentType.UNDERGRADUATE.name()))
                return StudentType.UNDERGRADUATE;
        else if (studentStatus.equalsIgnoreCase(StudentType.UNDECLARED.name()))
                 return StudentType.UNDECLARED;

        System.out.print("Incorrect student status");
        return readStudentType();
    }

    private static ClassStanding readClassStanding(){
        String classStanding = in.nextLine();
//        if (classStanding.equalsIgnoreCase("freshman"))
//            return ClassStanding.FRESHMAN;
//        else  if (classStanding.equalsIgnoreCase("sophomore"))
//            return ClassStanding.SOPHOMORE;
//        else if (classStanding.equalsIgnoreCase("junior"))
//            return ClassStanding.JUNIOR;
//        else if (classStanding.equalsIgnoreCase("senior"))
//            return ClassStanding.SENIOR;
//        else if (classStanding.equalsIgnoreCase("UNKNOWN"))
//            return ClassStanding.UNKNOWN;
        if (classStanding.equalsIgnoreCase("Masters"))
            return ClassStanding.MASTERS_STUDIES;
        else if (classStanding.equalsIgnoreCase("Phd"))
             return ClassStanding.PHD_STUDIES;

        System.out.print("Incorrect enter! Enter Masters for Master Studies or Phd for Phd studies: ");
        return readClassStanding();

    }
}
