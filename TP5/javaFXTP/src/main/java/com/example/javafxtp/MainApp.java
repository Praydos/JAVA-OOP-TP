package com.example.javafxtp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import metier.Departement;
import metier.MetierImpl;
import metier.Professeur;

import java.util.List;

public class MainApp extends Application {

    private MetierImpl metier = new MetierImpl(); // Assuming MetierImpl is already implemented
    private TableView<Professeur> professorTable = new TableView<>();
    private TableView<Departement> departmentTable = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        // Main Layout
        TabPane tabPane = new TabPane();

        // Professor Tab
        Tab professorTab = new Tab("Manage Professors", createProfessorTab());
        professorTab.setClosable(false);

        // Department Tab
        Tab departmentTab = new Tab("Manage Departments", createDepartmentTab());
        departmentTab.setClosable(false);

        tabPane.getTabs().addAll(professorTab, departmentTab);

        // Scene and Stage Setup
        Scene scene = new Scene(tabPane, 1000, 700);
        primaryStage.setTitle("CRUD Operations - Professors and Departments");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Create Professor Tab
    private VBox createProfessorTab() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Title
        Label title = new Label("Professor Management");

        // TableView Setup
        setupProfessorTableView();

        // Form for CRUD operations
        VBox formLayout = createProfessorForm();

        // Add Components to Main Layout
        vbox.getChildren().addAll(title, professorTable, formLayout);
        return vbox;
    }

    // Set up TableView for Professors
    private void setupProfessorTableView() {
        TableColumn<Professeur, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Professeur, String> nomColumn = new TableColumn<>("Name");
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Professeur, String> prenomColumn = new TableColumn<>("Prenom");
        prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Professeur, String> cinColumn = new TableColumn<>("CIN");
        cinColumn.setCellValueFactory(new PropertyValueFactory<>("cin"));

        TableColumn<Professeur, String> adresseColumn = new TableColumn<>("Address");
        adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));

        TableColumn<Professeur, String> telephoneColumn = new TableColumn<>("Telephone");
        telephoneColumn.setCellValueFactory(new PropertyValueFactory<>("telephone"));

        TableColumn<Professeur, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Professeur, String> dateRecColumn = new TableColumn<>("Recruitment Date");
        dateRecColumn.setCellValueFactory(new PropertyValueFactory<>("dateRec"));

        TableColumn<Professeur, Integer> depColumn = new TableColumn<>("Department ID");
        depColumn.setCellValueFactory(new PropertyValueFactory<>("idDep"));

        professorTable.getColumns().addAll(idColumn, nomColumn, prenomColumn, cinColumn, adresseColumn,
                telephoneColumn, emailColumn, dateRecColumn, depColumn);
    }

    // Create Form for Professor CRUD Operations
    private VBox createProfessorForm() {
        // Input Fields
        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nomField = new TextField();
        nomField.setPromptText("Name");

        TextField prenomField = new TextField();
        prenomField.setPromptText("Prenom");

        TextField cinField = new TextField();
        cinField.setPromptText("CIN");

        TextField adresseField = new TextField();
        adresseField.setPromptText("Address");

        TextField telephoneField = new TextField();
        telephoneField.setPromptText("Telephone");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField dateRecField = new TextField();
        dateRecField.setPromptText("Recruitment Date (YYYY-MM-DD)");

        TextField depField = new TextField();
        depField.setPromptText("Department ID");

        // Buttons
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button listButton = new Button("List");

        // Event Handlers for Professors
        addButton.setOnAction(e -> {
            try {
                Professeur prof = new Professeur();
                prof.setNom(nomField.getText());
                prof.setPrenom(prenomField.getText());
                prof.setCin(cinField.getText());
                prof.setAdresse(adresseField.getText());
                prof.setTelephone(telephoneField.getText());
                prof.setEmail(emailField.getText());
                prof.setDateRec(dateRecField.getText());
                prof.setIdDep(Integer.parseInt(depField.getText()));
                metier.ajouterProfesseur(prof);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        updateButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Professeur prof = metier.getProfesseur(id);
                if (prof != null) {
                    prof.setNom(nomField.getText());
                    prof.setPrenom(prenomField.getText());
                    prof.setCin(cinField.getText());
                    prof.setAdresse(adresseField.getText());
                    prof.setTelephone(telephoneField.getText());
                    prof.setEmail(emailField.getText());
                    prof.setDateRec(dateRecField.getText());
                    prof.setIdDep(Integer.parseInt(depField.getText()));
                    metier.modifierProfesseur(prof);
                    listButton.fire(); // Refresh the list
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                metier.deleteProfesseur(id);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        listButton.setOnAction(e -> {
            try {
                List<Professeur> professors = metier.getProfesseurs();
                professorTable.getItems().clear();
                professorTable.getItems().addAll(professors);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Form Layout for Professors
        HBox buttonsBox = new HBox(10, addButton, updateButton, deleteButton, listButton);
        buttonsBox.setPadding(new Insets(10));

        VBox formLayout = new VBox(10, idField, nomField, prenomField, cinField, adresseField,
                telephoneField, emailField, dateRecField, depField, buttonsBox);
        formLayout.setPadding(new Insets(10));
        return formLayout;
    }

    // Create Department Tab
    private VBox createDepartmentTab() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Title
        Label title = new Label("Department Management");

        // TableView Setup
        setupDepartmentTableView();

        // Form for CRUD operations
        VBox formLayout = createDepartmentForm();

        // Add Components to Main Layout
        vbox.getChildren().addAll(title, departmentTable, formLayout);
        return vbox;
    }

    // Set up TableView for Departments
    private void setupDepartmentTableView() {
        TableColumn<Departement, Integer> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Departement, String> nomColumn = new TableColumn<>("Department Name");
        nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));

        departmentTable.getColumns().addAll(idColumn, nomColumn);
    }

    // Create Form for Department CRUD Operations
    private VBox createDepartmentForm() {
        // Input Fields
        TextField idField = new TextField();
        idField.setPromptText("ID");

        TextField nomField = new TextField();
        nomField.setPromptText("Department Name");

        // Buttons
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button deleteButton = new Button("Delete");
        Button listButton = new Button("List");

        // Event Handlers for Departments
        addButton.setOnAction(e -> {
            try {
                Departement dep = new Departement(0, nomField.getText());
                metier.ajouterDepartement(dep);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        updateButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Departement dep = metier.getDepartement(id);
                if (dep != null) {
                    dep.setNom(nomField.getText());
                    metier.modifierDepartement(dep);
                    listButton.fire(); // Refresh the list
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        deleteButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                metier.deleteDepartement(id);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        listButton.setOnAction(e -> {
            try {
                List<Departement> departments = metier.getDepartements();
                departmentTable.getItems().clear();
                departmentTable.getItems().addAll(departments);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        // Form Layout for Departments
        HBox buttonsBox = new HBox(10, addButton, updateButton, deleteButton, listButton);
        buttonsBox.setPadding(new Insets(10));

        VBox formLayout = new VBox(10, idField, nomField, buttonsBox);
        formLayout.setPadding(new Insets(10));
        return formLayout;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
