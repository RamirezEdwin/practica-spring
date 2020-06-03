package com.proyectospringedwin.proyectospringedwin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyectospringedwin.proyectospringedwin.models.entity.Ciudad;
import com.proyectospringedwin.proyectospringedwin.models.entity.Cliente;
import com.proyectospringedwin.proyectospringedwin.service.ICiudadService;
import com.proyectospringedwin.proyectospringedwin.service.IClienteService;

@Controller
@RequestMapping("/views/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	
	@Autowired
	private ICiudadService ciudadSercice; 
	
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Cliente> listadoClientes = clienteService.listarTodos();
		
		
		model.addAttribute("titulo", "lista de clientes");
		model.addAttribute("clientes", listadoClientes);
		return "/views/clientes/listar";
		
		
		
	}
	
 @GetMapping("/create")
	public String crear(Model model) {
	 
	 
	 Cliente cliente = new  Cliente();
	 List<Ciudad> listCiudades = ciudadSercice.listaCiudades();
	 
	 
	 model.addAttribute("titulo", "formulario:nuevo cliente");
	 model.addAttribute("cliente", cliente);
	 model.addAttribute("ciudades", listCiudades);
		
		
		return "/views/clientes/frmCrear";
	}
 
 
 @PostMapping("/save")
 public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model) {
	 List<Ciudad> listCiudades = ciudadSercice.listaCiudades();
	 
	 if (result.hasErrors()) {
		 
		 model.addAttribute("titulo", "formulario:nuevo cliente");
		 model.addAttribute("cliente", cliente);
		 model.addAttribute("ciudades", listCiudades);
			
			
			return "/views/clientes/frmCrear";
		
	}
	 
	 
	 clienteService.guardar(cliente);
		/* System.out.println("Cliente guardado con exito!"); */
	 
	 
	 
	 return "redirect:/views/clientes/";
 }
 
 
 @GetMapping("/edit/{id}")
	public String editar(@PathVariable("id")Long idCliente,  Model model) {
	 
	 
	 Cliente cliente = clienteService.buscarPorId(idCliente);
	 List<Ciudad> listCiudades = ciudadSercice.listaCiudades();
	 
	 
	 model.addAttribute("titulo", "formulario:editar cliente");
	 model.addAttribute("cliente", cliente);
	 model.addAttribute("ciudades", listCiudades);
		
		
		return "/views/clientes/frmCrear";
	}


 @GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id")Long idCliente) {
	 
	 
	 clienteService.eliminar(idCliente);
		/* System.out.println("Registro Eliminado con exito"); */
		
		
		return "redirect:/views/clientes/";
	}

}
