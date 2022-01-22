package ec.edu.uce.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;

@Repository
public class RecetaRepoImpl implements IRecetaRepo{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertarPReceta(Receta receta) {
		// TODO Auto-generated method stub
		Object[] datosAInsertar=new Object[] {receta.getId(),receta.getIndicaciones(),receta.getMedicamentos()};
		this.jdbcTemplate.update("insert into receta(id,indicaciones,medicamentos) values(?,?,?)",datosAInsertar);
	}

	@Override
	public Receta buscarPaciente(Integer id) {
		Object[] datoABuscar =new Object[] {id};
		return this.jdbcTemplate.queryForObject("select * from receta where id=?",datoABuscar,new BeanPropertyRowMapper<Receta>(Receta.class));
	}

	@Override
	public void actualizarReceta(Receta receta) {
		// TODO Auto-generated method stub
		Object[] datosAActualizar =new Object[] {receta.getId(),receta.getMedicamentos(),receta.getIndicaciones(),receta.getId()};
		this.jdbcTemplate.update("UPDATE receta SET id = ?,indicaciones=?,medicamentos=? WHERE id = ?;",datosAActualizar);
	}

	@Override
	public void borrarReceta(Integer id) {
		// TODO Auto-generated method stub
		Object[] datoABorrar =new Object[] {id};
		this.jdbcTemplate.update("delete from receta where id=?",datoABorrar);
	}

}
