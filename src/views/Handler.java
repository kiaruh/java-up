package views;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import bo.*;
import dbImpl.*;
import entities.*;
import exceptions.ServiceException;
import views.asignacion.*;
import views.empleado.*;
import views.grupo.*;
import views.tarea.*;
import views.usuario.*;

public class Handler {

	private JFrame frame;
	private LoginPanel login;
	@SuppressWarnings("unused")
	private Usuario session;
	private UsuarioService usuarioService;
	private EmpleadoService empleadoService;
	private GrupoService grupoService;
	private TareaService tareaService;
	private AsignacionService asignacionService;
	
	public Handler() {
		usuarioService = new UsuarioService();
		empleadoService = new EmpleadoService();
		grupoService = new GrupoService();
		tareaService = new TareaService();
		asignacionService = new AsignacionService();
	}
	
	public void init() {
		asignacionService.setDAOImpl(new AsignacionDAODBImpl());
		usuarioService.setDAOImpl(new UsuarioDAODBImpl());
		empleadoService.setDAOImpl(new EmpleadoDAODBImpl());
		grupoService.setDAOImpl(new GrupoDAODBImpl());
		tareaService.setDAOImpl(new TareaDAODBImpl());
		frame = new JFrame("Sistema de Horas");
		frame.setSize(450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login = new LoginPanel(this);
		frame.add(login);
		frame.setVisible(true);

	}
	
	//Login
	public void enviarSubmit(String user, String pass) throws ServiceException{
		try{
			Usuario logeado =usuarioService.checkPassword(user, pass);
			this.session = logeado;
			this.login.setVisible(false);
			frame.getContentPane().add(new MainMenuPanel(this));
			frame.getContentPane().validate();		
			}catch(ServiceException e1){
				mostrarAlert("Usuario o Password incorrecto");
			}
	}
	
	//LogOut	
	public void logout(){
		this.session = null;
		frame.getContentPane().removeAll();
		this.login.setVisible(true);
		frame.getContentPane().add(login);
		frame.getContentPane().validate();	
	}
	
	//Main menu
	public void MenuPanel(){
		frame.getContentPane().removeAll();
		//this.menu.setVisible(true);
		frame.getContentPane().add(new MainMenuPanel(this));
		frame.getContentPane().validate();
	}
	
	//Messenger
	public void mostrarAlert(String msg){
		JOptionPane.showMessageDialog(null, msg);		
	};
	
	//Usuario
	public void UsuarioPanel(){
		try {
			
			frame.getContentPane().add(new UsuarioMainPanel(this,usuarioService.getAllUsuarios()));
		} catch (ServiceException e1) {
			mostrarAlert("No se pudo buscar a los usuarios");
		}
	}

	public void AltaUsuarioPanel(){
		frame.getContentPane().add(new NewUsuarioPanel(this));
	}

	public void ModiUsuarioPanel(String username){
		try {
			frame.getContentPane().add(new UsuarioEditPanel(this, usuarioService.getUsuarioByUsername(username)));
		} catch (ServiceException e2) {
			mostrarAlert("No se pudo modificar");
		}

	}
	
	public void DarAltaUsuario(String username, String pw) throws ServiceException{
		Usuario u = new Usuario();
		u.setUsername(username);
		u.setPassword(pw);
		
		if(usuarioService.getUsuarioByUsername(username)==null){
			usuarioService.insertarUsuario(u);
			mostrarAlert("Se creo con exito");
		}
		else
			mostrarAlert("Usuario ya existe");

	}
	
	public void BorrarUsuario(String username) throws ServiceException {
		
		if(usuarioService.getUsuarioByUsername(username)!=null){
			if(!username.equals("admin")) {
				usuarioService.deleteUsuarioByUsername(username);
				mostrarAlert("Se borro con exito");
			} else {
				mostrarAlert("No se puede eliminar al \"admin\"");
			}
			try {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new UsuarioMainPanel(this,usuarioService.getAllUsuarios()));
				frame.getContentPane().validate();				
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo buscar a los usuarios");
			}
		}
		else
			mostrarAlert("Empleado no existe");
	}
	
	public void ModiUsuario(Usuario u) throws Exception{
					
		usuarioService.updateUsuario(u);
		mostrarAlert("Se modifico con exito");
		}
	
	//Empleado
	public void EmpleadoPanel(){
		try {
			frame.getContentPane().add(new EmpleadoMainPanel(this,empleadoService.getAllEmpleado()));
		} catch (ServiceException e1) {
			mostrarAlert("No se pudo buscar a los empleados");
		}
	}

	public void AltaEmpleadoPanel(){
		frame.getContentPane().add(new NewEmpleadoPanel(this));
	}

	public void ModiEmpleadoPanel(int legajo){
		try {
			frame.getContentPane().add(new EmpleadoEditPanel(this, empleadoService.getEmpleadoByLegajo(legajo)));
		} catch (ServiceException e2) {
			mostrarAlert("No se pudo modificar");
		}

	}

	
	public void DarAltaEmpleado(int dni, int legajo, String nombre, String sexo) throws ServiceException{
		Empleado u = new Empleado();
		u.setLegajo(legajo);
		u.setDni(dni);
		u.setNombre(nombre);
		u.setSexo(sexo);
		if(empleadoService.getEmpleadoByLegajo(legajo)==null){
			empleadoService.insertarEmpleado(u);
			mostrarAlert("Se creo con exito");
		}
		else
			mostrarAlert("Empleado ya existe");

	}
	
	public void BorrarEmpleado(int legajo) throws ServiceException {
		if(empleadoService.getEmpleadoByLegajo(legajo)!=null){
			empleadoService.deleteEmpleadoByLegajo(legajo);
			mostrarAlert("Se borro con exito");
			try {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new EmpleadoMainPanel(this,empleadoService.getAllEmpleado()));
				frame.getContentPane().validate();				
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo buscar a los empleados");
			}
		}
		else
			mostrarAlert("Empleado no existe");
	}
	
	public void ModiEmpleado(Empleado u) throws Exception{
					
		empleadoService.updateEmpleado(u);
		mostrarAlert("Se modifico con exito");
		}
	
	//Grupo
	public void GrupoPanel(){
		try {
			
			frame.getContentPane().add(new GrupoMainPanel(this,grupoService.getAllGrupo()));
		} catch (ServiceException e1) {
			mostrarAlert("No se pudo buscar a los empleados");
		}
	}

	public void AltaGrupoPanel(){
		frame.getContentPane().add(new NewGrupoPanel(this));
	}
	
	public void DarAltaGrupo(int id_grupo) throws ServiceException{
		Grupo u = new Grupo();
		u.setId(id_grupo);
		
		if(grupoService.getGrupoById(id_grupo)==null){
			grupoService.insertarGrupo(u);
			mostrarAlert("Se creo con exito");
		}
		else
			mostrarAlert("Grupo ya existe");

	}
	
	public void BorrarGrupo(int id_grupo) throws ServiceException {
		
		if(grupoService.getGrupoById(id_grupo)!=null){
			grupoService.deleteGrupoById(id_grupo);
			mostrarAlert("Se borro con exito");
			
			try {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new GrupoMainPanel(this,grupoService.getAllGrupo()));
				frame.getContentPane().validate();				
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo buscar a los grupos");
			}
		}
		else
			mostrarAlert("Grupo no existe");
	}
	

	//Tarea
	public void TareaPanel(){
		try {
			
			frame.getContentPane().add(new TareaMainPanel(this,tareaService.getAllTarea()));
		} catch (ServiceException e1) {
			mostrarAlert("No se pudo buscar a las tareas");
		}
	}

	public void AltaTareaPanel(){
		frame.getContentPane().add(new NewTareaPanel(this));
	}

	public void ModiTareaPanel(int id_tarea){
		try {
			frame.getContentPane().add(new TareaEditPanel(this,tareaService.getTareaById(id_tarea)));
		} catch (ServiceException e2) {
			mostrarAlert("No se pudo modificar");
		}

	}
	
	public void DarAltaTarea(int id_tarea, int id_grupo, String desc, int hora) throws ServiceException{
		Tarea u = new Tarea();
		u.setId(id_tarea);
		u.setGrupo(id_grupo);
		u.setDesc(desc);
		u.setHora(hora);
		
		
		if(tareaService.getTareaById(id_tarea)==null){
			if(grupoService.getGrupoById(id_grupo)!=null){
				tareaService.insertarTarea(u);
				mostrarAlert("Se creo con exito");
			} else {
				mostrarAlert("Grupo no existe");
			}
		} else {
			mostrarAlert("Tarea ya existe");
		}
	}
	
	public void BorrarTarea(int id_tarea) throws ServiceException {
		
		if(tareaService.getTareaById(id_tarea)!=null){
			tareaService.deleteTareaById(id_tarea);
			mostrarAlert("Se borro con exito");
			List<Tarea> lista;
			try {
				lista = tareaService.getAllTarea();
				frame.getContentPane().removeAll();
				frame.getContentPane().add(new TareaMainPanel(this,lista));
				frame.getContentPane().validate();				
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo buscar a las tareas");
			}
		}
		else
			mostrarAlert("Tarea no existe");
	}
	
	public void ModiTarea(Tarea u) throws Exception{
					
		tareaService.updateTarea(u);
		mostrarAlert("Se modifico con exito");
		}
	
	//Asignacion
		public void AsignacionPanel(int id, boolean flag){
			try {
				
				if(flag) {
					frame.getContentPane().add(new AsignacionList(this,asignacionService.getAsignacionByLegajo(id),id,flag));
				} else {
					frame.getContentPane().add(new AsignacionList(this,asignacionService.getAsignacionByGrupo(id),id,flag));
				}
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo buscar a las asignaciones");
			}
		}

		public void AltaAsignacionPanel(int id, boolean flag){
			if(flag) {
				frame.getContentPane().add(new NewAsignaEmpleadoPanel(this,id));
			} else {
				frame.getContentPane().add(new NewAsignaGrupoPanel(this,id));
			}
		}

		public void DarAltaAsignacion(int legajo, int id_grupo) throws ServiceException{
			Asignacion u = new Asignacion();
			u.setEmpleado(legajo);
			u.setGrupo(id_grupo);
			
			
			
			if(asignacionService.getAsignacion(legajo,id_grupo).getEmpleado()==0 && asignacionService.getAsignacion(legajo,id_grupo).getGrupo()==0){
				if(empleadoService.getEmpleadoByLegajo(legajo)!=null && grupoService.getGrupoById(id_grupo)!=null) {
					asignacionService.insertarAsignacion(u);
					mostrarAlert("Se creo con exito");
				} else {
					mostrarAlert("Por favor verifique los datos");
				}
			}
			else {
				mostrarAlert("Asignacion ya existe");
			}
		}
		
		public void BorrarAsignacion(int legajo, int id_grupo, boolean flag) throws ServiceException {
			
			if(asignacionService.getAsignacion(legajo,id_grupo)!=null){
				asignacionService.deleteAsignacion(legajo, id_grupo);
				mostrarAlert("Se borro con exito");
				try {
					if(flag) {
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new AsignacionList(this,asignacionService.getAsignacionByLegajo(legajo),legajo,flag));
						frame.getContentPane().validate();	
					} else {
						frame.getContentPane().removeAll();
						frame.getContentPane().add(new AsignacionList(this,asignacionService.getAsignacionByGrupo(id_grupo),id_grupo,flag));
						frame.getContentPane().validate();	
					}
				} catch (ServiceException e1) {
					mostrarAlert("No se pudo buscar a las tareas");
				}
			}
			else
				mostrarAlert("Tarea no existe");
		}
		
		//Calcular Horas
		public void HoraPanel(){
			try {
				
				frame.getContentPane().add(new HoraListPanel(this,empleadoService.getAllHora()));
				//ConsultarHoraPanel(e,empleadoService.getAllHora());
			} catch (ServiceException e1) {
				mostrarAlert("No se pudo calcular las horas");
			}
		}
	
}
