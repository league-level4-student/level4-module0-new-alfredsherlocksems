package _04_Data_Type_Option_Pane;

import javax.swing.JOptionPane;

public class DataTypeOptionPane {
    public static void main(String[] args) {

        DataType[] dataTypes;
        dataTypes = DataType.values();
        int answer = JOptionPane.showOptionDialog(null, "Stuff", "DataTypes", 0, 3, null, dataTypes, null);
        switch (dataTypes[answer]) {
        case BYTE:
        	JOptionPane.showMessageDialog(null, "" + DataType.BYTE.getBits());
        	break;
        case SHORT:
        	JOptionPane.showMessageDialog(null, "" + DataType.SHORT.getBits());
        	break;
        case INT:
        	JOptionPane.showMessageDialog(null, "" + DataType.INT.getBits());
        	break;
        case LONG:
        	JOptionPane.showMessageDialog(null, "" + DataType.LONG.getBits());
        	break;
        case FLOAT:
        	JOptionPane.showMessageDialog(null, "" + DataType.FLOAT.getBits());
        	break;
        case DOUBLE:
        	JOptionPane.showMessageDialog(null, "" + DataType.DOUBLE.getBits());
        	break;
        case BOOLEAN:
        	JOptionPane.showMessageDialog(null, "" + DataType.BOOLEAN.getBits());
        	break;
        case CHAR:
        	JOptionPane.showMessageDialog(null, "" + DataType.CHAR.getBits());
        	break;
        }
        
       
    }
    enum DataType {
    	BYTE(8), SHORT(16), INT(32), LONG(64), FLOAT(32), DOUBLE(64), BOOLEAN(2), CHAR(16);
    	public int bits;
    
    	private DataType(int bits) {
    		this.bits = bits;
    	}
    	public int getBits() {
    		return bits;
    	}
    }
 }
