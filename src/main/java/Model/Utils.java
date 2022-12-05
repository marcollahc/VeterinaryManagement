package Model;

import javax.swing.JComboBox;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author marcos-medeiros
 */
public class Utils {
    public static int getComboBoxIdValue(String selectedId) {
        String[] id_key_info = selectedId.split(" | ");
        return Integer.valueOf(id_key_info[0]);
    }
    
    public static void setComboBoxSelectedValue(JComboBox combobox, String find) {
        for (int i = 0; i< combobox.getModel().getSize(); i++) {
            if (combobox.getItemAt(i).toString().indexOf(find) > -1) {
                combobox.setSelectedIndex(i);
                break;
            }
        }
    }
}
