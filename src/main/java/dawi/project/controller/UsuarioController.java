package dawi.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import dawi.project.entity.Enlace;
import dawi.project.entity.Usuario;
import dawi.project.service.UsuarioServices;

@SessionAttributes({"datosUsuario","ENLACES", "codigoUsuario", "datitos"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicio;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/intranet")
	public String intranet(Authentication auth, Model model) {
		String vLogin=auth.getName();
		//invocar al método validarSesion
		Usuario bean=servicio.validarSesion(vLogin);
		//invocar al método enlacesDelUsuario
		List<Enlace> lista=servicio.enlacesDelUsuario(bean.getRol().getIdrol());
		//asignar valor a los atributos de tipo sesión
		model.addAttribute("datosUsuario",bean.getNombre());
		model.addAttribute("ENLACES",lista);
		model.addAttribute("codigoUsuario", bean.getIdalmacenero());
		return "intranet";
	}
}
