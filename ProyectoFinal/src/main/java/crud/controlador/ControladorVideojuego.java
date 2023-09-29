package crud.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import crud.modelo.DAOVideojuego;
import crud.modelo.DTOVideojuego;
import crud.vista.VMenuVideojuego;

public class ControladorVideojuego {
	private VMenuVideojuego vista;
	private DAOVideojuego modelo;

	public ControladorVideojuego(VMenuVideojuego v, DAOVideojuego dao) {
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
	}

	private class CActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTOVideojuego v = modelo.read(Integer.valueOf(vista.idTxt.getText()));
				if (v != null) {
					System.out.println(v);
					vista.desarrolladorTxt.setText(v.getIdDes()+"");
					vista.nombreTxt.setText(v.getNombre());
					vista.precioTxt.setText(v.getPrecio()+"");
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

	private class AActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				DTOVideojuego juego = new DTOVideojuego(Integer.valueOf(vista.idTxt.getText()),
						Integer.valueOf(vista.desarrolladorTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()),
						Double.valueOf(vista.precioTxt.getText()));
				if (juego != null) {
					modelo.insert(juego);
					vista.consulta.setEnabled(false);
					vista.alta.setEnabled(true);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);
					JOptionPane.showMessageDialog(vista, "Videojuego insertado correctamente");
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
				DTOVideojuego juego = new DTOVideojuego(Integer.valueOf(vista.idTxt.getText()),
						Integer.valueOf(vista.desarrolladorTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()),
						Double.valueOf(vista.precioTxt.getText()));
				if (juego != null) {
					modelo.update(juego);
					vista.consulta.setEnabled(false);
					vista.alta.setEnabled(false);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);
					JOptionPane.showMessageDialog(vista, "Videojuego modificado correctamente");
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
				DTOVideojuego juego = new DTOVideojuego(Integer.valueOf(vista.idTxt.getText()),
						Integer.valueOf(vista.desarrolladorTxt.getText()),
						String.valueOf(vista.nombreTxt.getText()),
						Double.valueOf(vista.precioTxt.getText()));
				int venta = JOptionPane.showConfirmDialog(null, "¿Seguro?", "Borrado", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE);
				if (venta == 0) {
					if (juego != null) {
						modelo.delete(juego.getId());
						vista.consulta.setEnabled(false);
						vista.alta.setEnabled(false);
						vista.baja.setEnabled(true);
						vista.modifica.setEnabled(false);
						JOptionPane.showMessageDialog(vista, "Videojuego eliminado correctamente");
					}
				} else {
					JOptionPane.showMessageDialog(vista, "La operación de borrado ha sido cancelada");
					vista.idTxt.setText(null);
					vista.desarrolladorTxt.setText(null);
					vista.nombreTxt.setText(null);
					vista.precioTxt.setText(null);

					vista.consulta.setEnabled(true);
					vista.alta.setEnabled(true);
					vista.baja.setEnabled(true);
					vista.modifica.setEnabled(true);

					vista.idTxt.setEnabled(true);
					vista.desarrolladorTxt.setEnabled(true);
					vista.nombreTxt.setEnabled(true);
					vista.precioTxt.setEnabled(true);
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

}
