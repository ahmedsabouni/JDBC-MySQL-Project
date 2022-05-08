package UI;

import businessLogic.ProjectLogic;
import domain.*;
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
    public Pane dishPane;
    public Button confirmUpdateBtn1;
    public Button searchAllDishBtn;
    public TableColumn<Dish,String> difficultyCul;
    public TableColumn<Dish,String> categoryCul;
    public TableColumn<Dish,String> cuisineCul;
    public TableColumn<Dish,String> dishCul;
    public TableView<Dish> dishTable;
    public TextField difficultyField;
    public TextField categoryField;
    public TextField cuisineField;
    public TextField dishField;
    public Button updateDishBtn;
    public TextArea resultArea1;
    public Button addDishBtn;
    public Button deleteDishBtn;
    public Button searchDishBtn;
    public TextField dishSearchField;
    public MenuItem insertDish;
    public TextField guideIdSearchField;
    public Button searchGuideBtn;
    public Button deleteGuideBtn;
    public Button updateGuideBtn;
    public Button addGuideBtn;
    public TextArea resultArea2;
    public TableView<Guide> guideTable;
    public TextField guidePhoneField;
    public TextField guideNameField;
    public TextField huideIdField;
    public TextField guideNameSearchField;
    public Button searchGuidesBtn;
    public Button confirmUpdateBtn2;
    public TableColumn<Guide,String> guidephoneCul;
    public TableColumn<Guide,String> guideNameCul;
    public TableColumn<Guide,String> guideIdCul;
    public TextField guideIdField;

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
        //*******************************************************************************
        dishCul.setCellValueFactory(new PropertyValueFactory<>("dish"));
        categoryCul.setCellValueFactory(new PropertyValueFactory<>("category"));
        cuisineCul.setCellValueFactory(new PropertyValueFactory<>("cuisine"));
        difficultyCul.setCellValueFactory(new PropertyValueFactory<>("difficulty"));
        //*******************************************************************************
        guideNameCul.setCellValueFactory(new PropertyValueFactory<>("name"));
        guideIdCul.setCellValueFactory(new PropertyValueFactory<>("Id"));
        guidephoneCul.setCellValueFactory(new PropertyValueFactory<>("phone"));

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
        dishPane.setVisible(false);
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


    public void confirmUpdate1(ActionEvent actionEvent) throws Exception {
        projectLogic.updateDish(createDish());
        resultArea.setText("Dish Updated successfully");
        clearFields();
        employeeTable.getItems().clear();
        confirmUpdateBtn1.setVisible(false);
        searchDishes(actionEvent);
    }

    private Dish createDish() {
        Dish dish = new Dish();
        dish.setDish(dishField.getText());
        dish.setCuisine(cuisineField.getText());
        dish.setDifficulty(difficultyField.getText());
        dish.setCategory(categoryField.getText());
        return dish;
    }

    public void searchDishes(ActionEvent actionEvent) throws Exception {
        dishTable.getItems().clear();
        dishTable.getItems().addAll(projectLogic.searchDishes());


    }

    public void deleteDish(ActionEvent actionEvent) {
        projectLogic.deleteDish(dishTable.getSelectionModel().getSelectedItem());
        resultArea1.setText("Dish deleted successfully");
    }

    public void updateDish(ActionEvent actionEvent) {
        Dish d = dishTable.getSelectionModel().getSelectedItem();
        if(d == null){
            resultArea.setText("Please select a dish to update");
        }
        else{
            dishField.setText(d.getDish());
            categoryField.setText(d.getCategory());
            cuisineField.setText(d.getCuisine());
            difficultyField.setText(d.getDifficulty());
            confirmUpdateBtn1.setVisible(true);
        }
    }

    public void searchBtn1(ActionEvent actionEvent) throws Exception {
        if (!dishSearchField.getText().isEmpty()) {
            dishTable.getItems().clear();
            for (Dish d : projectLogic.searchDishes()) {
                if (d.getDish().equals(dishSearchField.getText())) {
                    dishTable.getItems().add(d);
                }
            }
        }
        else {resultArea.setText("Please enter a dish name to get results");}

    }

    public void showInsertDich(ActionEvent actionEvent) {
        hidePanes();
        dishPane.setVisible(true);
    }

    public void insertDish(ActionEvent actionEvent) {
        Dish dish = new Dish();
        dish.setDish(dishField.getText());
        dish.setCuisine(cuisineField.getText());
        dish.setDifficulty(difficultyField.getText());
        dish.setCategory(categoryField.getText());
        projectLogic.insertDish(dish);
        resultArea1.setText("Dish inserted successfully");
    }

    public void searchGuide(ActionEvent actionEvent) {

        if (!guideIdSearchField.getText().isEmpty()) {
            guideTable.getItems().clear();
            for (Guide g : projectLogic.serchGuides()) {
                if (g.getId().equals(guideIdSearchField.getText())) {
                    guideTable.getItems().add(g);
                }
            }
        }
        else if (!guideNameSearchField.getText().isEmpty()) {
            employeeTable.getItems().clear();
            for (Guide g : projectLogic.serchGuides()) {
                if (g.getName().equalsIgnoreCase(guideNameSearchField.getText())) {
                    guideTable.getItems().add(g);
                }
            }
        }
        else {resultArea.setText("Please enter a guide id or a name to get a result");}

    }

    public void deleteGuide(ActionEvent actionEvent) {
        projectLogic.deleteGuide(guideTable.getSelectionModel().getSelectedItem());
        resultArea2.setText("Guide deleted successfully");
    }

    public void updateGuide(ActionEvent actionEvent) {
        Guide g = guideTable.getSelectionModel().getSelectedItem();
        if(g == null){
            resultArea.setText("Please select a guide to update");
        }
        else{
            guideIdField.setText(g.getId());
            guideNameField.setText(g.getName());
            guidePhoneField.setText(g.getPhone());
            confirmUpdateBtn2.setVisible(true);
        }
        
        
    }

    public void insertGuide(ActionEvent actionEvent) {
        Guide guide = new Guide();
        guide.setName(guideNameField.getText());
        guide.setId(guideIdField.getText());
        guide.setPhone(guidePhoneField.getText());
        projectLogic.insertGuide(guide);

    }

    public void searchGuides(ActionEvent actionEvent) {
        guideTable.getItems().clear();
        guideTable.getItems().addAll(projectLogic.serchGuides());
        resultArea.setText("done");

    }

    public void confirmUpdate2(ActionEvent actionEvent) {
        Guide g = guideTable.getSelectionModel().getSelectedItem();
        g.setId(guideIdField.getText());
        g.setName(guideNameField.getText());
        g.setPhone(guidePhoneField.getText());
        projectLogic.updateGuide(g);
    }
}

