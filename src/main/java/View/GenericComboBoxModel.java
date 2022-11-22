/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author marcosmedeiros
 * 
 * Adaptado de http://www.linhadecodigo.com.br/artigo/3664/comboboxmodel-em-java.aspx
 */
public abstract class GenericComboBoxModel extends AbstractListModel<Object> implements ComboBoxModel<Object> {
    protected ArrayList<Object> v_data;
    protected Object selected;

    public GenericComboBoxModel(List v_data) {
        this.v_data = (ArrayList) v_data;
    }

    @Override
    public Object getElementAt(int index) {
        return v_data.get(index);
    }
 
    @Override
    public int getSize() {
        return v_data.size();
    }
 
    @Override
    public Object getSelectedItem() {
        return this.selected;
    }
 
    @Override
    public void setSelectedItem(Object item) {
        this.selected = item;
    }
     
    public void addObject(Object estado) {
        v_data.add(estado);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
        setSelectedItem(v_data.get(getSize() - 1));
    }
    
    public void addListObject(List<Object> objects) {
        int primeiraLinha = getSize();
        v_data.addAll(objects);
        fireIntervalAdded(this, primeiraLinha, primeiraLinha  + objects.size());
        setSelectedItem(v_data.get(getSize() - 1));
    }
     
    public void removeObject() {
        v_data.remove(getSelectedItem());
        fireIntervalRemoved(this, 0, getSize() - 1);
        setSelectedItem(v_data.get(0));
    }
     
    public void clear() {
        v_data.clear();
        fireContentsChanged(this, 0, getSize() - 1);
    }
}
