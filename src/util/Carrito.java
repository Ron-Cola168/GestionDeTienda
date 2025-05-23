package util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private static class ItemCarrito {
        String nombre;
        double precio;
        
        public ItemCarrito(String nombre, double precio) {
            this.nombre = nombre;
            this.precio = precio;
        }
    }
    
    private List<ItemCarrito> items;
    private JTextArea displayArea;
    private JLabel totalLabel;
    
    public Carrito(JTextArea display, JLabel totalLabel) {
        this.items = new ArrayList<>();
        this.displayArea = display;
        this.totalLabel = totalLabel;
    }
    
    public void agregarItem(String nombre, double precio) {
        items.add(new ItemCarrito(nombre, precio));
        actualizarDisplay();
    }
    
    private void actualizarDisplay() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        
        for (ItemCarrito item : items) {
            sb.append(item.nombre).append(" - ").append(String.format("%.2f€", item.precio)).append("\n");
            total += item.precio;
        }
        
        displayArea.setText(sb.toString());
        totalLabel.setText(String.format("%.2f €", total));
    }
}