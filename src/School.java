import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class School extends JFrame {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();



    public School() {
        setTitle("School Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        setLocationRelativeTo(null);

        ImageIcon addStudentIcon = new ImageIcon("Studentpic.jpeg");
        addStudentIcon = new ImageIcon(addStudentIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        ImageIcon addTeacherIcon = new ImageIcon("TeacherPic.jpeg");
        addTeacherIcon = new ImageIcon(addTeacherIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        ImageIcon createCourseIcon = new ImageIcon("CoursePic.jpeg");
        createCourseIcon = new ImageIcon(createCourseIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        ImageIcon enrollStudentIcon = new ImageIcon("EnrollPic.jpeg");
        enrollStudentIcon = new ImageIcon(enrollStudentIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));

        ImageIcon viewInfoIcon = new ImageIcon("InfoPic.jpeg");
        viewInfoIcon = new ImageIcon(viewInfoIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));


        JButton addStudentBtn = new JButton("Add Student", addStudentIcon);
        JButton addTeacherBtn = new JButton("Add Teacher", addTeacherIcon);
        JButton createCourseBtn = new JButton("Create Course", createCourseIcon);
        JButton enrollStudentBtn = new JButton("Enroll Student", enrollStudentIcon);
        JButton viewStudentInfoBtn = new JButton("View Info", viewInfoIcon);


        JButton[] buttons = { addStudentBtn, addTeacherBtn, createCourseBtn, enrollStudentBtn, viewStudentInfoBtn };
        for (JButton btn : buttons) {
            btn.setHorizontalTextPosition(SwingConstants.RIGHT);
            btn.setVerticalTextPosition(SwingConstants.CENTER);
            btn.setIconTextGap(50);
        }


        add(addStudentBtn);
        add(addTeacherBtn);
        add(createCourseBtn);
        add(enrollStudentBtn);
        add(viewStudentInfoBtn);

        addStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddStudentFrame();
            }
        });

        addTeacherBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openAddTeacherFrame();
            }
        });

        createCourseBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCreateCourseFrame();
            }
        });

        enrollStudentBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openEnrollFrame();
            }
        });

        viewStudentInfoBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openViewStudentInfoFrame();
            }
        });

        setVisible(true);
    }

    private void openAddStudentFrame() {
        JFrame frame = new JFrame("Add Student");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Semester:");
        JTextField ageField = new JTextField();
        JLabel idLabel = new JLabel("Student ID");
        JTextField idField = new JTextField();
        JButton okButton = new JButton("Add");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(idLabel);
        frame.add(idField);
        frame.add(new JLabel());
        frame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                try {
                    int age = Integer.parseInt(ageField.getText());
                    int id = Integer.parseInt(idField.getText());
                    students.add(new Student(name, age, id));
                    JOptionPane.showMessageDialog(frame, "Student added.");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for age and ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        frame.setVisible(true);
    }

    private void openAddTeacherFrame() {
        JFrame frame = new JFrame("Add Teacher");
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));
        frame.setLocationRelativeTo(null);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel ageLabel = new JLabel("Teacher ID:");
        JTextField ageField = new JTextField();
        JLabel subjectLabel = new JLabel("Subject:");
        JTextField subjectField = new JTextField();
        JButton okButton = new JButton("Add");

        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(ageLabel);
        frame.add(ageField);
        frame.add(subjectLabel);
        frame.add(subjectField);
        frame.add(new JLabel());
        frame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String subject = subjectField.getText();
                try {
                    int age = Integer.parseInt(ageField.getText());
                    teachers.add(new Teacher(name, age, subject));
                    JOptionPane.showMessageDialog(frame, "Teacher added.");
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for age.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        frame.setVisible(true);
    }

    private void openCreateCourseFrame() {
        if (teachers.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Add a teacher first.");
            return;
        }

        JFrame frame = new JFrame("Create Course");
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2));
        frame.setLocationRelativeTo(null);

        JLabel courseLabel = new JLabel("Course Name:");
        JTextField courseField = new JTextField();
        JLabel teacherLabel = new JLabel("Select Teacher:");
        JComboBox<String> teacherBox = new JComboBox<>();

        for (Teacher t : teachers) {
            teacherBox.addItem(t.name);
        }

        JButton okButton = new JButton("Create");

        frame.add(courseLabel);
        frame.add(courseField);
        frame.add(teacherLabel);
        frame.add(teacherBox);
        frame.add(new JLabel());
        frame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String courseName = courseField.getText();
                String selectedTeacher = (String) teacherBox.getSelectedItem();
                for (Teacher t : teachers) {
                    if (t.name.equals(selectedTeacher)) {
                        courses.add(new Course(courseName, t));
                        break;
                    }
                }
                JOptionPane.showMessageDialog(frame, "Course created.");
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void openEnrollFrame() {
        if (students.isEmpty() || courses.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Add students and courses first.");
            return;
        }

        JFrame frame = new JFrame("Enroll Student");
        frame.setSize(300, 150);
        frame.setLayout(new GridLayout(3, 2));
        frame.setLocationRelativeTo(null);

        JLabel studentLabel = new JLabel("Select Student:");
        JComboBox<String> studentBox = new JComboBox<>();
        for (Student s : students) {
            studentBox.addItem(s.name);
        }

        JLabel courseLabel = new JLabel("Select Course:");
        JComboBox<String> courseBox = new JComboBox<>();
        for (Course c : courses) {
            courseBox.addItem(c.getCourseName());
        }

        JButton okButton = new JButton("Enroll");

        frame.add(studentLabel);
        frame.add(studentBox);
        frame.add(courseLabel);
        frame.add(courseBox);
        frame.add(new JLabel());
        frame.add(okButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedStudent = (String) studentBox.getSelectedItem();
                String selectedCourse = (String) courseBox.getSelectedItem();
                Student student = null;
                Course course = null;

                for (Student s : students) {
                    if (s.name.equals(selectedStudent)) {
                        student = s;
                        break;
                    }
                }

                for (Course c : courses) {
                    if (c.getCourseName().equals(selectedCourse)) {
                        course = c;
                        break;
                    }
                }

                if (student != null && course != null) {
                    student.enrollCourse(course);
                    JOptionPane.showMessageDialog(frame, "Student enrolled.");
                }
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }

    private void openViewStudentInfoFrame() {
        if (students.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students available.");
            return;
        }

        JFrame frame = new JFrame("View Student Info");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);

        JComboBox<String> studentBox = new JComboBox<>();
        for (Student s : students) {
            studentBox.addItem(s.name);
        }

        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        JButton viewBtn = new JButton("View");

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Student:"));
        topPanel.add(studentBox);
        topPanel.add(viewBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(infoArea), BorderLayout.CENTER);

        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String studentName = (String) studentBox.getSelectedItem();
                Student student = null;
                for (Student s : students) {
                    if (s.name.equals(studentName)) {
                        student = s;
                        break;
                    }
                }

                if (student != null) {
                    ArrayList<String> lines = new ArrayList<>();
                    lines.add("Name: " + student.name);
                    lines.add("Semester: " + student.age);
                    lines.add("ID: " + student.studentId);
                    lines.add("Courses:");
                    for (Course c : student.courses) {
                        lines.add("- " + c.getCourseName() + " (Teacher: " + c.teacher.name + ")");
                    }

                    String info = String.join("\n", lines);
                    infoArea.setText(info);
                }
            }
        });

        frame.setVisible(true);
    }

    class Person {
        protected String name;
        protected int age;
        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    class Teacher extends Person {
        private String subject;
        public Teacher(String name, int age, String subject) {
            super(name, age);
            this.subject = subject;
        }
    }

    class Course {
        private String courseName;
        private Teacher teacher;
        public Course(String courseName, Teacher teacher) {
            this.courseName = courseName;
            this.teacher = teacher;
        }
        public String getCourseName() {
            return courseName;
        }
    }

    class Student extends Person {
        private int studentId;
        private ArrayList<Course> courses;
        public Student(String name, int age, int studentId) {
            super(name, age);
            this.studentId = studentId;
            this.courses = new ArrayList<>();
        }
        public void enrollCourse(Course course) {
            courses.add(course);
        }
    }

    public static void main(String[] args) {
        JWindow splash = new JWindow();

        try {
            ImageIcon originalIcon = new ImageIcon("WelcomeScreen.jpeg");


            Image scaledImage = originalIcon.getImage()
                    .getScaledInstance(600, 500, Image.SCALE_SMOOTH);

            splash.getContentPane().add(new JLabel(new ImageIcon(scaledImage)));
            splash.pack();
            splash.setLocationRelativeTo(null);
            splash.setVisible(true);

            Thread.sleep(10000);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load splash image: " + e.getMessage());
        } finally {
            splash.dispose();
        }

        JFrame mainFrame = new JFrame("School Management System");
        mainFrame.setSize(600, 500);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        new School();
    }
}