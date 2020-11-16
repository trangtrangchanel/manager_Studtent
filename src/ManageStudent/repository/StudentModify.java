/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageStudent.repository;

import ManageStudent.Create_Account;
import ManageStudent.model.Mark;
import ManageStudent.model.Student;
import ManageStudent.model.Subjects;
import constant.Constant;
import static constant.Constant.connectionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentModify {

    private static Connection getConnection(String userName, String passWord, String urlConnection) throws SQLException {
        return DriverManager.getConnection(connectionDB, Constant.userName, Constant.passWord);
    }

    public static List<Student> finAll() throws ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();

        Statement statement = null;
        Connection connection = null;
        //Kết nối tới DATABASE

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "SELECT * FROM SinhVien";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Student std = new Student(
                        resultSet.getInt("ID"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("GIOITINH"),
                        resultSet.getString("TUOI"),
                        resultSet.getString("EMAIL"),
                        resultSet.getInt("PHONE_NUMBER"));
                studentList.add(std);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //kết thúc
        return studentList;
    }
//ADD DATA INTO DATABASE

    public static void Insert(Student std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "INSERT INTO	 dbo.SinhVien ( ID,HOTEN , GIOITINH , TUOI ,  EMAIL , PHONE_NUMBER )VALUES  (?,?,?,?,?,?)";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setInt(1, std.getId());
            preparedStatement.setString(2, std.getFullname());
            preparedStatement.setString(3, std.getGender());
            preparedStatement.setInt(4, std.getAge());
            preparedStatement.setString(5, std.getEmail());
            preparedStatement.setString(6, std.getPhoneNumber());

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void Update(Student std) throws ClassNotFoundException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);

            //tạo truy vấn
            String sql = "UPDATE SinhVien SET HOTEN =?,GIOITINH = ?,TUOI = ?,EMAIL = ?,PHONE_NUMBER = ? WHERE ID = ?";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setString(1, std.getFullname());
            preparedStatement.setString(2, std.getGender());
            preparedStatement.setInt(3, std.getAge());
            preparedStatement.setString(4, std.getEmail());
            preparedStatement.setString(5, std.getPhoneNumber());
            preparedStatement.setInt(6, std.getId());

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void Delete(int id) throws ClassNotFoundException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;

        //Kết nối tới DATABASE
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);

            //tạo truy vấn
            String sql = "DELETE FROM SinhVien WHERE ID = ?";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setInt(1, id);

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static List<Student> FindByFullName(String fullname) throws ClassNotFoundException {
        List<Student> studentList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "SELECT * FROM dbo.SinhVien WHERE HOTEN LIKE ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%" + fullname + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student std = new Student(resultSet.getInt("ID"),
                        resultSet.getString("HOTEN"),
                        resultSet.getString("GIOITINH"),
                        resultSet.getString("TUOI"),
                        resultSet.getString("EMAIL"),
                        resultSet.getInt("PHONE_NUMBER"));
                studentList.add(std);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //kết thúc
        return studentList;
    }

    public static void Create_Account(Create_Account ca) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = getConnection(connectionDB, Constant.userName, Constant.passWord);

        //tạo truy vấn
        String sql = "INSERT INTO DataUser ( TaiKhoan, MatKhau )VALUES  ( ?,? )";
        preparedStatement = connection.prepareCall(sql);

        preparedStatement.setString(1, ca.getAccout());
        preparedStatement.setString(2, ca.getPass());

        preparedStatement.execute();
    }

    //-------------------------------Subjects---------------------------------
    public static List<Subjects> findAllSubjects() throws ClassNotFoundException {
        List<Subjects> SubjectslList = new ArrayList<>();

        Statement statement = null;
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);

            //tạo truy vấn
            String sql = "SELECT * FROM dbo.MonHoc";
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Subjects subjects = new Subjects(
                        resultSet.getString("MaMH"),
                        resultSet.getString("TenMH"),
                        resultSet.getInt("SoTiet"));
                SubjectslList.add(subjects);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //kết thúc
        return SubjectslList;
    }

    public static void InsertSubjects(Subjects std) throws ClassNotFoundException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "INSERT INTO MonHoc ( MaMH, TenMH, SoTiet )VALUES  (?,?,?)";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database 
            preparedStatement.setString(1, std.getIdSubject());
            preparedStatement.setString(2, std.getNameSubject());
            preparedStatement.setInt(3, std.getCounterSubject());

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void DeleteSubjects(String maMH) throws ClassNotFoundException {

        Connection connection = null;

        PreparedStatement preparedStatement = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);

            //tạo truy vấn
            String sql = "DELETE FROM MonHoc WHERE MaMH = ?";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setString(1, maMH);

            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    //--------------------Mark--------------------------------------------
    public static void InsertMark(Mark std) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "INSERT INTO dbo.KetQua ( ID,MaMH, DiemThi )VALUES  (?,?,?)";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setInt(1, std.getIdStudent());
            preparedStatement.setString(2, std.getIdSubject());
            preparedStatement.setInt(3, std.getScore());
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static List<Mark> findAllMark() throws ClassNotFoundException {
        List<Mark> markList = new ArrayList<>();
        Statement statement = null;
        Connection connection = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "SELECT * FROM dbo.KetQua";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Mark mark = new Mark(
                        resultSet.getInt("ID"),
                        resultSet.getString("MaMH"),
                        resultSet.getInt("DiemThi"));
                markList.add(mark);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //kết thúc
        return markList;
    }

    public static void DeleteMark(int id) throws ClassNotFoundException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            //lấy data sinh viên
            connection = getConnection(connectionDB, Constant.userName, Constant.passWord);
            //tạo truy vấn
            String sql = "DELETE FROM KetQua WHERE ID = ?";
            preparedStatement = connection.prepareCall(sql);
            //Thêm dữ liêu database
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StudentModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
