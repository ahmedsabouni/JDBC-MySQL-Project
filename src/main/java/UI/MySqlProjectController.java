package UI;

import businessLogic.ProjectLogic;
import domain.Employee;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySqlProjectController {
    public TableColumn<Employee,String> FnameCul;
    public TableColumn<Employee,String> MinitCul;
    public TableColumn<Employee,String> LnameCul;
    public TableColumn<Employee, LocalDate> BdateCul;
    public TableColumn<Employee,Integer> SalaryCul;
    public TableColumn<Employee,String> SexCul;
    public TableColumn<Employee,String> AddressCul;
    public TableColumn<Employee,String> Super_ssnCul;
    public TableColumn<Employee,Integer> DnoCul;
    public TableColumn<Employee,String> SsnCul;
    public TextField DnoFIeld;
    public DatePicker BdateField;
    public Button confirmUpdateBtn;
    public TextField empSsn;
    public TextField searchEmpLName;
    public Menu query1button;
    public MenuBar query1;
    public Pane query1Pane;

    ProjectLogic projectLogic = new ProjectLogic();
    public MenuItem insertEmployee;
    public MenuBar menuBar;
    public Pane insertEmployeePane;
    public Pane insertGuidePane;
    public static List<Pane> panes = new ArrayList<>();
    public MenuItem insertGuide;
    public AnchorPane insertPanes;

    public TableView<Employee> employeeTable;

    public Button searchEmpsBtn;
    public TextField empIdText;
    public Button searchEmpBtn;
    public Button deleteEmpBtn;
    public Button updateEmpBtn;
    public Button addEmpBtn;
    @FXML
    public TextArea resultArea;
    public TextField FnameField;
    public TextField LnameField;
    public TextField MinitField;
    public TextField AddressField;
    public TextField Super_ssnField;
    
    public TextField SsnField;
    public TextField Dno;

    public TextField SalaryField;
    public TextField newEmailText;
    public TextField SexField;
    public VBox insertPane;


    public void initialize() {
        //panes.addAll(insertEmployeePane,insertGuidePane);
        //insertGuidePane.setVisible(false);
        FnameCul.setCellValueFactory(new PropertyValueFactory<>("Fname"));
        MinitCul.setCellValueFactory(new PropertyValueFactory<>("Minit"));
        LnameCul.setCellValueFactory(new PropertyValueFactory<>("Lname"));
        BdateCul.setCellValueFactory(new PropertyValueFactory<>("Bdate"));
        SalaryCul.setCellValueFactory(new PropertyValueFactory<>("Salary"));
        SexCul.setCellValueFactory(new PropertyValueFactory<>("Sex"));
        SsnCul.setCellValueFactory(new PropertyValueFactory<>("Ssn"));
        AddressCul.setCellValueFactory(new PropertyValueFactory<>("Address"));
        Super_ssnCul.setCellValueFactory(new PropertyValueFactory<>("Super_ssn"));
        DnoCul.setCellValueFactory(new PropertyValueFactory<>("Dno"));
    }

    public void updateEmployee(ActionEvent actionEvent) {
        Employee employee = employeeTable.getSelectionModel().getSelectedItem();
        if(employee == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Employee Selected");
            alert.setContentText("Please select an employee to update");
            alert.showAndWait();
        }
        else{
            FnameField.setText(employee.getFname());
            LnameField.setText(employee.getLname());
            MinitField.setText(employee.getMinit());
            AddressField.setText(employee.getAddress());
            Super_ssnField.setText(employee.getSuper_ssn());
            SsnField.setText(employee.getSsn());
            SsnField.setEditable(false);

            SalaryField.setText(String.valueOf(employee.getSalary()));
            SexField.setText(employee.getSex());
            BdateField.setValue(employee.getBdate());
            resultArea.setText("");
            DnoFIeld.setText(String.valueOf(employee.getDno()));
            confirmUpdateBtn.setVisible(true);

        }
    }

    public Employee createEmployee(){
        Employee employee = new Employee();
        employee.setFname(FnameField.getText());
        employee.setLname(LnameField.getText());
        employee.setMinit(MinitField.getText());
        employee.setAddress(AddressField.getText());
        employee.setSuper_ssn(Super_ssnField.getText());
        employee.setBdate(BdateField.getValue());
        employee.setSsn(SsnField.getText());
        employee.setDno(Integer.parseInt(DnoFIeld.getText()));
        employee.setSalary(Integer.parseInt(SalaryField.getText()));
        employee.setSex(SexField.getText());
        return employee;
    }

    public void insertEmployee(ActionEvent actionEvent) throws Exception {

        projectLogic.insertEmployee(createEmployee());
        clearFields();
        employeeTable.getItems().addAll(projectLogic.serchEmployees());
        resultArea.setText("Employee Inserted successfully");
    }

    public void deleteEmployee(ActionEvent actionEvent) {
        Employee employee = employeeTable.getSelectionModel().getSelectedItem();
        if (employee != null) {
            projectLogic.deleteEmployee(employee.getSsn());
            resultArea.setText("Employee Deleted successfully");
            employeeTable.getItems().remove(employee);

        } else {
            resultArea.setText("Please select an employee to delete");
        }
    }

    public void searchEmployee(ActionEvent actionEvent) {

    }

    public void searchEmployees(ActionEvent actionEvent) throws Exception {
        System.out.println("searchEmployees");
        employeeTable.getItems().clear();
        employeeTable.getItems().addAll(projectLogic.serchEmployees());
        resultArea.setText("done");


    }

    public void showInsertEmployee(ActionEvent actionEvent) {
        hidePanes();
        insertEmployeePane.setVisible(true);
    }

    public void showInsertGuide(ActionEvent actionEvent) {
        insertGuidePane.toFront();
    }
    public void confirmUpdate(ActionEvent actionEvent) throws Exception {
        projectLogic.updateEmployee(createEmployee());
        resultArea.setText("Employee Updated successfully");
        clearFields();
        employeeTable.getItems().clear();
        confirmUpdateBtn.setVisible(false);
        searchEmployees(actionEvent);

        }

    public void clearFields() {
        FnameField.clear();
        LnameField.clear();
        MinitField.clear();
        AddressField.clear();
        Super_ssnField.clear();
        BdateField.setValue(null);
        SsnField.clear();
        DnoFIeld.clear();
        SalaryField.clear();
        SexField.clear();
    }

    public void searchBtn(ActionEvent actionEvent) throws Exception {
        if (!empSsn.getText().isEmpty()) {
            employeeTable.getItems().clear();
            for (Employee employee : projectLogic.serchEmployees()) {
                if (employee.getSsn().equals(empSsn.getText())) {
                    employeeTable.getItems().add(employee);
                }
            }
    }
        else if (!searchEmpLName.getText().isEmpty()) {
            employeeTable.getItems().clear();
            for (Employee employee : projectLogic.serchEmployees()) {
                if (employee.getLname().equalsIgnoreCase(searchEmpLName.getText())) {
                    employeeTable.getItems().add(employee);
                }
            }
        }
        else {resultArea.setText("Please enter an employee SSN or a last name to get results");}
    }
    public void hidePanes( ) {
        insertEmployeePane.setVisible(false);
        query1Pane.setVisible(false);


    }

    public void showQuery11(Event actionEvent) {
        System.out.println("showQuery1");
        hidePanes();
        query1Pane.setVisible(true);
        query1Pane.toFront();
    }
    public void showQuery12(Event actionEvent) {
        System.out.println("showQuery12");
        hidePanes();
    }
    public void showQuery13(Event actionEvent) {
        System.out.println("showQuery13");
        hidePanes();
    }
    public void showQuery21(Event actionEvent) {
        System.out.println("showQuery21");
        hidePanes();
    }
    public void showQuery22(Event actionEvent) {
        System.out.println("showQuery22");
        hidePanes();
    }public void showQuery23(Event actionEvent) {
        System.out.println("showQuery23");
        hidePanes();
    }public void showQuery31(Event actionEvent) {
        System.out.println("showQuery31");
        hidePanes();
    }
    public void showQuery32(Event actionEvent) {
        System.out.println("showQuery32");
        hidePanes();
    }
    public void showQuery33(Event actionEvent) {
        System.out.println("showQuery33");
        hidePanes();
    }



}

