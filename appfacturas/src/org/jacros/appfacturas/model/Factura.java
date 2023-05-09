package org.jacros.appfacturas.model;

import java.util.Date;

public class Factura {


    private  Integer folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private Integer indiceItems;
    public static final Integer MAX_ITEMS = 12;
    private static Integer ultimoFolio;


    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.items = new ItemFactura[Factura.MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public Integer getFolio() {

        return folio;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItems() {
        return items;
    }

    public void addItemFactura(ItemFactura item){
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public Double calcularTotal(){
        Double total = 0.0;
        for (int indice = 0; indice < items.length; indice++) {
            if (items[indice] == null){
                continue;
            }
            total += this.items[indice].calcularImporte();
        }
        return total;
    }
}
