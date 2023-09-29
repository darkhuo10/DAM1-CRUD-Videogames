package crud.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import crud.modelo.DAODesarrollador;
import crud.modelo.DTODesarrollador;
import crud.modelo.DTOVideojuego;
import crud.vista.VMenuDesarrollador;

public class ControladorDesarrollador {
	private VMenuDesarrollador vista;
	private DAODesarrollador modelo;

	public ControladorDesarrollador(VMenuDesarrollador v, DAODesarrollador dao) {
		super();
		this.vista = v;
		this.modelo = dao;
		setListeners();
		vista.setVisible(true);

	}

	private void setListeners() {
		vista.consulta.addActionListener(new CActionListener());
		vista.alta.addActionListener(new AActionListener());
		vista.modifica.addActionListener(new MActionListener());
		vista.baja.addActionListener(new BActionListener());
		vista.juegos.addActionListener(new JActionListener());
	}

	private class JActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				List<DTOVideojuego> juegos = modelo.readJuegos(Integer.valueOf(vista.idTxt.getText()));

				if (vista.idTxt.getText()!= null) {
					vista.textoR.setText(juegos.toString());
					vista.consulta.setEnabled(false);
				} else {
					vista.modifica.setEnabled(false);
					vista.baja.setEnabled(false);
					vista.consulta.setEnabled(false);
					JOptionPane.showMessageDialog(vista, "Id no encontrado");
				}

			} catch (

			NumberFormatException e1) {
				JOptionPane.showMessageDialog(vista, "Incorrecto");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vista, "Error:" + e1.getMessage());
			}
		}
	}

	private class AActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTODesarrollador des = new DTODesarrollador(Integer.valueOf(vista.idTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()), String.valueOf(vista.paisTxt.getText()),
						String.valueOf(vista.webTxt.getText()));
				if (des != null) {
					modelo.insert(des);
					vista.consulta.setEnabled(false);
					vista.alta.setEnabled(true);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);
					JOptionPane.showMessageDialog(vista, "Desarrollador insertado correctamente");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vista, "Error de inserción: " + e1.getMessage());
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			}
		}
	}

	private class MActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTODesarrollador des = new DTODesarrollador(Integer.valueOf(vista.idTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()), String.valueOf(vista.paisTxt.getText()),
						String.valueOf(vista.webTxt.getText()));
				if (des != null) {
					modelo.update(des);
					vista.consulta.setEnabled(false);
					vista.alta.setEnabled(false);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);
					JOptionPane.showMessageDialog(vista, "Desarrollador modificado correctamente");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vista, "Error en la modificación: " + e1.getMessage());
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			}
		}
	}

	private class BActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTODesarrollador des = new DTODesarrollador(Integer.valueOf(vista.idTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()), String.valueOf(vista.paisTxt.getText()),
						String.valueOf(vista.webTxt.getText()));
				int venta = JOptionPane.showConfirmDialog(null, "¿Seguro?", "Borrado", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (venta == 0) {
					if (des != null) {
						modelo.delete(des.getId());
						vista.consulta.setEnabled(false);
						vista.alta.setEnabled(false);
						vista.baja.setEnabled(true);
						vista.modifica.setEnabled(false);
						JOptionPane.showMessageDialog(vista, "Desarrollador eliminado correctamente");
					}
				} else {
					JOptionPane.showMessageDialog(vista, "La operación de borrado ha sido cancelada");
					vista.idTxt.setText(null);
					vista.nombreTxt.setText(null);
					vista.paisTxt.setText(null);
					vista.webTxt.setText(null);

					vista.consulta.setEnabled(true);
					vista.alta.setEnabled(true);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);

					vista.idTxt.setEnabled(true);
					vista.nombreTxt.setEnabled(true);
					vista.paisTxt.setEnabled(true);
					vista.webTxt.setEnabled(true);

				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			} catch (SQLException e1) {

				JOptionPane.showMessageDialog(vista, "Error en la eliminación: " + e1.getMessage());
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(vista, "Ningún campo debe ser nulo");
			}
		}
	}

	private class CActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTODesarrollador des = modelo.read(Integer.valueOf(vista.idTxt.getText()));
				if (des != null) {
					System.out.println(des);
					vista.nombreTxt.setText(des.getNombre());
					vista.paisTxt.setText(des.getPais());
					vista.webTxt.setText(des.getWeb());
					vista.alta.setEnabled(false);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);
					vista.consulta.setEnabled(false);
				} else {
					vista.modifica.setEnabled(false);
					vista.baja.setEnabled(false);
					vista.consulta.setEnabled(false);
					JOptionPane.showMessageDialog(vista, "Id no encontrado");
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(vista, "Incorrecto");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(vista, "Error:" + e1.getMessage());
			}
		}
	}

}
