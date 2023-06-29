package dawi.project.controller;

import java.io.File;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import dawi.project.entity.Detalle;
import dawi.project.entity.Entradas;
import dawi.project.entity.ProductoHasEntrada;
import dawi.project.entity.ProductoModel;
import dawi.project.entity.ProveedorModel;
import dawi.project.entity.Usuario;
import dawi.project.service.EntradaServices;
import dawi.project.service.ProductoService;
import dawi.project.service.ProveedorService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Controller
@RequestMapping("/entrada")
public class EntradaController {
	@Autowired
	private EntradaServices serEntrada;
	@Autowired
	private ProductoService serProducto;
	@Autowired
	private ProveedorService serProveedor;
	
	@RequestMapping("/lista")
	public String index(Model model) {
		model.addAttribute("proveedores", serProveedor.listarProveedor());
		model.addAttribute("productos", serProducto.listarProducto());
		model.addAttribute("entradas", serEntrada.listarEntradas());
		return "entrada";
	}
	
	@RequestMapping("/listaProductoJSON")
	@ResponseBody
	public List<ProductoModel> listaProductosNombre(String nombre) {
		return serProducto.buscarPorNombre(nombre);
	}
	
	@RequestMapping("/listaProveedorJSON")
	@ResponseBody
	public List<ProveedorModel> listaProveedorNombre(String nombre) {
		return serProveedor.buscarPorNombre(nombre);
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,@RequestParam("descripcion") String des,
							@RequestParam("precio") double pre,@RequestParam("cantidad") int can,
							HttpSession session) {
		//declarar un arreglo de obejtos de clase Detalle
		List<Detalle> lista=null;
		try {
			//validar si existe el atributo de tipo sesión "datos"
			if(session.getAttribute("datitos")==null)//no existe el atributo "datos"
				//crear el arreglo lista
				lista=new ArrayList<Detalle>();
			else//si existe el atributo "datos"
				//recuperar el atributo "datos" y guardarlo en lista
			lista=(List<Detalle>) session.getAttribute("datitos");
			
			//crear objeto de la clase Detalle con los valores de los parámetros del método adiconar
			Detalle det=new Detalle();
			det.setCodigo(cod);
			det.setDescripcion(des);
			det.setPrecio(pre);
			det.setCantidad(can);
			//adicionar objeto "det" dentro del arreglo "lista"
			lista.add(det);
			//crear o actualizar el atributo "datos"
			session.setAttribute("datitos", lista);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("proveedor") String proveedor,@RequestParam("fecha") String fec,
				@RequestParam("cantidad") int cantidad, @RequestParam("precio") double precio,
						@SessionAttribute("codigoUsuario") int codUsu,HttpSession session){
		System.out.println("se ejecuta el metodo grabar");
		try {
			//crear objeto de la entidad Boleta
			Entradas ent=new Entradas();
			ent.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fec));
			//separar	cli=5-Soto Mora Luis
			String sep[]=proveedor.split("-");
			ProveedorModel pro = new ProveedorModel();
			pro.setIdproveedor(Integer.parseInt(sep[0]));
			ent.setProveedorEntrada(pro);
			ent.setCantidad(cantidad);
			ent.setPrecioCompra(precio);
			//objeto de la entidad Usuario
			Usuario u=new Usuario();
			u.setIdalmacenero(codUsu);
			ent.setUsuario(u);
			//detalle  ---> listaMedicamentoHasBoleta
			//arreglo de objetos de la entidad MedicamentoHasBoleta
			List<ProductoHasEntrada> data=new ArrayList<ProductoHasEntrada>();
			//recuperar atributo de tipo sesión "datos"
			List<Detalle> lista=(List<Detalle>) session.getAttribute("datitos");
			//bucle sobre ""lista
			for(Detalle d:lista) {
				ProductoHasEntrada phe=new ProductoHasEntrada();
				System.out.println("el idproducto es " + d.getCodigo());
				//setear mhb con los valoes del objeto "d"
				phe.setPrecio(d.getPrecio());
				//
				ProductoModel p=new ProductoModel();
				p.setIdproducto(d.getCodigo());
				phe.setProducto(p);
				//enviar mhb al arreglo "data"
				data.add(phe);
			}
			//adicionar objeto "data" dentro "bol"
			ent.setListaProductoHasEntrada(data);
			//grabar boleta
			serEntrada.registrarEntrada(ent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/entrada/lista";
	}
	
	@RequestMapping("/reporteEntradas")
	public void reporteCliente(HttpServletResponse response,@RequestParam("proveedor") int cod) {
		try {
			//invocar al método listarTodos
			List<Entradas> lista=serEntrada.listarPorProveedor(cod);
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:reporteEntrada.jrxml");
			//crear objeto de la clase JasperReport y manipular el objeto file
			JasperReport jasper=JasperCompileManager.compileReport(file.getAbsolutePath());
			//origen de datos "manipular lista"
			JRBeanCollectionDataSource origen=new JRBeanCollectionDataSource(lista);
			//crear reporte
			JasperPrint jasperPrint=JasperFillManager.fillReport(jasper,null,origen);
			//salida del reporte en formato PDF
			response.setContentType("application/pdf");
			//
			OutputStream salida=response.getOutputStream();
			//exportar a pdf
			JasperExportManager.exportReportToPdfStream(jasperPrint,salida);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
