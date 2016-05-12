/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pds.graphics;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nodaro
 */
public class ResultSetTableModel extends AbstractTableModel {
  private final ResultSetMetaData rsmd;
  private final List<Row> rows;

  public ResultSetTableModel(ResultSetMetaData rsmd) {
    this.rsmd = rsmd;
    this.rows = new ArrayList<Row>();
  }

  public int getRowCount() {
    return rows.size();
  }

  public int getColumnCount() {
    return rsmd.getColumnCount();
  }

  public Object getValue(int row, int column) {
    return rows.get(row).getValue(column);
  }

  public String getColumnName(int col) {
    return rsmd.getColumnName(col - 1); // ResultSetMetaData columns indexed from 1, not 0.
  }

  public Class<?> getColumnClass(int col) {
    // TODO: Convert SQL type (int) returned by ResultSetMetaData.getType(col) to Java Class.
  }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

// SwingWorker implementation
new SwingWorker<Void, Row>() {
  public Void doInBackground() {
    // TODO: Process ResultSet and create Rows.  Call publish() for every N rows created.
  }

  protected void process(Row... chunks) {
    // TODO: Add to ResultSetTableModel List and fire TableEvent.
  }
}.execute();