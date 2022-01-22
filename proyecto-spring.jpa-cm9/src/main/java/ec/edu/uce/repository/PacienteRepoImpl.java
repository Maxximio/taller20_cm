package ec.edu.uce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

import ec.edu.uce.modelo.Paciente;

@Repository
public class PacienteRepoImpl implements IPacienteRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		//insert into paciente(id,nombre,apellido, edad) values(1,'Edison','Cayambe',32)
		//arreglo de datos a insertar
		Object[] datosAInsertar=new Object[] {paciente.getId(),paciente.getNombre(),paciente.getApellido(),paciente.getEdad()};
		this.jdbcTemplate.update("insert into paciente(id,nombre,apellido, edad) values(?,?,?,?)",datosAInsertar);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		Object[] datosAActualizar =new Object[] {paciente.getId(),paciente.getNombre(),paciente.getApellido(),paciente.getEdad(),paciente.getId()};
		this.jdbcTemplate.update("UPDATE paciente SET id = ?,nombre=?,apellido=?,edad=? WHERE id = ?;",datosAActualizar);
	}

	@Override
	public void borrarPaciente(Integer id) {
		Object[] datoABorrar =new Object[] {id};
		this.jdbcTemplate.update("delete from paciente where id=?",datoABorrar);
	}

	@Override
	public Paciente buscarPaciente(Integer id) {
		Object[] datoABuscar =new Object[] {id};
		return this.jdbcTemplate.queryForObject("select * from paciente where id=?",datoABuscar,new BeanPropertyRowMapper<Paciente>(Paciente.class));
	}

}
