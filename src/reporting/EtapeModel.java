package reporting;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EtapeModel extends AbstractTableModel {
	
    private ArrayList<Etape> mesEtapes;

    public EtapeModel(ArrayList<Etape> mesEtapes) {
        super();
        this.mesEtapes = mesEtapes;
      //  this.mesEtapes.add(new Etape("",1,1,1));
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return mesEtapes.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
    	Etape a = mesEtapes.get(rowIndex);
    	if(rowIndex == this.mesEtapes.size() - 1)
    	{
    		switch(columnIndex) {
            case 4 : return getPP();
            default : return "";
    	}
    	}
    		else {
        switch(columnIndex) {
        	case 0 : return a.getEmploye();
            case 1 : return a.getEt();
            case 2 : return a.getAccepte();
            case 3 : return a.getRefuse();
            case 4 : return a.getTa();
            case 5 : return a.getMd();
            default : return null;
        }
    		}
    }

    @Override
    public String getColumnName(int columnIndex ) {
        switch(columnIndex) {
            case 0 : return "Etape";
            case 1 : return "N E.T";
          	case 2 : return "Accepte";
            case 3 : return "Refuse";
          	case 4 : return "T.A (%)";
          	case 5 : return "M.D";
            default : return null;
        }
    }
    @Override
    public Class getColumnClass(int columnIndex ) {
        switch(columnIndex) {
            case 0 : return String.class;
            case 1 : return Integer.class;
            case 2 : return Integer.class;
            case 3 : return Integer.class;
            case 4 : return Integer.class;
            case 5 : return Integer.class;
            default : return Object.class;
        }
    }

	public Double getPP() {
		int sDt = 0;
		int sAccepte = 0;
		for(int i = 0; i < this.mesEtapes.size(); i++)
		{
			sDt+=this.mesEtapes.get(i).getEt();
			sAccepte = this.mesEtapes.get(i).getAccepte();
		}
	return ((float)sDt * 100.0 / (float)sAccepte);
	}
}


