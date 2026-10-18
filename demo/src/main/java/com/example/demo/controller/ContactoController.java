package com.example.demo.controller;

import com.example.demo.model.ContactoModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ContactoController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtComentario;

    @FXML
    private TableView<ContactoModel> tablaAgenda;

    @FXML
    private TableColumn<ContactoModel, String> colNombre;

    @FXML
    private TableColumn<ContactoModel, String> colCorreo;
    @FXML
    private TableColumn<ContactoModel, String> colNumero;
    @FXML
    private TableColumn<ContactoModel, String> colComentario;

    private final ObservableList<ContactoModel> agenda =
            FXCollections.observableArrayList();

    private void configurarTable() {
        colNombre.setCellValueFactory(
                dato -> new javafx.beans.property.SimpleStringProperty(
                        dato.getValue().getNombre())
        );

        colCorreo.setCellValueFactory(
                dato -> new javafx.beans.property.SimpleStringProperty(
                        dato.getValue().getCorreo())
        );

        colNumero.setCellValueFactory(
                dato -> new javafx.beans.property.SimpleStringProperty(
                        dato.getValue().getNumero())
        );

        colComentario.setCellValueFactory(
                dato -> new javafx.beans.property.SimpleStringProperty(
                        dato.getValue().getComentario())
        );
    }

    @FXML
    private void limpiarCampos() {
        txtNombre.clear();
        txtCorreo.clear();
        txtNumero.clear();
        txtComentario.clear();

        txtNombre.requestFocus();

    }

    @FXML
    public void agregarContacto() {
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String numero = txtNumero.getText();
        String comentario = txtComentario.getText();

        if (nombre.isEmpty() || correo.isEmpty() || numero.isEmpty() || comentario.isEmpty()) {
            return;
        }
        ContactoModel contacto = new ContactoModel(
                nombre,
                correo,
                numero,
                comentario
        );
        agenda.add(contacto);

        limpiarCampos();
    }

    @FXML
    private void eliminarContacto() {
        ContactoModel seleccionado = tablaAgenda.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            agenda.remove(seleccionado);
        }

    }

    @FXML
    private void seleccionarContacto() {
        ContactoModel selecionado = tablaAgenda.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            txtNombre.setText(selecionado.getNombre());
            txtCorreo.setText(selecionado.getCorreo());
            txtNumero.setText(selecionado.getNumero());
            txtComentario.setText(selecionado.getComentario());
        }
    }

    @FXML
    private void actualizarContacto() {
        ContactoModel seleccionado = tablaAgenda.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            return;
        }
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        String numero = txtNumero.getText();
        String comentario = txtComentario.getText();

        if (nombre.isEmpty() || correo.isEmpty() || numero.isEmpty() || comentario.isEmpty()) {
            return;
        }
        seleccionado.setNombre(nombre);
        seleccionado.setCorreo(correo);
        seleccionado.setNumero(numero);
        seleccionado.setComentario(comentario);

        tablaAgenda.refresh();

        limpiarCampos();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        configurarTable();
        tablaAgenda.setItems(agenda);
        tablaAgenda.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        txtNombre.setText(seleccionado.getNombre());
                        txtCorreo.setText(seleccionado.getCorreo());
                        txtNumero.setText(seleccionado.getNumero());
                        txtComentario.setText(seleccionado.getComentario());
                    }
                });

    }


}
