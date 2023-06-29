package dawi.project.controller;

import java.io.File;
import java.io.OutputStream;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dawi.project.entity.CategoriaModel;
import dawi.project.entity.Entradas;
import dawi.project.entity.MarcaModel;
import dawi.project.entity.ProductoModel;
import dawi.project.service.CategoriaService;
import dawi.project.service.MarcaService;
import dawi.project.service.ProductoService;
import dawi.project.service.ProveedorService;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService serProd;
	
	@Autowired
	private ProveedorService serProv;

	@Autowired
	private MarcaService serMarc;
	
	@Autowired
	private CategoriaService serCate;

	@RequestMapping("/lista")
	public String index(Model model) {
		
		model.addAttribute("Proveedor", serProv.listarProveedor());
		model.addAttribute("Categoria", serCate.listarCategoria());
		model.addAttribute("Producto", serProd.listarProducto());
		return "producto";
	}

	@RequestMapping("/grabar")
	public String grabarModel(@RequestParam("codigo") Integer cod, 
			@RequestParam("descripcion") String des,
			@RequestParam("stockmi") int stm, 
			@RequestParam("stockac") int sta, 
			@RequestParam("categoria") int cat,
			@RequestParam("marca") int mar, 
			@RequestParam("fecha") String fec,
			@RequestParam("precio") double precio,
			RedirectAttributes redirect) {
		try {

			ProductoModel pm = new ProductoModel();

			pm.setDescripcion(des);
			pm.setStock_minimo(stm);
			pm.setStock_actual(sta);
			pm.setFecha(LocalDate.parse(fec));
			pm.setPrecio(precio);

			CategoriaModel cm = new CategoriaModel();
			cm.setIdcategoria(cat);
			pm.setCategoria(cm);

			MarcaModel mm = new MarcaModel();
			mm.setIdmarca(mar);
			pm.setMarca(mm);

			if (cod == 0) {
				serProd.grabar(pm);
				redirect.addFlashAttribute("MENSAJE", "PRODUCTO REGISTRADO");
			} else {
				pm.setIdproducto(cod);
				serProd.actualizar(pm);
				redirect.addFlashAttribute("MENSAJE", "PRODUCTO ACTUALIZADO");
			}

		} catch (Exception e) {
			// TODO: handle exception
			redirect.addFlashAttribute("mensaje", "Error en el Registro");
			e.printStackTrace();
		}
		return "redirect:/producto/lista";
	}

	//ruta (URL) para buscar por código
	@RequestMapping("/buscar")
	@ResponseBody
	public ProductoModel buscar(@RequestParam("Codigo") int cod) {
		return serProd.buscar(cod);
	}

	//ruta (URL) para eliminar por código
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("Codigo") int cod, RedirectAttributes redirect) {
		try {
			serProd.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE", "Registro eliminado correctamente");
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la eliminación de producto");
			e.printStackTrace();
		}
		return "redirect:/producto/lista";
	}
	
	//ruta (URL) para listar todos los tipos de medicamentos según el código del laboaratorio
	@RequestMapping("/listarPorProveedor")
	@ResponseBody //genera JSON
	public List<MarcaModel> listarPorProveedor(@RequestParam("Codigo") Integer cod) {
		return serMarc.listarPorProveedor(cod);
		
	}
	
	@RequestMapping("/reporteProductos")
	public void reporteCliente(HttpServletResponse response,@RequestParam("categoria") int cod) {
		try {
			//invocar al método listarTodos
			List<ProductoModel> lista=serProd.listarPorCategoria(cod);
			//acceder al reporte "reporteMedicamento.jrxml"
			File file=ResourceUtils.getFile("classpath:reporteProducto.jrxml");
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
