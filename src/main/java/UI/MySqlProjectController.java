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

    public TextArea QueryField11;
    public TextArea QueryField12;
    public TextArea QueryField13;
    public TextArea QueryResult11;
    public TextArea QueryResult12;
    public TextArea QueryResult13;
    public TextArea QueryResult31;
    public TextArea QueryResult32;
    public TextArea QueryResul33;
    public TextArea QueryField32;
    public TextArea QueryField33;
    public TextArea QueryField31;
    public Pane queries3Pane;
    public TextArea QueryField21;
    public TextArea QueryField22;
    public TextArea QueryField23;
    public Pane queries2Pane;
    public TextArea QueryResult21;
    public TextArea QueryResult23;
    public TextArea QueryResult22;
    public Pane queries1Pane;

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
        //********************************
        QueryField11.setText("""
                Select f.nameid as name, count(*) as howManyTime
                from frequents as f inner join restaurant as r on f.restaurname = r.restaurname
                group by f.nameid
                order by count(*)""");
        QueryField21.setText("""
                                select distinct Customer.customerid, Customer.custname
                                from Customer
                                inner join Hotel_trip_customer
                                on Customer.customerid = Hotel_trip_customer.customerid
                                inner join Hotel
                                on Hotel_trip_customer.hotelid = Hotel.hotelid
                                Where Hotel.hotelcity = 'London' or Hotel.hotelcity= 'Paris' or Hotel.hotelcity= 'Madrid' or Hotel.hotelcity= 'Rome'""");
        QueryField31.setText("""
                SELECT htc.TripTo, htc.DepartureDate
                FROM HOTEL_TRIP_CUSTOMER as htc                
                UNION              
                SELECT eo.TripTo, eo.DepartureDate
                FROM EXCUR_OPT_CUSTOMER as eo
                """);
        QueryField33.setText("""
                SELECT
                    HOTEL.HotelId, HOTEL.hotelname, COUNT(*)
                FROM
                    HOTEL
                        INNER JOIN
                    hotel_trip ON HOTEL.HotelId = hotel_trip.Hotelid
                GROUP BY HOTEL.hotelId
                HAVING COUNT(HOTEL.HotelId) <= ALL (SELECT COUNT(HotelId)
                                                   FROM HOTEL TRIP
                                                   GROUP BY HotelId);
                """);
        QueryField32.setText("""
                        SELECT customer.custname,customer.CustomerId
                        FROM hotel_trip_customer as htc
                              INNER JOIN
                        customer
                        ON htc.CustomerId = customer.CustomerId
                        WHERE
                            customer.CustomerId NOT IN (SELECT htc1.CustomerId FROM hotel_trip_customer AS htc1
                            WHERE htc1.TripTo <>'Riga')
                        GROUP BY CUSTOMER.CustomerId;
                """);
   

        //********************************
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
        hidePanes();
        insertGuidePane.setVisible(true);
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
        queries1Pane.setVisible(false);
        dishPane.setVisible(false);
        insertGuidePane.setVisible(false);
        queries2Pane.setVisible(false);
        queries3Pane.setVisible(false);


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



    public void RunQuery21(ActionEvent actionEvent) throws Exception {
        QueryResult21.setText(projectLogic.runQuery(QueryField21.getText()).toString());

    }

    public void RunQuery23(ActionEvent actionEvent) throws Exception {
        QueryResult23.setText(projectLogic.runQuery(QueryField23.getText()).toString());

    }

    public void RunQuery22(ActionEvent actionEvent) throws Exception {
        QueryResult22.setText(projectLogic.runQuery(QueryField22.getText()).toString());

    }

    public void RunQuery31(ActionEvent actionEvent) throws Exception {
        QueryResult31.setText(projectLogic.runQuery(QueryField31.getText()).toString());

    }

    public void RunQuery32(ActionEvent actionEvent) throws Exception {
        QueryResult32.setText(projectLogic.runQuery(QueryField32.getText()).toString());

    }

    public void RunQuery33(ActionEvent actionEvent) throws Exception {
        QueryResul33.setText(projectLogic.runQuery(QueryField33.getText()).toString());

    }

    public void RunQuery12(ActionEvent actionEvent) throws Exception {
        QueryResult12.setText(projectLogic.runQuery(QueryField12.getText()).toString());

    }

    public void RunQuery13(ActionEvent actionEvent) throws Exception {
        QueryResult13.setText(projectLogic.runQuery(QueryField13.getText()).toString());

    }

    public void RunQuery11(ActionEvent actionEvent) throws Exception {
        QueryResult11.setText(projectLogic.runQuery(QueryField11.getText()).toString());

    }



    public void showQueries1(ActionEvent actionEvent) {
        System.out.println("showQueries3");
        hidePanes();
        queries1Pane.setVisible(true);
    }

    public void showQueries2(ActionEvent actionEvent) {
        System.out.println("showQueries2");
        hidePanes();
        queries2Pane.setVisible(true);
    }

    public void showQueries3(ActionEvent actionEvent) {
        System.out.println("showQueries3");
        hidePanes();
        queries3Pane.setVisible(true);
    }
}

