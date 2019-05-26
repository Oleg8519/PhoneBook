import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            System.out.println("Данная программа выполняет пять команд: \n'Регистрация' \n'Авторизация' \n'Редактирование' \n'Удаление' \n'Все данные' ");
               System.out.print("Введите вашу команду: ");
               Scanner str = new Scanner(System.in);
               String request = str.nextLine();

               if (request.equals("Регистрация")) {
                   Connect connect = new Connect();

                   System.out.print("Введите имя:");
                   String devname = str.nextLine();

                   System.out.print("Введите фамилию:");
                   String devsurname = str.nextLine();

                   System.out.print("Введите номер телефона:");
                   int devphoneNumber = str.nextInt();

                   String checkIn = "INSERT INTO phone_book (name, surname, phoneNumber)VALUES(?,?,?)";

                   try {

                       PreparedStatement preparedStatement = connect.getConnection().prepareStatement(checkIn);

                       preparedStatement.setString(1, devname);
                       preparedStatement.setString(2, devsurname);
                       preparedStatement.setInt(3, devphoneNumber);
                       preparedStatement.executeUpdate();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   System.out.println("Регистрация выполнена успешно");


               } else if (request.equals("Авторизация")) {
                   System.out.print("Введите id пользователя:");

                   int number = str.nextInt();
                   Connect connect = new Connect();
                   String authorizacion = "select * from phone_book where iduser = " + number;
                   try {
                       Statement statement = connect.getConnection().createStatement();
                       ResultSet resultSet = statement.executeQuery(authorizacion);

                       while (resultSet.next()) {
                           User user = new User();
                           user.setIduser(resultSet.getInt("iduser"));
                           user.setName(resultSet.getString("name"));
                           user.setSurname(resultSet.getString("surname"));
                           user.setPhoneNumber(resultSet.getInt("phoneNumber"));
                           System.out.println(user);
                       }

                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   System.out.println("Авторизация выполнена успешно");


               } else if (request.equals("Все данные")) {

                   Connect connect = new Connect();
                   String total = "SELECT * FROM phone_book";
                   try {
                       PreparedStatement preparedStatement = connect.getConnection().prepareStatement(total);

                       ResultSet res = preparedStatement.executeQuery();
                       while (res.next()) {
                           int iduser = res.getInt("iduser");
                           String name = res.getString("name");
                           String surname = res.getString("surname");
                           int phoneNumber = res.getInt("phoneNumber");
                           System.out.println("iduser: " + iduser + ", name: " + name + ", surname: " + surname + ", phoneNumber: " + phoneNumber + "");
                       }
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }

                   System.out.println("Все данные выведены на экран");

               } else if (request.equals("Удаление")) {
                   System.out.print("Введите id пользователя которого хотите удалить:");
                   int devnumber = str.nextInt();
                   Connect connect = new Connect();
                   String delete = "DELETE FROM phone_book WHERE iduser = ?";
                   try {
                       PreparedStatement preparedStatement = connect.getConnection().prepareStatement(delete);
                       preparedStatement.setInt(1, devnumber);
                       preparedStatement.executeUpdate();
                   } catch (SQLException e) {
                       e.printStackTrace();
                   }
                   System.out.println("Пользователь удален из базы данных");


               } else if (request.equals("Редактирование")) {
                   Connect connect = new Connect();
                   System.out.println("Есть три команды: \n'Изменить имя'\n'Изменить фамилию'\n'Изменить номер телефона'");
                   System.out.print("Напишите вашу команду:");
                   String changeName = str.nextLine();
                   if (changeName.equals("Изменить имя")) {
                       System.out.println("Введите новое имя:");
                       String newName = str.nextLine();
                       System.out.println("Введите id пользователя:");
                       int num = str.nextInt();
                       String newdata = "UPDATE phone_book SET name ='" + newName + "' WHERE iduser=" + num;
                       try {
                           Statement statement = connect.getConnection().createStatement();

                           int resultSet = statement.executeUpdate(newdata);
                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                       System.out.println("Имя пользователя изменено");
                   } else if (changeName.equals("Изменить фамилию")) {
                       System.out.println("Введите новую фамилию:");
                       String newSurname = str.nextLine();
                       System.out.println("Введите id пользователя:");
                       int numb = str.nextInt();
                       String twodata = "UPDATE phone_book SET surname='" + newSurname + "' WHERE iduser =" + numb;
                       try {
                           Statement statement = connect.getConnection().createStatement();

                           int resultSets = statement.executeUpdate(twodata);
                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                       System.out.println("Фамилия пользователя изменена");
                   } else if (changeName.equals("Изменить номер телефона")) {
                       System.out.println("Введите новый номер:");
                       int newNumber = str.nextInt();
                       System.out.println("Введите id пользователя:");
                       int numbe = str.nextInt();
                       String threedata = "UPDATE phone_book SET phoneNumber='" + newNumber + "' WHERE iduser=" + numbe;
                       try {
                           Statement statement = connect.getConnection().createStatement();

                           int resultSets = statement.executeUpdate(threedata);
                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                       System.out.println("Номер телефона изменен");
                   }

               }

                }
            }




