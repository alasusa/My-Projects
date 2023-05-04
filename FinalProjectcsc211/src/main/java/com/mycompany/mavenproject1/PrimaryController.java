/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author aslas
 */
public class PrimaryController implements Initializable{

    @FXML
    private TextField IDTF;
    @FXML
    private TextField FirstNameTF;
    @FXML
    private TextField LastNameTF;
    @FXML
    private TextField MonthTF;
    @FXML
    private TextField DayTF;
    @FXML
    private TextField YearTF;
    @FXML
    private TextField StatusTF;
    @FXML
    private Label EmployeeCountLabel;

    ObservableList<Employee> employees = FXCollections.observableArrayList();
    
    
    
    
   
    int EmployeeCount = 0;
   
    Employee[] EmployeeArray = new Employee[EmployeeCount];
    @FXML
    private Button AddEmployeeButton;
    @FXML
    private TableColumn<Employee, Integer> IDColumn;
    @FXML
    private TableColumn<Employee, String> LastNameColumn;
    @FXML
    private TableColumn<Employee, String> FirstNameColumn;
    @FXML
    private TableColumn<Employee, Integer> DateOfHireColumn;
    @FXML
    private TableView<Employee> TableView;
    
    
    public void initialize(URL url, ResourceBundle resourcebundle) {
        FirstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstname"));
       LastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastname"));
        IDColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("ID"));
       DateOfHireColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("hireDate"));
        
    }
    
    @FXML
    private void buttonEventHandler(ActionEvent event) {
       
try{
        Employee employee = new Employee(FirstNameTF.getText(), LastNameTF.getText(), Integer.parseInt(IDTF.getText()), Integer.parseInt(DayTF.getText()), Integer.parseInt(MonthTF.getText()), Integer.parseInt(YearTF.getText()));
       
       ObservableList<Employee> employees = TableView.getItems();
       employees.add(employee);
       TableView.setItems(employees);
       
       
      String output = "New Employee added.";
        StatusTF.setText(output);
       
       
     EmployeeCount = EmployeeCount + 1;
    EmployeeCountLabel.setText (String.format("%s",EmployeeCount));
    clearInput();
    
    
     File file = new File("output.txt");
     FileWriter fw = new FileWriter("output.txt", true);
     PrintWriter outputfile = new PrintWriter(fw);
     outputfile.println(employee.toString());
    
        } catch(NumberFormatException ex) {
            StatusTF.setText("Number Format Error found: " + ex.getMessage());
        } catch (IOException ex) {
            StatusTF.setText("IOException found: " + ex.getMessage());
        }

        
    }
       
    
    public void clearInput(){
        IDTF.setText(" ");
        FirstNameTF.setText(" ");
        LastNameTF.setText(" ");
        DayTF.setText(" ");
        MonthTF.setText(" ");
        YearTF.setText(" ");
    }
    
    
}