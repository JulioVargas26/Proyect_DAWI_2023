package dawi.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import dawi.project.entity.ProveedorModel;
import dawi.project.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService serProv;

	@RequestMapping("/lista")
	public String index(Model model) {

		model.addAttribute("proveedor", serProv.listarProveedor());
		return "proveedor";
	}
	
	@RequestMapping("/grabar")
	public String grabarModel(@RequestParam ("idproveedor") Integer cod, 
			                  @RequestParam ("nombre") String nom,
			                  @RequestParam ("ruc") String ruc,
			                  @RequestParam ("direccion") String direc,
			                  RedirectAttributes redirect) {
		try {

			ProveedorModel sm = new ProveedorModel();

			sm.setNombre(nom);
			sm.setRuc(ruc);
			sm.setDireccion(direc);

			if (cod == 0) {
				serProv.grabar(sm);
				redirect.addFlashAttribute("MENSAJE", "PROVEEDOR REGISTRADO");
			} else {
				sm.setIdproveedor(cod);
				serProv.actualizar(sm);
				redirect.addFlashAttribute("MENSAJE", "PROVEEDOR ACTUALIZADO");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			redirect.addFlashAttribute("mensaje", "ERROR EN EL REGISTRO");
			e.printStackTrace();
		}
		
		return "redirect:/proveedor/lista";
	
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public ProveedorModel buscarProv(@RequestParam("idproveedor")int cod) {
		
		return serProv.buscar(cod);
	
	}
	
	@RequestMapping("/eliminar")
	public String eliminarProv(@RequestParam("idproveedor")int cod, RedirectAttributes redirect) {
		
		try {
			serProv.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado correctamente");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación de proveedor");
			e.printStackTrace();
		}
		return "redirect:/proveedor/lista";
	}

}
